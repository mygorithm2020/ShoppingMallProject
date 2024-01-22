package com.ezenmarket.controller;

import com.ezenmarket.admin.controller.action.AdminAction;
import com.ezenmarket.admin.controller.action.AdminMemberListAction;
import com.ezenmarket.admin.controller.action.AdminOrderListAction;
import com.ezenmarket.admin.controller.action.AdminProductListAction;
import com.ezenmarket.admin.controller.action.AdminQnaListAction;
import com.ezenmarket.controller.action.Action;
import com.ezenmarket.controller.action.CartInsertAction;
import com.ezenmarket.controller.action.ContractAction;
import com.ezenmarket.controller.action.IdCheckFormAction;
import com.ezenmarket.controller.action.IndexAction;
import com.ezenmarket.controller.action.JoinAction;
import com.ezenmarket.controller.action.JoinFormAction;
import com.ezenmarket.controller.action.LoginAction;
import com.ezenmarket.controller.action.LoginFormAction;
import com.ezenmarket.controller.action.LogoutAction;
import com.ezenmarket.controller.action.MemberDeleteAction;
import com.ezenmarket.controller.action.MemberDeleteFormAction;
import com.ezenmarket.controller.action.MemberUpdateAction;
import com.ezenmarket.controller.action.MemberUpdateFormAction;
import com.ezenmarket.controller.action.ProductDeleteAction;
import com.ezenmarket.controller.action.ProductDetail;
import com.ezenmarket.controller.action.ProductSearchList;
import com.ezenmarket.controller.action.ProductUpdateAction;
import com.ezenmarket.controller.action.ProductUpdateFormAction;
import com.ezenmarket.controller.action.QnaDeleteAction;
import com.ezenmarket.controller.action.QnaListAction;
import com.ezenmarket.controller.action.QnaMyListAction;
import com.ezenmarket.controller.action.QnaUpdateAction;
import com.ezenmarket.controller.action.QnaUpdateFormAction;
import com.ezenmarket.controller.action.QnaViewAction;
import com.ezenmarket.controller.action.QnaWriteAction;
import com.ezenmarket.controller.action.QnaWriteFormAction;
import com.ezenmarket.controller.action.RentCartDeleteAction;
import com.ezenmarket.controller.action.RentCartListAction;
import com.ezenmarket.controller.action.RentDeleteAction;
import com.ezenmarket.controller.action.RentDetailAction;
import com.ezenmarket.controller.action.RentListAction;
import com.ezenmarket.controller.action.RentWriteAction;
import com.ezenmarket.controller.action.UploadListAction;
import com.ezenmarket.controller.action.WriteProductAction;
import com.ezenmarket.controller.action.WriteProductForm;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() { return instance; }
	
	public Action getAction(String command) {
		Action ac = null;
		System.out.println(command);
		if(command.equals("index")) ac = new IndexAction();
		else if(command.equals("product_search_list")) ac = new ProductSearchList();
		else if(command.equals("product_detail")) ac = new ProductDetail();
		else if(command.equals("login_form")) ac = new LoginFormAction();   // header
		else if(command.equals("login")) ac = new LoginAction();   // login.jsp
		else if(command.equals("contract")) ac = new ContractAction();   // header
		else if(command.equals("join_form")) ac = new JoinFormAction();   // member.js(contract.jsp)
		else if(command.equals("join")) ac = new JoinAction(); // member.js(join.jsp) 
		else if(command.equals("Id_Check_Form")) ac = new IdCheckFormAction(); // idCheck.jsp 
		else if(command.equals("logout")) ac = new LogoutAction();  // header		
		else if(command.equals("Member_Update_Form")) ac = new MemberUpdateFormAction(); // header 
		else 	if(command.equals("Member_Update")) ac = new MemberUpdateAction(); // member.js 
		else if(command.equals("Member_Delete_Form")) ac = new MemberDeleteFormAction(); // member.js 
		else if(command.equals("Member_Delete")) ac = new MemberDeleteAction(); // delete.jsp
		
		
		
							//1
		else if(command.equals("logout")) ac = new LogoutAction();		//			로그아웃
		else if(command.equals("upload_list")) ac = new UploadListAction();		//1 등록 내역 연결
		else if(command.equals("rent_list")) ac = new RentListAction();			//1 대여 내역		
		else if(command.equals("rent_cart_list")) ac = new RentCartListAction();		  //1 대여 장바구니
		else if(command.equals("update_inform")) ac = new UploadListAction();			//1  회원정보 수정
		else if(command.equals("delete_inform")) ac = new UploadListAction();			//1  회원 탈퇴
		else if(command.equals("mypage")) ac = new UploadListAction();			//1  회원 탈퇴
		else if(command.equals("qna_list")) ac = new QnaListAction();		//1 큐엔에이 리스트
		else if(command.equals("qna_view")) ac = new QnaViewAction();			// 1 큐엔에이 내용 보기
		else if(command.equals("qna_write_form")) ac = new QnaWriteFormAction();   	//큐엔에이 쓰기 창
		else if(command.equals("qna_write")) ac = new QnaWriteAction();  // 큐엔에이 등록
		else if(command.equals("qna_my_list")) ac = new QnaMyListAction();			//내 큐엔에이 리스트
		else if(command.equals("qna_update_form")) ac = new QnaUpdateFormAction();		// 큐엔에이 수정
		else if(command.equals("qna_update")) ac = new QnaUpdateAction();		//큐엔에이 수정
		//추가한 내용
		else if(command.equals("qna_delete")) ac = new QnaDeleteAction();
		else if(command.equals("rent_cart_delete")) ac = new RentCartDeleteAction();	
		//추가한 내용2
		else if(command.equals("rent_delete")) ac = new RentDeleteAction();
		
		//admin 추가
		else if(command.equals("admin")) ac= new AdminAction();
		else if(command.equals("admin_product_list")) ac = new AdminProductListAction();		
		else if(command.equals("admin_order_list")) ac = new AdminOrderListAction();
		else if(command.equals("admin_member_list")) ac = new AdminMemberListAction();
		else if(command.equals("admin_qna_list")) ac = new AdminQnaListAction();
				
		else if(command.equals("Member_Update_Form")) ac = new MemberUpdateFormAction();
		
		else if(command.equals("write_product_form")) ac = new WriteProductForm();
		else if(command.equals("write_product")) ac = new WriteProductAction();
		else if(command.equals("product_update_form")) ac = new ProductUpdateFormAction();
		else if(command.equals("product_update")) ac = new ProductUpdateAction();
		else if(command.equals("product_delete")) ac = new ProductDeleteAction();
		else if(command.equals("cart_insert")) ac = new CartInsertAction();
		else if(command.equals("rent_write")) ac = new RentWriteAction();
		else if(command.equals("rent_detail")) ac = new RentDetailAction();
		return ac;
	}
}
