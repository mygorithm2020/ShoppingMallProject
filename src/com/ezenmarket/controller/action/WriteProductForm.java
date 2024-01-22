package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.LocationVo;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.ProductVo;

public class WriteProductForm implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productWrite.jsp";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");
		if( id == null) { url = "market.do?command=index"; }
		else {
			String kindList[] = { "컴퓨터", "카메라", "음악악기", "스포츠", "도서", "육아", "의류잡화" ,"게임용품"};
			ProductDao pdao=ProductDao.getInstance();
			ArrayList<LocationVo> locationList = pdao.locationList();
			request.setAttribute("locationList", locationList);
			request.setAttribute("kindList", kindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
