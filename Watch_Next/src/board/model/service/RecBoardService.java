package board.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import board.model.dao.RecBoardDAO;
import movie.model.vo.File;

public class RecBoardService {

	public HashMap<String, ArrayList<File>> listView() {
		Connection conn = getConnection();
		RecBoardDAO bdao = 	new RecBoardDAO();
		HashMap<String, ArrayList<File>> hlist = new HashMap<String, ArrayList<File>>();
		
		ArrayList<File> list = bdao.REVIEW_RecBoard(conn);
		ArrayList<File> list2 = bdao.STAR_RecBoard(conn);
		ArrayList<File> list3 = bdao.LIKE_RecBoard(conn);
		
		
		return hlist;
	}
	
}
