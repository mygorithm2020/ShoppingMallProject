package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dao.OrderRentDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.RentVo;
import com.ezenmarket.dto.RentcartVo;

public class RentWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=rent_list";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		
		if( id == null) { url = "market.do?command=index"; }
		else {
			RentVo rvo = new RentVo();
			rvo.setName(request.getParameter("pname"));
			rvo.setRnum(Integer.parseInt(request.getParameter("pseq")));
			rvo.setId(request.getParameter("loginid"));
			java.sql.Date bDate = java.sql.Date.valueOf(request.getParameter("from"));
			java.sql.Date tDate = java.sql.Date.valueOf(request.getParameter("to"));
			rvo.setBorrow(bDate);
			rvo.setTurn(tDate);
			rvo.setLocationname(request.getParameter("location"));
			rvo.setPrice(Integer.parseInt(request.getParameter("price")));
					    
			OrderRentDao ordao = OrderRentDao.getInstance();
			ordao.rentWrite(rvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
