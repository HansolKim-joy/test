package letter.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import letter.model.dao.LetterDAO;
import letter.model.vo.Letter;
public class LetterService {
	
	public ArrayList<Letter> letterList(String userId, int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Letter> letterList = new LetterDAO().getLetterList(conn, userId, currentPage, boardLimit);
		
		close(conn);
		return letterList;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int count = new LetterDAO().getListCount(conn);
		
		close(conn);
		return count;
	}

	public ArrayList<Letter> sendletterList(String userId, int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Letter> letterList = new LetterDAO().sendLetterList(conn, userId, currentPage, boardLimit);
		
		close(conn);
		return letterList;
	}

	public int letterSend(Letter l) {
		Connection conn = getConnection();
		int result = new LetterDAO().letterSend(conn,l);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public String getUserId(String sendName) {
		Connection conn = getConnection();
		String userId = new LetterDAO().getUserId(conn, sendName);
		
		close(conn);
		return userId;
	}

	public int getsendListCount() {
		Connection conn = getConnection();
		int count = new LetterDAO().getsendListCount(conn);
		
		close(conn);
		return count;
	}

	public Letter getDetailLetter(int no) {
		Connection conn = getConnection();
		Letter l = new LetterDAO().getDetailLetter(conn, no);
		
		close(conn);
		return l;
	}

	public int deleteLetter(String[] no) {
		Connection conn = getConnection();
		int result = new LetterDAO().deleteLetter(conn, no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

}
