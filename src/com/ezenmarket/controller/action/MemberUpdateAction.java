package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;



public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=index";
		MemberVo mvo = new MemberVo();
		mvo.setId(request.getParameter("id"));
		mvo.setPw(request.getParameter("pw"));
		mvo.setName(request.getParameter("name"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setZipcode(request.getParameter("zipcode"));
		mvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setGender(request.getParameter("gender"));
		
		
		
		
		mvo.setBirth(Integer.parseInt(request.getParameter("birth")));
		
		MemberDao mdao = MemberDao.getInstance(); 
		mdao.updateMember(mvo);
		 		
		RequestDispatcher dispathcer = request.getRequestDispatcher(url);
		dispathcer.forward(request, response);
		
	}

}
