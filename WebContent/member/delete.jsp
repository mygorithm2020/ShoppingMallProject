<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ include file ="sub_img.html" %>
<%@ include file ="sub_menu.html" %>

<style>

.mc_area{margin:0 auto; margin-top:100px; border:0px solid black; }
.m_title{padding:30px 0; margin-bottom:30px; font-weight:bold; color:#000; font-size:250%; text-align:center;}
.del_legend{font-size:110%; margin-bottom:100px; text-align:center;}
.del_frm1{ margin:0 auto;   /* border:1px solid gray;  */ width:400px;  text-align:left; padding-left:60px;}
.del_le{font-size:120%; font-weight:bold; text-align:center; color:#BF023B;}
.submit_a{height: 40px; width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px; border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
 .cancel_a{height: 40px;  width: 185px; border-radius: 5px; box-shadow: 3px 3px 2px #ccc; 
 margin: 5px 20px;  border: 1px solid #999; background-color: #B1C7DB; font-size: 18px;
 font-weight: bold; margin: 0 0 0 20px;}
 .del_frm{ margin:0 auto; /* border:1px solid gray;  */ width:650px;  text-align:center;}
 
</style>



<article class="mc_area">
<p class="m_title">회원 탈퇴<p>

<form id="del_frm1" action="market.do?command=Member_Delete_Form" method="post" name="formm">

<fieldset>
<legend class="del_le">회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</legend>
<br><br>


<label class="del_legend">
① 사용하고 계신 [${loginUser.id}] 는 탈퇴할 경우 재사용 및 복구가 불가능합니다.<br><br>
② 탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.<br><br>
③ 삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.<br><br>
<input  type="hidden" name="loginid"	 value="${loginUser.id}">
</label>

</fieldset>

</form>

<form class="del_frm">
<div id="buttons" style="margin-top:30px; ">
	<input type="button" value="확인" class="submit_a" onclick="go_delete_last()">  
	<input type="reset" value="취소" class="cancel_a"  onclick="location.href='market.do?command=index'">
</div>
</form>



</article>

<%@ include file="../footer.jsp" %>

