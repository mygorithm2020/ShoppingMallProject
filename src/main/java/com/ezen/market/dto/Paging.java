package com.ezen.market.dto;

public class Paging {
	private int page =1; //현재 페이지(get)
	private int totalCount;		// 게시물 전체의 수(get)
	private int beginPage;		// 출력 시작
	private int endPage;			// 출력 끝
	private int displayRow = 5;		//한 페이지에 표시할 게시물의 갯수
	private int displayPage = 3;		//한 페이지에 표시할 페이지의 개수 : 만약 5일 경우 ◀ 11 12 13 14 15 ▶
	boolean prev;			//prev 버튼이 보일건지 안보일건지
	boolean next;			//next 버튼이 보일건지 안보일건지
	private int startNum;   //현재 화면에 표시할 페이지들중 시작페이지의 값 저장
	private int endNum;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		//현재의 페이징 시스템은 this.totalCount 에 값이 먼저 저 장되면서 시작됩니다.
		//따라서 setTotalCount()가 페이징의 시작이 됩니다.
		// 이후 페이징에 필요한 동작즐은 현ㄴ재 이 위치에서 호출하는 별도의 paging() 메서드를 만들어서 사용합니다.
		this.totalCount = totalCount;
		paging();
	}
	private void paging() {
		endPage = (int)Math.ceil(page/(double)displayPage)*displayPage;
		//현재페이지가 15, 한 페이지에 표시할 페이지 개수가 10으로 가정
		//15/(double)10 => 1.5, 이걸 Math.ceil 에 적용하면 2.0
		//(int) 적용하면 2 -> 마지막으로 displayPage에 곱하면 20이 endPage로 결정됨
		beginPage = endPage - (displayPage -1); //시작페이지 계산
		
		int totalPage = (int)Math.ceil(totalCount /(double)displayRow);
		//전체 레코드 갯수가 145개 이고, 한페이지에 10개씩 보여지고 있다면
		// 145/10 -> 14.5 -> 올림 -> 15 -> 소수점 버림
		// 총 페이지의 갯수는 15개
		
		if(totalPage <=endPage) {
			endPage = totalPage;
			next = false;
		}else {
			next = true;
		}// 현재 표시하려는 endPage 보다 토탈 페이지가 작다면 endPage를 토탈 페이지로 바꿈
		//넥스트 버튼 안보이게 설정.
		//그렇지 않으면 다른 동작 없이 넥스 버튼 보이게 설정
		
		//prev = (beginPage==1)?false:true; 밑에랑 같은 의미
		if(beginPage==1) prev = false;
		else prev = true;
		
		startNum = (page-1)*displayRow+1;		// 현재 표시할 게시물 중 시작 게시물의 행번호 : displayRow단위
		endNum = page*displayRow;		//현재 표시할 게시물 중 끝 게시물의 행번호	: displatRow의 단위
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

}
