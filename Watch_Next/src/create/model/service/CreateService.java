package create.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import create.model.dao.CreateDAO;
import create.model.vo.Create;

public class CreateService {

	public ArrayList<Create> selectList(int currentPage, int boardLimit, String sk, String sv, String sk2) {
		Connection conn = getConnection();
		
		ArrayList<Create> list = new CreateDAO().selectList(conn, currentPage, boardLimit, sk, sv, sk2);
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new CreateDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public int insertCreate(Create c) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		
		int result1 = dao.insertCreate1(conn,c);
		int result2 = dao.insertCreate2(conn,c);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}

}
