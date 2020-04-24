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
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login.me", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("lg_userPwd");
//		System.out.println(userId + " " + userPwd);

		Member m = new Member(userId, userPwd);

		Member loginUser = new MemberService().loginMember(m);
		System.out.println(loginUser);
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(600);
			response.sendRedirect(request.getContextPath());
//			request.getRequestDispatcher("view/pages/loginForm.jsp").forward(request, response);
			
//		} else if(loginUser.getDeleteYN().equals("Y") || loginUser == null) {
//			request.setAttribute("msg", "회원가입을 해주세요.");
//			request.getRequestDispatcher("view/pages/loginForm.jsp").forward(request, response);	
		} else {
			request.setAttribute("msg", "가입하지 않은 아이디거나, 또는 비밀번호가 틀립니다.");
			RequestDispatcher view = request.getRequestDispatcher("view/pages/loginForm.jsp");
			view.forward(request, response);
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
//		if(loginUser.getUserId() == userId && loginUser.getUserPwd() != userPwd) {
//			request.setAttribute("msg", "가입하지 않은 아이디거나, 비밀번호가 잘못되었습니다.");
//		
//			
////		} else if(loginUser == null && loginUser.getDeleteYN().equals("Y")) { // login.jsp의 input id와 pwd 값을 받아 오고 db에서 확인할때 없으면 null을 받아오기 때문에.
////			request.setAttribute("msg", "없는 회원입니다. 회원가입을 해주세요.");
//		} else if(loginUser != null && loginUser.getDeleteYN().equals("N")){
//			session.setAttribute("loginUser", loginUser);
//			session.setMaxInactiveInterval(600);
//			response.sendRedirect(request.getContextPath());
//			
//		}
//	}	
////		if(loginUser.getUserId() == userId || loginUser.getUserPwd() == userPwd) {
////			HttpSession session = request.getSession();
//			session.setAttribute("loginUser", loginUser);
//			session.setMaxInactiveInterval(600);
//			response.sendRedirect(request.getContextPath());
//		} else {
//			request.setAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다..");
//			RequestDispatcher view = request.getRequestDispatcher("view/pages/loginForm.jsp");
//		}
//		
//			view.forward(request, response);
//		else {
//			request.setAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
//			response.sendRedirect(request.getContextPath());
//			RequestDispatcher view = request.getRequestDispatcher("view/pages/loginForm.jsp");
//			view.forward(request, response);
//		}
		
		
//	}

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