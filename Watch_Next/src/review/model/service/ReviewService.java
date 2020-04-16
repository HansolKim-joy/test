package review.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import review.model.dao.ReviewDAO;
import review.model.vo.Review;
import review.model.vo.ReviewReply;

public class ReviewService {


	public ArrayList<Review> selectList(int currentPage, int boardLimit, String sk, String sv, String spo) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDAO().selectList(conn, currentPage, boardLimit, sk, sv, spo);
		
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
	
	public ArrayList<ReviewReply> selectReplyList(int rv) {
		Connection conn = getConnection();
		ArrayList<ReviewReply> list = new ReviewDAO().selectReplyList(conn, rv);
		
		close(conn);
		
		return list;
	}


	public ArrayList<ReviewReply> insertReply(ReviewReply re) {
		Connection conn = getConnection();
		ReviewDAO rDAO = new ReviewDAO();
		
		int result = rDAO.insertReply(conn, re);
		ArrayList<ReviewReply> rList = null;
		
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

	public ArrayList<Review> choiceHead(String choice) {
		Connection conn = getConnection();
		ArrayList<Review> cList = new ReviewDAO().choiceHead(conn, choice);
		close(conn);
		
		return cList;
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

	public static ArrayList<Review> spoList(String spo) {
		Connection conn = getConnection();
		ArrayList<Review> spolist = new ReviewDAO().selectSpoList(conn, spo);
		
		close(conn);
		
		return spolist;
	}




}
