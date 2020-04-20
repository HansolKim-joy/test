package create.model.vo;

public class PageInfo {
	private int currentPage;
	private int listCount;
	private int limit;
	private int MaxPage;
	private int startPage;
	private int endPage;
	private int boardLimit;
	
	public PageInfo() {}

	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage,
			int boardLimit) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		MaxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.boardLimit = boardLimit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getMaxPage() {
		return MaxPage;
	}

	public void setMaxPage(int maxPage) {
		MaxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit + ", MaxPage="
				+ MaxPage + ", startPage=" + startPage + ", endPage=" + endPage + ", boardLimit=" + boardLimit + "]";
	}
	
	

}
