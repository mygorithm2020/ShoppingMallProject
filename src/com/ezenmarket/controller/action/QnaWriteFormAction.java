package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dto.MemberVo;



public class QnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaWrite.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo= (MemberVo) session.getAttribute("loginUser"); 
	    if (mvo == null)  	url = "marktet.do?command=login_form";
	    
	    request.getRequestDispatcher(url).forward(request, response);	    	
	}
}
