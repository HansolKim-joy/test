package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/update.rv")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rv = Integer.parseInt(request.getParameter("rv").trim());
		String btilte = request.getParameter("revW_reviewName");
		String mtilte = request.getParameter("revW_movieName");
		String content = request.getParameter("editor_content");
		String spo = request.getParameter("revW_spolier");
		if(request.getParameter("revW_spolier") != null) {
			spo = "Y";
		}else {
			spo = "N";
		}
		int popcorn = Integer.parseInt(request.getParameter("pop_point").trim());
		
		
		Review r = new Review();
		r.setbNo(rv);
		r.setbTitle(btilte);
		r.setmTitle(mtilte);
		r.setbContent(content);
		r.setSpo(spo);
		r.setPopcorn(popcorn);
		
		int result = new ReviewService().updateReview(r);
		
		String page = null;
		if(result>0) {
			page="/detail.rv?rv=" + rv;
		} else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
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
