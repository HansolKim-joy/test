package member.model.vo;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String email;
	private String mailingYN;
	private String adminYN;
	private String deleteYN;

	public Member() {}

	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Member(String userId, String userPwd, String userName, String phone, String email, String mailingYN,
			String adminYN, String deleteYN ) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.mailingYN = mailingYN;
		this.adminYN = adminYN;
		this.deleteYN = deleteYN;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone=" + phone
				+ ", email=" + email + ", mailingYN=" + mailingYN + ", adminYN=" + adminYN + ", deleteYN=" + deleteYN
				+ "]";
	}
}
