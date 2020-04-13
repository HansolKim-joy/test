package recruit.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import recruit.model.dao.recruitDAO;
import recruit.model.vo.Recruit;

public class recruitService {

	
	public int getListCount() {
		//게시판 총 글 수 세는 것	
		Connection conn = getConnection();
		
		int result = new recruitDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Recruit> selectList(int currentPage, int boardLimit) {
		//recruit 게시글 가져옴
		Connection conn = getConnection();
		
		ArrayList<Recruit> list = new recruitDAO().selectList(conn, currentPage, boardLimit);
		
		close(conn);
		
		
		return list;
	}
	
	public int insertRecruit(Recruit r) {
		//게시판 작성
		Connection conn = getConnection();
		
		int result = new recruitDAO().insertBoard(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Recruit selectBoard(int rNo) {
		
		Connection conn = getConnection();
		recruitDAO dao = new recruitDAO(); //recruitDAO 두 개를 호출해야하기 때문에 참조변수로 선언
		int result = dao.updateCount(conn, rNo);
		//게시판 상세보기 시 조회수가 증가해야하기 때문에 게시판 상세보기 서비스에는 조회수 증가하는 기능도 구현 해야함
		//System.out.println("===================update complete================");
		Recruit board = null;
		if(result > 0) {
			board = dao.selectBoard(conn, rNo);
			if(board != null) {
				System.out.println("====================select===============");
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return board;
		
	}

	

}
