<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    
<%@ include file="/resources/headerfooter/header.jsp" %>  

<%@ include file ="/resources/sub/member/sub_img.html" %>
<%@ include file ="/resources/sub/member/sub_menu.html" %>


<style>

.mc_area{margin:0 auto; margin-top:100px; border:0px solid black; }
.m_title{padding:30px 0; margin-bottom:30px; font-weight:bold; color:#000; font-size:250%; text-align:center;}
.del_frm1{ margin:0 auto;   /* border:1px solid gray;  */ width:400px;  text-align:left; padding-left:60px;}
.del_div{margin-top:30px;}
.del_legend{font-weight:bold; font-size:130%; margin-bottom:100px; text-align:center;}
.input{width: 330px; height: 35px;  font-size:120%; /* margin: 5px 0; */ margin-bottom:30px; padding:2px; 
 border: 1px solid #999;  background-color: #E8E8E8;  border-radius: 5px;}


.del_frm{ margin:0 auto; /* border:1px solid gray;  */ width:650px;  text-align:center;}
.del_text{font-weight:bold; font-size:100%;}
.submit_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px; border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
 .cancel_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px;  border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
</style>




<article class="mc_area">
<p class="m_title">회원가입<p>


<form class="del_frm1" id="join" action="join" method="post" name="formm">

		<div class="del_div"></div>
		<label class="del_legend">기본 정보</label><br>
		<label>User ID</label><br>
		<input class="input"  type="text" name="id" size="12" style="width:200px;">
		<input type="hidden" name="reid">
		<input type="button" value="중복 체크" class="dup" onClick="idcheck();"><br>
		
		<label>Password</label><br>
		<input class="input"  type="password" name="pw"><br>
		
		<label>Retype Password</label><br>
		<input class="input"  type="password" name="pwCheck"><br>
		
		<label>Name</label><br>
		<input class="input"  type="text"  name="name"><br>

		
		 <label>E-mail</label><br>
		<input class="input"  type="text"  name="email"><br>

	
		<div class="del_div"></div>
		<label class="del_legend">추가 정보</label><br>
		
		<label>Zip Code</label><br>
		<input class="input"  type="text" name="zipcode" size="10" maxlength="6"><br>
		
		<label>Address</label><br>
		<input class="input"  type="text" name="addr1" size="50"><br>
		<label>&nbsp;</label><br>
		<input class="input"  type="text" name="addr2" size="25"><br>
		
		<label>Phone Number</label><br>
		<input class="input"  type="text" name="phone" placeholder="전화번호 입력"><br>		
		
		<label>Birthday</label><br>
		<input class="input"  type="text" name="year" placeholder="연도" size="5" maxlength="4">
		<input class="input"  type="text" name="month" placeholder="월"  size="5" maxlength="2">
		<input class="input"  type="text" name="day" placeholder="일"  size="5" maxlength="2"><br>
		
		<label>Gender</label><br>
		<input  type="radio" name="gender"  value="M"> Male &nbsp; &nbsp; &nbsp;
		<input  type="radio" name="gender"  checked value="F"> Female <br>				
		
</form>			

	
<form class="del_frm">
	<div id="buttons" style="margin-top:30px; ">
			<input type="button" value="회원가입" class="submit_a" onclick="go_save()">  
			<input type="reset" value="취소" class="cancel_a" onclick="location.href='/market/'">
	</div>
</form>

</article>


<%@ include file="/resources/headerfooter/footer.jsp" %>  
