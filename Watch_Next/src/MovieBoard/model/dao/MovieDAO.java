package MovieBoard.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import MovieBoard.model.vo.Movie;
import MovieBoard.model.vo.Review;

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

	public ArrayList<Movie> MovieList(Connection conn, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Movie> list = null;
		String sql = prop.getProperty("MovieList");
		int startRow = (currentPage - 1) * boardLimit + 1;
		int endRow = startRow + boardLimit - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Movie>();
			
			while(rset.next()) {
				Movie m = new Movie(rset.getInt("movie_no"),
						 rset.getString("movie_title"),
						 rset.getString("file_newname")
						);
				list.add(m);
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
			pstmt.setString(1, m.getMovieTitle());
			pstmt.setString(2, m.getDirector());
			pstmt.setString(3, m.getActor());
			pstmt.setDate(4, m.getReleaseDate());
			pstmt.setString(5, m.getCountry());
			pstmt.setString(6, m.getStory());
			pstmt.setInt(7, m.getGenreNo());
			pstmt.setInt(8, m.getFileNo());
			pstmt.setString(9, m.getRunningTime());
			pstmt.setString(10, m.getServiceSite());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public Movie searchMovie(Connection conn, String movieTitle) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Movie m = null;
		String sql = prop.getProperty("searchMovie");
		// select * from MLIST where MOVIE_TITLE = ?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			
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
						rset.getString("genre"),
						rset.getString("file_newname"),
						rset.getString("service_site")
						// 여기에 get메소드 넣기
						// 이미지도 가져와야하니 newname도 가져와야함
						// 뭐뭐가져와야하는지 학교가서 보자
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
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
