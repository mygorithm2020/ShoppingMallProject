package com.ezen.market.dto;

import java.sql.Timestamp;

public class NoticeVo {
	private Integer nnum;
	private String title;
	private String content;
	private Timestamp indate;
	public Integer getNnum() {
		return nnum;
	}
	public void setNnum(Integer nnum) {
		this.nnum = nnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
	

}
