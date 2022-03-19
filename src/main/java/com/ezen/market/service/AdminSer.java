package com.ezen.market.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.market.dao.AdmDao;
import com.ezen.market.dto.MemberVo;
import com.ezen.market.dto.Paging;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.QnaVo;
import com.ezen.market.dto.RentVo;

@Service
public class AdminSer {
	
	@Autowired
	AdmDao adao;
	
	public ArrayList<QnaVo> listAllQna(Paging paging){
		ArrayList<QnaVo> qnaList = adao.listAllQna(paging);
		return qnaList;
	}
	
	public int getAllcount(){
		int count = adao.getAllcount();
		return count;
	}
	
	public ArrayList<RentVo> listOrder(Paging paging, String key){
		ArrayList<RentVo> list = adao.listOrder(paging, key);
		return list;
	}
	
	public ArrayList<ProductVo> listProduct(Paging paging, String key){
		ArrayList<ProductVo> list = adao.listProduct(paging, key);
		return list;
	}
	
	public ArrayList<MemberVo>listMember(Paging paging, String key){
		ArrayList<MemberVo> list = adao.listMember(paging, key);
		return list;
	}
	
	public  int getAllCountOrder(String key) {
		 int count = adao.getAllCount(key);
		 return count;
	}
	
	public  int getAllCountProd(String key) {
		 int count = adao.getAllCount(key);
		 return count;
	}
	
	public  int getAllCount(String key) {
		 int count = adao.getAllCount(key);
		 return count;
	}
	
}
