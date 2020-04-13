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

import movie.model.vo.Movie;
import review.model.vo.Review;
import movie.model.service.BoardService;


/**
 * Servlet implementation class MovieSearchServlet
 */
@WebServlet("/search.mo")
public class MovieSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String movieTitle = request.getParameter("movieTitle");
		BoardService service = new BoardService();
		Movie m = null;
		String fName = "";
		String genre = "";
		HashMap<String, Movie> mMap = service.searchMovie(movieTitle);
		Iterator<Map.Entry<String,Movie>> entries = mMap.entrySet().iterator();
		if(entries.hasNext()){
			Entry<String,Movie> entry = (Entry<String,Movie>)entries.next();
			m = entry.getValue();
			fName = entry.getKey().split(", ")[0];
			genre = entry.getKey().split(", ")[1];
		}

		Review r = service.searchGradeReview(movieTitle);
		String page = "";
		if(m != null) {
			page = "view/infoMovie/infoMovie.jsp";
			request.setAttribute("Movie", m);
			request.setAttribute("Review", r);
			request.setAttribute("fName", fName);
			request.setAttribute("genre", genre);
		}else {
			page = "view/common/errorPage.jsp";
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