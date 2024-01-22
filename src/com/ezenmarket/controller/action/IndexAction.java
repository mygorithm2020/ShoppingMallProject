package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.ProductVo;



public class IndexAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		ArrayList<ProductVo> nlist = new ArrayList<ProductVo>();
		ArrayList<ProductVo> blist = new ArrayList<ProductVo>();
		
		
		ProductDao pdao = ProductDao.getInstance();
		nlist = pdao.listNewProduct();
		blist = pdao.listBestProduct();
		
		
		request.setAttribute("newProductList", nlist);
		request.setAttribute("bestProductList", blist);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
