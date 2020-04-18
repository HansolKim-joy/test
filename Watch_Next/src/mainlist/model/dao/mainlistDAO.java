package mainlist.model.dao;

import static common.JDBCTemplate.*;

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

	public ArrayList<Recruit> selectRelist(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		Recruit re = null;
//		ArrayList<Recruit> list = null;
		ArrayList<Recruit> list = new ArrayList<Recruit>();

		String query = prop.getProperty("selectRelist");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

//			System.out.println("rset1111" + rset);
			while (rset.next()) {
				re = new Recruit(rset.getInt("board_no"), 
								 rset.getString("user_Id"), 
								 rset.getString("board_title"),
								 rset.getInt("board_views"),
								 rset.getDate("board_date"), 
								 rset.getString("recruit_head"));
				list.add(re);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
}
