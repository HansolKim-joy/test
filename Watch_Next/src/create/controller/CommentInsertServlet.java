package create.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import member.model.vo.Member;
import recruit.model.service.recruitService;
import common.Comment;
import create.model.service.CreateService;

/**
 * Servlet implementation class CommentInsertServlet
 */
@WebServlet("/insert.co")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String writer = request.getParameter("writer");
		int bid = Integer.parseInt(request.getParameter("rNo"));
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser"); 
		String writer = loginUser.getUserId(); 
		
		Comment co = new Comment();
		co.setrWriter(writer);
		co.setrContent(content);
		co.setRefBid(bid);
		System.out.println("servletcontetn " + content);
		
		ArrayList<Comment> comment = new CreateService().insertComment(co);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(comment, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
