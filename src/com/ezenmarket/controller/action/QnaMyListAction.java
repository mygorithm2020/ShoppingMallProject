package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.QnaVo;

public class QnaMyListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaMyList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	      url = "marktet.do?command=login_form";
	    } else {
	    	QnaDao qdao = QnaDao.getInstance();
	    	ArrayList<QnaVo> list = qdao.myList(mvo.getId());	    	
	    	request.setAttribute("myqnaList", list);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}
		
}
