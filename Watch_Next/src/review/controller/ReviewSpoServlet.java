package review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewSpoServlet
 */
@WebServlet("/list.spo")
public class ReviewSpoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSpoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//스포유무로 모아보기
				String spo = request.getParameter("spo");
				/*
				 * String spo=""; if(spo_ != null) { spo = spo_; }
				 */
				System.out.println("servlet_spo는?"+spo);
				
				Review rspo = new Review();
				rspo.setSpo(spo);
				
				
				ArrayList<Review> spolist = ReviewService.spoList(spo);
				response.setContentType("applicaiton/json; charset=UTF-8");
				new Gson().toJson(spolist, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
