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

import recruit.model.vo.Recruit;

public class recruitDAO {
	
	private Properties prop = new Properties();
	
	public recruitDAO() {
		//recruit게시글 받아옴
		String fileName = recruitDAO.class.getResource("/sql/recruit/board-query.properties").getPath();

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
			
			int finalResult = 0;
			if(result > 0) {
				finalResult = insertRecruit(conn,r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	private int insertRecruit(Connection conn, Recruit r) {
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
			
			pstmt.setInt(1, r.getrNo());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Recruit(rset.getInt("RECRUIT_NO"),
										rset.getString("RECRUIT_HEAD"),
										rset.getString("USER_ID"),
										rset.getString("BOARD_TITLE"),
										rset.getString("BOARD_CONTENT"),
										rset.getInt("BOARD_VIEWS"),
										rset.getDate("BOARD_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

}
