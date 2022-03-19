<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/qna/sub_menu.jsp" %>
<article>
<h2> 1:1 문의 수정하기 </h2>
  
<form name="formm" method="post"	action="qna_update?num=${qnaUpdate.num}" id="forr">

<fieldset> 
		<legend>문의 내용 수정</legend>  
		 <%-- <label><a name="num">${qnaUpdate.num}</a></label> --%>
        <label>Title</label><input type="text" name="title"  size="40"  value="${qnaUpdate.title }"><br>
		<label>Content</label><textarea rows="12" cols="70" name="content" style="margin-left: 20px; font-size: 100%">${qnaUpdate.content }</textarea><br>
</fieldset>

<div class="clear2"></div>
<div id="buttons" style="float:right">
<input type="submit"  value="글 수정하기"     class="submit"> 
<input type="button"  value="등록 취소"  class="submit"  
						onclick="location.href='qna_list'">
</div>
</form>
</article>
</div>

<%@ include file="/resources/headerfooter/footer.jsp" %>    