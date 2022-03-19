package com.ezen.market.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.market.dao.QnaDao;
import com.ezen.market.dto.QnaVo;

@Service
public class QnaSer {
	
	@Autowired
	QnaDao qdao;
	
	public void deleteQna(Integer num){
		qdao.deleteQna(num);
	}
	
	public void updateQna(QnaVo qvo) {
		qdao.updateQna(qvo);
	}
	public QnaVo getQna(int num) {
		QnaVo qvo = qdao.getQna(num);
		return qvo;
	}
	
	public ArrayList<QnaVo> myList(String id){
		ArrayList<QnaVo> list = qdao.myList(id);
		return list;
	}
	
	public void insertQna(QnaVo qvo, String id) {
		qdao.insertQna(qvo, id);
	}
	
	public ArrayList<QnaVo> listQna(String id){
		ArrayList<QnaVo> list = qdao.listQna(id);
		return list;
	}

}
