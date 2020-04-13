package movie.model.vo;

public class Genre {
	private int gNo;
	private String Genre;
	
	public Genre() {}

	public Genre(int gNo, String genre) {
		super();
		this.gNo = gNo;
		Genre = genre;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	@Override
	public String toString() {
		return "Genre [gNo=" + gNo + ", Genre=" + Genre + "]";
	}
	
	
	
}
