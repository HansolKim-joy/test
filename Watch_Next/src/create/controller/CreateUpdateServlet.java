package create.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import create.model.service.CreateService;
import create.model.vo.CFile;
import create.model.vo.Create;


/**
 * Servlet implementation class CreateUpdateServlet
 */
@WebServlet("/update.cr")
public class CreateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateServlet() {
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
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();
			
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
		
		int cNo = Integer.parseInt(multiRequest.getParameter("cNo"));
		String title = multiRequest.getParameter("creW_createName");
		String director = multiRequest.getParameter("creW_directorName");
		String content = multiRequest.getParameter("taContent");
		
		content = content.replace("\r\n", "<br>");
	
		
		Create c = new Create();
		c.setbNO(cNo);
		c.setbTitle(title);
		c.setcDirector(director);
		c.setbContent(content);
		
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
			
			at.setbNo(cNo);
//			at.setfNo(Integer.parseInt(multiRequest.getParameter("creW_file")));
			
			fileList.add(at);
	
		}
		
		System.out.println("서블릿fileList:"+fileList);
		System.out.println("서블릿c:"+c);
		
		
		int result = new CreateService().updateCreate(c, fileList);
		
		String page = null;
		if(result>0) {
			page="detail.creat?cNo=" + cNo;
			response.sendRedirect(page);
		} else {
			
			for(int i=0; i<saveFiles.size(); i++) {
				File failedFile = new File(savePath+saveFiles.get(i));
				failedFile.delete();
			}
			
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			request.getRequestDispatcher(page).forward(request, response);
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
