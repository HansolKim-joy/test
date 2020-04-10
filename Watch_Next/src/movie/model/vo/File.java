package movie.model.vo;

public class File {
	private int FileNo;
	private String originName;
	private String newName;
	
	public File () {}

	public File(int fileNo, String originName, String newName) {
		super();
		FileNo = fileNo;
		this.originName = originName;
		this.newName = newName;
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

	@Override
	public String toString() {
		return "File [FileNo=" + FileNo + ", originName=" + originName + ", newName=" + newName + "]";
	}
	
	
	
}
