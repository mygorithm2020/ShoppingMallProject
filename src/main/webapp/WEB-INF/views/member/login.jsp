<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
    
<%@ include file="/resources/headerfooter/header.jsp" %>  

<%@ include file ="/resources/sub/member/sub_img.html" %>
<%@ include file ="/resources/sub/member/sub_menu.html" %>

<style>
.input{width: 330px; height: 35px;  font-size:120%; /* margin: 5px 0; */ margin-bottom:30px; padding:2px; 
 border: 1px solid #999;  background-color: #E8E8E8;  border-radius: 5px;}
.login_label{font-size:120%; font-weight:bold; float: left; margin-bottom:5px;}
.m_area{margin:0 auto; margin-top:100px; border:0px solid black; text-align:center;}
.login1{width:300px; margin:0 auto; padding:20px; margin-bottom:50px;  border:0; }
.m_title{padding:30px 0; margin-bottom:20px; font-weight:bold; color:#000; font-size:250%; text-align:center;}
.submit_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px; border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
/*  .cancel_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px;  border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;} */
</style>
<article class="m_area">

<p class="m_title">Login</p>

<form method="post"  action="login"  >
	<fieldset class="login1">
	<legend></legend>
	<label class="login_label">ID</label><br><input name="id" type="text" class="input"><br>
	<label class="login_label">Password</label><br><input name="pw" type="password" class="input" ><br>	
	</fieldset>
	<div id="buttons">
		<input type="submit" value="로그인" class="submit_a" onclick="customer_id()" >
		<input type="button"  value="회원가입"  onclick="location.href='contract'" class="submit_a">
		<input type="button"  value="아이디 비밀번호 찾기"  class="submit_a"  onclick="find_id()">
	</div>
</form> 
</article>


<%@ include file="/resources/headerfooter/footer.jsp" %>  