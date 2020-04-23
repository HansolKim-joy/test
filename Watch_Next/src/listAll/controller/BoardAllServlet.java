package listAll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Funding.model.vo.Demand;
import common.Comment;
import create.model.vo.Create;
import listAll.model.vo.MyFollow;
import member.model.vo.Member;
import movie.model.service.BoardService;
import movie.model.vo.Movie;
import recruit.model.vo.Recruit;
import review.model.vo.Review;

/**
 * Servlet implementation class BoardAllServlet
 */
@WebServlet("/list.all")
public class BoardAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		BoardService bService = new BoardService();
		ArrayList<Demand> IwriteFund = bService.iwriteFunding(userId);
		ArrayList<Review> ReviewList = bService.selectMyReview(userId);
		ArrayList<Recruit> RecruitList = bService.selectMyRecruit(userId);
		ArrayList<Movie> DibList = bService.selectMyDib(userId);
		ArrayList<Comment> ReviewComlist = bService.selectComment(userId);
		ArrayList<Comment> RecruitComlist = bService.selectRcComment(userId);
		ArrayList<Comment> CreateComList = bService.selectCcomment(userId);
		ArrayList<MyFollow> FollowList = bService.selectFollow(userId);
		ArrayList<Demand> OpenFunding = bService.selectOpenFunding(userId);
		ArrayList<Demand> CloseFunding = bService.selectClosedFunding(userId);
		ArrayList<Create> CreateList = bService.selectCreate(userId);
//		System.out.println("ksldjf" + ReviewList);
		
		String page = "";
		if(ReviewList != null) {
//			System.out.println("servlet" + ReviewList);
			page = "view/myPage/myPageMain.jsp";
			request.setAttribute("ReviewList", ReviewList);
			request.setAttribute("RecruitList", RecruitList);
			request.setAttribute("DibList", DibList);
			request.setAttribute("ReviewComlist", ReviewComlist);
			request.setAttribute("RecruitComlist", RecruitComlist);
			request.setAttribute("IwriteFund", IwriteFund);
			request.setAttribute("FollowList", FollowList);
			request.setAttribute("OpenFunding", OpenFunding);
			request.setAttribute("CloseFunding", CloseFunding);
			request.setAttribute("CreateList", CreateList);
			request.setAttribute("CreateComList", CreateComList);
		}else {
			page = "view/errorPage/errorPage.jsp";
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
