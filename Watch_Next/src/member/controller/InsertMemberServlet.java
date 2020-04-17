package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insert.me")
public class InsertMemberServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      String userId = request.getParameter("user_ID");
      String userPwd = request.getParameter("user_Pass");
      String name = request.getParameter("user_Name");
      String phone = request.getParameter("user_Phone");
      String email = request.getParameter("user_Email");
      String mailingYN = request.getParameter("user_Check");
//      System.out.println(mailingYN);
      
      
      
      
      Member m = new Member(userId, userPwd, name, phone, email, mailingYN, null, null);
      
      int result = new MemberService().insertMember(m);
      
      
      String page = "";
      String msg = "";
      
      if(result > 0) {
    	 msg = "회원가입에 성공하였습니다.";
         page = "view/pages/loginForm.jsp";
      } else {
		 msg = "회원가입에 실패했습니다. 다시 입력해주세요.";
         page = "view/pages/JoinForm.jsp";
      }
      
      request.setAttribute("msg", msg);
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