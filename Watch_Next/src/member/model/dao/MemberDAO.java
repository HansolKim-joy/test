package member.model.dao;

import static common.JDBCTemplate.close;

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

			if (rset.next()) {
//				System.out.println("123");
				String userId = rset.getString("USER_ID");
				String userPwd = rset.getString("USER_PASS");
				String userName = rset.getString("USER_NAME");
				String phone = rset.getString("USER_PHONE");
				String email = rset.getString("USER_EMAIL");
				String mailingYN = rset.getString("mailing");
				String adminYN = rset.getString("admin_Yn");
				String deleteYN = rset.getString("USER_DELETE");

				loginUser = new Member(userId, userPwd, userName, phone, email, mailingYN, adminYN, deleteYN);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return loginUser;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMember");
		System.out.println(m.getMailingYN());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getMailingYN());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int idCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("idCheck");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;

	}

	public int updateMember(Connection conn, Member member) {
		// UPDATE TB_USER SET USER_NAME=?, USER_PHONE=?, USER_EMAIL=?, MAILING=? WHERE
		// USER_ID=?;
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getUserName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getMailingYN());
			pstmt.setString(6, member.getUserId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member selectMember(Connection conn, Member member) {
		// select * from tb_user where user_id=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String query = prop.getProperty("selectNewMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(rset.getString("user_id"), rset.getString("user_pass"), rset.getString("user_name"),
						rset.getString("user_phone"), rset.getString("user_email"), rset.getString("mailing"),
						rset.getString("admin_yn"), rset.getString("user_delete"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	public Member checkPwd(Connection conn, String userId) {
		// select user_pass from tb_user where user_id=?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;

		String query = prop.getProperty("checkPwd");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(rset.getString("user_id"), rset.getString("user_pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}

	public Member findUser(Connection conn, String email) {
		// SELECT * FROM TB_USER WHERE USER_EMAIL = ?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member finduser = null;

		String query = prop.getProperty("FindUser");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				System.out.println("rset " + rset);
				String userId = rset.getString("USER_ID");
				String userPwd = rset.getString("USER_PASS");

				finduser = new Member(userId, userPwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return finduser;
	}

	public int deleteMember(Connection conn, String userId) {
		// UPDATE TB_USER SET USER_DELETE = 'Y' WHERE USER_ID=?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
//			System.out.println("dao" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member searchUser(Connection conn, String searchUserId) {
		// SELECT * FROM TB_USER WHERE USER_ID=? AND USER_DELETE='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member searchUser = null;
		
		String query = prop.getProperty("searchUser");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchUserId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchUser = new Member(rset.getString("user_id"),
										rset.getString("user_pass"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_email"),
										rset.getString("mailing"),
										rset.getString("admin_yn"),
										rset.getString("user_delete"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return searchUser;
	}

	public int countMyBoard(Connection conn, String searchUserId) {
		// SELECT COUNT(*) FROM TB_BOARD WHERE USER_ID=? AND BOARD_DELETE_YN='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int countBoard = 0;
		
		String query = prop.getProperty("countMyBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchUserId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				countBoard = rset.getInt(1);
			}
//			System.out.println("dao" + countBoard);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return countBoard;
	}

	public int countMyComment(Connection conn, String searchUserId) {
		// select count(*) from tb_comments where user_id=? and comments_delete_yn='N'
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int countComment = 0;
		
		String query = prop.getProperty("countMyComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchUserId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				countComment = rset.getInt(1);
			}
//			System.out.println("dao_com" + countComment);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return countComment;
	}

	public int newPwd(Connection conn, String email, String uuid) {
		// UPDATE TB_USER SET USER_PASS = ? WHERE USER_EMAIL = ?
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("newPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uuid);
			pstmt.setString(2, email);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
		
	}

}
