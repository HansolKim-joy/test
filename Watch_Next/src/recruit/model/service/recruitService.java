package recruit.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import recruit.model.dao.recruitDAO;
import common.Comment;
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
		
		recruitDAO rd = new recruitDAO();
		
		int result1 = rd.insertBoard(conn, r);
		
		int result2 = 0;
		int result = 0;
		if(result1 > 0) {
			result2 = rd.insertRecruit(conn, r);
			
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		result = result1 + result2;
		
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

	public int updateRecruit(Recruit r) {
		
		Connection conn = getConnection();
		
		recruitDAO rd = new recruitDAO();
		
		int result1 = rd.updateBoard(conn, r);
		int result2 = 0;
		int result = 0;
		
		if(result1 > 0) {
			result2 = rd.updateRecruit(conn, r);
			
			if(result1 > 0 && result2 > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		result = result1 + result2;
		
		return result;
	}
	
	public ArrayList<Comment> selectComment(int rNo) {
			//댓글가져옴
		Connection conn = getConnection();
		
		ArrayList<Comment> comment = new recruitDAO().selectComment(conn, rNo);
		
		close(conn);
		
		return comment;
		}
	
	public ArrayList<Comment> insertComment(Comment co) {
		//댓글입력
		Connection conn = getConnection();
		recruitDAO reDAO = new recruitDAO();
		
		int result = reDAO.insertComment(co, conn);
		ArrayList<Comment> comment = null;
		
		if(result > 0) {
			commit(conn);
			
			comment = reDAO.selectComment(conn, co.getRefBid());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return comment;
	}


	public int deleteRecruit(int rNo) {
		
		Connection conn = getConnection();
		int result = new recruitDAO().deleteRecruit(conn, rNo);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Recruit> choiceHead(String choice, String choice2, String choice3, int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<Recruit> cList = null;
		
		/*
		 * if(choice != null && choice2 == null && choice3 == null) { cList = new
		 * recruitDAO().choiceHead1(conn, choice, currentPage, boardLimit);
		 * 
		 * } else if(choice == null && choice2 != null && choice3 != null) { cList = new
		 * recruitDAO().choiceHead2(conn, choice2, choice3, currentPage, boardLimit);
		 * 
		 * } else if(choice != null && choice2 == null && choice3 != null) { cList = new
		 * recruitDAO().choiceHead3(conn, choice, choice3, currentPage, boardLimit);
		 * 
		 * } else if(choice != null && choice2 != null && choice3 != null) { cList = new
		 * recruitDAO().choiceHead4(conn, choice, choice2, choice3, currentPage,
		 * boardLimit);
		 * 
		 * } else { cList = new recruitDAO().choiceHead5(conn); }
		 */	
		
		if(choice != null && choice2 != null && choice3.equalsIgnoreCase("blank")) {
			cList = new recruitDAO().ch1(conn, choice, choice2, currentPage, boardLimit);
			
		}else {
			cList = new recruitDAO().ch2(conn, choice, choice2, choice3, currentPage, boardLimit);
		}
		 
		close(conn);
		return cList;
	}

	
	 public ArrayList<Comment> deleteComment(int rId, int rNo) { 
		 Connection conn = getConnection();
		 int result = new recruitDAO().deleteComment(conn, rId);
		 if(result > 0) {
			 commit(conn);
		 }else {
			 rollback(conn);
		 }
		 
		 ArrayList<Comment> list = new recruitDAO().selectComment(conn, rNo);
		 close(conn);
		 
		 
		 return list;
		 
	 }
	 

	
	

}
