package board.model.vo;

import java.sql.Date;

public class Review {
	private int rNo;
	private String mTitle;
	private int rStar;
	private int rLike;
	private char rSpo;
	public Review(int rNo, String mTitle, int rStar, int rLike, char rSpo) {
		super();
		this.rNo = rNo;
		this.mTitle = mTitle;
		this.rStar = rStar;
		this.rLike = rLike;
		this.rSpo = rSpo;
	}
	
	
	public Review() {}
	


	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public int getrStar() {
		return rStar;
	}
	public void setrStar(int rStar) {
		this.rStar = rStar;
	}
	public int getrLike() {
		return rLike;
	}
	public void setrLike(int rLike) {
		this.rLike = rLike;
	}
	public char getrSpo() {
		return rSpo;
	}
	public void setrSpo(char rSpo) {
		this.rSpo = rSpo;
	}

	@Override
	public String toString() {
		return "Review [rNo=" + rNo + ", mTitle=" + mTitle + ", rStar=" + rStar + ", rLike=" + rLike + ", rSpo=" + rSpo
				+ "]";
	}
	
	
}
