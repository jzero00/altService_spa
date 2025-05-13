package altService.utils;

public class SearchCriteria {

	private int page; // 페이지 번호
	private int perPageNum; // 한페이지당 리스트개수
	private int offset; // offset 다음페이지 출력시 몇번 자료부터 보여줄 것인지 결정
	private String searchType; // 검색구분
	private String keyword; // 검색어
	private String stts;

	public SearchCriteria() {
		super();
		this.page = 1;
		this.perPageNum = 10;
		this.offset = 0;
		this.searchType = "";
		this.keyword = "";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getOffset() {
		offset = (this.page - 1) * perPageNum;
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageStartRowNum() { // 각 페이지마다 시작하는 행번호
		return (this.page - 1) * perPageNum;
	}

	public String getStts() {
		return stts;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

}