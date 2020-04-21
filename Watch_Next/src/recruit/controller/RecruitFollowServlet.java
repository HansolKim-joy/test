package recruit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import recruit.model.service.recruitService;

/**
 * Servlet implementation class RecruitFollowServlet
 */
@WebServlet("/follow.recruit")
public class RecruitFollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitFollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		String writer = request.getParameter("fwriter");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		int result = new recruitService().follow(rNo, writer, userId);
		
		String page = request.getContextPath()+"/detail.recruit?rNo=" + rNo;
		response.sendRedirect(page);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
