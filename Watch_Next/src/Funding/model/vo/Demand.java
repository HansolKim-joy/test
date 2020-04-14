package Funding.model.vo;

public class Demand {
	private int dNo;//수요조사 번호
	private String userId;//회원아이디
	private int smNo;//상영극장번호
	private String smName; //상영극장이름
	private int smWant; //보고싶어요
	
	public Demand() {}
	
	public Demand(int dNo, String userId, int smNo, String smName, int smWant) {
		super();
		this.dNo = dNo;
		this.userId = userId;
		this.smNo = smNo;
		this.smName = smName;
		this.smWant = smWant;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSmNo() {
		return smNo;
	}

	public void setSmNo(int smNo) {
		this.smNo = smNo;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public int getSmWant() {
		return smWant;
	}

	public void setSmWant(int smWant) {
		this.smWant = smWant;
	}

	@Override
	public String toString() {
		return "Demand [dNo=" + dNo + ", userId=" + userId + ", smNo=" + smNo + ", smName=" + smName + ", smWant="
				+ smWant + "]";
	}

	
	
}
