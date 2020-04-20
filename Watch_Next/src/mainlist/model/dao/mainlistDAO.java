package mainlist.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.dao.RecBoardDAO;
import recruit.model.vo.Recruit;
import review.model.vo.Review;

public class mainlistDAO {
	private Properties prop = new Properties();

	public mainlistDAO() {
		String fileName = RecBoardDAO.class.getResource("/sql/mainlist/mainlist-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Recruit> selectRclist(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		Recruit re = null;
//		ArrayList<Recruit> list = null;
		ArrayList<Recruit> list = new ArrayList<Recruit>();

		String query = prop.getProperty("selectRclist");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

//			System.out.println("dao" + rset);
			
			while (rset.next()) {
				re = new Recruit(rset.getInt("board_no"), 
								 rset.getString("user_Id"), 
								 rset.getString("board_title"),
								 rset.getInt("board_views"),
								 rset.getDate("board_date"), 
								 rset.getString("recruit_head"));
				list.add(re);
//				System.out.println("daore"+re);
			}
//			System.out.println("daolist" + list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<Review> selectRvlist(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		Review rv = null;
		ArrayList<Review> Reviewlist = new ArrayList<Review>();
		
		String query = prop.getProperty("selectRvlist");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				rv = new Review(rset.getInt("board_no"), 
								rset.getString("spo_chk_yn"), 
								rset.getString("review_movie_title"), 
								rset.getString("board_title"), 
								rset.getInt("review_grade"),
								rset.getDate("board_date"),
								rset.getString("user_id"),
								rset.getInt("board_views"));
				Reviewlist.add(rv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return Reviewlist;
	}
}
