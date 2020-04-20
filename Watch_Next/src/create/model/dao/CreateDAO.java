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

import create.model.vo.Create;

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
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? OR CREATE_DIRECTOR LIKE ? ORDER BY BOARD_DATE DESC";
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
					SQL = "SELECT * FROM CRLIST WHERE RNUM BETWEEN ? AND ? AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? OR CREATE_DIRECTOR LIKE ? ORDER BY CREATE_LIKE DESC";
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
		// insertCreate1 = insert into tb_board values(seq_bid.nextval, ?, ?, ?, 0, sysdate, default, default)
		
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
		// insertCreate2 = insert into tb_create values(seq_bid.currval, seq_fno.nextval, ?, 0, 0)
		
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
	
	
	
	
	
}
