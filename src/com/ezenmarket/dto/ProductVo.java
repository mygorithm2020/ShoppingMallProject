package com.ezenmarket.dto;

import java.sql.Timestamp;

public class ProductVo {
	private Integer num;	
	private String id;
	private String title;
	private String name;
	private Integer count;	
	private Integer price;
	private Integer category;	
	private String img;
	private String locationname;
	private String content;
	private Timestamp indate;
	private Integer viewcount;	
	private Integer rentcount;	
	private String classify;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
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
	public Integer getViewcount() {
		return viewcount;
	}
	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}
	public Integer getRentcount() {
		return rentcount;
	}
	public void setRentcount(Integer rentcount) {
		this.rentcount = rentcount;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	

}
