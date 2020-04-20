package Funding.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Funding.model.service.DemandService;
import Funding.model.vo.AdminFunding;

/**
 * Servlet implementation class AdminFundingAllow
 */
@WebServlet("/FunDetail.adm")
public class AdminFundingAllow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFundingAllow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		ArrayList<AdminFunding> list = new DemandService().FunDetail(no);
		
		String page =null;
		
		if(list != null) {
			page="view/admin/Admin_fundingWrite.jsp";
			request.setAttribute("list", list);
		}else {
			page="view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
