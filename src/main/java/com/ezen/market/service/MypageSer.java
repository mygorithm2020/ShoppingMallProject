package com.ezen.market.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.market.dao.MypageDao;
import com.ezen.market.dto.RentVo;
import com.ezen.market.dto.RentcartVo;

@Service
public class MypageSer {
	
	@Autowired
	MypageDao mdao;
	
	public void rentWrite(RentVo rvo) {
		mdao.rentWrite(rvo);
	}
	
	public void insertRentCart(RentcartVo rcvo) {
		mdao.insertRentCart(rcvo);
	}
	
	public RentVo getRentDetail(String rseq) {
		RentVo rvo = mdao.getRentDetail(rseq);
		return rvo;
	}
	
	public ArrayList<RentcartVo> listRentCart(String id, int num, String name) {
		ArrayList<RentcartVo> list = mdao.listRentCart(id, num, name);
		return list;
	}
	
	public ArrayList<Integer> selectNumRentCart(String id){
		ArrayList<Integer> list = mdao.selectNumRentCart(id);
		return list;
	}

}
