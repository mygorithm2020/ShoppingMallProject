package com.ezen.market.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.market.dto.MemberVo;
import com.ezen.market.dto.Paging;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.QnaVo;
import com.ezen.market.dto.RentVo;
import com.ezen.market.service.AdminSer;
import com.ezen.market.service.MemberSer;
import com.ezen.market.service.ProductSer;

@Controller
public class AdminCon {
	
	@Autowired
	AdminSer as;
	@Autowired
	MemberSer ms;
	@Autowired
	ProductSer ps;
	
	@RequestMapping(value="admin_qna_list")
	public String admin_qna_list(Model model, HttpServletRequest request) {
		String url = "admin/qna/qnaList";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if( mvo == null) { url = "redirect:/login_form"; }
		else {
			int page=1;	
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			Paging paging = new Paging();
			paging.setPage(page);						
			int count = as.getAllcount();
			paging.setTotalCount(count);			
			ArrayList<QnaVo> qnaList = as.listAllQna(paging);
			request.setAttribute("qnaList", qnaList);
			request.setAttribute("paging", paging);
		}
	    return url;
	}
	
	@RequestMapping(value="admin_order_list")
	public String admin_order_list(Model model, HttpServletRequest request) {
		String url = "admin/order/orderList";
		HttpSession session = request.getSession();				
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if (mvo == null) { url = "redirect:/login_form";  }
		else {
			int page=1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			Paging paging = new Paging();
			String key = request.getParameter("key");			
			paging.setPage(page);  // 현재 페이지 세팅
			int count = as.getAllCountOrder(key); // 레코드 갯수 계산
			paging.setTotalCount(count);  
			
			ArrayList<RentVo> list = as.listOrder(paging, key);
			model.addAttribute("orderList", list);
			model.addAttribute("paging", paging);
			model.addAttribute("key", key);
			
		}
	    return url;
	}
	
	@RequestMapping(value="admin_product_list")
	public String admin_product_list(Model model, HttpServletRequest request) {
		String url = "admin/product/productList";
		HttpSession session = request.getSession();
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if( mvo == null) { url = "redirect:/login_form"; }
		else {
			int page=1;
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));
			// 현재 화면에 표시할 페이지는 초기값 1이지만, 파라미터로 전달되는 페이지가 있다면 그걸 우선으로 설정합니다
			String key = request.getParameter("key");								
			Paging paging = new Paging(); // 페이지 객체 생성
			paging.setPage(page);  // 현재 페이지 세팅
			int count = as.getAllCountProd(key); // 레코드 갯수 계산
			paging.setTotalCount(count);  
			// 총갯수 를 setTotalCount(count) 에 넣고 그안의 paging() 을 호출하여 그외 멤버 변수들을 계산함
			
			ArrayList<ProductVo> productList = as.listProduct(paging, key);
			//System.out.println(productList.size());
			model.addAttribute("productList",productList);
			model.addAttribute("paging", paging);
			model.addAttribute("key", key);
		}
	    return url;
	}
	
	@RequestMapping(value="admin_member_list")
	public String admin_member_list(Model model, HttpServletRequest request) {
		String url = "admin/member/memberList";
		HttpSession session = request.getSession();		
		
		MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
		if (mvo == null) {url = "redirect:/login_form"; }
		else {
			int page=1;	
			if(request.getParameter("page")!=null) page = Integer.parseInt(request.getParameter("page"));						
			String key = request.getParameter("key");
		    int count = as.getAllCount(key);
		    Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(count);
			ArrayList<MemberVo> memberList = as.listMember(paging, key);
			model.addAttribute("memberList", memberList);
			model.addAttribute("paging", paging);
			 
		}
	    return url;
	}
	
	@RequestMapping(value="admin")
	public String admin(Model model, HttpServletRequest request) {
		String url = "redirect:/admin_member_list";  
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if (mvo == null) {
	    	url = "redirect:/login_form";
	    }
	    return url;
	}

}
