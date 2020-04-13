package Funding.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import Funding.model.dao.DemandDAO;
import Funding.model.vo.Demand;

public class DemandService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new DemandDAO().getListCount(conn);
		close(conn);
		
		return result;
	}

	public ArrayList<Demand> selectList(int currentPage, int boardLimit) {
		Connection conn = null;
		ArrayList<Demand> list = new DemandDAO().selectList(conn,currentPage,boardLimit);
		close(conn);
		
		return list;
	}

}
