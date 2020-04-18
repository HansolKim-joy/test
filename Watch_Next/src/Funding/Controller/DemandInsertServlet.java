package Funding.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import Funding.model.service.DemandService;
import Funding.model.vo.Demand;
import common.MyFileRenamePolicy;
import member.model.vo.Member;
import movie.model.service.BoardService;

/**
 * Servlet implementation class DemandInsertServlet
 */
@WebServlet("/insert.demand")
public class DemandInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemandInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DemandService service = new DemandService();
		// enctype이 multipart/form-date로 전송 되었는지 확인
		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출

			String savePath = root + "Resources/images/";

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());
			String saveFile = null; // 바뀐 파일의 이름 저장
			String originFile = null; // 원본 파일의 이름 저장

			Enumeration<String> files = multiRequest.getFileNames(); // 폼에서 전송된 파일 리스트들의 name 반환
			while (files.hasMoreElements()) {
				String name = files.nextElement();
				// multiRequest.getFilesystemName() : MyRenameFilePolicy의 rename메소드에서 작성한대로
				// rename된 파일 명
				if (multiRequest.getFilesystemName(name) != null) {

					saveFile = multiRequest.getFilesystemName(name);
					originFile = multiRequest.getOriginalFileName(name); // getOriginalFileName() : 실제 사용자가 업로드 할때의 파일명
				}
			}
			HttpSession session = request.getSession();
			Member loginUser = (Member) session.getAttribute("loginUser");
			String userId = loginUser.getUserId();
			String movieTitle = multiRequest.getParameter("admin_movie_name");
			int smNo = Integer.parseInt(multiRequest.getParameter("admin_movie_spot"));
			String movieDirector = multiRequest.getParameter("admin_movie_director");
			int money = Integer.parseInt(multiRequest.getParameter("admin_movie_min"));
			int wantmoney = Integer.parseInt(multiRequest.getParameter("movie_wantprice"));
			String movieActor = multiRequest.getParameter("admin_movie_actor");
			int gerneNo = Integer.parseInt(multiRequest.getParameter("admin_movie_genre"));
			String runningTime = multiRequest.getParameter("admin_movie_time");
			String movieStory = multiRequest.getParameter("admin_movie_story");
			int fileNo = new BoardService().insertPoster(originFile, saveFile);
			System.out.println(fileNo);
			Demand d = new Demand(userId, smNo, fileNo, wantmoney, money, movieTitle, movieDirector, movieActor, movieStory, gerneNo, runningTime);
			int result = service.insertDemand(d);
			String page = "";
			if(result > 0) {
				page = request.getContextPath() + "/list.de";
				response.sendRedirect(page);
			}else {
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
