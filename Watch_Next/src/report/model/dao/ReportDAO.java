package report.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import report.model.vo.Report;

public class ReportDAO {
	
	private Properties prop = new Properties();
	
	public ReportDAO() {
		String fileName = ReportDAO.class.getResource("/sql/report/report-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReport(Connection conn, Report rep) {
		// insertReport=insert into tb_dec values(SEQ_DEC.NEXTVAL, ?, ?, ?, ?)
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rep.getDecContent());
			pstmt.setInt(2, rep.getBoardNo());
			pstmt.setNull(3, Types.INTEGER);
			pstmt.setString(4, rep.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReportR(Connection conn, Report rep) {
		// insertReportR=insert into tb_dec values(SEQ_DEC.NEXTVAL, ?, ?, ?, ?)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rep.getDecContent());
			pstmt.setNull(2, Types.VARCHAR);
			pstmt.setInt(3, rep.getCommentsNo());
			pstmt.setString(4, rep.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/*
	 * public int[] selectReportR(Connection conn, String userId) { // getReportC =
	 * select * from tb_dec where user_id=? PreparedStatement pstmt = null;
	 * ResultSet rset = null; int[] repRp = null;
	 * 
	 * String query = prop.getProperty("getReportC"); try { pstmt =
	 * conn.prepareStatement(query); pstmt.setString(1,userId);
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * for(int i = 0; rset.next(); i++) { repRp[i] = rset.getInt("COMMENTS_NO"); } }
	 * catch (SQLException e) { e.printStackTrace(); } finally { close(rset);
	 * close(pstmt); }
	 * 
	 * return repRp; }
	 */

}
