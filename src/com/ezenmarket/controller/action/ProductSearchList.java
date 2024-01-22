package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.ProductVo;




public class ProductSearchList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productList.jsp";
		
		String pname = request.getParameter("product");
		String gu = request.getParameter("gu");
		ProductDao pdao=ProductDao.getInstance();
		ArrayList<ProductVo> productSearchList = pdao.productSearchList(pname,gu);
		request.setAttribute("productSearchList",productSearchList);
		request.setAttribute("pname", pname);
		
		System.out.println(pname+gu);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
