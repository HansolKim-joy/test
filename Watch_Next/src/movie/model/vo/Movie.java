package movie.model.vo;

import java.sql.Date;

public class Movie {
	private int mNo;
	private int mGenre;
	private int mFileNo;
	private String mTitle;
	private String mDirector;
	private String mActor;
	private Date mReleaseDate;
	private String mCountry;
	private String mStory;
	private String mRunningTime;
	private String Service_Site;
	
	public Movie() {}

	public Movie(int mNo, int mGenre, int mFileNo, String mTitle, String mDirector, String mActor, Date mReleaseDate,
			String mCountry, String mStory, String mRunningTime, String service_Site) {
		super();
		this.mNo = mNo;
		this.mGenre = mGenre;
		this.mFileNo = mFileNo;
		this.mTitle = mTitle;
		this.mDirector = mDirector;
		this.mActor = mActor;
		this.mReleaseDate = mReleaseDate;
		this.mCountry = mCountry;
		this.mStory = mStory;
		this.mRunningTime = mRunningTime;
		Service_Site = service_Site;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getmGenre() {
		return mGenre;
	}

	public void setmGenre(int mGenre) {
		this.mGenre = mGenre;
	}

	public int getmFileNo() {
		return mFileNo;
	}

	public void setmFileNo(int mFileNo) {
		this.mFileNo = mFileNo;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmDirector() {
		return mDirector;
	}

	public void setmDirector(String mDirector) {
		this.mDirector = mDirector;
	}

	public String getmActor() {
		return mActor;
	}

	public void setmActor(String mActor) {
		this.mActor = mActor;
	}

	public Date getmReleaseDate() {
		return mReleaseDate;
	}

	public void setmReleaseDate(Date mReleaseDate) {
		this.mReleaseDate = mReleaseDate;
	}

	public String getmCountry() {
		return mCountry;
	}

	public void setmCountry(String mCountry) {
		this.mCountry = mCountry;
	}

	public String getmStory() {
		return mStory;
	}

	public void setmStory(String mStory) {
		this.mStory = mStory;
	}

	public String getmRunningTime() {
		return mRunningTime;
	}

	public void setmRunningTime(String mRunningTime) {
		this.mRunningTime = mRunningTime;
	}

	public String getService_Site() {
		return Service_Site;
	}

	public void setService_Site(String service_Site) {
		Service_Site = service_Site;
	}

	@Override
	public String toString() {
		return "Movie [mNo=" + mNo + ", mGenre=" + mGenre + ", mFileNo=" + mFileNo + ", mTitle=" + mTitle
				+ ", mDirector=" + mDirector + ", mActor=" + mActor + ", mCountry=" + mCountry + ", mStory=" + mStory
				+ ", mRunningTime=" + mRunningTime + ", Service_Site=" + Service_Site + "]";
	}
	
	
}