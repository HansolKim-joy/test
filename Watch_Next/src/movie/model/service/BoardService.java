package movie.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import common.Comment;
import listAll.model.BoardDAO;
import movie.model.dao.MovieDAO;
import movie.model.vo.Dib;
import movie.model.vo.Movie;
import recruit.model.vo.Recruit;
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

	public int insertDib(String user_id, int movie_no) {
		Connection conn = getConnection();
		int result = new MovieDAO().insertDib(conn, user_id, movie_no);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Dib searchDib(int i) {
		Connection conn = getConnection();
		Dib d = new MovieDAO().searchDib(conn, i);
		close(conn);
		return d;
	}

	public int DeleteDib(String user_id, int movie_no) {
		Connection conn = getConnection();
		int result = new MovieDAO().deleteDib(conn, user_id, movie_no);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Review> selectMyReview(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Review> ReviewList = new BoardDAO().selectMyReview(conn, userId);
		
		close(conn);
		return ReviewList;
	}

	public ArrayList<Recruit> selectMyRecruit(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Recruit> RecruitList = new BoardDAO().selectMyRecruit(conn, userId);
		close(conn);
		return RecruitList;
	}

	public ArrayList<Movie> selectMyDib(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Movie> DibList = new BoardDAO().selectMyDib(conn, userId);
		close(conn);
		return DibList;
	}

	public ArrayList<Comment> selectComment(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Comment> ReviewComlist = new BoardDAO().selectComment(conn, userId);
		close(conn);
		return ReviewComlist;
	}

	public ArrayList<Comment> selectRcComment(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Comment> RecruitComlist = new BoardDAO().selectRcComment(conn, userId);
		close(conn);
		return RecruitComlist;
	}
}
