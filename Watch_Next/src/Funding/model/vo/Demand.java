package Funding.model.vo;

import java.sql.Date;

public class Demand {
	private int dNo;// 수요조사 번호
	private String userId;// 회원아이디
	private int smNo;// 상영극장번호
	private int smWant; // 보고싶어요
	private int fileNo; // 파일번호
	private String movieTitle; // 영화 제목
	private String movieDirector; // 영화 감독
	private String movieActor;// 영화 배우
	private String movieStory;// 영화 스토리
	private int minPeople;
	private Date startDate;// 시작 날짜
	private Date endDate;// 끝나는 날짜
	private int gerneNo;// 장르 번호
	private String runningTime;// 상영 시간

	public Demand() {
	}

	public Demand(int dNo, String userId, int smNo, int smWant, int fileNo, String movieTitle, String movieDirector,
			String movieActor, String movieStory, int minPeople, Date startDate, Date endDate, int gerneNo,
			String runningTime) {
		super();
		this.dNo = dNo;
		this.userId = userId;
		this.smNo = smNo;
		this.smWant = smWant;
		this.fileNo = fileNo;
		this.movieTitle = movieTitle;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
		this.minPeople = minPeople;
		this.startDate = startDate;
		this.endDate = endDate;
		this.gerneNo = gerneNo;
		this.runningTime = runningTime;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getSmNo() {
		return smNo;
	}

	public void setSmNo(int smNo) {
		this.smNo = smNo;
	}

	public int getSmWant() {
		return smWant;
	}

	public void setSmWant(int smWant) {
		this.smWant = smWant;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public String getMovieStory() {
		return movieStory;
	}

	public void setMovieStory(String movieStory) {
		this.movieStory = movieStory;
	}

	public int getMinPeople() {
		return minPeople;
	}

	public void setMinPeople(int minPeople) {
		this.minPeople = minPeople;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getGerneNo() {
		return gerneNo;
	}

	public void setGerneNo(int gerneNo) {
		this.gerneNo = gerneNo;
	}

	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	@Override
	public String toString() {
		return "Demand [dNo=" + dNo + ", userId=" + userId + ", smNo=" + smNo + ", smWant=" + smWant + ", fileNo="
				+ fileNo + ", movieTitle=" + movieTitle + ", movieDirector=" + movieDirector + ", movieActor="
				+ movieActor + ", movieStory=" + movieStory + ", minPeople=" + minPeople + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", gerneNo=" + gerneNo + ", runningTime=" + runningTime + "]";
	}

}
