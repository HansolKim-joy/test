package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;
import review.model.vo.ReviewReply;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/detail.rv")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rv = Integer.parseInt(request.getParameter("rv"));
		
		Review review = new ReviewService().selectReview(rv);
		ArrayList<ReviewReply> list = new ReviewService().selectReplyList(rv);
		
		String page = null;
		if(review != null) {
			page = "view/review_board/reviewPost.jsp";
			request.setAttribute("review", review);
			request.setAttribute("list", list);
		} else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "게시물 상세조회에 실패했습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
