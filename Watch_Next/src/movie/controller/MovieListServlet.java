package movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.BoardService;
import movie.model.vo.Movie;
import common.PageInfo;


/**
 * Servlet implementation class allMovieServlet
 */
@WebServlet("/movie.all")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		int choice = 0;
		if(request.getParameter("choice") != null) {
			choice = Integer.parseInt(request.getParameter("choice"));
		}
		int listCount = service.getListCount();
		
		int currentPage;			// 현재 페이지
		int pageLimit = 10;			// 한 페이지에 표시될 페이징 수
		int maxPage;				// 전체 페이지중 마지막 페이지
		int startPage;				// 페이징된 페이지 중 시작페이지
		int endPage;				// 페이징된 페이지 중 마지막페이지
		int boardLimit = 15;		// 한 페이지에 보일 게시글 수
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		maxPage = (int)(((double)(listCount)/boardLimit) + 0.9);
		if(maxPage < 1) {
			maxPage = 1;
		}
		startPage = (((int)((double)currentPage/pageLimit + 0.9)) - 1) * pageLimit + 1;
		
		endPage = pageLimit + startPage - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		/*
		 * System.out.println(currentPage); System.out.println(maxPage);
		 * System.out.println(startPage); System.out.println(endPage);
		 * System.out.println(listCount); System.out.println(boardLimit);
		 */
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		HashMap<String,Movie> mMap = service.MovieList(currentPage, boardLimit);
		List<String> keySetList = new ArrayList<String>(mMap.keySet());
		if(choice == 1) {
			Collections.sort(keySetList,(o1, o2) -> (mMap.get(o1).getmTitle().compareTo(mMap.get(o2).getmTitle())));
		}else if(choice == 2){
			Collections.sort(keySetList,(o1, o2) -> (mMap.get(o2).getmTitle().compareTo(mMap.get(o1).getmTitle())));
		}
		ArrayList<Movie> mlist = new ArrayList<Movie>();
		ArrayList<String> fNameList = new ArrayList<String>();
		for(String key : keySetList) {
			fNameList.add(key);
			mlist.add(mMap.get(key));
		}
		
		String page = null;
		page = "view/allMovie/allMovie2.jsp";
		request.setAttribute("mlist", mlist);
		request.setAttribute("fNameList", fNameList);
		request.setAttribute("pi", pi);
		request.setAttribute("choice", choice);
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
