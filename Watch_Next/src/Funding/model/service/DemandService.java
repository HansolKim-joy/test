package Funding.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import Funding.model.dao.DemandDAO;
import Funding.model.vo.Demand;
import Funding.model.vo.DemandList;

public class DemandService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new DemandDAO().getListCount(conn);
		close(conn);
		
		return result;
	}

	public ArrayList<DemandList> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<DemandList> list = new DemandDAO().selectList(conn,currentPage,boardLimit);
		close(conn);
		
		return list;
	}
	
	public int insertDemand(Demand d) {
		Connection conn = getConnection();
		int result = new DemandDAO().insertDemand(conn, d);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
