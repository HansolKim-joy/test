package report.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

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

	public ArrayList<Report> selectBoardtReport() {
		Connection conn = getConnection();
		
		ArrayList<Report> BoardReport = new ReportDAO().selectBoardReport(conn);
		close(conn);
		return BoardReport;
	}

	public ArrayList<Report> selectCommReport() {
		Connection conn = getConnection();
		
		ArrayList<Report> CommReport = new ReportDAO().selectCommReport(conn);
		close(conn);
		return CommReport;
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
