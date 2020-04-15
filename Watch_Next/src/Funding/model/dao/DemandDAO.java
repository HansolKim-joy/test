package Funding.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import Funding.model.vo.Demand;
import Funding.model.vo.DemandList;


public class DemandDAO {
	private Properties prop = new Properties();
	
	public DemandDAO() {
		String fileName = DemandDAO.class.getResource("/sql/Funding/demand-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("listCount");
		
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
	public ArrayList<DemandList> selectList(Connection conn, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DemandList> list = new ArrayList<DemandList>();
		
		String query = prop.getProperty("SelectList");
		
		int start = (currentPage - 1 ) * boardLimit + 1;
		int end = start + boardLimit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DemandList dl = new DemandList(rset.getInt("DEMAND_SURVEY_NO"),
											   rset.getInt("FNO"),
											   rset.getString("FNAME"),
											   rset.getInt("DEMAND_MIN_PEOPLE"),
											   rset.getInt("DDAY"));
				
				list.add(dl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	public int insertDemand(Connection conn, Demand d) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertDemand");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,d.getUserId());
			pstmt.setInt(2, d.getSmNo());
			pstmt.setInt(3, d.getFileNo());
			pstmt.setString(4, d.getMovieTitle());
			pstmt.setString(5, d.getMovieDirector());
			pstmt.setString(6, d.getMovieActor());
			pstmt.setString(7, d.getMovieStory());
			pstmt.setInt(8, d.getMinPeople());
			pstmt.setInt(9, d.getGerneNo());
			pstmt.setString(10, d.getRunningTime());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
