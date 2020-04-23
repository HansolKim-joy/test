package mainlist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.model.service.RecBoardService;
import listAll.controller.BoardAllServlet;
import mainlist.model.service.mainlistService;
import movie.model.service.BoardService;
import movie.model.vo.File;
import recruit.model.vo.Recruit;
import review.model.vo.Review;

/**
 * Servlet implementation class RecruitListServlet
 */
@WebServlet("/listRecruit.vo")
public class RecruitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fi = request.getParameter("fi");
		String se = request.getParameter("se");
//		System.out.println(" 와우 "+fi);
//		System.out.println(" 와우 "+se);
		ArrayList<Recruit> Recruitlist = new mainlistService().selectRclist();
		ArrayList<Review> Reviewlist = new mainlistService().selectRvlist();
//		System.out.println("servlet" + list);
		
		
		
		
		
//		String page = "";
		if(fi != null && se == null) {
//			System.out.println("여기야1");
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(Reviewlist, response.getWriter());
		} else if(fi==null && se !=null) {
//			System.out.println("여기야2");
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(Recruitlist, response.getWriter());
		} else {
			
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
