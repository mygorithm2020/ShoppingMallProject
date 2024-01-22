package com.ezenmarket.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.controller.action.Action;
import com.ezenmarket.dao.AdminDao;
import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.Paging;
import com.ezenmarket.dto.ProductVo;



public class AdminProductListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if( mvo == null) { url = "market.do?command=login_form"; }
		else {
			int page=1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			// 현재 화면에 표시할 페이지는 초기값 1이지만, 파라미터로 전달되는 페이지가 있다면 그걸 우선으로 설정합니다
			String key = request.getParameter("key");			
			ProductDao pdao=ProductDao.getInstance();
			AdminDao adao = AdminDao.getInstance();
			Paging paging = new Paging(); // 페이지 객체 생성
			paging.setPage(page);  // 현재 페이지 세팅
			int count = adao.getAllCount(key); // 레코드 갯수 계산
			paging.setTotalCount(count);  
			// 총갯수 를 setTotalCount(count) 에 넣고 그안의 paging() 을 호출하여 그외 멤버 변수들을 계산함
			
			ArrayList<ProductVo> productList = adao.listProduct(paging, key);
			//System.out.println(productList.size());
			request.setAttribute("productList",productList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}









