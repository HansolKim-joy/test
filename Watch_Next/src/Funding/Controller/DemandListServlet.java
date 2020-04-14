package Funding.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Funding.model.service.DemandService;
import recruit.model.vo.PageInfo;

/**
 * Servlet implementation class DemandListServlet
 */
@WebServlet("/list.de")
public class DemandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemandService ds = new DemandService();
		
		int ListCount = ds.getListCount();
		
		int currentPage; 
		int pageLimit = 10; 
		int maxPage; 
		int startPage; 
		int endPage;
		int boardLimit = 6;
		 
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
		
		ArrayList<String> list = ds.selectList(currentPage, boardLimit);
		
		
		
		
		String page =null;
		if(list != null) {
			page="view/demand/demandListView.jsp";
			request.setAttribute("list", list);
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
