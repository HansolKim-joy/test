package report.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import report.model.dao.ReportDAO;
import report.model.vo.Report;

public class ReportService {

	public int sendReport(Report rep) {
		Connection conn = getConnection();
		ReportDAO dao = new ReportDAO();
		
		int result = dao.insertReport(conn, rep);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int sendReportR(Report rep) {
		Connection conn = getConnection();
		ReportDAO dao = new ReportDAO();
		
		int result = dao.insertReportR(conn, rep);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/*
	 * public int[] selectReport(String userId) { Connection conn = getConnection();
	 * ReportDAO dao = new ReportDAO();
	 * 
	 * int[] replist = dao.selectReportR(conn, userId);
	 * 
	 * close(conn);
	 * 
	 * return replist; }
	 */

}
