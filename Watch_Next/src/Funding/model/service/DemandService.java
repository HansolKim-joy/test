package Funding.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import Funding.model.dao.DemandDAO;
import Funding.model.vo.Demand;

public class DemandService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new DemandDAO().getListCount(conn);
		close(conn);
		
		return result;
	}

	public ArrayList<String> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<String> list = new DemandDAO().selectList(conn,currentPage,boardLimit);
		close(conn);
		
		return list;
	}

}
