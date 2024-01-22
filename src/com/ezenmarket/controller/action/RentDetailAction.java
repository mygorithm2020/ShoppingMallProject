package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenmarket.dao.OrderRentDao;
import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.ProductVo;
import com.ezenmarket.dto.RentVo;

public class RentDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="mypage/RentDetail.jsp";
		String rseq = request.getParameter("rseq");
		/*ProductVo pvo2= new ProductVo();
		ProductDao pdao2 = ProductDao.getInstance();
		pvo2 = pdao2.addView(pseq);*/
		RentVo rvo= new RentVo();
		OrderRentDao rdao = OrderRentDao.getInstance();
		rvo = rdao.getRentDetail(rseq);
		request.setAttribute("rentVo", rvo);
		
		ProductVo pvo = new ProductVo();
		ProductDao pdao = ProductDao.getInstance();
		pvo = pdao.getProduct(rseq);
		request.setAttribute("productVo", pvo);
				
		
		ArrayList<ProductVo> nlist = new ArrayList<ProductVo>();
		nlist = pdao.listNewProduct();
		request.setAttribute("newProductList", nlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
