package create.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import common.Comment;
import create.model.dao.CreateDAO;
import create.model.vo.CFile;
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
	
	public int insertCreate(Create c, ArrayList<CFile> fileList) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		
		int result1 = dao.insertCreate1(conn,c);
		int result2 = dao.insertCreate2(conn,c);
		int result3 = dao.insertPoster(conn, fileList);
		
		if(result1>0 && result2>0 && result3>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}
	

	public Create selectCreate(int rNo) {
		Connection conn = getConnection();
		CreateDAO dao = new CreateDAO();
		
		int result = dao.updateCount(conn, rNo);
		
		Create create = null;
		if(result>0) {
			create = dao.selectCreate(conn, rNo);
			
			if(create != null) {
				commit(conn); //조회수용 커밋
			} else {
				rollback(conn);
			}
		}else {
			rollback(conn);
		}	
			
		
		close(conn);
		
		return create;
	}
	
	public int updateCreate(Create c, ArrayList<CFile> fileList) {
		Connection conn = getConnection();
		
		CreateDAO cd = new CreateDAO();
		
		int result1 = cd.updateBoard(conn, c);
		int result2 = cd.updateCreate(conn, c);
		int result3 = cd.deletePoster(conn, fileList);
		int result4 = cd.updatePoster(conn, fileList);
		
		
		if(result1 > 0 && result2>0 && result3>0 && result4>0) {
			commit(conn);
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public ArrayList<Comment> selectComment(int rNo) {
		//디비에서 댓글 가져옴
		Connection conn = getConnection();
		ArrayList<Comment> comment = new CreateDAO().selectComment(conn, rNo);
		
		close(conn);
		
		return comment;
	}
	
	public ArrayList<Comment> insertComment(Comment co) {
		//댓글 입력
		Connection conn = getConnection();
		CreateDAO reDAO = new CreateDAO();
		
		int result = reDAO.insertComment(co, conn);
		int result2 = reDAO.insertCommentC(co, conn);
		ArrayList<Comment> comment = null;
		
		if(result > 0 && result2>0) {
			commit(conn);
			
			comment = reDAO.selectComment(conn, co.getRefBid());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return comment;
	}
	
	public ArrayList<Comment> deleteComment(int rId, int rNo) { 
		 Connection conn = getConnection();
		 
		 CreateDAO dao = new CreateDAO();
		 int result = dao.deleteComment(conn, rId);
		 int result2 = dao.deleteCommentC(conn, rNo);
		 if(result > 0 && result2>0) {
			 commit(conn);
		 }else {
			 rollback(conn);
		 }
		 
		 ArrayList<Comment> list = new CreateDAO().selectComment(conn, rNo);
		 close(conn);
		 
		 
		 return list;
		 
	 }



	public  char getLike(String userId, int rNo) {
		Connection conn = getConnection();
		char chk = new CreateDAO().getLike(conn, userId, rNo);
		
		close(conn);
		return chk;
	}
	
	public int putLike(int rNo, String userId) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		
		int result1 = dao.putLike(conn, rNo, userId);
		int result2 = dao.putLikeC(conn, rNo);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}

	public int notLike(int rNo, String userId) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		
		int result1 = dao.notLike(conn, rNo, userId);
		int result2 = dao.notLikeC(conn, rNo);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}

	public int deleteCreate(int rNo) {
		Connection conn = getConnection();
		int result = new CreateDAO().deleteCreate(conn, rNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
			
		return result;
	}

	public String getWriter(int cNo) {
		Connection conn = getConnection();
		Create create = null;
		
		String writer = new CreateDAO().getWriter(conn, cNo);
		
		close(conn);
		
		return writer;
	}

	public static char getFollow(String userId, String writer) {
		Connection conn = getConnection();
		char fchk = new CreateDAO().getFollow(conn, userId, writer);
		
		close(conn);
		return fchk;
	}

	public int putFollow(int cNo, String writer, String userId) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		
		int result = dao.putFollow(conn, cNo, writer, userId);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int notFollow(int cNo, String writer, String userId) {
		Connection conn = getConnection();
		
		CreateDAO dao = new CreateDAO();
		int result = dao.notFollow(conn, cNo, userId, writer);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	/*public ArrayList<Attachment> selectList(int i) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = null;
		CreateDAO dao = new CreateDAO();
		
		if(i ==2) {
			list = dao.selectFList(conn);
		}
		
		
		return list;
	}*/

	/*
	 * public int insertPoster(ArrayList<CFile> fileList) { Connection conn =
	 * getConnection();
	 * 
	 * int result1 = new CreateDAO().insertPoster(conn, fileList);
	 * 
	 * if(result1>0) { commit(conn); } else { rollback(conn); }
	 * 
	 * close(conn); return result1; }
	 */

	public ArrayList<CFile> selectThumbList() {
		Connection conn = getConnection();
		ArrayList<CFile> flist = null;
		
		flist = new CreateDAO().selectCFlist(conn);
		
		close(conn);
		
		return flist;
	}

	public ArrayList<CFile> selectFile(int cNo) {
		Connection conn = getConnection();
		ArrayList<CFile> list = new CreateDAO().selectFile(conn, cNo);
		
		close(conn);
		return list;
	}

	

	

	
	
	


}
