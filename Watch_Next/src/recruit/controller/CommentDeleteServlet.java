package recruit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recruit.model.service.recruitService;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/delete.comment")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bid 11"+request.getParameter("rNo"));
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		
		int result = new recruitService().deleteComment(rNo);
		System.out.println("servlet "+result);
		
		if(result > 0) {
			response.sendRedirect("detail.recruit");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "댓글 삭제를 실패했습니다.");
			view.forward(request, response);
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
