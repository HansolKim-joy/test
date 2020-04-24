package create.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import create.model.service.CreateService;
import create.model.vo.CFile;
import create.model.vo.Create;
import member.model.vo.Member;


/**
 * Servlet implementation class CreateInsertServlet
 */
@WebServlet("/insert.cr")
public class CreateInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10000;
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "Resources/crethumb_uploadFiles/";
			
			MultipartRequest multiRequest
			 = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			ArrayList<String> saveFiles = new ArrayList<String>();		// 바뀐 파일의 이름 저장
			ArrayList<String> originFiles = new ArrayList<String>();	// 원본 파일의 이름 저장
			
			
			
			
			Enumeration<String> files = multiRequest.getFileNames(); // 폼에서 전송된 파일 리스트들의 name 반환
			while(files.hasMoreElements()) {
				String name = files.nextElement(); // 전송 순서 역순으로 가져옴
				
				if(multiRequest.getFilesystemName(name) != null) {
					// getFilesystemName() : MyRenameFilePolicy의 rename메소드에서 작성한대로 rename된 파일 명
					
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name)); 
					// getOriginalFileName() : 실제 사용자가 업로드할 때의 파일 명
				}
			
			}
			
		
		String bTitle = multiRequest.getParameter("creW_createName");
		String cDirector = multiRequest.getParameter("creW_directorName");
		String content = multiRequest.getParameter("taContent");
		
		//줄바꿈
		content = content.replace("\r\n", "<br>");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser"); 
		String writer = loginUser.getUserId(); 
		
		//파일 추가하기
		Create c = new Create();
		c.setbTitle(bTitle);
		c.setcDirector(cDirector);
		c.setbContent(content);
		c.setbWriter(writer);
		
		ArrayList<CFile> fileList = new ArrayList<CFile>();
		for(int i= originFiles.size()-1; i>=0; i--) {
			CFile at = new CFile();
			at.setOriginNames(originFiles.get(i));
			at.setNewNames(saveFiles.get(i));
			
			if(i == originFiles.size() -1) {
				at.setFileleve(0);
			} else {
				at.setFileleve(1);
			}
			
			fileList.add(at);
	
		}
		
		int result = new CreateService().insertCreate(c, fileList);
		
		if(result>0) {
			response.sendRedirect("list.cr");
		} else {
			
			for(int i=0; i<saveFiles.size(); i++) {
				File failedFile = new File(savePath+saveFiles.get(i));
				failedFile.delete();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "창작게시물 등록에 실패했습니다.");
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
