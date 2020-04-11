package member.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = new Properties();
	
	public MemberDAO() {
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Member loginMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println("123");
				String userId = rset.getString("USER_ID");
				String userPwd = rset.getString("USER_PASS");
				String userName = rset.getString("USER_NAME");
				String email = rset.getString("USER_EMAIL");
				String phone = rset.getString("USER_PHONE");
				String deleteYN = rset.getString("USER_DELETE");
				String mailingYN = rset.getString("MAILING");
				String adminYN = rset.getString("ADMIN_YN");
				
				loginUser = new Member(userId, userPwd, userName, email, phone, deleteYN, mailingYN, adminYN);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}
	
}
