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
import create.model.vo.CFile;
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
		int cNo = Integer.parseInt(request.getParameter("cNo").trim());
		System.out.println("rnoservlet " + cNo);
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		char chk = new CreateService().getLike(userId, cNo);
		request.setAttribute("chk", chk);
		
		String writer = new CreateService().getWriter(cNo);
		char fchk = CreateService.getFollow(userId, writer);
		request.setAttribute("fchk", fchk);
		CreateService service = new CreateService();
		
		Create create = service.selectCreate(cNo);
//		ArrayList<CFile> fileList = service.selectFile(cNo);
		ArrayList<Comment> comment = service.selectComment(cNo);
		
		String page = null;
		if(create != null) {
			page = "view/create/createPost.jsp";
			request.setAttribute("create", create);
			request.setAttribute("loginUser", loginUser);
			request.setAttribute("comment", comment);
//			request.setAttribute("fileList", fileList);
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
