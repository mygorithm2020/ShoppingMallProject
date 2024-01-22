package com.ezenmarket.dto;

import java.sql.Timestamp;

public class CartVo {
	private Integer num;
	private Integer cnum;
	private String id;
	private Integer count;
	private Integer price;
	private Timestamp indate;
	private String result;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCnum() {
		return cnum;
	}
	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	}
