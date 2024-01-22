package com.ezenmarket.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenmarket.dao.CartDao;
import com.ezenmarket.dao.UploadDao;
import com.ezenmarket.dto.MemberVo;


public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/uploadList.jsp";
		HttpSession session = request.getSession();
	    MemberVo mvo = (MemberVo) session.getAttribute("loginUser");
	    if(mvo==null) {
	    	url = "market.do?command=login_form";
	    }else {
	    	UploadDao udao = UploadDao.getInstance();
	        ArrayList<Integer> proList	= udao.selectnumUpload(mvo.getId());
	        // 현재 등록된 등록 물품의 번호를 리스트로 리턴받음
	      //  ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
	      //  for( int oseq : oseqList ) { // 리턴 받은 주문 번호 리스트에서 주문번호를 oseq 변수에 하나씩 넣고 반복 실행
	        //	ArrayList<OrderVO> orderListIng = cdao.listOrderById(mvo.getId(), oseq);
	        	// 현재 주문 번호의 주문 리스트 얻어 옴
	        	//OrderVO ovo = orderListIng.get(0);
	        	// 리스트 중 첫번째를 따로 보관
	        	//ovo.setPname(ovo.getPname() + " 포함 " + orderListIng.size() + " 건");
	        	// 따로 보관한 첫번째 주문의 상품명을   "ovo상품명 포함 x 건" 으로 수정
	        	int totalPrice = 0;
	          //  for (OrderVO ovo1 : orderListIng)  totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
	           // ovo.setPrice2(totalPrice);
	            // 따로 보관한 첫번째 주문의 가격을 총상품 가격으로 수정
	           // orderList.add(ovo);
	        }
	    //    request.setAttribute("title", "진행 중인 주문 내역");
	    //    request.setAttribute("orderList", orderList);
	    }
	   // request.getRequestDispatcher(url).forward(request, response);
		
	}


