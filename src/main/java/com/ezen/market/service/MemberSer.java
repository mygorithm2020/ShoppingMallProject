package com.ezen.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.market.dao.MemDao;
import com.ezen.market.dto.MemberVo;

@Service
public class MemberSer {
	
	@Autowired
	MemDao mdao;
	
	public void updateMember(MemberVo mvo) {
		mdao.updateMember(mvo);
	}
	
	public void deleteMember(String id2) {
		mdao.deleteMember(id2);
	}
	
	public int confirmID(String id) {
		int message = mdao.confirmID(id);
		return message;
	}
	
	public void insertMember(MemberVo mvo) {
		mdao.insertMember(mvo);
	}
	
	public MemberVo getMember(String id) {
		MemberVo mvo = mdao.getMember(id);
		return mvo;
	}

}
