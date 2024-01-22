package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;



public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		MemberVo mvo = new MemberVo();
		mvo.setId(request.getParameter("id"));
		mvo.setPw(request.getParameter("pw"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZipcode(request.getParameter("zipcode"));
		mvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setGender(request.getParameter("gender"));
		
		String birth=request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
		
		mvo.setBirth(Integer.parseInt(birth));
		
		MemberDao mdao = MemberDao.getInstance();
		mdao.insertMember(mvo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
