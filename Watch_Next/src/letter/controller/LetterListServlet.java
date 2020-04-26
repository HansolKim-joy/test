package letter.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageInfo;
import letter.model.service.LetterService;
import letter.model.vo.Letter;
import member.model.vo.Member;

/**
 * Servlet implementation class LetterViewServlet
 */
@WebServlet("/letter.view")
public class LetterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetterListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LetterService service = new LetterService();
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		String chk = request.getParameter("str");
		PageInfo pi = null;
		int allCount = service.allListCount(userId);
		if(chk != null && !chk.equals("null")) {
			int sendlistCount = service.getsendListCount(userId);
			int currentPage;			// 현재 페이지
			int pageLimit = 10;			// 한 페이지에 표시될 페이징 수
			int maxPage;				// 전체 페이지중 마지막 페이지
			int startPage;				// 페이징된 페이지 중 시작페이지
			int endPage;				// 페이징된 페이지 중 마지막페이지
			int boardLimit = 10;		// 한 페이지에 보일 게시글 수
			
			currentPage = 1;
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			maxPage = (int)(((double)sendlistCount/boardLimit) + 0.9);
			startPage = (((int)((double)currentPage/pageLimit + 0.9)) - 1) * pageLimit + 1;
			
			endPage = pageLimit + startPage - 1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			pi = new PageInfo(currentPage, sendlistCount, pageLimit, maxPage, startPage, endPage, boardLimit);
			ArrayList<Letter> sendletterList = service.sendletterList(userId, currentPage, boardLimit);
			request.setAttribute("letterList", sendletterList);
			request.setAttribute("count", sendlistCount);
			request.setAttribute("chk", "str");
		}else {
			int listCount = service.getListCount(userId);
			int currentPage;			// 현재 페이지
			int pageLimit = 10;			// 한 페이지에 표시될 페이징 수
			int maxPage;				// 전체 페이지중 마지막 페이지
			int startPage;				// 페이징된 페이지 중 시작페이지
			int endPage;				// 페이징된 페이지 중 마지막페이지
			int boardLimit = 10;		// 한 페이지에 보일 게시글 수
			
			currentPage = 1;
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			maxPage = (int)(((double)listCount/boardLimit) + 0.9);
			startPage = (((int)((double)currentPage/pageLimit + 0.9)) - 1) * pageLimit + 1;
			
			endPage = pageLimit + startPage - 1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
			ArrayList<Letter> letterList = service.letterList(userId, currentPage, boardLimit);
			request.setAttribute("letterList", letterList);
			request.setAttribute("count", listCount);
		}
		
		
		String page = "view/letter/letterMain.jsp";
		request.setAttribute("pi", pi);
		request.setAttribute("allCount", allCount);
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
