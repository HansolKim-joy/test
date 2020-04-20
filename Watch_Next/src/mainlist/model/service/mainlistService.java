package mainlist.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import mainlist.model.dao.mainlistDAO;
import recruit.model.vo.Recruit;
import review.model.vo.Review;

public class mainlistService {

	public ArrayList<Recruit> selectRclist() {
		Connection conn = getConnection();
		ArrayList<Recruit> Recruitlist = new mainlistDAO().selectRclist(conn);
//		System.out.println("service" + list);
		close(conn);

		return Recruitlist;
	}

	public ArrayList<Review> selectRvlist() {
		Connection conn = getConnection();
		ArrayList<Review> Reviewlist = new mainlistDAO().selectRvlist(conn);
		close(conn);
		return Reviewlist;
	}

}
