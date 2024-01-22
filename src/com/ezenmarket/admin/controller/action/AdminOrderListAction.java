package com.ezenmarket.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.controller.action.Action;
import com.ezenmarket.dao.AdminDao;
import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.OrderVo;
import com.ezenmarket.dto.Paging;
import com.ezenmarket.dto.RentVo;


public class AdminOrderListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/order/orderList.jsp";
		HttpSession session = request.getSession();				
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if (mvo == null) {url = "market.do?command=login_form"; }
		else {
			int page=1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			Paging paging = new Paging();
			String key = request.getParameter("key");
			CartDao cdao = CartDao.getInstance();
			AdminDao adao = AdminDao.getInstance();
			paging.setPage(page);  // 현재 페이지 세팅
			int count = adao.getAllCount(key); // 레코드 갯수 계산
			paging.setTotalCount(count);  
			
			ArrayList<RentVo> list = adao.listOrder(paging, key);
			request.setAttribute("orderList", list);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
			
			request.getRequestDispatcher(url).forward(request, response);
			
		}
		
	}

}
