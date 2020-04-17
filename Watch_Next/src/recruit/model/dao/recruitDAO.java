package recruit.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.Comment;
import recruit.model.vo.Recruit;

public class recruitDAO {
	
	private Properties prop = new Properties();
	
	public recruitDAO() {
		//recruit게시글 받아옴
		String fileName = recruitDAO.class.getResource("/sql/recruit/recruit-query.properties").getPath();

    try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getListCount(Connection conn) {
		//select count(*) from tb_recruit 
		//게시판의 총 글 개수
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return result;
	}


	public ArrayList<Recruit> selectList(Connection conn, int currentPage, int boardLimit) {
		//db에서 게시글 받아옴
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Recruit> list = null;
		
		String query = prop.getProperty("selectList");
		
		 int startRow = (currentPage - 1) * boardLimit + 1; 
		 int endRow = startRow + boardLimit - 1;
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Recruit>();
			
			while(rset.next()) {
				Recruit r = new Recruit(rset.getInt("RECRUIT_NO"),
										rset.getString("RECRUIT_HEAD"),
										rset.getString("board_title"),
										rset.getDate("board_date"),
										rset.getString("user_id"),
										rset.getInt("board_views"));
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


	public int insertBoard(Connection conn, Recruit r) {
		// 게시글 작성
		// insert into tb_recruit values(seq_board, ?, ?, ?, ?, ?)
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getUserId());
			pstmt.setString(2, r.getbTitle());
			pstmt.setString(3, r.getbContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int insertRecruit(Connection conn, Recruit r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRecruit");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, r.getrHead());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}


	public int updateCount(Connection conn, int rNo) {
		//조회수
		// update tb_recruit set board_views = board_views + 1 where rNo = ?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public Recruit selectBoard(Connection conn, int rNo) {
		// select * from recdetail where rNo=?
		//게시글 선택
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Recruit r = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				r = new Recruit(rset.getInt("RECRUIT_NO"),
										rset.getString("RECRUIT_HEAD"),
										rset.getString("BOARD_TITLE"),
										rset.getString("BOARD_CONTENT"),
										rset.getString("USER_ID"),
										rset.getInt("BOARD_VIEWS"),
										rset.getDate("BOARD_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public int updateBoard(Connection conn, Recruit r) {
		//게시글 수정
		//update tb_board set bTitle?, bContent?  where board_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, r.getbTitle());
			pstmt.setString(2, r.getbContent());
			pstmt.setInt(3, r.getrNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	public int updateRecruit(Connection conn, Recruit r) {
		//게시글 수정
		//update tb_recruit set recruit_head? where recruit_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateRecruit");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, r.getrHead());
			pstmt.setInt(2, r.getrNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteRecruit(Connection conn, int rNo) {
		//게시글 삭제
		//update tb_board set BOARD_DELETE_YN='Y' where board_no=?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteRecruit");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, rNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public ArrayList<Recruit> choiceHead(Connection conn, String choice) {
		//검색옵션(넷플 / 왓챠)
		//select RECRUIT_NO, RECRUIT_HEAD, BOARD_NO, USER_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_VIEWS, BOARD_DATE from tb_recruit 
		//join tb_board on (recruit_no = board_no) where recruit_head = ?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Recruit> cList = null;
		String query = prop.getProperty("choiceHead");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, choice);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				cList.add(new Recruit(
						rset.getInt("RECRUIT_NO"), 
						rset.getString("RECRUIT_HEAD"),
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"), 
						rset.getString("USER_ID"),
						rset.getInt("BOARD_VIEWS"),
						rset.getDate("BOARD_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cList;
	}


	public ArrayList<Comment> selectComment(Connection conn, int rNo) {
		//db에서 댓글 가져옴
		//select * from tb_comments where board_no=? 
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> comment = null;
		
		String query = prop.getProperty("selectComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			
			rset = pstmt.executeQuery();
			
			comment = new ArrayList<Comment>();
			System.out.println("selectComment " + rset);
			while(rset.next()) {
				comment.add(new Comment(rset.getInt("comments_no"),
									     rset.getString("comments_cotent"),
										 rset.getInt("board_no"),
										 rset.getString("user_id"),
										 rset.getDate("comments_date"),
										 rset.getString("comments_dec_yn"),
										 rset.getString("comments_delete_yn")));
							}
			
			System.out.println("comment " + comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return comment;
	}


	public int insertComment(Comment co, Connection conn) {
		//댓글 입력
		//insert into tb_comments values(seq_rid.nextval, ?, ?, ?, sysdate, default, default)
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, co.getRefBid());
			pstmt.setString(2, co.getrWriter());
			pstmt.setString(3, co.getrContent());
			
			result = pstmt.executeUpdate();
			
			System.out.println("댓글입력" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	  public int deleteComment(Connection conn, int rId) { 
		  //댓글 삭제 
		  //update tb_comments set COMMENTS_DELETE_YN='Y' where COMMENTS_NO=? 
		  PreparedStatement pstmt = null; 
		  int result = 0;
		  
		  String query = prop.getProperty("deleteComment");
		  
		  try { 
			  pstmt = conn.prepareStatement(query); 
			  
			  pstmt.setInt(1, rId);
			  
			  result = pstmt.executeUpdate();
		  } catch (SQLException e) { 
			  e.printStackTrace(); 
		  }finally { 
			  close(pstmt); 
		  }
		  
		  return result;
		  }
	 



}
