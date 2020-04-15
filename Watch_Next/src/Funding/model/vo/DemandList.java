package Funding.model.vo;


public class DemandList {
	private int dNo;
	private int FileNo;
	private String FileName;
	private int minPeople;
	private int EndDay;

	public DemandList() {}

	public DemandList(int dNo, int fileNo, String fileName, int minPeople, int endDay) {
		super();
		this.dNo = dNo;
		FileNo = fileNo;
		FileName = fileName;
		this.minPeople = minPeople;
		EndDay = endDay;
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

	public int getMinPeople() {
		return minPeople;
	}

	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}

	public int getEndDay() {
		return EndDay;
	}

	public void setEndDay(int endDay) {
		EndDay = endDay;
	}

	@Override
	public String toString() {
		return "DemandList [dNo=" + dNo + ", FileNo=" + FileNo + ", FileName=" + FileName + ", minPeople=" + minPeople
				+ ", EndDay=" + EndDay + "]";
	}
	
	

	
}
