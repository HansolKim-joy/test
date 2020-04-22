package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member m) {
		Connection conn = getConnection();
		Member loginUser = new MemberDAO().loginMember(conn, m);
		close(conn);
//		System.out.println(loginUser);
		return loginUser;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
//		System.out.println("service" + m.getMailingYN());
		int result = new MemberDAO().insertMember(conn, m);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();
		int result = new MemberDAO().idCheck(conn, userId);
		return result;
	}

	public Member updateMember(Member member) {
		Connection conn = getConnection();
		MemberDAO mDAO = new MemberDAO();
		Member m = null;

		int result = mDAO.updateMember(conn, member);

		if (result > 0) {
			m = mDAO.selectMember(conn, member);
//			System.out.println(m);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return m;
	}

	public Member checkPwd(String userId) {
		Connection conn = getConnection();
		Member m = new MemberDAO().checkPwd(conn, userId);

		close(conn);
		return m;
	}

	public Member findUser(String email) {
		Connection conn = getConnection();
		Member finduser = new MemberDAO().findUser(conn, email);
		close(conn);
		return finduser;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = new MemberDAO().deleteMember(conn, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member searchUser(String searchUserId) {
		Connection conn = getConnection();
		Member searchUser = new MemberDAO().searchUser(conn, searchUserId);
		close(conn);
		return searchUser;
	}

	public int countMyBoard(String searchUserId) {
		Connection conn = getConnection();
		int countBoard = new MemberDAO().countMyBoard(conn, searchUserId);
		
		close(conn);
		return countBoard;
	}

	public int countMyComment(String searchUserId) {
		Connection conn = getConnection();
		int countComment = new MemberDAO().countMyComment(conn, searchUserId);
		close(conn);
		return countComment;
	}

	public int newPwd(String email, String uuid) {
		Connection conn = getConnection();
		int result = new MemberDAO().newPwd(conn, email, uuid);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

		

}
