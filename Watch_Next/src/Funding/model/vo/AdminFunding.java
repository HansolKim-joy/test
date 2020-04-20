package Funding.model.vo;

public class AdminFunding {
	private int dNo;//펀딩번호
	private String fNewName;//파일 이름
	private String title;// 펀딩  영화 제목
	private String actor;// 펀딩  영화 배우
	private String director;// 펀딩 영화 출연진
	private String story;// 펀딩 영화 내용
	private String smName;// 펀딩 극장 이름
	private int maxPeople;// 펀딩 극장 인원
	private String genre;// 영화 장르 이름
	private String rTime;// 영화 시간
	private int wantPrice;// 펀딩 총 금액
	private int price;// 펀딩 내야하는 금액
	
	public AdminFunding() {}

	public AdminFunding(int dNo, String fNewName, String title, String actor, String director, String story,
			String smName, int maxPeople, String genre, String rTime, int wantPrice, int price) {
		super();
		this.dNo = dNo;
		this.fNewName = fNewName;
		this.title = title;
		this.actor = actor;
		this.director = director;
		this.story = story;
		this.smName = smName;
		this.maxPeople = maxPeople;
		this.genre = genre;
		this.rTime = rTime;
		this.wantPrice = wantPrice;
		this.price = price;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getfNewName() {
		return fNewName;
	}

	public void setfNewName(String fNewName) {
		this.fNewName = fNewName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getrTime() {
		return rTime;
	}

	public void setrTime(String rTime) {
		this.rTime = rTime;
	}

	public int getWantPrice() {
		return wantPrice;
	}

	public void setWantPrice(int wantPrice) {
		this.wantPrice = wantPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AdminFunding [dNo=" + dNo + ", fNewName=" + fNewName + ", title=" + title + ", actor=" + actor
				+ ", director=" + director + ", story=" + story + ", smName=" + smName + ", maxPeople=" + maxPeople
				+ ", genre=" + genre + ", rTime=" + rTime + ", wantPrice=" + wantPrice + ", price=" + price + "]";
	}
	
	
}