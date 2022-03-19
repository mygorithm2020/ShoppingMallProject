<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/qna/sub_menu.jsp" %>
<article>
<h2> 1:1 고객 게시판 </h2>
<form name="formm" method="post">
<table id="cartList1">
		<tr>	<th>번호</th> <th>제목</th> <th>등록일</th><th>답변 여부</th></tr>
   		<c:forEach items="${qnaList}"  var="qnaVO">
			<tr>  
        		<td> ${qnaVO.num} </td>    
       			<td><a href="qna_view?num=${qnaVO.num}">${qnaVO.title}</td>      
        		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
        		<td> 
				         <c:choose>
				           <c:when test="${qnaVO.result==0}"> 답변 예정 </c:when>
				           <c:when test="${qnaVO.result==1}"> 답변 완료 </c:when>
				         </c:choose>
        		</td>    
      		</tr>
      	</c:forEach>
</table>
<div class="clear2"></div>
<div id="buttons1" style="float:right"> <input type="button"  value="1:1 질문하기"  class="submit" 
onClick="location.href='qna_write_form'"> 
<!-- <input type="button"    value="내 질문목록 보기"  class="cancel" onclick="location.href='index'"> -->  
</div>
</form>

</article>



</div>
<%@ include file="/resources/headerfooter/footer.jsp" %>  