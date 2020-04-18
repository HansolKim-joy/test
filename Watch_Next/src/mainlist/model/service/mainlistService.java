package mainlist.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import mainlist.model.dao.mainlistDAO;
import recruit.model.vo.Recruit;

public class mainlistService {

	public ArrayList<Recruit> selectRelist() {
		Connection conn = getConnection();
		ArrayList<Recruit> list = new mainlistDAO().selectRelist(conn);
//		System.out.println("list" + list);
		close(conn);

		return list;
	}

}
