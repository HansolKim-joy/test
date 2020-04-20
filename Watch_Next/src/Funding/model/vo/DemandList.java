package Funding.model.vo;


public class DemandList {
	private int dNo;
	private int FileNo;
	private String Title;
	private String FileName;
	private int price;
	private int EndDay;

	public DemandList() {}

	public DemandList(int dNo, int fileNo, String Title, String fileName, int price, int endDay) {
		super();
		this.dNo = dNo;
		this.FileNo = fileNo;
		this.Title = Title;
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
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "DemandList [dNo=" + dNo + ", FileNo=" + FileNo + ", Title=" + Title + ", FileName=" + FileName
				+ ", price=" + price + ", EndDay=" + EndDay + "]";
	}

	
	
	

	
}
