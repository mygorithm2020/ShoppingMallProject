<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">  
<nav id="sub_menu1">
    <ul>	  		
			<li><a href="mypage">등록 내역</a></li>			<!-- 하나로 -->
			<!-- <li><a href="buy_list">구매 내역</a></li>		두개로 -->
			<li><a href="rent_list">대여 내역</a></li>		<!-- 두개로 -->			
			<!-- <li><a href="buy_cart_list">구매 장바구니</a></li>					두개로 -->
			<li><a href="rent_cart_list">대여 장바구니</a></li>					<!-- 두개로 -->
			<li><a href="Member_Update_Form?id=${loginUser.id}">회원정보수정</a></li>
			<li><a href="Member_Delete_Form">회원탈퇴</a></li>
    </ul>
</nav>