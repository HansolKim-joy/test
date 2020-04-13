package recruit.model.vo;

import java.sql.Date;

public class Recruit {
	private int rNo;
	private String rHead;
	private String bTitle;
	private Date bDate;
	private String userId;
	private int bViews;
	private String bContent;
	private char DecYn;
	private char DeleteYn;
	
	
	public Recruit() {}
	
	
	public Recruit(int rNo, String rHead, String bTitle, Date bDate, String userId, int bViews) {
		super();
		this.rNo = rNo;
		this.rHead = rHead;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.userId = userId;
		this.bViews = bViews;
	}





	public Recruit(int rNo, String rHead, String bTitle, String bContent, String userId, int bViews, Date bDate) {
		super();
		this.rNo = rNo;
		this.rHead = rHead;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.userId = userId;
		this.bViews = bViews;
		this.bDate = bDate;
	}
	
	
	

	public Recruit(int rNo, String rHead, String bTitle, Date bDate, String userId, int bViews, String bContent,
			char decYn, char deleteYn) {
		super();
		this.rNo = rNo;
		this.rHead = rHead;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.userId = userId;
		this.bViews = bViews;
		this.bContent = bContent;
		DecYn = decYn;
		DeleteYn = deleteYn;
	}





	public int getrNo() {
		return rNo;
	}


	public void setrNo(int rNo) {
		this.rNo = rNo;
	}


	public String getrHead() {
		return rHead;
	}


	public void setrHead(String rHead) {
		this.rHead = rHead;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getbContent() {
		return bContent;
	}


	public void setbContent(String bContent) {
		this.bContent = bContent;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getbViews() {
		return bViews;
	}


	public void setbViews(int bViews) {
		this.bViews = bViews;
	}


	public Date getbDate() {
		return bDate;
	}


	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	 

	public char getDecYn() {
		return DecYn;
	}


	public void setDecYn(char decYn) {
		DecYn = decYn;
	}


	public char getDeleteYn() {
		return DeleteYn;
	}


	public void setDeleteYn(char deleteYn) {
		DeleteYn = deleteYn;
	}


	@Override
	public String toString() {
		return "Recruit [rNo=" + rNo + ", rHead=" + rHead + ", bTitle=" + bTitle + ", bDate=" + bDate + ", userId="
				+ userId + ", bViews=" + bViews + ", bContent=" + bContent + ", DecYn=" + DecYn + ", DeleteYn="
				+ DeleteYn + "]";
	}


	
	
	

}
