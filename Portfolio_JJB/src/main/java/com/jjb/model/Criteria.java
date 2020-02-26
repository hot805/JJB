package com.jjb.model;

public class Criteria {
	//페이지번호
	private int pageNum;
	//한 페이지당 데이터 처리 갯수(10개)
	private int amount;
	
	private String keyword;
	//처음인지 아닌지 파악하기 위함
	private boolean check;
	//어떤 메뉴의 어떤 카테고리인지 구분하기 위함
	private String page;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if(keyword.equals("")) {
			keyword=null;
		}
		this.keyword = keyword;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", check=" + check
				+ ", page=" + page + "]";
	}	
	
}
