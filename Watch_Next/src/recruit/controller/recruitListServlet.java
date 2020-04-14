package recruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import recruit.model.service.recruitService;
import recruit.model.vo.PageInfo;
import recruit.model.vo.Recruit;

/**
 * Servlet implementation class recruitListServlet
 */
@WebServlet("/list.recruit")
public class recruitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recruitListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db에서 게시글 불러오는 servlet
		 recruitService rservice = new recruitService();
		 
		 int listCount = rservice.getListCount();
		 
		 int currentPage; 
		 int pageLimit = 10; 
		 int maxPage; 
		 int startPage; 
		 int endPage;
		 int boardLimit = 10;

		 currentPage = 1; 
		 
		 if(request.getParameter("currentPage") != null) {
		 currentPage = Integer.parseInt(request.getParameter("currentPage"));
		 }
		  
		 maxPage = (int)((double)listCount / boardLimit + 0.9);
		 
		 startPage = (((int)((double)currentPage / pageLimit + 0.9)) - 1) * pageLimit + 1;
		  
		 endPage = pageLimit + startPage - 1;
		 
		 if(maxPage < endPage) { 
			 endPage = maxPage;
		}
		  
		 PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		  

		 //---------------------------목록 호출-------------------------
		 
		 ArrayList<Recruit> list = rservice.selectList(currentPage, boardLimit);
		 HttpSession session = request.getSession();
		 Member loginUser = (Member)session.getAttribute("loginUser");
		 //-------------------------검색옵션-----------------
		
		String choice = request.getParameter("choice");
		ArrayList<Recruit> cList = rservice.choiceHead(choice);

		 String page = null;
		 if(list != null) { 
			 page = "view/recruit/recruitList.jsp";
			 request.setAttribute("list", list); 
			 request.setAttribute("pi", pi);
			 request.setAttribute("loginUser", loginUser);
		 
		 } else { 
			 page = "view/common/errorPage.jsp"; 
		 	 request.setAttribute("msg", "게시판 조회에 실패하였습니다.");
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
