package Funding.model.vo;

import java.sql.Date;

public class DemandList {
	private int dNo;
	private int FileNo;
	private String FileName;
	private Date EndDay;
	private int Percent;

	public DemandList() {}

	public DemandList(int dNo, int fileNo, String fileName, Date endDay, int percent) {
		super();
		this.dNo = dNo;
		FileNo = fileNo;
		FileName = fileName;
		EndDay = endDay;
		Percent = percent;
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

	public Date getEndDay() {
		return EndDay;
	}

	public void setEndDay(Date endDay) {
		EndDay = endDay;
	}

	public int getPercent() {
		return Percent;
	}

	public void setPercent(int percent) {
		Percent = percent;
	}

	@Override
	public String toString() {
		return "DemandList [dNo=" + dNo + ", FileNo=" + FileNo + ", FileName=" + FileName + ", EndDay=" + EndDay
				+ ", Percent=" + Percent + "]";
	}
	
	
	
	



	
	
	
	
	
	
}
