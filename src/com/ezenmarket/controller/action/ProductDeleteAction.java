package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.MemberVo;



public class ProductDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=index";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		if( id == null) { url = "market.do?command=login_form"; }
		else {
			String pseq = request.getParameter("pseq");
			ProductDao pdao = ProductDao.getInstance();
			pdao.deleteProduct(pseq);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
		
	

}
