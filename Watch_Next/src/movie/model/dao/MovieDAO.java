package movie.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import movie.model.vo.Movie;
import review.model.vo.Review;

import static common.JDBCTemplate.*;
public class MovieDAO {
	private Properties prop = new Properties();
	
	public MovieDAO() {
		String fileName = MovieDAO.class.getResource("/sql/movie/movie-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public HashMap<String, Movie> MovieList(Connection conn, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Movie> list = null;
		String sql = prop.getProperty("MovieList");
		int startRow = (currentPage - 1) * boardLimit + 1;
		int endRow = startRow + boardLimit - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new HashMap<String, Movie>();
			
			while(rset.next()) {
				Movie m = new Movie(rset.getInt("movie_no"),
						 rset.getString("movie_title")
						);
				list.put(rset.getString("file_newname"),m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection conn) {
		Statement stmt = null;
		int result = 0;
		
		String sql = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		
		return result;
	}

	public int insertPoster(Connection conn, String originFile, String saveFile) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertPoster");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, originFile);
			pstmt.setString(2, saveFile);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectFileNo(Connection conn, String saveFile) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = prop.getProperty("selectFileNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saveFile);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertMovie(Connection conn, Movie m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getmTitle());
			pstmt.setString(2, m.getmDirector());
			pstmt.setString(3, m.getmActor());
			pstmt.setDate(4, m.getmReleaseDate());
			pstmt.setString(5, m.getmCountry());
			pstmt.setString(6, m.getmStory());
			pstmt.setInt(7, m.getmGenre());
			pstmt.setInt(8, m.getmFileNo());
			pstmt.setString(9, m.getmRunningTime());
			pstmt.setString(10, m.getService_Site());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public HashMap<String, Movie> searchMovie(Connection conn, String movieTitle) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Movie> mMap = null;
		Movie m = null;
		String sql = prop.getProperty("searchMovie");
		// select * from MLIST where MOVIE_TITLE = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			mMap = new HashMap<String, Movie>();
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Movie(
						rset.getInt("movie_no"),
						rset.getString("movie_title"),
						rset.getString("director"),
						rset.getString("actor"),
						rset.getString("runningtime"),
						rset.getDate("releasedate"),
						rset.getString("country"),
						rset.getString("story"),
						rset.getString("service_site")
						);
				mMap.put(rset.getString("file_newname") + ", " + rset.getString("genre"), m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mMap;
	}
	public Review searchGradeReview(Connection conn, String movieTitle) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		
		String sql = prop.getProperty("searchGradeReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(
						rset.getInt("review_no"),
						rset.getString("board_content")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
}
