package Funding.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Funding.model.service.DemandService;
import Funding.model.vo.Demand;
import Funding.model.vo.DemandList;
import common.PageInfo;

/**
 * Servlet implementation class DemandListServlet
 */
@WebServlet("/listSort.adm")
public class AdminListSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListSortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemandService ds = new DemandService();
		String cinema = request.getParameter("cinema");
		int ListCount = ds.getAdSortListCount(cinema);
		
		int currentPage; 
		int pageLimit = 10; 
		int maxPage; 
		int startPage; 
		int endPage;
		int boardLimit = 8;
		 
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			 currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
		maxPage = (int)((double)ListCount / boardLimit + 0.9);
		 
		startPage = (((int)((double)currentPage / pageLimit + 0.9)) - 1) * pageLimit + 1;
		  
		endPage = pageLimit + startPage - 1;
		
		if(maxPage < endPage) { 
			 endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, ListCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		ArrayList<DemandList> list = ds.AdminSortList(currentPage, boardLimit, cinema);
		ArrayList<Demand> want = ds.wantPeople();
		
		String page =null;
		if(list != null) {
			page="view/admin/Admin_FundingList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("wlist", want);
			request.setAttribute("pi", pi);
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
