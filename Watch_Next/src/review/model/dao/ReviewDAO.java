package review.model.dao;

import static common.JDBCTemplate.close;

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

import review.model.vo.Review;
import review.model.vo.ReviewReply;

public class ReviewDAO {
	
	private Properties prop = new Properties();
	
	public ReviewDAO() {
		String fileName = ReviewDAO.class.getResource("/sql/review/review-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Review> selectList(Connection conn, int currentPage, int boardLimit) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = null;
		
		String query = prop.getProperty("selectList");
		
		int startRow = (currentPage -1) * boardLimit +1;
		int endRow = startRow + boardLimit -1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			while(rset.next()) {
				Review r = new Review(rset.getInt("board_no"),
		      			  rset.getString("user_id"),
		      			  rset.getString("spo_chk_yn"),
		      			  rset.getString("board_title"),
		      			  rset.getString("review_movie_title"),
		      			  rset.getInt("review_grade"),
		      			  rset.getString("board_content"),
		      			  rset.getInt("review_like"),
		      			  rset.getInt("board_views"),
		      			  rset.getDate("board_date"),
		      			  rset.getString("board_delete_yn"));
	
				list.add(r);
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
		// select count(*) from rvlist where board_delete_yn='N'
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return result;
	}


	public int insertReview1(Connection conn, Review r) {
		// insert into tb_board랑 tb_review에 각각 insert
		// insertReview1 = insert into tb_board values(seq_bid.nextval, ?, ?, ?, 0, sysdate, default, default)
		
		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = prop.getProperty("insertReview1");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "user01");//임시아이디 받아온 아이디로 바꿔넣어야함
			pstmt.setString(2, r.getbTitle());
			pstmt.setString(3, r.getbContent());
						
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}


	public int insertReview2(Connection conn, Review r) {
		// insertReview2 = insert into tb_review values(seq_bid.currval, ?, ?, ?, default)
		
		PreparedStatement pstmt = null;
		int result2 = 0;
		
		String query = prop.getProperty("insertReview2");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getSpo());
			pstmt.setString(2, r.getmTitle());
			pstmt.setInt(3, r.getPopcorn());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result2;
	}


	public int updateCount(Connection conn, int rv) {
		// update tb_board set board_views = board_views + 1 where board_no = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rv);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public Review selectReview(Connection conn, int rv) {
		// select * from rvlist where board_no = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		
		String query = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rv);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				r = new Review(rset.getInt("board_no"),
		      			  rset.getString("user_id"),
		      			  rset.getString("spo_chk_yn"),
		      			  rset.getString("board_title"),
		      			  rset.getString("review_movie_title"),
		      			  rset.getInt("review_grade"),
		      			  rset.getString("board_content"),
		      			  rset.getInt("review_like"),
		      			  rset.getInt("board_views"),
		      			  rset.getDate("board_date"),
		      			  rset.getString("board_delete_yn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	
	public ArrayList<ReviewReply> selectReplyList(Connection conn, int refBid) {
		// selectReplyList=select * from tb_comments where board_no=?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewReply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, refBid);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ReviewReply>();
			
			while(rset.next()) {
				list.add(new ReviewReply(rset.getInt("comments_no"),
									     rset.getString("comments_cotent"),
										 rset.getInt("board_no"),
										 rset.getString("user_id"),
										 rset.getDate("comments_date"),
										 rset.getString("comments_dec_yn"),
										 rset.getString("comments_delete_yn")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertReply(Connection conn, ReviewReply re) {
		// insert into tb_comments values(seq_rid.nextval, ?, ?, ?, sysdate, default, default)
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, re.getRefBid());
			pstmt.setString(2, re.getrWriter());
			pstmt.setString(3, re.getrContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int updateReview1(Connection conn, Review r) {
		// updateReview1 = update tb_board set board_title=?, board_content=? where board_no=?
				
		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = prop.getProperty("updateReview1");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getbTitle());
			pstmt.setString(2, r.getbContent());
			pstmt.setInt(3, r.getbNo());
						
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}


	public int updateReview2(Connection conn, Review r) {
		// updateReview2 = update tb_review set spo_chk_yn=?, review_movie_title=?, review_grade=? where review_no=?
		
		PreparedStatement pstmt = null;
		int result2 = 0;
		
		String query = prop.getProperty("updateReview2");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getSpo());
			pstmt.setString(2, r.getmTitle());
			pstmt.setInt(3, r.getPopcorn());
			pstmt.setInt(4, r.getbNo());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result2;
	}


	public int deleteReview(Connection conn, int rv) {
		// deleteReview = update tb_board set board_delete_yn='Y' where board_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReivew");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rv);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}


	




	
	

}