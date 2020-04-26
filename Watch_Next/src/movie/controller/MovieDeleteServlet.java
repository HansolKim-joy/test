package movie.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.BoardService;

/**
 * Servlet implementation class MovieDeleteServlet
 */
@WebServlet("/delete.mo")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String fName = request.getParameter("fName");
		String savePath = "";
		if(fName != null) {
			String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출
			savePath = root + "Resources/images/";
			File deleteFile = new File(savePath + fName);
			deleteFile.delete();
		}
		int result1 = new BoardService().DeleteAllDib(no);
		int result2 = new BoardService().DeleteMovie(no);
		int result3 = new BoardService().DeleteFile(fName);
		String page = "";
		if(result2 > 0 && result3 > 0) {
			page = request.getContextPath() + "/movie.all";
			response.sendRedirect(page);
		}else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "영화 삭제에 실패했습니다.");
			request.getRequestDispatcher(page).forward(request, response);
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
