package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.ProductVo;


public class UploadListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/uploadList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
				url = "market.do?command=login_form";
		}else {
				ProductDao pdao = ProductDao.getInstance();
				ArrayList<ProductVo> list = pdao.listProduct(mvo.getId()); 
				//아이디로 검색한 장바구니 물건들을 검색하여 리스트로 받음
				
				request.setAttribute("productList", list);				
		}
	    request.getRequestDispatcher(url).forward(request, response);
	}
		
	

}
