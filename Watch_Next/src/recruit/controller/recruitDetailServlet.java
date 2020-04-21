package recruit.controller;

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
import recruit.model.service.recruitService;
import recruit.model.vo.Recruit;
import review.model.service.ReviewService;

/**
 * Servlet implementation class recruitDetailServlet
 */
@WebServlet("/detail.recruit")
public class recruitDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recruitDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		
		 HttpSession session = request.getSession();
		 Member loginUser = (Member)session.getAttribute("loginUser");
		 String userId = loginUser.getUserId();
		 
		 String writer = new recruitService().getWriter(rNo);
		char fchk = recruitService.getFollow(userId, writer);
		request.setAttribute("fchk", fchk);
		 Recruit board = new recruitService().selectBoard(rNo);
		 ArrayList<Comment> comment = new recruitService().selectComment(rNo);
		
		 String page = null;
			if(board != null) {
				page = "view/recruit/recruitDetail.jsp";
				request.setAttribute("board", board);
				request.setAttribute("loginUser", userId);
				request.setAttribute("comment", comment);
			} else {
				page = "view/errorPage/errorPage.jsp";
				request.setAttribute("msg", "게시글 상세조회에 실패하였습니다.");
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
