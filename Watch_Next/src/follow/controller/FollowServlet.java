package follow.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import follow.model.vo.Follow;
import follow.model.service.FollowService;


/**
 * Servlet implementation class FollowServlet
 */
@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("rpWriter");
		System.out.println("writer "+writer);
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String user = loginUser.getUserId();
		
		int result = new FollowService().following(writer, user);
		
		String page = null;
		if(result > 0) {
			page = "/deatil.recruit";
		}else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "팔로우에 실패하였습니다.");
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
