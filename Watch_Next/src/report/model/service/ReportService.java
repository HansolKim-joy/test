package report.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

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

}
