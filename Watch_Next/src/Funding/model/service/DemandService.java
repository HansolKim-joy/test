package Funding.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import Funding.model.dao.DemandDAO;
import Funding.model.vo.Demand;
import Funding.model.vo.DemandList;

public class DemandService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new DemandDAO().getListCount(conn);
		close(conn);
		
		return result;
	}
	
	public ArrayList<DemandList> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		ArrayList<DemandList> list = new DemandDAO().selectList(conn,currentPage,boardLimit);
		close(conn);
		
		return list;
	}
	
	public int insertDemand(Demand d) {
		Connection conn = getConnection();
		int result = new DemandDAO().insertDemand(conn, d);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	/*보고싶어요(게시글 순) 리스트*/
	public ArrayList<Demand> wantPeople() {
		Connection conn = getConnection();
		ArrayList<Demand> want = new DemandDAO().wantPeople(conn);
		close(conn);
		return want;
	}
	
	public Demand getDemand(int no) {
		Connection conn = getConnection();
		Demand d = new DemandDAO().getDemand(conn, no);
		close(conn);
		return d;
	}

	public String getFile(int no) {
		Connection conn = getConnection();
		String fName = new DemandDAO().getFile(conn, no);
		close(conn);
		return fName;
	}

	public String getGenre(int gerneNo) {
		Connection conn = getConnection();
		String genre = new DemandDAO().getGenre(conn, gerneNo);
		close(conn);
		return genre;
	}

	public String getScreen(int smNo) {
		Connection conn = getConnection();
		String smName = new DemandDAO().getScreen(conn, smNo);
		close(conn);
		return smName;
	}

	public char getFund(String userId, int no, String duserId) {
        Connection conn = getConnection();
        char chk = new DemandDAO().getFund(conn, userId, no, duserId);
        close(conn);
        return chk;
    }

    public int putFund(int no, String userId, String dUserId, int price) {
        Connection conn = getConnection();
        int result = new DemandDAO().putFund(conn, no, userId, dUserId, price);
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }

    public int notFund(int no, String dUserId, String userId) {
        Connection conn = getConnection();
        int result = new DemandDAO().notFund(conn, no, userId, dUserId);
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
	public ArrayList<DemandList> SortList(int currentPage, int boardLimit, String cinema) {
		Connection conn = getConnection();
		ArrayList<DemandList> list = new DemandDAO().SortList(conn, currentPage, boardLimit, cinema);
		System.out.println("service" + cinema);
		close(conn);
		
		return list;
	}
	
	
}
