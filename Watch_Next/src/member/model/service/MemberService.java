package member.model.service;



import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member m) {
		Connection conn = getConnection();
		Member loginUser = new MemberDAO().loginMember(conn,m);
		close(conn);
		System.out.println(loginUser);
		
		return loginUser;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		System.out.println("service" + m.getMailingYN());
		int result = new MemberDAO().insertMember(conn, m);
		if(result > 0) {
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
	
}
