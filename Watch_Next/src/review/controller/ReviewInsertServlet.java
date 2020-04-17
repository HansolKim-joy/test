package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/insert.rv")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String btitle = request.getParameter("revW_reviewName");
		String mtitle = request.getParameter("revW_movieName");
		String content = request.getParameter("editor_content");
		String spo = request.getParameter("revW_spolier");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser"); 
		String writer = loginUser.getUserId(); 
		
		if(request.getParameter("revW_spolier") != null) {
			spo = "Y";
		}else {
			spo = "N";
		}
		int popcorn = Integer.parseInt(request.getParameter("pop_point"));
				
		Review r = new Review();
		r.setbTitle(btitle);
		r.setmTitle(mtitle);
		r.setbContent(content);
		r.setSpo(spo);
		r.setPopcorn(popcorn);
		r.setbWriter(writer);
		
		int result = new ReviewService().insertReview(r);
		
		if(result>0) {
			response.sendRedirect("list.rv");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "리뷰 등록에 실패했습니다.");
			view.forward(request, response);
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
