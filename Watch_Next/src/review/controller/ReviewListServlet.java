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
import review.model.vo.PageInfo;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/list.rv")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewService service = new ReviewService();

		// 페이징
		int listCount = service.getListCount();

		int currentPage;
		int pageLimit = 10;
		int maxPage;
		int startPage;
		int endPage;
		int boardLimit = 10;

		currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));

		}

		maxPage = (int) ((double) listCount / boardLimit + 0.9);
		startPage = (((int) ((double) currentPage / pageLimit + 0.9)) - 1) * pageLimit + 1;
		endPage = pageLimit + startPage - 1;
		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 검색
		String sk_ = request.getParameter("sk"); //임시변수
		String sv_ = request.getParameter("sv");

		String sk="전체"; //null처리한 실제변수
		if(sk_ != null) {
			sk = sk_;
		}
		
		String sv="";
		if(sv_ != null) {
			sv = sv_;
		}
		
		//스포유무로 모아보기
		String sk2_ = request.getParameter("sk2");
		
		String sk2="스포선택";
		if(sk2_ != null) {
			sk2 = sk2_;
		}
		
		

		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);

		ArrayList<Review> list = service.selectList(currentPage, boardLimit, sk, sv, sk2);

		String page = null;
		if (list != null) {
			page = "view/review_board/reviewList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패했습니다.");
		}

		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);

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
