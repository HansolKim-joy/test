package board.model.vo;

import java.sql.Date;

public class Board {
	private String bNo;
	private String userId;
	private String bTitle;
	private String bContent;
	private int bCount;
	private Date bDate;
	private char bDEC;
	private char bDelete;
	
	public Board() {}
	
	public Board(String bNo, String userId, String bTitle, String bContent, int bCount, Date bDate, char bDEC,
			char bDelete) {
		super();
		this.bNo = bNo;
		this.userId = userId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bCount = bCount;
		this.bDate = bDate;
		this.bDEC = bDEC;
		this.bDelete = bDelete;
	}
	
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public char getbDEC() {
		return bDEC;
	}
	public void setbDEC(char bDEC) {
		this.bDEC = bDEC;
	}
	public char getbDelete() {
		return bDelete;
	}
	public void setbDelete(char bDelete) {
		this.bDelete = bDelete;
	}

	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", userId=" + userId + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bCount=" + bCount + ", bDate=" + bDate + ", bDEC=" + bDEC + ", bDelete=" + bDelete + "]";
	}
	
	
	
}
