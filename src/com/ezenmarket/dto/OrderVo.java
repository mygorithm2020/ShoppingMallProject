package com.ezenmarket.dto;

import java.sql.Timestamp;

public class OrderVo {
	private Integer num;
	private String name;
	private Integer onum;
	private String id;
	private Integer count;
	private Timestamp indate;
	private Integer price;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Integer getOnum() {
		return onum;
	}
	public void setOnum(Integer onum) {
		this.onum = onum;
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
	

}
