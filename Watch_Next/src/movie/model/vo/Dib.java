package movie.model.vo;

public class Dib {
	private String user_id;
	private int movie_no;
	public Dib() {
		// TODO Auto-generated constructor stub
	}
	public Dib(String user_id, int movie_no) {
		super();
		this.user_id = user_id;
		this.movie_no = movie_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}
	@Override
	public String toString() {
		return "DIb [user_id=" + user_id + ", movie_no=" + movie_no + "]";
	}
	
}
