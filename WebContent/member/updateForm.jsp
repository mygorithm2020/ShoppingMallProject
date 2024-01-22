<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file ="sub_img.html" %>
<%@ include file ="sub_menu.html" %>


<style>
.mc_area{margin:0 auto; margin-top:100px; border:0px solid black; }
.m_title{padding:30px 0; margin-bottom:30px; font-weight:bold; color:#000; font-size:250%; text-align:center;}
.del_frm1{ margin:0 auto; /*  border:1px solid gray; */  width:400px;  text-align:left; padding-left:60px;}
.del_div{margin-top:30px;}
.del_legend{font-weight:bold; font-size:130%; margin-bottom:100px; text-align:center;}
.input{width: 330px; height: 35px;  font-size:120%; /* margin: 5px 0; */ margin-bottom:30px; padding:2px; 
 border: 1px solid #999;  background-color: #E8E8E8;  border-radius: 5px;}


.del_frm{ margin:0 auto; /*  border:1px solid gray; */  width:650px;  text-align:center;}
.del_text{font-weight:bold; font-size:100%;}
.submit_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px; border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
 .cancel_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px;  border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
</style>


<article class="mc_area">
<p class="m_title">내정보관리<p>

<form class="del_frm1" id="join" action="market.do?command=join" method="post" name="formm">

		<div class="del_div"></div>
		<label class="del_legend">기본 정보</label><br>
		<label>User ID</label><br>
		<input class="input" type="text" name="id" value="${member.id}" readonly ><br>
		<label>Password</label><br>
		<input class="input" type="password"  name="pw"><br> 
		<label>Retype Password</label><br>
		<input  class="input" type="password" name="pwCheck"><br>
		
		<label>Name</label><br>
		<input class="input" type="text"  name="name"  value="${member.name}"  readonly ><br>
		
		 <label>E-mail</label><br>
		<input class="input" type="text"  name="email"   value="${member.email}"><br>
		
		<div class="del_div"></div>
		<label class="del_legend">추가 정보</label><br>
		<label>Zip Code</label><br>
		<input class="input" type="text" name="zipcode" size="10" value="${member.zipcode}"><br>
		
		<label>Address</label><br>
		<input class="input" type="text" name="addr1" size="40" value="${addr1}"><br>
		<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input class="input" type="text" name="addr2" size="25" value="${addr2}"><br>
		
		<label>Phone Number</label><br>
		<input class="input" type="text" name="phone"  value="${member.phone}"><br>		
		
		<label>Gender</label><br>
	    <input  class="input" type="text" name="gender" value="${member.gender}"  readonly><br>		
				
		<label>Birthday</label><br>
	    <input  class="input" type="text" name="birth" value="${member.birth}"  readonly><br>
</form>	
<form class="del_frm">
	<div id="buttons" style="margin-top:30px; ">
			<input type="button" value="정보수정" class="submit_a" onclick="go_update()">  
			<input type="reset" value="취소" class="cancel_a" onclick="location.href='market.do?command=index'"><br><br>
			<label class="del_text">이젠마켓을 더 이상 이용하지 않으신다면</label>
			<input type="button" value="회원탈퇴" class="submit_a" onclick="go_delete()">
	</div>
</form>

</article>

<%@ include file="../footer.jsp" %>
