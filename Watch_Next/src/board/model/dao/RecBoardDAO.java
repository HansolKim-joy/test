package board.model.dao;

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

import movie.model.vo.File;

public class RecBoardDAO {
	private Properties prop = new Properties();
	
	public RecBoardDAO() {
		String fileName = RecBoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<File> REVIEW_RecBoard(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<File> list = new ArrayList<File>();
		String query = prop.getProperty("Review_rec");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				File f = new File(rset.getString("FILE_NEWNAME"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<File> STAR_RecBoard(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<File> LIKE_RecBoard(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
