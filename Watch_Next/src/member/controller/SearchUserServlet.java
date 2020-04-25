package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/searchUser.do")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchUserId = request.getParameter("searchUser");
//		System.out.println(searchUserId);
		MemberService ms = new MemberService();
		Member searchUser = ms.searchUser(searchUserId);
		int countBoard = ms.countMyBoard(searchUserId);
		int countComment = ms.countMyComment(searchUserId);
		
		JSONObject searchObj = null;
		if(searchUser != null) {
			searchObj = new JSONObject();
			
			searchObj.put("userId", searchUser.getUserId());
			searchObj.put("userName", searchUser.getUserName());
			searchObj.put("countBoard", countBoard);
			searchObj.put("countComment", countComment);
		}
		
		System.out.println("searchObj" + searchObj);
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(searchObj);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
