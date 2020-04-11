package member.model.vo;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String phone;
	private char deleteYN;
	private char mailingYN;
	private char adminYN;
	
	public Member() {}

	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Member(String userId, String userPwd, String userName, String email, String phone, char deleteYN,
			char mailingYN, char adminYN) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.deleteYN = deleteYN;
		this.mailingYN = mailingYN;
		this.adminYN = adminYN;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(char deleteYN) {
		this.deleteYN = deleteYN;
	}

	public char getMailingYN() {
		return mailingYN;
	}

	public void setMailingYN(char mailingYN) {
		this.mailingYN = mailingYN;
	}

	public char getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(char adminYN) {
		this.adminYN = adminYN;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", deleteYN=" + deleteYN + ", mailingYN=" + mailingYN + ", adminYN=" + adminYN
				+ "]";
	}

}
