package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.OrderRentDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.OrderVo;
import com.ezenmarket.dto.RentVo;

public class RentListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/rentList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
			url = "market.do?command=login_form";
	    }else {
	    	OrderRentDao ordao = OrderRentDao.getInstance();
	    	ArrayList<RentVo> list = ordao.rentList(mvo.getId()); 
			//아이디로 검색한 장바구니 물건들을 검색하여 리스트로 받음
			
			request.setAttribute("rentList", list);				
	    }
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
