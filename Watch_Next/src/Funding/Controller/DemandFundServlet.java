package Funding.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Funding.model.service.DemandService;
import member.model.vo.Member;

/**
 * Servlet implementation class DemandWantServlet
 */
@WebServlet("/demand.fund")
public class DemandFundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandFundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String dUserId = request.getParameter("userId");
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		int result = new DemandService().putFund(no, userId, dUserId, price);
		String page = request.getContextPath() + "/demand.detail?no=" + no;
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
