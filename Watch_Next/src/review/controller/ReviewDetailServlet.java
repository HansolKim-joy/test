package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Comment;
import member.model.vo.Member;
import report.model.service.ReportService;
import report.model.vo.Report;
import review.model.service.ReviewService;

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
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		char chk = ReviewService.getLike(userId,rv);
		request.setAttribute("chk", chk);
		
		String writer = new ReviewService().getWriter(rv);
		char fchk = ReviewService.getFollow(userId, writer);
		request.setAttribute("fchk", fchk);
			
//		int[] decrpNo = new ReportService().getRpNo(userId);
//		System.out.println("서블릿 리플번호:"+decrpNo);
		//char rdChk = ReviewService.getReportR(userId, 리플번호); //해당 유저가 해당번호의 리플을 신고했는지
		//request.setAttribute("rdChk", rdChk);
				
		review.model.vo.Review review = new ReviewService().selectReview(rv);
		ArrayList<Comment> list = new ReviewService().selectReplyList(rv);
		
		
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
