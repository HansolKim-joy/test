package create.model.dao;

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
import create.model.vo.CFile;
import create.model.vo.Create;
import movie.model.vo.File;

public class CreateDAO {
	
	private Properties prop = new Properties();
	
	public CreateDAO() {
		String fileName = CreateDAO.class.getResource("/sql/create/create-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Create> selectList(Connection conn, int currentPage, int boardLimit, String sk, String sv, String sk2) {
		// SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Create> list = null;
		String SQL="";
		
		String query = prop.getProperty("selectList");
		
		int startRow = (currentPage -1) * boardLimit +1;
		int endRow = startRow + boardLimit -1;
		
		try {
			if(sk2.equals("최신순")) {
				if(sk.equals("전체")) {
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND (BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? OR CREATE_DIRECTOR LIKE ?) ORDER BY BOARD_DATE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
					pstmt.setString(4, "%" + sv + "%");
					pstmt.setString(5, "%" + sv + "%");
				} else if(sk.equals("제목")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ? ORDER BY BOARD_DATE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else if(sk.equals("감독")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND CREATE_DIRECTOR LIKE ? ORDER BY BOARD_DATE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else if(sk.equals("내용")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_CONTENT LIKE ? ORDER BY BOARD_DATE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else {
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
				}
			} else { //추천순
				if(sk.equals("전체")) {
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND (BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? OR CREATE_DIRECTOR LIKE ?) ORDER BY CREATE_LIKE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
					pstmt.setString(4, "%" + sv + "%");
					pstmt.setString(5, "%" + sv + "%");
				} else if(sk.equals("제목")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ? ORDER BY CREATE_LIKE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else if(sk.equals("감독")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND CREATE_DIRECTOR LIKE ? ORDER BY CREATE_LIKE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else if(sk.equals("내용")){
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_CONTENT LIKE ? ORDER BY CREATE_LIKE DESC";
					pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					pstmt.setString(3, "%" + sv + "%");
				} else {
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
				}
			}
			
			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Create>();
			
			while(rset.next()) {
				Create c = new Create(rset.getInt("RNUM"),
									  rset.getInt("BOARD_NO"),
									  rset.getInt("FILE_NO"),
									  rset.getString("USER_ID"),
									  rset.getString("BOARD_TITLE"),
									  rset.getString("CREATE_DIRECTOR"),
									  rset.getString("BOARD_CONTENT"),
									  rset.getInt("CREATE_LIKE"),
									  rset.getInt("BOARD_VIEWS"),
									  rset.getInt("CREATE_COMMS"),
									  rset.getString("BOARD_DEC_YN"),
									  rset.getDate("BOARD_DATE"),
									  rset.getString("BOARD_DELETE_YN"));
				
				list.add(c);
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
		// select count(*) from CRLIST where board_delete_yn='N'
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

	public int insertCreate1(Connection conn, Create c) {
		// insertCreate1 = insert into tb_board values(seq_board.nextval, ?, ?, ?, 0, sysdate, default, default)
		
		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = prop.getProperty("insertCreate1");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getbWriter());
			pstmt.setString(2, c.getbTitle());
			pstmt.setString(3, c.getbContent());
			
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result1;
	}

	public int insertCreate2(Connection conn, Create c) {
		// insertCreate2 = insert into tb_create values(seq_board.currval, seq_fno.nextval, ?, 0, 0)
		
		PreparedStatement pstmt = null;
		int result2 = 0;
		
		String query = prop.getProperty("insertCreate2");
			
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getcDirector());
			
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result2;
	}
	

	public int updateCount(Connection conn, int rNo) {
		// 조회수
		//update tb_board set board_views = board_views + 1 where board_no = ?
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

	public Create selectCreate(Connection conn, int rNo) {
		// select * from crlist where board_no=?
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Create c = null;
		
		String query = prop.getProperty("selectCreate");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, rNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Create(rset.getInt("rnum"),
								rset.getInt("board_no"),
								rset.getInt("FILE_NO"),
								rset.getString("user_id"),
								rset.getString("board_title"),
								rset.getString("CREATE_DIRECTOR"),
								rset.getString("board_content"),
								rset.getInt("CREATE_LIKE"),
								rset.getInt("BOARD_VIEWS"),
								rset.getInt("CREATE_COMMS"),
								rset.getDate("BOARD_DATE"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}
	
	public int updateBoard(Connection conn, Create c) {
		//게시글 수정
		//update tb_board set BOARD_TITLE=?, BOARD_CONTENT=? where board_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, c.getbTitle());
			pstmt.setString(2, c.getbContent());
			pstmt.setInt(3, c.getbNO());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	

	public int updateCreate(Connection conn, Create c) {
		//게시글 수정
		//update TB_CREATE set FILE_NO=? CREATE_DIRECTOR=? where CREATE_NO = ?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCreate");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, c.getfNo());
			pstmt.setString(2, c.getcDirector());
			pstmt.setInt(3, c.getbNO());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	
	public ArrayList<Comment> selectComment(Connection conn, int rNo) {
		// select * from tb_comments where board_no=? and comments_delete_yn='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> comment = new ArrayList<Comment>();
		
		String query = prop.getProperty("selectComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				comment.add(new Comment(rset.getInt("comments_no"),
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
	
	
	public char getLike(Connection conn, String userId, int rNo) {
		// select * from tb_likey where user_id = ? and bno = ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		char chk=0;
		
		Create create = null;
		
		String query = prop.getProperty("getLike");
		
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, rNo);
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

	public int putLike(Connection conn, int rNo, String userId) {
		// putLike = INSERT INTO TB_LIKEY VALUES(?, ?, 'Y')
				PreparedStatement pstmt = null;
				int result = 0;
				
				String query = prop.getProperty("putLike");
				
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, userId);
					pstmt.setInt(2, rNo);
					
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				
				
				return result;
	}

	public int putLikeC(Connection conn, int rNo) {
		// putLikeC=update tb_create set create_like = create_like + 1 where create_no = ?
				PreparedStatement pstmt = null;
				int result = 0;
				
				
				String query = prop.getProperty("putLikeC");
				
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

	public int notLike(Connection conn, int rNo, String userId) {
		// notLike = DELETE FROM TB_LIKEY WHERE USER_ID = ? AND BNO = ?
				PreparedStatement pstmt = null;
				int result = 0;
				
				String query = prop.getProperty("notLike");
				
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, userId);
					pstmt.setInt(2, rNo);
					
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				
				
				return result;
	}

	public int notLikeC(Connection conn, int rNo) {
		// notLikeC=update tb_review set review_like = review_like - 1 where review_no = ?
				PreparedStatement pstmt = null;
				int result = 0;
				
				
				String query = prop.getProperty("notLikeC");
				
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

	public int deleteCreate(Connection conn, int rNo) {
		// 창작글 삭제
		//update tb_board set board_delete_yn='Y' where board_no=?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteCreate");
		
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

	public String getWriter(Connection conn, int cNo) {
		// getWriter = SELECT USER_ID FROM TB_BOARD WHERE BOARD_NO = ?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Create c = null;
		String writer = null;
		
		String query = prop.getProperty("getWriter");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				writer = rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return writer;
	}

	public char getFollow(Connection conn, String userId, String writer) {
		// getFollow=SELECT * FROM TB_FOLLOW WHERE USER_ID = ? AND FOLLOW_USER_ID = ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		char fchk = 0;
		
		Create create = null;
		
		String query = prop.getProperty("getFollow");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			pstmt.setString(2, writer);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				fchk = rs.getString("follow_yn").charAt(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return fchk;
	}

	public int putFollow(Connection conn, int cNo, String writer, String userId) {
		// putFollow = INSERT INTO TB_FOLLOW VALUES(?, ?, SEQ_FOLLOW.NEXTVAL, 'Y')
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("putFollow");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, writer);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int notFollow(Connection conn, int cNo, String userId, String writer) {
		// notFollow = DELETE FROM TB_FOLLOW WHERE USER_ID = ? AND FOLLOW_USER_ID = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("notFollow");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  userId);
			pstmt.setString(2, writer);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertCommentC(Comment co, Connection conn) {
		// insertCommentC= update tb_create set create_comms = create_comms+1 where create_no=?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertCommentC");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, co.getRefBid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int deleteCommentC(Connection conn, int rNo) {
		// deleteCommentC= update tb_create set create_comms = create_comms-1 where create_no=? 
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteCommentC");
		
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

	/*public ArrayList<File> selectFList(Connection conn) {
		// selectFList=select * from tb_file
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<File> list = null;
		
		String query = prop.getProperty("selectFList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<File>();
			
			while(rs.next()) {
				list.add(new Attachment(rs.getInt("bid"), rs.getString("chang_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return list;
	}*/


	public int insertPoster(Connection conn, ArrayList<CFile> fileList) {
		//insertPoster=insert into tb_cfile values(seq_board.currval ,seq_fno.NEXTVAL, ?, ?, ?, 'N')
		PreparedStatement pstmt = null;
//		ArrayList<File> list = new ArrayList<File>();
		int result = 0;
		
		String sql = prop.getProperty("insertPoster");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				CFile at = fileList.get(i);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginNames());
				pstmt.setString(2, at.getNewNames());
				pstmt.setInt(3, at.getFileleve());
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<CFile> selectCFlist(Connection conn) {
		// selectFList = select * from tb_cfile where file_level=0 and delete_yn='N'
		
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<CFile> flist = null;
		
		String query = prop.getProperty("selectFList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			flist = new ArrayList<CFile>();
			
			while(rset.next()) {
				flist.add(new CFile(rset.getInt("board_no"),
									rset.getString("file_newname")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return flist;
	}

	public ArrayList<CFile> selectFile(Connection conn, int cNo) {
		// selectFile=select * from tb_cfile where board_no = ? and file_level=1 and delete_yn='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CFile> list = null;
		
		String query = prop.getProperty("selectFile");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CFile>();
			
			while(rset.next()) {
				CFile cf = new CFile();
				cf.setfNo(rset.getInt("file_no"));
				cf.setOriginNames(rset.getString("file_oriname"));
				cf.setNewNames(rset.getString("file_newname"));
				
				list.add(cf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public int updatePoster(Connection conn, ArrayList<CFile> fileList) {
		// updatePoster=update tb_cfile set file_oriname=?, file_newname=?, file_level=? where board_no=?
		// updatePoster=insert into tb_cfile values(? ,seq_fno.NEXTVAL, ?, ?, ?, 'N')
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("updatePoster");
		
		
			
			try {
				for(int i=0; i<fileList.size(); i++) {
					CFile cf = fileList.get(i);
					
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cf.getbNo());
				pstmt.setString(2, cf.getOriginNames());
				pstmt.setString(3, cf.getNewNames());
				pstmt.setInt(4, cf.getFileleve());
				
				
				result += pstmt.executeUpdate();
				} 
				
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			
		
		return result;
			
	}

	public int deletePoster(Connection conn, ArrayList<CFile> fileList) {
		// deletePoster = update tb_cfile set delete_yn='Y' where board_no=?
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deletePoster");
		
		try {
			
			for(int i=0; i<fileList.size(); i++) {
				CFile cf = fileList.get(i);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cf.getbNo());
			
			result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}



	

	

	

	
	
	
	
	
}

