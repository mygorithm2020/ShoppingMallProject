<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/ADheader.jsp" %>  
<%@ include file ="/resources/sub/admin/sub_img.html" %>
<%@ include file ="/resources/sub/admin/sub_menu.jsp" %>

<article>
<h1>상품리스트</h1>
<form name="frm" method="post">
<br>
<table>
	<tr >
		<td width="642" >
			상품명	<input type="text" name="key" value="${key}">
			<input class="btn" type="button" name="btn_search" value="검색" onClick="go_search();">
			<!-- <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total();"> -->
			<!-- <input class="btn" type="button" name="btn_write" value="상품등록" onClick="go_wrt();"> -->
			<input type="hidden" name="all_view" value="y">
		</td>
	</tr>
</table>
<br>
<table id="productList">
	<tr><th>번호</th><th>상품명</th><th>대여 가격</th><th>대여 장소</th><th>등록일</th><th>카테고리</th><th>분류</th></tr>
	<c:choose>
    	<c:when test="${productListSize<=0}">
    		<tr>
      			<td width="100%" colspan="7" align="center" height="23">등록된 상품이 없습니다.</td>      
    		</tr>
    	</c:when>
    	<c:otherwise>
		    <c:forEach items="${productList}" var="productVO">
		   		<tr>
					<td height="23" align="center" >${productVO.num}</td>
					<td >
						<a href="#" onClick="go_detail('${productVO.num}')">${productVO.name}</a>
					</td>
					<td><fmt:formatNumber value="${productVO.price}"/></td>
					<td>${productVO.locationname}</td>
		      		<td><fmt:formatDate value="${productVO.indate}"/></td>
		      		<td>
		      			<c:choose>
		      				<c:when test='${productVO.category==1}'>컴퓨터</c:when>
		      				<c:when test='${productVO.category==2}'>카메라</c:when>
		      				<c:when test='${productVO.category==3}'>악기</c:when>
		      				<c:when test='${productVO.category==4}'>스포츠/레저</c:when>
		      				<c:when test='${productVO.category==5}'>도서</c:when>
		      				<c:when test='${productVO.category==6}'>출산/육아</c:when>
		      				<c:when test='${productVO.category==7}'>의류잡화</c:when>
		      				<c:otherwise>게임용품</c:otherwise> 
						</c:choose>
					</td>
					<td>
		      			<c:choose>
		      				<c:when test='${productVO.classify=="1"}'>대여</c:when>		      				
		      				<c:otherwise>판매</c:otherwise> 
						</c:choose>
					</td>
				</tr>
		    </c:forEach> 
    	</c:otherwise>
	</c:choose>
</table>
</form>
<jsp:include page="/resources/paging/paging.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
</article>
<%@ include file="/resources/headerfooter/ADfooter.jsp" %>  