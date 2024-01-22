package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dao.ProductDao;
import com.ezenmarket.dto.CartVo;
import com.ezenmarket.dto.MemberVo;
import com.ezenmarket.dto.ProductVo;
import com.ezenmarket.dto.RentVo;
import com.ezenmarket.dto.RentcartVo;

public class RentCartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/rentCartList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo == null) {
			url = "market.do?command=login_form";
	    }else {
			CartDao cdao = CartDao.getInstance();
			ProductDao pdao = ProductDao.getInstance();
			ArrayList<RentcartVo> list = new ArrayList<RentcartVo>();
			 Integer totalprice = 0;
			//ArrayList<ProductVo> list2 = new ArrayList<ProductVo>();	
			
	        ArrayList<Integer> cartnum = cdao.selectNumRentCart(mvo.getId());
			/*
			 * // 현재 진행중인 주문(처리전)의 주문 번호를 리스트로 리턴받음 ArrayList<CartVo> orderList = new
			 * ArrayList<CartVo>();
			 */
	        ArrayList<RentcartVo> klist = new ArrayList<RentcartVo>();
	        for( int num : cartnum ) { 
	        	ProductVo pvo = pdao.subListProduct(num);
	        	String name =pvo.getName();
	        	
	        	list = cdao.listRentCart(mvo.getId(), num, name);
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
	    	 request.setAttribute("rentCartList", klist);		
	    	 request.setAttribute("totalPrice", totalprice);		
			//request.setAttribute("productList", list2);			
	    }
	    request.getRequestDispatcher(url).forward(request, response);
		
	}

}
