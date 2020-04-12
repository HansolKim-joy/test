package review.model.vo;

import java.sql.Date;

public class Review {
	private int bNo;
	private int bType;
	private String bWriter;
	private String spo;
	private String bTitle;
	private String mTitle;
	private int popcorn;
	private String bContent;
	private int bCount;
	private String dec;
	private Date bDate;
	private String status;
	
	public Review() {}
	
	public Review(int bNo, int bType, String bWriter, String spo, String bTitle, String mTitle, int popcorn,
			String bContent, int bCount, Date bDate, String status) {
		super();
		this.bNo = bNo;
		this.bType = bType;
		this.bWriter = bWriter;
		this.spo = spo;
		this.bTitle = bTitle;
		this.mTitle = mTitle;
		this.popcorn = popcorn;
		this.bContent = bContent;
		this.bCount = bCount;
		this.bDate = bDate;
		this.status = status;
	}

	public Review(int bNo, int bType, String bWriter, String spo, String bTitle, String mTitle, int popcorn,
			String bContent, int bCount, String dec, Date bDate, String status) {
		super();
		this.bNo = bNo;
		this.bType = bType;
		this.bWriter = bWriter;
		this.spo = spo;
		this.bTitle = bTitle;
		this.mTitle = mTitle;
		this.popcorn = popcorn;
		this.bContent = bContent;
		this.bCount = bCount;
		this.dec = dec;
		this.bDate = bDate;
		this.status = status;
	}

	
	
	public Review(String spo, String bTitle, String mTitle, int popcorn, String bContent) {
		super();
		this.spo = spo;
		this.bTitle = bTitle;
		this.mTitle = mTitle;
		this.popcorn = popcorn;
		this.bContent = bContent;
	}
	
	//종훈씨
		public Review(int bNo, String bContent) {
			super();
			this.bNo = bNo;
			this.bContent = bContent;
		}	
		
		//일단 임시아이디용 객체
		public Review(String bTitle, String bContent) {
			super();
			this.bTitle = bTitle;
			this.bContent = bContent;
		}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getbType() {
		return bType;
	}

	public void setbType(int bType) {
		this.bType = bType;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getSpo() {
		return spo;
	}

	public void setSpo(String spo) {
		this.spo = spo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public int getPopcorn() {
		return popcorn;
	}

	public void setPopcorn(int popcorn) {
		this.popcorn = popcorn;
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

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Review [bNo=" + bNo + ", bType=" + bType + ", bWriter=" + bWriter + ", spo=" + spo + ", bTitle="
				+ bTitle + ", mTitle=" + mTitle + ", popcorn=" + popcorn + ", bContent=" + bContent + ", bCount="
				+ bCount + ", dec=" + dec + ", bDate=" + bDate + ", status=" + status + "]";
	}
	
	


	


	
	




}