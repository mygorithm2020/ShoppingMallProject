package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.MemberDao;
import com.ezenmarket.dto.MemberVo;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=index";
		
		HttpSession session = request.getSession();
		MemberDao mdao = MemberDao.getInstance();	
		String id2 =request.getParameter("loginid") ;
		MemberVo id = (MemberVo)session.getAttribute("loginUser");		
		if( id == null) { url = "market.do?command=login_form"; }
		else {		
			mdao.deleteMember(id2);			
		}
		
		if(session!=null) session.invalidate();
		
		RequestDispatcher dispathcer = request.getRequestDispatcher(url);
		
		dispathcer.forward(request, response);
		
	}

}



/*
 * MemberVo mvo = new MemberVo(); mvo.setId(request.getParameter("id"));
 * 
 * mvo.setPw(request.getParameter("pw"));
 * mvo.setName(request.getParameter("name"));
 * mvo.setEmail(request.getParameter("email"));
 * mvo.setZipcode(request.getParameter("zipcode"));
 * mvo.setAddress(request.getParameter("addr1") + " " +
 * request.getParameter("addr2")); mvo.setPhone(request.getParameter("phone"));
 * 
 * mvo.setGender(request.getParameter("gender"));
 * 
 * mvo.setBirth(Integer.parseInt(request.getParameter("birth")));
 * 
 * 
 * MemberDao mdao = MemberDao.getInstance(); mdao.deleteMember(mvo);
 */
