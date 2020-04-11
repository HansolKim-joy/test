package MovieBoard.model.vo;

import java.sql.Date;

public class Review {
	
	private int reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private String reviewViews;
	private Date reviewDate;
	private char reviewSpoCheckYN;
	private String reviewMovieTitle;
	private int reviewGrade;
	public Review() {}
	
	// 영화 검색 리뷰 가져오기 생성자
	
	public Review(int reviewNo, String reviewContent) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
	}
	
	// 전체 생성자
	
	public Review(int reviewNo, String reviewTitle, String reviewContent, String reviewViews, Date reviewDate,
			char reviewSpoCheckYN, String reviewMovieTitle, int reviewGrade) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewViews = reviewViews;
		this.reviewDate = reviewDate;
		this.reviewSpoCheckYN = reviewSpoCheckYN;
		this.reviewMovieTitle = reviewMovieTitle;
		this.reviewGrade = reviewGrade;
	}

	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewViews() {
		return reviewViews;
	}
	public void setReviewViews(String reviewViews) {
		this.reviewViews = reviewViews;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public char getReviewSpoCheckYN() {
		return reviewSpoCheckYN;
	}
	public void setReviewSpoCheckYN(char reviewSpoCheckYN) {
		this.reviewSpoCheckYN = reviewSpoCheckYN;
	}
	public String getReviewMovieTitle() {
		return reviewMovieTitle;
	}
	public void setReviewMovieTitle(String reviewMovieTitle) {
		this.reviewMovieTitle = reviewMovieTitle;
	}
	public int getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent
				+ ", reviewViews=" + reviewViews + ", reviewDate=" + reviewDate + ", reviewSpoCheckYN="
				+ reviewSpoCheckYN + ", reviewMovieTitle=" + reviewMovieTitle + ", reviewGrade=" + reviewGrade + "]";
	}
	

	

	
}
