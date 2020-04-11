package MovieBoard.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import MovieBoard.model.service.BoardService;
import MovieBoard.model.vo.Movie;
import common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MovieInsertServlet
 */
@WebServlet("/insert.movie")
public class MovieInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInsertServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardService service = new BoardService();
		
		// enctype이 multipart/form-date로 전송 되었는지 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				int maxSize = 1024 * 1024 * 10;
				String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출
				
				String savePath = root + "Resources/images/";
				
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new MyFileRenamePolicy());
				String saveFile = null;		// 바뀐 파일의 이름 저장
				String originFile = null;	// 원본 파일의 이름 저장
				
				Enumeration<String> files = multiRequest.getFileNames(); // 폼에서 전송된 파일 리스트들의 name 반환
				while(files.hasMoreElements()) {
					String name = files.nextElement();
					/*
					 * System.out.println(name);
					 * System.out.println(multiRequest.getFilesystemName(name));
					 */
					// multiRequest.getFilesystemName() : MyRenameFilePolicy의 rename메소드에서 작성한대로 rename된 파일 명
					if(multiRequest.getFilesystemName(name) != null) {
						
						saveFile = multiRequest.getFilesystemName(name);
						originFile = multiRequest.getOriginalFileName(name); // getOriginalFileName() : 실제 사용자가 업로드 할때의 파일명
					}
				}
				
				String movieTitle = multiRequest.getParameter("admin_movie_name");
				String director = multiRequest.getParameter("admin_movie_director");
				String actor = multiRequest.getParameter("admin_movie_actor");
				int genreNo = Integer.parseInt(multiRequest.getParameter("admin_movie_genre"));
				String runningTime = multiRequest.getParameter("admin_movie_time");
				String country = multiRequest.getParameter("admin_movie_country");
				Date releaseDate = Date.valueOf(multiRequest.getParameter("admin_movie_open"));
				String story = multiRequest.getParameter("admin_movie_story");
				String[] serviceSites = multiRequest.getParameterValues("admin_movie_service");
				String serviceSite = String.join(", ", serviceSites);
				System.out.println(serviceSite);
				int fileNo = service.insertPoster(originFile, saveFile);
				Movie m = new Movie(movieTitle, director, actor, runningTime, releaseDate, country, story, fileNo, genreNo, serviceSite);
				
				int result = service.insertMovie(m);
				String page = "";
				if(result > 0) {
					page = request.getContextPath() + "/movie.all";
					response.sendRedirect(page);
				}else {
					File failedFile = new File(savePath + saveFile);
					failedFile.delete();
					page = "view/common/errorPage.jsp";
					request.setAttribute("msg", "영화정보 입력에 실패했습니다.");
					RequestDispatcher view = request.getRequestDispatcher(page);
					view.forward(request, response);
				}
			} catch(Exception e) {
				e.printStackTrace();
				String page = "view/common/errorPage.jsp";
				request.setAttribute("msg", "영화정보 입력에 실패했습니다. 빈칸없이 입력해 주세요.");
				RequestDispatcher view = request.getRequestDispatcher(page);
				view.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
