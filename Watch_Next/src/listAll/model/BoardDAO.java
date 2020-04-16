package listAll.model;

import static common.JDBCTemplate.*;

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
	public ArrayList<Board> selectMyboard(Connection conn, String userId) {
		// select * from tb_board where user_id=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		String query = prop.getProperty("selectAll");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			System.out.println("DAO" + rset);
			while(rset.next()) {
				b = new Board(rset.getInt("board_no"), 
								rset.getString("user_id"),
								rset.getString("board_title"),
								rset.getString("board_content"),
								rset.getInt("board_views"),
								rset.getDate("board_date"),
								rset.getString("board_dec_yn").charAt(0),
								rset.getString("board_delete_yn").charAt(0));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
}
