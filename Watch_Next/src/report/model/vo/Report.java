package report.model.vo;

public class Report {
	private int decNo;
	private String decContent;
	private int boardNo;
	private int commentsNo;
	private String userId;
	
	public Report() {}
	
	//게시글 신고전달
	public Report(String decContent, String userId, int boardNo) {
		super();
		this.decContent = decContent;
		this.userId = userId;
		this.boardNo = boardNo;
	}
	
	// 댓글 신고전달
	public Report(String decContent, int commentsNo, String userId) {
		super();
		this.decContent = decContent;
		this.commentsNo = commentsNo;
		this.userId = userId;
	}

	//전체
	public Report(int decNo, String decContent, int boardNo, int commentsNo, String userId) {
		super();
		this.decNo = decNo;
		this.decContent = decContent;
		this.boardNo = boardNo;
		this.commentsNo = commentsNo;
		this.userId = userId;
	}

	public int getDecNo() {
		return decNo;
	}

	public void setDecNo(int decNo) {
		this.decNo = decNo;
	}

	public String getDecContent() {
		return decContent;
	}

	public void setDecContent(String decContent) {
		this.decContent = decContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(int commentsNo) {
		this.commentsNo = commentsNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Report [decNo=" + decNo + ", decContent=" + decContent + ", boardNo=" + boardNo + ", commentsNo="
				+ commentsNo + ", userId=" + userId + "]";
	}
	
	
	
	
}
