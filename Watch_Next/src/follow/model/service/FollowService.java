package follow.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;

import follow.model.dao.FollowDAO;
import member.model.vo.Member;

public class FollowService {

	public int following(String writer, String user) {
		// 팔로우 하기
		Connection conn = getConnection();
		int result = new FollowDAO().follow(conn, writer, user);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
