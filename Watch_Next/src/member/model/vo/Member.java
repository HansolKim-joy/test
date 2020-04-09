package member.model.vo;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String phone;
	private String deleteYN;
	private String mailingYN;
	private String adminYN;
	
	public Member() {}

	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Member(String userId, String userPwd, String userName, String email, String phone, String deleteYN,
			String mailingYN, String adminYN) {
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

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}

	public String getMailingYN() {
		return mailingYN;
	}

	public void setMailingYN(String mailingYN) {
		this.mailingYN = mailingYN;
	}

	public String getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", deleteYN=" + deleteYN + ", mailingYN=" + mailingYN + ", adminYN=" + adminYN
				+ "]";
	}
	
	
	
}
