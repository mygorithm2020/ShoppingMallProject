package com.ezen.market.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.market.dto.MemberVo;
import com.ezen.market.dto.ProductVo;
import com.ezen.market.dto.RentVo;
import com.ezen.market.dto.RentcartVo;
import com.ezen.market.service.MypageSer;
import com.ezen.market.service.ProductSer;

@Controller
public class MypageCon {
	
	@Autowired
	MypageSer ms;
	@Autowired
	ProductSer ps;
	
	
	@RequestMapping(value="rent_write")
	public String rent_write(Model model, HttpServletRequest request) {						
		String url = "redirect:/rent_list";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");		
		if( id == null) {  url = "redirect:/login_form"; }
		else {
			RentVo rvo = new RentVo();
			rvo.setName(request.getParameter("pname"));
			rvo.setRnum(Integer.parseInt(request.getParameter("pseq")));
			rvo.setId(request.getParameter("loginid"));
			java.sql.Date bDate = java.sql.Date.valueOf(request.getParameter("from"));
			java.sql.Date tDate = java.sql.Date.valueOf(request.getParameter("to"));
			rvo.setBorrow(bDate);
			rvo.setTurn(tDate);
			rvo.setLocationname(request.getParameter("location"));
			rvo.setPrice(Integer.parseInt(request.getParameter("price")));					    
			
			ms.rentWrite(rvo);
		}
		return url;
	}
	
	@RequestMapping(value="cart_insert")
	public String cart_insert(Model model, HttpServletRequest request) {						
		String url = "redirect:/rent_cart_list";
		HttpSession session = request.getSession();
		MemberVo id = (MemberVo)session.getAttribute("loginUser");		
		if( id == null) { url = "redirect:/login_form"; }
		else {			
			RentcartVo rcvo = new RentcartVo();
			rcvo.setId(request.getParameter("loginid"));		
			rcvo.setRnum(Integer.parseInt(request.getParameter("pseq")));
			rcvo.setPrice(Integer.parseInt(request.getParameter("price")));			
			java.sql.Date bDate = java.sql.Date.valueOf(request.getParameter("from"));
			java.sql.Date tDate = java.sql.Date.valueOf(request.getParameter("to"));			
						
			rcvo.setBorrow(bDate);
			rcvo.setTurn(tDate);				    		  
			ms.insertRentCart(rcvo);
		}
		return url;	
	}
	
	@RequestMapping(value="rent_detail")
	public String rent_detail(Model model, HttpServletRequest request) {						
		String url="mypage/RentDetail";
		String rseq = request.getParameter("rseq");
		/*ProductVo pvo2= new ProductVo();
		ProductDao pdao2 = ProductDao.getInstance();
		pvo2 = pdao2.addView(pseq);*/		
		RentVo rvo = ms.getRentDetail(rseq);
		model.addAttribute("rentVo", rvo);
		
		ProductVo pvo = new ProductVo();		
		pvo = ps.getProduct(rseq);
		model.addAttribute("productVo", pvo);				
		
		ArrayList<ProductVo> nlist = new ArrayList<ProductVo>();
		nlist = ps.listNewProduct();
		model.addAttribute("newProductList", nlist);
	
		return url;		
	}
	
	@RequestMapping(value="rent_cart_list")
	public String rent_cart_list(Model model, HttpServletRequest request) {						
		String url = "mypage/rentCartList";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
	    	url = "redirect:/login_form";
	    }else {			
			ArrayList<RentcartVo> list = new ArrayList<RentcartVo>();
			 Integer totalprice = 0;
			//ArrayList<ProductVo> list2 = new ArrayList<ProductVo>();				
	        ArrayList<Integer> cartnum = ms.selectNumRentCart(mvo.getId());
			/*
			 * // 현재 진행중인 주문(처리전)의 주문 번호를 리스트로 리턴받음 ArrayList<CartVo> orderList = new
			 * ArrayList<CartVo>();
			 */
	        ArrayList<RentcartVo> klist = new ArrayList<RentcartVo>();
	        for( int num : cartnum ) { 
	        	ProductVo pvo = ps.subListProduct(num);
	        	String name =pvo.getName();
	        	
	        	list = ms.listRentCart(mvo.getId(), num, name);
	        	//번호를 통해 상품의 내용 불러옴	        	
	        	RentcartVo rvo = new RentcartVo();	        	
	        	//불러온 상품 내용을 리스트에 담음
	        	
	        	for( RentcartVo k : list) {   	klist.add(k);}
	        	
				/*
				 * // 현재 주문 번호의 주문 리스트 얻어 옴 OrderVO ovo = orderListIng.get(0); // 리스트 중 첫번째를 따로
				 * 보관 ovo.setPname(ovo.getPname() + " 포함 " + orderListIng.size() + " 건"); // 따로
				 * 보관한 첫번째 주문의 상품명을 "ovo상품명 포함 x 건" 으로 수정 int totalPrice = 0; for (OrderVO ovo1
				 * : orderListIng) totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				 * ovo.setPrice2(totalPrice); // 따로 보관한 첫번째 주문의 가격을 총상품 가격으로 수정
				 * orderList.add(ovo);
				 */		
	        }
	       
	    	 for( RentcartVo i : klist ) {
	    	totalprice += i.getPrice()*i.getCount();
	    	}
	    	 model.addAttribute("rentCartList", klist);		
	    	 model.addAttribute("totalPrice", totalprice);		
			//request.setAttribute("productList", list2);			
	    }	
	
		return url;		
	}

}
