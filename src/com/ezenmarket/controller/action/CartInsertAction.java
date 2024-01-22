package com.ezenmarket.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;

import com.ezenmarket.dto.MemberVo;

import com.ezenmarket.dto.RentcartVo;


public class CartInsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=rent_cart_list";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		
		if( id == null) { url = "market.do?command=index"; }
		else {
			
			
			
			
			RentcartVo rcvo = new RentcartVo();
			rcvo.setId(request.getParameter("loginid"));
		
			rcvo.setRnum(Integer.parseInt(request.getParameter("pseq")));
			rcvo.setPrice(Integer.parseInt(request.getParameter("price")));
			
			java.sql.Date bDate = java.sql.Date.valueOf(request.getParameter("from"));
			java.sql.Date tDate = java.sql.Date.valueOf(request.getParameter("to"));
			
			
			
			rcvo.setBorrow(bDate);
			rcvo.setTurn(tDate);
			
		    
		    
		    CartDao cdao = CartDao.getInstance();
		    cdao.insertRentCart(rcvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
