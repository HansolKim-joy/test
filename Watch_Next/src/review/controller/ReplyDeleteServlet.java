package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/deleteReply.rv")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rpno = Integer.parseInt(request.getParameter("replyno").trim());
		int rv = Integer.parseInt(request.getParameter("rv").trim());
		
		int result = new ReviewService().deleteReply(rpno);
		
		if(result>0) {
			response.sendRedirect("detail.rv?rv="+rv);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "리뷰 삭제를 실패하였습니다.");
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
