package create.model.vo;

public class CFile {
	private int fNo; //파일에 대한 아이디
	private int bNo; //게시판번호
	private String originNames;
	private String newNames;
	private int fileleve;
	private String status;
	
	public CFile() {}

	public CFile(int bNo, String newNames) {
		super();
		this.bNo = bNo;
		this.newNames = newNames;
	}

	public CFile(int fNo, int bNo, String originNames, String newNames, int fileleve, String status) {
		super();
		this.fNo = fNo;
		this.bNo = bNo;
		this.originNames = originNames;
		this.newNames = newNames;
		this.fileleve = fileleve;
		this.status = status;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getOriginNames() {
		return originNames;
	}

	public void setOriginNames(String originNames) {
		this.originNames = originNames;
	}

	public String getNewNames() {
		return newNames;
	}

	public void setNewNames(String newNames) {
		this.newNames = newNames;
	}

	public int getFileleve() {
		return fileleve;
	}

	public void setFileleve(int fileleve) {
		this.fileleve = fileleve;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CFile [fNo=" + fNo + ", bNo=" + bNo + ", originNames=" + originNames + ", newNames=" + newNames
				+ ", fileleve=" + fileleve + ", status=" + status + "]";
	}

	

	
	
	
}
