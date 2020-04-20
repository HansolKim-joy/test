package create.controller;

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
import create.model.service.CreateService;
import create.model.vo.Create;
import member.model.vo.Member;

/**
 * Servlet implementation class CreateDetailServlet
 */
@WebServlet("/detail.creat")
public class CreateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		System.out.println("rnoservlet " + rNo);
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		char chk = new CreateService().getLike(userId, rNo);
		request.setAttribute("chk", chk);
		
		Create create = new CreateService().selectCreate(rNo);
		ArrayList<Comment> comment = new CreateService().selectComment(rNo);
		
		String page = null;
		if(create != null) {
			page = "view/create/createPost.jsp";
			request.setAttribute("create", create);
			request.setAttribute("loginUser", loginUser);
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
