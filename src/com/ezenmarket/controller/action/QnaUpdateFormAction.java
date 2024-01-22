package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.QnaVo;

public class QnaUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaUpdate.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");    
	    Integer num = Integer.parseInt(request.getParameter("num") ) ;
	    QnaVo qvo = new QnaVo();
	    if (mvo == null) {
	    	url = "market.do?command=login_form";
	    }else{
	    	
	    	QnaDao qdao = QnaDao.getInstance();	    	
	    	qvo = qdao.getQna(num);
	    }
	    request.setAttribute("qnaUpdate", qvo);
	    request.getRequestDispatcher(url).forward(request, response);	 
	}

}
