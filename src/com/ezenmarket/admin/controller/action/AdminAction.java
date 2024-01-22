package com.ezenmarket.admin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.controller.action.Action;
import com.ezenmarket.dto.MemberVo;



public class AdminAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=admin_member_list";  
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url = "market.do?command=login_form";
	    }
	   
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
