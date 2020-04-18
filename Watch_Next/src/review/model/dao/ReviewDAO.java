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

import common.Comment;
import review.model.vo.Review;

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


	public ArrayList<Review> selectList(Connection conn, int currentPage, int boardLimit, String sk, String sv, String sk2) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = null;
		String SQL ="";
		
		String query = prop.getProperty("selectList");
		
		int startRow = (currentPage -1) * boardLimit +1;
		int endRow = startRow + boardLimit -1;
				try {
				if(sk2.equals("스포선택")) {
					if(sk.equals("전체")) {
						SQL = "SELECT * FROM RVLIST WHERE RNUM BETWEEN ? AND ? AND REVIEW_MOVIE_TITLE LIKE ? OR BOARD_TITLE LIKE ? OR USER_ID LIKE ? OR BOARD_CONTENT LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						pstmt.setString(3, "%" + sv + "%");
						pstmt.setString(4, "%" + sv + "%");
						pstmt.setString(5, "%" + sv + "%");
						pstmt.setString(6, "%" + sv + "%");
					} else if(sk.equals("영화제목")) {
						SQL = "SELECT * FROM RVLIST WHERE RNUM BETWEEN ? AND ? AND REVIEW_MOVIE_TITLE LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setInt(1, startRow); 
						pstmt.setInt(2, endRow);
						pstmt.setString(3, "%" + sv + "%");
						
					} else if(sk.equals("리뷰제목")) {
						SQL = "SELECT * FROM RVLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						pstmt.setString(3, "%" + sv + "%");
						
					} else if(sk.equals("작성자")) {
						SQL = "SELECT * FROM RVLIST WHERE RNUM BETWEEN ? AND ? AND USER_ID LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						pstmt.setString(3, "%" + sv + "%");
						
					} else if(sk.equals("내용")) {
						SQL = "SELECT * FROM RVLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_CONTENT LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
						pstmt.setString(3, "%" + sv + "%");
					}//"스포선택" if문끝
					
				} else {
					if(sk.equals("전체")) {
						SQL = "SELECT * FROM RVLIST WHERE SPO_CHK_YN=? AND RNUM BETWEEN ? AND ? AND REVIEW_MOVIE_TITLE LIKE ? OR BOARD_TITLE LIKE ? OR USER_ID LIKE ? OR BOARD_CONTENT LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, sk2);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						pstmt.setString(4, "%" + sv + "%");
						pstmt.setString(5, "%" + sv + "%");
						pstmt.setString(6, "%" + sv + "%");
						pstmt.setString(7, "%" + sv + "%");
					} else if(sk.equals("영화제목")) {
						SQL = "SELECT * FROM RVLIST WHERE SPO_CHK_YN=? AND RNUM BETWEEN ? AND ? AND REVIEW_MOVIE_TITLE LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, sk2);
						pstmt.setInt(2, startRow); 
						pstmt.setInt(3, endRow);
						pstmt.setString(4, "%" + sv + "%");
						
					} else if(sk.equals("리뷰제목")) {
						SQL = "SELECT * FROM RVLIST WHERE SPO_CHK_YN=? AND RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, sk2);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						pstmt.setString(4, "%" + sv + "%");
						
					} else if(sk.equals("작성자")) {
						SQL = "SELECT * FROM RVLIST WHERE SPO_CHK_YN=? AND RNUM BETWEEN ? AND ? AND USER_ID LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, sk2);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						pstmt.setString(4, "%" + sv + "%");
						
					} else if(sk.equals("내용")) {
						SQL = "SELECT * FROM RVLIST WHERE SPO_CHK_YN=? AND RNUM BETWEEN ? AND ? AND BOARD_CONTENT LIKE ?";
						pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, sk2);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						pstmt.setString(4, "%" + sv + "%");
						
					}else{
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, startRow);
						pstmt.setInt(2, endRow);
					}
				}	
					
					rset = pstmt.executeQuery();
					list = new ArrayList<Review>();
					
					while(rset.next()) {
						Review r = new Review( rset.getInt("rnum"),
								  rset.getInt("board_no"),
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
			pstmt.setString(1, r.getbWriter());
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
				r = new Review(rset.getInt("rnum"),
						  rset.getInt("board_no"),
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
	
	public ArrayList<Comment> selectReplyList(Connection conn, int refBid) {
		// selectReplyList=select * from tb_comments where board_no=? and comments_delete_yn='N'
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, refBid);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Comment>();
			
			while(rset.next()) {
				list.add(new Comment(rset.getInt("comments_no"),
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

	public int insertReply(Connection conn, Comment re) {
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


	
	 public ArrayList<Review> choiceHead(Connection conn, String choice) {
	 PreparedStatement pstmt = null; ResultSet rset = null; ArrayList<Review>
	 cList = null; String query = prop.getProperty("choiceHead");
	  
	 try { pstmt = conn.prepareStatement(query); pstmt.setString(1, choice); rset
	= pstmt.executeQuery();
	  
	  while(rset.next()) { Review r = new Review(rset.getInt("rnum"),
	  rset.getInt("board_no"), rset.getString("user_id"),
	  rset.getString("spo_chk_yn"), rset.getString("board_title"),
	  rset.getString("review_movie_title"), rset.getInt("review_grade"),
	  rset.getString("board_content"), rset.getInt("review_like"),
	  rset.getInt("board_views"), rset.getDate("board_date"),
	  rset.getString("board_delete_yn"));
	  
	  cList.add(r); } } catch (SQLException e) { e.printStackTrace(); }
	  
	  
	  return cList; }
	


	public int like(Connection conn, int bid) {
		String SQL = "update tb_review set review_like = review_like +1 where review_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		
		return -1;
		
	}


	public ArrayList<Review> selectSpoList(Connection conn, String spo) {
		// selectSpoList = select * from rvlist where spo_chk_yn=?
		
					System.out.println("dao_spo는?"+spo);
					
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					ArrayList<Review> spolist = null;
					
					String query = prop.getProperty("selectSpoList");
					
					try {
						pstmt = conn.prepareStatement(query);
						pstmt.setString(1, spo);
						rset = pstmt.executeQuery();
						
						spolist = new ArrayList<Review>();
						
						while(rset.next()) {
							Review r = new Review( rset.getInt("rnum"),
									  rset.getInt("board_no"),
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
				
							spolist.add(r);
							System.out.println("dao spo : " + spolist);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					return spolist;
	}


	public int deleteReply(Connection conn, int rpno) {
		// deleteReply = update tb_comments set comments_delete_yn='Y' where comments_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rpno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public char getLike(Connection conn, String userId, int rv) {
		// getLike=SELECT * FROM TB_LIKEY WHERE USER_ID = ? AND BNO = ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		char chk=0;
		
		Review review = null;
		
		String query = prop.getProperty("getLike");
		
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, rv);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				chk = rs.getString("like_yn").charAt(0);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	
		return chk;
	}


	public int putLike(Connection conn, int rv, String userId) {
		// putLike = INSERT INTO TB_LIKEY VALUES(?, ?, 'Y')
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("putLike");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, rv);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int putLikeC(Connection conn, int rv) {
		// putLikeC=update tb_review set review_like = review_like + 1 where review_no = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String query = prop.getProperty("putLikeC");
		
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


	public int notLike(Connection conn, int rv, String userId) {
		// notLike = DELETE FROM TB_LIKEY WHERE USER_ID = ? AND BNO = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("notLike");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, rv);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int notLikeC(Connection conn, int rv) {
		// notLikeC=update tb_review set review_like = review_like - 1 where review_no = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String query = prop.getProperty("notLikeC");
		
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
	




	
	

}
