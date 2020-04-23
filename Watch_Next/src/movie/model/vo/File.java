package movie.model.vo;

public class File {
	private int FileNo;
	private String originName;
	private String newName;
	private int dNo;
	private String title;
	
	public File () {}

	public File(String newName, int dNo, String title) {
		super();
		this.newName = newName;
		this.dNo = dNo;
		this.title = title;
	}

	public File(int fileNo, String originName, String newName, String title) {
		super();
		this.FileNo = fileNo;
		this.originName = originName;
		this.newName = newName;
		this.title=title;
	}
	
	public File(int fileNo, String originName, String newName, int dNo, String title) {
		super();
		FileNo = fileNo;
		this.originName = originName;
		this.newName = newName;
		this.dNo = dNo;
		this.title = title;
	}

	public File(String newName) {
		super();
		this.newName = newName;
	}

	public int getFileNo() {
		return FileNo;
	}

	public void setFileNo(int fileNo) {
		FileNo = fileNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	@Override
	public String toString() {
		return "File [FileNo=" + FileNo + ", originName=" + originName + ", newName=" + newName + ", dNo=" + dNo
				+ ", title=" + title + "]";
	}

	

	
	
}
