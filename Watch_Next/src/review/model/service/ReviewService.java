package review.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import common.Comment;
import review.model.dao.ReviewDAO;
import review.model.vo.Review;

public class ReviewService {


	public ArrayList<Review> selectList(int currentPage, int boardLimit, String sk, String sv, String sk2) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDAO().selectList(conn, currentPage, boardLimit, sk, sv, sk2);
		
		close(conn);
		
		return list;
	}

	public int getListCount() {
		
		Connection conn = getConnection();
		
		int result = new ReviewDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		
		int result1 = dao.insertReview1(conn, r);
		int result2 = dao.insertReview2(conn, r);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return  result1;
	}

	public Review selectReview(int rv) {
		Connection conn = getConnection();
		ReviewDAO dao = new ReviewDAO();
		
		int result = dao.updateCount(conn, rv);
		
		Review review = null;
		if(result>0) {
			review = dao.selectReview(conn, rv);
			
			if(review != null) {
				commit(conn); //조회수용 커밋
			} else {
				rollback(conn);
			}
		}	
			
		
		close(conn);
		
		return review;
	}
	
	public ArrayList<Comment> selectReplyList(int rv) {
		Connection conn = getConnection();
		ArrayList<Comment> list = new ReviewDAO().selectReplyList(conn, rv);
		
		close(conn);
		
		return list;
	}


	public ArrayList<Comment> insertReply(Comment re) {
		Connection conn = getConnection();
		ReviewDAO rDAO = new ReviewDAO();
		
		int result = rDAO.insertReply(conn, re);
		ArrayList<Comment> rList = null;
		
		if(result>0) {
			commit(conn);
			rList = rDAO.selectReplyList(conn, re.getRefBid());
		} else {
			rollback(conn);
		}
		close(conn);
		
		return rList;
	}

	public int updateReview(Review r) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		
		int result1 = dao.updateReview1(conn, r);
		int result2 = dao.updateReview2(conn, r);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return  result1;
	}

	public int deleteReview(int rv) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReview(conn, rv);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int likey(int bid) {// bid아직 안받아옴
		Connection conn = getConnection();
		int result = new ReviewDAO().like(conn, bid);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteReply(int rpno) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReply(conn, rpno);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public static char getLike(String userId, int rv) {
		Connection conn = getConnection();
		char chk = new ReviewDAO().getLike(conn, userId, rv);
		
		close(conn);
		return chk;
	}

	public int putLike(int rv, String userId) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		
		int result1 = dao.putLike(conn, rv, userId);
		int result2 = dao.putLikeC(conn, rv);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}

	public int notLike(int rv, String userId) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		
		int result1 = dao.notLike(conn, rv, userId);
		int result2 = dao.notLikeC(conn, rv);
		
		if(result1>0 && result2>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1;
	}

	public int putFollow(int rv, String writer, String userId) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		
		int result1 = dao.putFollow(conn, rv, writer, userId);
	
		
		if(result1>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}

	public String getWriter(int rv) {
		Connection conn = getConnection();
		Review review = null;
		
		String writer = new ReviewDAO().getWriter(conn, rv);
		
		close(conn);
		
		return writer;
	}

	public static char getFollow(String userId, String writer) {
		Connection conn = getConnection();
		char fchk = new ReviewDAO().getFollow(conn, userId, writer);
		
		close(conn);
		return fchk;
	}

	public int notFollow(int rv, String writer, String userId) {
		Connection conn = getConnection();
		
		ReviewDAO dao = new ReviewDAO();
		int result = dao.notFollow(conn, rv, userId, writer);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}




}
