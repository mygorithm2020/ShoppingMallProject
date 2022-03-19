<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2" style="margin-left: 180px;">
<article>
<h2> 공지사항 </h2>
<form name="formm" method="post">
<table id="cartList1">
		<tr>	<th>번호</th> <th>제목</th> <th>등록일</th></tr>
   		<c:forEach items="${notice}"  var="qnaVO">
			<tr>  
        		<td> ${qnaVO.nnum} </td>    
       			<td><a href="notice_view?num=${qnaVO.nnum}">${qnaVO.title}</td>      
        		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>        		
      		</tr>
      	</c:forEach>
</table>
<div class="clear2"></div>
<!-- <div id="buttons1" style="float:right"> <input type="button"  value="1:1 질문하기"  class="submit" 
onClick="location.href='qna_write_form'"> 
<input type="button"    value="내 질문목록 보기"  class="cancel" onclick="location.href='index'">  
</div> -->
</form>

</article>



</div>
<%@ include file="/resources/headerfooter/footer.jsp" %>  