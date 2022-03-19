<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/admin.css' />"  rel="stylesheet"> 
<script type="text/javascript" src="<c:url value = '/resources/script/ADproduct.js' />" ></script>    

</head>
<body>
<div id="wrap1">
<!--헤더가 들어가는 곳 시작 -->
<header>
		<!--로고 들어가는 곳 시작--->
		<div id="logo">
				<a href="admin_member_list">
					<img src="<c:url value='/resources/images/logo2.png'/> " width="180" height="100">					
				</a>
		</div>	
		<!--로고 들어가는 곳 끝-->
		<nav id="catagory_menu1">
				<ul>
						<c:choose>
								<c:when test="${empty loginUser}">
										<li><a href="login_form">로그인</a></li>
										<li><a href="contract">회원가입</a></li>
								</c:when>
								<c:otherwise>
										<li style="color:#3468D9; font-weight:bold; font-size: 20px;">${loginUser.name}    (${loginUser.id})</li>										
       									<li><a href="logout">로그아웃</a></li>
       									<li><a href="admin_member_list">관리자 페이지</a></li>
								</c:otherwise>
						</c:choose>						
				</ul>
		</nav>		
		<!-- <nav id="top_menu">
		 		<ul>
			 			<li><a href="shop.do?command=category&kind=1">Heels</a></li>
			 			<li><a href="shop.do?command=category&kind=2">Boots</a></li>
			 			<li><a href="shop.do?command=category&kind=3">Sandals</a></li>
			 			<li><a href="shop.do?command=category&kind=4">Sneakers</a></li>
			 			<li><a href="shop.do?command=category&kind=5">On Sale</a></li>
			 	</ul>
		</nav> -->
</header>
</div>