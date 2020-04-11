package MovieBoard.model.vo;

import java.sql.Date;

public class Movie {
	private int movieNo;
	private String movieTitle;
	private String director;
	private String actor;
	private String runningTime;
	private Date releaseDate;
	private String country;
	private String story;
	private int genreNo;
	private String genreName;
	private int fileNo;
	private String fileNewName;
	private String boardTitle;
	private String serviceSite;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	// 전체영화 생성자
	public Movie(int movieNo, String movieTitle, String fileNewName) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.fileNewName = fileNewName;
	}
	
	// 영화 입력 생성자
	public Movie(String movieTitle, String director, String actor, String runningTime, Date releaseDate, String country,
			String story, int fileNo, int genreNo, String serviceSite) {
		super();
		this.movieTitle = movieTitle;
		this.director = director;
		this.actor = actor;
		this.runningTime = runningTime;
		this.releaseDate = releaseDate;
		this.country = country;
		this.story = story;
		this.fileNo = fileNo;
		this.genreNo = genreNo;
		this.serviceSite = serviceSite;
	}

	// 영화 검색 생성자
	
	public Movie(int movieNo, String movieTitle, String director, String actor, String runningTime, Date releaseDate,
			String country, String story, String genreName, String fileNewName, String serviceSite) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.director = director;
		this.actor = actor;
		this.runningTime = runningTime;
		this.releaseDate = releaseDate;
		this.country = country;
		this.story = story;
		this.genreName = genreName;
		this.fileNewName = fileNewName;
		this.serviceSite = serviceSite;
	}
	
	// 모든 변수 생성자
	public Movie(int movieNo, String movieTitle, String director, String actor, String runningTime, Date releaseDate,
			String country, String story, int genreNo, String genreName, int fileNo, String fileNewName,
			String boardTitle, String serviceSite) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.director = director;
		this.actor = actor;
		this.runningTime = runningTime;
		this.releaseDate = releaseDate;
		this.country = country;
		this.story = story;
		this.genreNo = genreNo;
		this.genreName = genreName;
		this.fileNo = fileNo;
		this.fileNewName = fileNewName;
		this.boardTitle = boardTitle;
		this.serviceSite = serviceSite;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileNewName() {
		return fileNewName;
	}
	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getServiceSite() {
		return serviceSite;
	}

	public void setServiceSite(String serviceSite) {
		this.serviceSite = serviceSite;
	}

	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", director=" + director + ", actor="
				+ actor + ", runningTime=" + runningTime + ", releaseDate=" + releaseDate + ", country=" + country
				+ ", story=" + story + ", genreNo=" + genreNo + ", genreName=" + genreName + ", fileNo=" + fileNo
				+ ", fileNewName=" + fileNewName + ", boardTitle=" + boardTitle + ", serviceSite=" + serviceSite + "]";
	}
	
	

	
	
}
