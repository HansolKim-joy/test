package movie.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		ArrayList<Movie> m = new ArrayList<Movie>();
		ArrayList<String> fName = new ArrayList<String>();
		ArrayList<String> genre = new ArrayList<String>();
		HashMap<String, Movie> mMap = service.searchMovie(movieTitle);
		Iterator<Map.Entry<String,Movie>> entries = mMap.entrySet().iterator();
		while(entries.hasNext()){
			Entry<String,Movie> entry = (Entry<String,Movie>)entries.next();
			Movie mo = entry.getValue();
			m.add(mo);
			fName.add(entry.getKey().split(", ")[0]);
			genre.add(entry.getKey().split(", ")[1]);
		}
		
		String page = "";
		if(!m.isEmpty()) {
			page = "view/infoMovie/SearchMovie.jsp";
			request.setAttribute("Movie", m);
			request.setAttribute("fName", fName);
			request.setAttribute("genre", genre);
			request.setAttribute("movieTitle", movieTitle);
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
