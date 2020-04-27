package letter.model.dao;
import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import letter.model.vo.Letter;
public class LetterDAO {
	private Properties prop = new Properties();
	public LetterDAO() {
		String fileName = LetterDAO.class.getResource("/sql/letter/letter-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Letter> getLetterList(Connection conn, String userId, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Letter> letterList = null;
		Letter l = null;
		int startRow = (currentPage - 1) * boardLimit + 1;
		int endRow = startRow + boardLimit - 1;
		String sql = prop.getProperty("getletterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			letterList = new ArrayList<Letter>();
			
			while(rs.next()) {
				l = new Letter(
						rs.getInt("message_no"),
						rs.getString("user_id2"),
						rs.getString("message_title"),
						rs.getString("message_content"),
						rs.getDate("message_date"),
						rs.getString("state").charAt(0),
						rs.getString("user_id")
						);
				letterList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return letterList;
	}
	public int getListCount(Connection conn, String userName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = prop.getProperty("getListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	public ArrayList<Letter> sendLetterList(Connection conn, String userId, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Letter> letterList = null;
		Letter l = null;
		int startRow = (currentPage - 1) * boardLimit + 1;
		int endRow = startRow + boardLimit - 1;
		String sql = prop.getProperty("sendletterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			letterList = new ArrayList<Letter>();
			
			while(rs.next()) {
				l = new Letter(
						rs.getInt("message_no"),
						rs.getString("user_id2"),
						rs.getString("message_title"),
						rs.getString("message_content"),
						rs.getDate("message_date"),
						rs.getString("state").charAt(0),
						rs.getString("user_id")
						);
				letterList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return letterList;
	}
	public int letterSend(Connection conn, Letter l) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("letterSend");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getUserId());
			pstmt.setString(2, l.getMsg_Title());
			pstmt.setString(3, l.getMsg_Content());
			pstmt.setString(4, l.getUserName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public String getUserId(Connection conn, String sendName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userId = "";
		
		String sql = prop.getProperty("getUserId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sendName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return userId;
	}
	public int getsendListCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = prop.getProperty("getsendListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	public Letter getDetailLetter(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Letter l = null;
		
		String sql = prop.getProperty("getDetailLetter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				l = new Letter(
						rs.getInt("message_no"),
						rs.getString("user_id"),
						rs.getString("message_title"),
						rs.getString("message_content"),
						rs.getDate("message_date"),
						rs.getString("state").charAt(0),
						rs.getString("user_id2")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return l;
	}
	public int deleteLetter(Connection conn, String[] no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteLetter");
		
		try {
			for(int i=0; i<no.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(no[i]));
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int allListCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = prop.getProperty("allListCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	public int updateStatus(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateStatus");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
