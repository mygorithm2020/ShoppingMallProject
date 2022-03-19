<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/ADheader.jsp" %>  
<%@ include file ="/resources/sub/admin/sub_img.html" %>
<%@ include file ="/resources/sub/admin/sub_menu.jsp" %>
<script type="text/javascript">
function go_view(num){
	var theForm = document.frm;
    //theForm.num.value = num;
    theForm.action = "admin_qna_detail&num=" + num;
    theForm.submit();
}
</script>
<article>
<h1>Q&amp;A 게시글 리스트</h1>  
<form name="frm" method="post">
<!-- <input type="hidden" name="num"> -->
<br>
<table id="orderList">
	<tr>
    	<th>번호(답변여부)</th> <th>제목</th> <th>작성자</th> <th>작성일</th>    
  	</tr>
  	<c:forEach items="${qnaList}" var="qnaVO">  
    	<tr>
      		<td>${qnaVO.num}  
      			<c:choose>          
        			<c:when test='${qnaVO.result=="0"}'>(미처리)</c:when>
        			<c:otherwise>(답변처리완료)</c:otherwise>
      			</c:choose>      
      		</td>
      		<td> <a href="qna_view&num=${qnaVO.num}">${qnaVO.title}</a></td>
      		<td> ${qnaVO.id} </td>
      		<td> <fmt:formatDate value="${qnaVO.indate}"/></td>
      	</tr>
    </c:forEach>
</table>
<jsp:include page="/resources/paging/paging_qna.jsp">
<jsp:param value="${paging.page}" name="page"/>
<jsp:param value="${paging.beginPage}" name="beginPage"/>
<jsp:param value="${paging.endPage}" name="endPage"/>
<jsp:param value="${paging.prev}" name="prev"/>
<jsp:param value="${paging.next}" name="next"/>
</jsp:include>
</form>
</article>
<%@ include file="/resources/headerfooter/ADfooter.jsp" %>  