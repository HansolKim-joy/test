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
import java.util.ArrayList;
import java.util.Properties;

import common.Comment;
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

	public int insertReport(Connection conn, Report rep) { //게시글신고
		// insertReport=insert into tb_dec values(SEQ_DEC.NEXTVAL, ?, ?, ?, ?)
	
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rep.getDecContent());//내용
			pstmt.setInt(2, rep.getBoardNo());//게시판번호
			pstmt.setNull(3, Types.INTEGER);//리플번호
			pstmt.setString(4, rep.getUserId());//유저
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReportR(Connection conn, Report rep) { //댓글신고
		// insertReportR=insert into tb_dec values(SEQ_DEC.NEXTVAL, ?, ?, ?, ?)
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rep.getDecContent());//내용
			pstmt.setNull(2, Types.INTEGER);//게시판번호
			pstmt.setInt(3, rep.getCommentsNo());//리플번호
			pstmt.setString(4, rep.getUserId());//유저
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	/*public ArrayList<Comment> getRpNo(Connection conn, String userId) { 
		// getRpNo =select comments_no from tb_dec where user_id=? and comments_no is not null
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> repRp = null;
	
		String query = prop.getProperty("getRpNo"); 
		try { 
			pstmt =conn.prepareStatement(query); 
			pstmt.setString(1,userId);
			rset = pstmt.executeQuery();
			
			repRp = new ArrayList<Comment>();
		
			while(rset.next()) {
				repRp.add(new Comment )
			}
			
			for(int i = 0; rset.next(); i++) { 
				repRp[i] += rset.getInt("COMMENTS_NO"); //배열 list로 바꾸기
				
			} 
		
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} finally { 
			close(rset);
			close(pstmt); 
		}
		 
		return repRp; 
		
	}*/
	 

}
