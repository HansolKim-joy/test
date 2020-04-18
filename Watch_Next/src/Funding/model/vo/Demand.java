package Funding.model.vo;

import java.sql.Date;

public class Demand {
	private int dNo;// 수요조사 번호
	private String userId;// 회원아이디
	private int smNo;// 상영극장번호
	private int smWant; // 모인 금액
	private int fileNo; // 파일번호
	private String movieTitle; // 영화 제목
	private String movieDirector; // 영화 감독
	private String movieActor;// 영화 배우
	private String movieStory;// 영화 스토리
	private int money; // 펀딩 금액
	private int wantMoney; // 참여 금액
	private Date startDate;// 시작 날짜
	private Date endDate;// 끝나는 날짜
	private int gerneNo;// 장르 번호
	private String runningTime;// 상영 시간
	private char usedYN;

	public Demand() {
	}

	// 수요조사 사람 퍼센트 생성자
	public Demand(int dNo, int money) {
		super();
		this.dNo = dNo;
		this.money = money;
	}

	// 수요조사 입력할때 생성자
	public Demand(String userId, int smNo, int fileNo, int wantMoney, int money, String movieTitle,
			String movieDirector, String movieActor, String movieStory, int gerneNo, String runningTime) {
		super();
		this.userId = userId;
		this.smNo = smNo;
		this.fileNo = fileNo;
		this.movieTitle = movieTitle;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieStory = movieStory;
		this.gerneNo = gerneNo;
		this.runningTime = runningTime;
		this.money = money;
		this.wantMoney = wantMoney;
	}

	// 불러올때 생성자
	public Demand(int dNo, String userId, int smNo, int smWant, int fileNo, String movieTitle, String movieDirector,
			String movieActor, String movieStory, int wantMoney, int money, Date startDate, Date endDate, int gerneNo,
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
		this.wantMoney = wantMoney;
		this.money = money;
		this.startDate = startDate;
		this.endDate = endDate;
		this.gerneNo = gerneNo;
		this.runningTime = runningTime;
	}

	// 전체 생성자
	public Demand(int dNo, String userId, int smNo, int smWant, int fileNo, String movieTitle, String movieDirector,
			String movieActor, String movieStory, int money, int wantMoney, Date startDate, Date endDate, int gerneNo,
			String runningTime, char usedYN) {
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
		this.money = money;
		this.wantMoney = wantMoney;
		this.startDate = startDate;
		this.endDate = endDate;
		this.gerneNo = gerneNo;
		this.runningTime = runningTime;
		this.usedYN = usedYN;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getWantMoney() {
		return wantMoney;
	}

	public void setWantMoney(int wantMoney) {
		this.wantMoney = wantMoney;
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

	public char getUsedYN() {
		return usedYN;
	}

	public void setUsedYN(char usedYN) {
		this.usedYN = usedYN;
	}

	@Override
	public String toString() {
		return "Demand [dNo=" + dNo + ", userId=" + userId + ", smNo=" + smNo + ", smWant=" + smWant + ", fileNo="
				+ fileNo + ", movieTitle=" + movieTitle + ", movieDirector=" + movieDirector + ", movieActor="
				+ movieActor + ", movieStory=" + movieStory + ", money=" + money + ", wantMoney=" + wantMoney
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", gerneNo=" + gerneNo + ", runningTime="
				+ runningTime + ", usedYN=" + usedYN + "]";
	}

}
