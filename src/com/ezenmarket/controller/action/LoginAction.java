package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;


public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");		
		MemberDao mdao = MemberDao.getInstance();		
		MemberVo mvo = mdao.getMember(id);
		HttpSession session = request.getSession();
		if(mvo != null) {
			if(mvo.getPw().equals(pw)) {
				//session.removeAttribute("id");				
				url="market.do?command=index";
				session.setAttribute("loginUser", mvo);
				if(mvo.getAdmin()==1) {
					url="market.do?command=admin";
					
				}
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}