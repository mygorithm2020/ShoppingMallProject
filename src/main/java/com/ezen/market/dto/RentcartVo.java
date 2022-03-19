package com.ezen.market.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class RentcartVo {
	private Integer num;
	private Integer rnum;
	private String name;
	private String id;
	private Integer count;
	private Integer price;
	private Date borrow;
	private Date turn;
	private Timestamp indate;
	private String result;
	
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
