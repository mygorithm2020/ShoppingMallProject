<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/qna/sub_menu.jsp" %>
<article>
<h2> 1:1 고객 게시판 </h2>
<form name="formm" method="post" action="qna_update_form?num=${qnaVO.num }" >
<table id="cartList1">		
		<tr><th>제목</th>	<td>${qnaVO.title}</td></tr>
		<tr><th>등록일</th><td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td></tr>
		<tr><th>질문내용</th><td>${qnaVO.content}</td></tr>
		<tr><th>답변 내용</th><td>${qnaVO.reply}</tr>
</table>
<div class="clear2"></div>
<div id="buttons" style="float:right">
<input type="button"  value="목록보기"     class="submit" onclick="location.href='qna_list'">
<c:choose>
		<c:when test="${loginUser.id == qnaVO.id}">
			<input type="submit"  value="수정하기"  class="submit" >
			<input type="button"  value="삭제하기"  class="submit"  onclick="location.href='qna_delete?num=${qnaVO.num }'">
		</c:when>								
</c:choose>
</div>
</form>
</article>
</div>
		

<%@ include file="/resources/headerfooter/footer.jsp" %>   