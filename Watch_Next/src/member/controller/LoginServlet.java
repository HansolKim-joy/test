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
@WebServlet("/login.me")
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
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String userId = request.getParameter("userId");
      String userPwd = request.getParameter("userPwd");
      
      System.out.println(userId + " " + userPwd);
      
      Member m = new Member(userId, userPwd);
      
      Member loginUser = new MemberService().loginMember(m);
      if(loginUser != null) {
         System.out.println(loginUser);
         HttpSession session = request.getSession();
         session.setAttribute("loginUser", loginUser);
         session.setMaxInactiveInterval(600);
         System.out.println(request.getContextPath());
         response.sendRedirect(request.getContextPath());
      }else {
         request.setAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
         RequestDispatcher view = request.getRequestDispatcher("view/pages/loginForm.jsp");
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