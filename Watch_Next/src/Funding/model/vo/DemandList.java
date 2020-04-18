package Funding.model.vo;


public class DemandList {
	private int dNo;
	private int FileNo;
	private String FileName;
	private int price;
	private int EndDay;

	public DemandList() {}

	public DemandList(int dNo, int fileNo, String fileName, int price, int endDay) {
		super();
		this.dNo = dNo;
		this.FileNo = fileNo;
		this.FileName = fileName;
		this.price = price;
		this.EndDay = endDay;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public int getFileNo() {
		return FileNo;
	}

	public void setFileNo(int fileNo) {
		FileNo = fileNo;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getEndDay() {
		return EndDay;
	}

	public void setEndDay(int endDay) {
		EndDay = endDay;
	}

	@Override
	public String toString() {
		return "DemandList [dNo=" + dNo + ", FileNo=" + FileNo + ", FileName=" + FileName + ", price=" + price
				+ ", EndDay=" + EndDay + "]";
	}
	
	

	
}
