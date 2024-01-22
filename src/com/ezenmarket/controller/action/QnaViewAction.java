package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.QnaVo;



public class QnaViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaView.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	      url = "market.do?command=login_form";
	    } else {
	    	int num = Integer.parseInt(request.getParameter("num"));
	    	QnaDao qdao = QnaDao.getInstance();
	    	QnaVo qvo = qdao.getQna(num);
	    	request.setAttribute("qnaVO", qvo);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
