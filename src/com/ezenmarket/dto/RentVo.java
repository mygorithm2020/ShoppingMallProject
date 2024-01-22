package com.ezenmarket.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class RentVo {
	private Integer num;
	private String name;
	private Integer rnum;
	private String id;
	private Date borrow;
	private Date turn;
	private String locationname;
	private Integer price;
	private Integer count;
		
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
	public Integer getRnum() {
		return rnum;
	}
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getBorrow() {
		return borrow;
	}
	public void setBorrow(Date borrow) {
		this.borrow = borrow;
	}
	public Date getTurn() {
		return turn;
	}
	public void setTurn(Date turn) {
		this.turn = turn;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	

}
