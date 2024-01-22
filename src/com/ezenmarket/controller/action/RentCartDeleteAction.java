package com.ezenmarket.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dao.QnaDao;
import com.ezenmarket.dto.MemberVo;

public class RentCartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "market.do?command=rent_cart_list";		
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo)session.getAttribute("loginUser");       
	    if (mvo == null) {
	    	url = "market.do?command=login_form";
	    }else{
	    	String[] num = request.getParameterValues("num");
			// 체크된 체크박스의 밸류들을 파라미터로 전달받음
			CartDao cdao = CartDao.getInstance();			
			for(String n : num) {				
				cdao.deleteCart(Integer.parseInt(n));
			}
			// 배열에 있는 카드 번호들을 n 변수에 하나씩 전달하며 cdao.deleteCart(n); 를 반복 실행
	    		    	    	
	    	
	    }		
					
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
