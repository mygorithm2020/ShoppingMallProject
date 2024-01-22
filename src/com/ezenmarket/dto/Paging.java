package com.ezenmarket.dto;

public class Paging {
	private int page =1;
    private int totalCount;
    private int beginPage;
    private int endPage;
    private int displayRow =10;  
    private int displayPage =10;  
    boolean prev;
    boolean next;
    private int startNum;
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
		this.totalCount = totalCount;
		paging();
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
	
	private void paging(){
        endPage = ((int)Math.ceil(page/(double)displayPage))
        															*displayPage;
        System.out.println("endPage : " + endPage);
        beginPage = endPage - (displayPage - 1);
        System.out.println("beginPage : " + beginPage);
        int totalPage 
        		= (int)Math.ceil(totalCount/(double)displayRow);
        if(totalPage<endPage){
            endPage = totalPage;
            next = false;
        }else{
            next = true;
        }
        prev = (beginPage==1)?false:true;
        if(beginPage==1)prev = false;
        else prev = true;
        System.out.println("endPage : " + endPage);
        System.out.println("totalPage : " + totalPage);
        startNum = (page-1)*displayRow+1;
        endNum = page*displayRow;
    } 
    
}
