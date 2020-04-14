package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class memberCheckServlet
 */
@WebServlet("/update.me")
public class memberCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userMailing = request.getParameter("mailing");
		
//		System.out.println(userId + ", " + userName + ", " + userEmail + ","
//				+ userPhone + ", " + userMailing);
		
		Member member = new Member(userId, null, userName, userPhone, userEmail, userMailing, "N", "N");
		
		Member m = new MemberService().updateMember(member);
		
		System.out.println(m);
		HttpSession session = request.getSession();
		
		
		
		String page = null;
		if(m != null) {
			page = "/view/myPage/myPageMain.jsp";
			session.setAttribute("loginUser", m);
		}else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "회원조회에 실패했습니다.");
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
