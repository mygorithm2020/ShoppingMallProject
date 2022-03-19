<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/shoping.css' />"  rel="stylesheet"> 
<script type="text/javascript" src="<c:url value = '/resources/script/member.js' />" ></script>    
<script type="text/javascript" src="<c:url value = '/resources/script/mypage.js' />" ></script>
<script type="text/javascript" src="<c:url value = '/resources/script/product.js' />" ></script>

<link rel="stylesheet" href="<c:url value='//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'/>">
<script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/> "></script>
<script src="<c:url value='https://code.jquery.com/ui/1.12.1/jquery-ui.min.js'/> "></script>
<script src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.9.2/i18n/jquery.ui.datepicker-ko.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js'/> "></script>
<script src="<c:url value='/resources/script/calendar.js'/> "></script>
</head>
<body>
<div id="wrap1">
<!--헤더가 들어가는 곳 시작 -->
<header>
		<!--로고 들어가는 곳 시작--->
		<div id="logo">
				<a href="/market/">
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
       									<li><a href="write_product_form">제품 대여 등록</a></li>
								</c:otherwise>
						</c:choose>
						<li><a href="mypage?id=${loginUser.id}">마이페이지</a></li>	      					
       					<li ><a href="qna_list" 	style="border:0px;">Q&amp;A</a></li>
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
