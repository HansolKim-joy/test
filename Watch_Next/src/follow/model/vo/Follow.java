package follow.model.vo;

public class Follow {
	private int fNo;
	private String userId;
	private String followUserId;
	
	public Follow() {}

	public Follow(int fNo, String userId, String followUserId) {
		super();
		this.fNo = fNo;
		this.userId = userId;
		this.followUserId = followUserId;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(String followUserId) {
		this.followUserId = followUserId;
	}

	@Override
	public String toString() {
		return "Follow [fNo=" + fNo + ", userId=" + userId + ", followUserId=" + followUserId + "]";
	}
	
	

}
