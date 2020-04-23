package common;

import java.sql.Date;

public class Comment {
	
	private int rId;
	private String rContent;
	private int refBid;
	private String rWriter;
	private Date createDate;
	private String dec_yn;
	private String status;
	private String bTitle;
	private String mTitle;
	private String bWriter;
	
	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public Comment() {}
	
	public Comment(int rId, String rContent, int refBid, String rWriter, Date createDate, String dec_yn, String status) {
		super();
		this.rId = rId;
		this.rContent = rContent;
		this.refBid = refBid;
		this.rWriter = rWriter;
		this.createDate = createDate;
		this.dec_yn = dec_yn;
		this.status = status;
	}
	
	public Comment(String rContent, int refBid, String rWriter) {
		super();
		this.rContent = rContent;
		this.refBid = refBid;
		this.rWriter = rWriter;
	}
	
	// 한솔
	public Comment(int refBid, String bWriter, String bTitle, String mTitle, String rContent, Date createDate) {
		super();
		this.refBid = refBid;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.mTitle = mTitle;
		this.rContent = rContent;
		this.createDate = createDate;
	}
	
	// 댓글신고중복확인
	
	
	
	public int getrId() {
		return rId;
	}
	
	public void setrId(int rId) {
		this.rId = rId;
	}
	
	public String getrContent() {
		return rContent;
	}
	
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	
	public int getRefBid() {
		return refBid;
	}
	
	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}
	
	public String getrWriter() {
		return rWriter;
	}
	
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getDec_yn() {
		return dec_yn;
	}
	
	public void setDec_yn(String dec_yn) {
		this.dec_yn = dec_yn;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Comment [rId=" + rId + ", rContent=" + rContent + ", refBid=" + refBid + ", rWriter=" + rWriter
				+ ", createDate=" + createDate + ", dec_yn=" + dec_yn + ", status=" + status + "]";
	}
	
	public String getbTitle() {
		return bTitle;
	}
	
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	
}
	
