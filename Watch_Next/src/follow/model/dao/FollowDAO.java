package follow.model.dao;

import static common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class FollowDAO {
	private Properties prop = new Properties();
	
	public FollowDAO() {
		String fileName = FollowDAO.class.getResource("/sql/follow/follow-query.propperties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int follow(Connection conn, String writer, String user) {
		// 팔로우 하기
		// insert into tb_follow values(?,?,seq_follow.nextval)
		PreparedStatement pstmt = null;
		int result = 0;
		//Member m = new Member();
		String query = prop.getProperty("follow");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user);
			pstmt.setString(2, writer);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
