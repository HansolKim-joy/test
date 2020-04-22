package movie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.BoardService;
import movie.model.vo.Dib;
import movie.model.vo.Movie;
import review.model.vo.Review;

/**
 * Servlet implementation class MovieDetailServlet
 */
@WebServlet("/detail.mo")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String movieTitle = request.getParameter("movieTitle");
		int no = Integer.parseInt(request.getParameter("no"));
		BoardService service = new BoardService();
		Movie m = null;
		String fName = "";
		String genre = "";
		HashMap<String, Movie> mMap = service.DetailMovie(movieTitle,no);
		Iterator<Map.Entry<String,Movie>> entries = mMap.entrySet().iterator();
		Dib d = null;
		if(entries.hasNext()){
			Entry<String,Movie> entry = (Entry<String,Movie>)entries.next();
			m = entry.getValue();
			fName = entry.getKey().split(", ")[0];
			genre = entry.getKey().split(", ")[1];
			d = service.searchDib(m.getmNo());
		}
		
		
		Review r = service.searchGradeReview(movieTitle);
		String page = "";
		if(m != null) {
			page = "view/infoMovie/infoMovie.jsp";
			request.setAttribute("Dib", d);
			request.setAttribute("Movie", m);
			request.setAttribute("Review", r);
			request.setAttribute("fName", fName);
			request.setAttribute("genre", genre);
		}else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "검색에 실패했습니다.");
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
