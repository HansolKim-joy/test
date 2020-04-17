package listAll.model;

import static common.JDBCTemplate.close;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import board.model.dao.RecBoardDAO;
import board.model.vo.Board;
import movie.model.vo.Movie;
import recruit.model.vo.Recruit;
import review.model.vo.Review;

public class BoardDAO {
	
	private Properties prop = new Properties();
		
		public BoardDAO() {
			String fileName = RecBoardDAO.class.getResource("/sql/listall/list_all.properties").getPath();
			try {
				prop.load(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public ArrayList<Review> selectMyReview(Connection conn, String userId) {
		// SELECT BOARD_NO, BOARD_TITLE, BOARD_VIEWS, BOARD_DATE, REVIEW_GRADE FROM TB_BOARD JOIN TB_REVIEW ON (REVIEW_NO = BOARD_NO) WHERE USER_ID=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		ArrayList<Review> ReviewList = new ArrayList<Review>();
		
		String query = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
//			System.out.println("DAO" + rset);
			while(rset.next()) {
				r = new Review(rset.getInt("board_no"), rset.getString("board_title"), 
								rset.getInt("board_views"), rset.getDate("board_date"), rset.getInt("review_grade"));
				
				ReviewList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return ReviewList;
	}
	public ArrayList<Recruit> selectMyRecruit(Connection conn, String userId) {
		// SELECT BOARD_NO, BOARD_TITLE, BOARD_VIEWS, BOARD_DATE, RECRUIT_HEAD FROM TB_BOARD JOIN TB_RECRUIT ON (RECRUIT_NO = BOARD_NO) WHERE USER_ID=? AND BOARD_DELETE_YN ='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Recruit rc = null;
		ArrayList<Recruit> RecruitList = new ArrayList<Recruit>();
		
		String query = prop.getProperty("selectRecruit");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rc = new Recruit(rset.getInt("board_no"), rset.getString("board_title"), rset.getInt("board_views"),
									rset.getDate("board_date"), rset.getString("recruit_head"));
				RecruitList.add(rc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return RecruitList;
	}
	public ArrayList<Movie> selectMyDib(Connection conn, String userId) {
		// select movie_no, director, movie_title, service_site from tb_user join tb_dib using (user_id) join tb_movie using (movie_no) where user_id=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Movie mo = null;
		ArrayList<Movie> DibList = new ArrayList<Movie>();
		
		String query = prop.getProperty("selectDib");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mo = new Movie(rset.getInt("movie_no"), 
								rset.getString("director"),
								rset.getString("movie_title"),
								rset.getString("service_site"));
				DibList.add(mo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return DibList;
	}
	
}
