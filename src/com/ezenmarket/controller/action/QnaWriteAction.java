package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.QnaVo;


public class QnaWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=qna_my_list";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");    
	    if (mvo == null) {
	    	url = "market.do?command=login_form";
	    }else{
	    	QnaVo qvo = new QnaVo();
	    	qvo.setTitle(request.getParameter("title"));
	    	qvo.setContent(request.getParameter("content"));
	    	QnaDao qdao = QnaDao.getInstance();
	    	qdao.insertQna(qvo, mvo.getId());
	    }
	    request.getRequestDispatcher(url).forward(request, response);	 
	}		
}
