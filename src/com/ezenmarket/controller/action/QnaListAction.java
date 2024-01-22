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



public class QnaListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url = "market.do?command=login_form";
	    } else {
	    	QnaDao qdao = QnaDao.getInstance();
	    	ArrayList<QnaVo> list = qdao.listQna(mvo.getId());
	    	request.setAttribute("qnaList", list);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
