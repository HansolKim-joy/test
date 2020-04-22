package listAll.model.vo;

public class MyFollow {
	private String followingUser;
	private String followedUser;
	private int bCnt;
	private int cCnt;
	
	public MyFollow(String followedUser, int bCnt, int cCnt) {
		super();
		this.followedUser = followedUser;
		this.bCnt = bCnt;
		this.cCnt = cCnt;
	}
	
	public MyFollow(String followingUser, String followedUser, int bCnt, int cCnt) {
		super();
		this.followingUser = followingUser;
		this.followedUser = followedUser;
		this.bCnt = bCnt;
		this.cCnt = cCnt;
	}
	public String getFollowingUser() {
		return followingUser;
	}
	public void setFollowingUser(String followingUser) {
		this.followingUser = followingUser;
	}
	public String getFollowedUser() {
		return followedUser;
	}
	public void setFollowedUser(String followedUser) {
		this.followedUser = followedUser;
	}
	public int getbCnt() {
		return bCnt;
	}
	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}
	public int getcCnt() {
		return cCnt;
	}
	public void setcCnt(int cCnt) {
		this.cCnt = cCnt;
	}
	@Override
	public String toString() {
		return "Follow [followingUser=" + followingUser + ", followedUser=" + followedUser + ", bCnt=" + bCnt
				+ ", cCnt=" + cCnt + "]";
	}
}
