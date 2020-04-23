package create.model.vo;

import java.sql.Date;

public class Create {
	private int rnum; //ROW NUM
	private int bNO; //게시판 번호
	private int fNo; //파일번호
	private String bWriter; //올린사람
	private String bTitle; //게시판제목
	private String cDirector; //창작영화 감독
	private String bContent; //게시판내용
	private int cLike; //좋아요수
	private int bCount; //조회수
	private int comm; //댓글수
	private String dec; //신고여부
	private Date cDate; //게시글 올린날짜
	private String status; //삭제여부(y면 삭제된게시물) 
	private String cName; // 한솔
	
	public Create() {}
	
	//insert(파일 추가전버전)
	public Create(String bWriter, String bTitle, String cDirector, String bContent, int fNo) {
		super();
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.cDirector = cDirector;
		this.bContent = bContent;
		this.fNo = fNo;
	}
	
	//전체생성자
	public Create(int rnum, int bNO, int fNo, String bWriter, String bTitle, String cDirector, String bContent,
			int cLike, int bCount, int comm, String dec, Date cDate, String status) {
		super();
		this.rnum = rnum;
		this.bNO = bNO;
		this.fNo = fNo;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.cDirector = cDirector;
		this.bContent = bContent;
		this.cLike = cLike;
		this.bCount = bCount;
		this.comm = comm;
		this.dec = dec;
		this.cDate = cDate;
		this.status = status;
	}
	
	//게시글 상세조회
	public Create(int rnum,int bNO, int fNo, String bWriter, String bTitle, String cDirector, String bContent, int cLike,
			int bCount, int comm, Date cDate) {
		super();
		this.rnum = rnum;
		this.bNO = bNO;
		this.fNo = fNo;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.cDirector = cDirector;
		this.bContent = bContent;
		this.cLike = cLike;
		this.bCount = bCount;
		this.comm = comm;
		this.cDate = cDate;
	}
	
	// 한솔
	public Create(int bNo, String cName, String cDirector, String bTitle, Date cDate) {
		super();
		this.bNO = bNo;
		this.cName = cName;
		this.cDirector = cDirector;
		this.bTitle = bTitle;
		this.cDate = cDate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getbNO() {
		return bNO;
	}

	public void setbNO(int bNO) {
		this.bNO = bNO;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getcDirector() {
		return cDirector;
	}

	public void setcDirector(String cDirector) {
		this.cDirector = cDirector;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getcLike() {
		return cLike;
	}

	public void setcLike(int cLike) {
		this.cLike = cLike;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	@Override
	public String toString() {
		return "Create [rnum=" + rnum + ", bNO=" + bNO + ", fNo=" + fNo + ", bWriter=" + bWriter + ", bTitle=" + bTitle
				+ ", cDirector=" + cDirector + ", bContent=" + bContent + ", cLike=" + cLike + ", bCount=" + bCount
				+ ", comm=" + comm + ", dec=" + dec + ", cDate=" + cDate + ", status=" + status + "]";
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	
}
