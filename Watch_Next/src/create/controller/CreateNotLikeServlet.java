package create.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import create.model.service.CreateService;
import member.model.vo.Member;
import review.model.service.ReviewService;

/**
 * Servlet implementation class CreateNotLikeServlet
 */
@WebServlet("/notlike.create")
public class CreateNotLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNotLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo= Integer.parseInt(request.getParameter("cNo").trim());
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		int result = new CreateService().notLike(cNo, userId);
		
		String page = request.getContextPath()+"/detail.creat?cNo=" + cNo;
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
