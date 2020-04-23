package listAll.model.dao;

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

import Funding.model.vo.Demand;
import board.model.dao.RecBoardDAO;
import common.Comment;
import create.model.vo.Create;
import listAll.model.vo.MyFollow;
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
		// SELECT BOARD_NO, BOARD_TITLE, BOARD_VIEWS, BOARD_DATE, REVIEW_GRADE, REVIEW_MOVIE_TITLE FROM TB_BOARD JOIN TB_REVIEW ON (REVIEW_NO = BOARD_NO) WHERE USER_ID=?
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
				r = new Review(rset.getInt("board_no"), 
								rset.getString("spo_chk_yn"),
								rset.getString("board_title"), 
								rset.getInt("board_views"), 
								rset.getDate("board_date"),
								rset.getInt("review_grade"), 
								rset.getString("review_movie_title"));
				
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
				mo = new Movie( rset.getInt("movie_no"),
								rset.getString("movie_title"),
								rset.getString("service_site"),
								rset.getString("file_newname"));
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
	
	public ArrayList<Comment> selectComment(Connection conn, String userId) {
		// SELECT BOARD_NO, BOARD_TITLE, REVIEW_MOVIE_TITLE, TB_COMMENTS.USER_ID, COMMENTS_COTENT, COMMENTS_DATE 
		// FROM TB_BOARD JOIN TB_REVIEW ON (BOARD_NO = REVIEW_NO) JOIN TB_COMMENTS USING (BOARD_NO) WHERE TB_COMMENTS.USER_ID=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Comment co = null;
		ArrayList<Comment> ReviewComlist = new ArrayList<Comment>();
		
		String query = prop.getProperty("selectRvCom");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				co = new Comment(rset.getInt("board_no"),
								rset.getString("bwriter"),
								rset.getString("board_title"),
								rset.getString("review_movie_title"),
								rset.getString("comments_cotent"),
								rset.getDate("comments_date"));
				
				System.out.println("dao" + co);
				ReviewComlist.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ReviewComlist;
	}
	public ArrayList<Comment> selectRcComment(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Comment co = null;
		ArrayList<Comment> RecruitComlist = new ArrayList<Comment>();
		
		String query = prop.getProperty("selectRcCom");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				co = new Comment(rset.getInt("board_no"),
									rset.getString("bwriter"),
									rset.getString("board_title"),
									rset.getString("recruit_head"), 
									rset.getString("comments_cotent"),
									rset.getDate("comments_date"));
				RecruitComlist.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return RecruitComlist;
	}
	public ArrayList<Demand> iwriteFunding(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Demand d = null;
		ArrayList<Demand> IwriteFund = new ArrayList<Demand>();
		
		String query = prop.getProperty("iwriteFunding");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				d = new Demand(rset.getString("screening_movie_name"),
								rset.getString("movie_title"),
								rset.getInt("demand_price"),
								rset.getDate("demand_end_date"),
								rset.getInt("nowmoney"));
				
//				System.out.println("IwroteDao" + d);
				IwriteFund.add(d);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return IwriteFund;
	}
	public ArrayList<MyFollow> selectFollow(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MyFollow mf = null;
		ArrayList<MyFollow> FollowList = new ArrayList<MyFollow>();
		
		String query = prop.getProperty("selectfollow");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mf = new MyFollow(rset.getString("follow_user_id"),
								  rset.getInt("bwritecnt"), 
								  rset.getInt("cwritecnt"));
				FollowList.add(mf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return FollowList;
	}
	public ArrayList<Demand> selectOpenFunding(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Demand d = null;
		ArrayList<Demand> OpenFunding = new ArrayList<Demand>();
		
		String query = prop.getProperty("openfunding");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				d = new Demand(rset.getString("requestp"),
							   rset.getInt("demand_want_price"),
							   rset.getString("screening_movie_name"),
							   rset.getString("movie_title"),
							   rset.getInt("demand_price"));
				OpenFunding.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return OpenFunding;
	}
	
	public ArrayList<Demand> selectClosedFunding(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Demand d = null;
		ArrayList<Demand> CloseFunding = new ArrayList<Demand>();
		
		String query = prop.getProperty("closefunding");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				d = new Demand(rset.getString("requestp"),
							   rset.getInt("demand_want_price"),
							   rset.getString("screening_movie_name"),
							   rset.getString("movie_title"),
							   rset.getInt("demand_price"));
				CloseFunding.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return CloseFunding;
	}
	public ArrayList<Create> selectCreate(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Create c = null;
		ArrayList<Create> CreateList = new ArrayList<Create>();
		
		String query = prop.getProperty("selectCreate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Create(rset.getInt("create_no"),
							   rset.getString("file_newname"),
							   rset.getString("create_director"),
							   rset.getString("board_title"),
							   rset.getDate("board_date"));
				CreateList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return CreateList;
	}
	public ArrayList<Comment> selectCcomment(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Comment c = null;
		ArrayList<Comment> CreateComList = new ArrayList<Comment>();
		
		String query = prop.getProperty("selectCCom");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Comment(rset.getInt("board_no"),
							     rset.getString("bwriter"),
							     rset.getString("create_director"),
							     rset.getString("board_title"),
							     rset.getString("comments_cotent"),
							     rset.getDate("comments_date"));
				CreateComList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return CreateComList;
	}
	
}
