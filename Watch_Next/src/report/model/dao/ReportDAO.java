package report.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// insertReport=insert into tb_dec values(?, ?, ?, ?, ?)
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1);
			pstmt.setString(2, "임시내용");
			pstmt.setInt(3, rep.getBoardNo());
			pstmt.setInt(4, 1);
			pstmt.setString(5, "user01");
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
