package movie.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import static common.JDBCTemplate.*;

import movie.model.dao.MovieDAO;
import movie.model.vo.Movie;

import review.model.vo.Review;

public class BoardService {
	public BoardService() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<String, Movie> MovieList(int currentPage, int boardLimit) {
		HashMap<String, Movie> list = null;
		Connection conn = getConnection();
		
		list = new MovieDAO().MovieList(conn, currentPage, boardLimit);
		
		close(conn);
		return list;
	}

	public int getListCount() {
		int result = 0;
		Connection conn = getConnection();
		
		result = new MovieDAO().getListCount(conn);
		
		close(conn);
		return result;
	}

	public int insertPoster(String originFile, String saveFile) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		int result1 = new MovieDAO().insertPoster(conn, originFile, saveFile);
		int result2 = new MovieDAO().selectFileNo(conn, saveFile);
		if(result1 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}

	public int insertMovie(Movie m) {
		Connection conn = getConnection();
		
		int result = new MovieDAO().insertMovie(conn, m);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public HashMap<String, Movie> searchMovie(String movieTitle) {
		Connection conn = getConnection();
		HashMap<String, Movie> m = new MovieDAO().searchMovie(conn, movieTitle);
		close(conn);
		return m;
	}
	
	public Review searchGradeReview(String movieTitle) {
		Connection conn = getConnection();
		Review r = new MovieDAO().searchGradeReview(conn, movieTitle);
		close(conn);
		return r;
	}
}
