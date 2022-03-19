<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/mypage/sub_menu.jsp" %>
<article>
<h2>등록물품 리스트</h2>
<form name="formm" method="post">
<c:choose>
      <c:when test="${productList.size()==0}">
						<h3 style="color: red;text-align: center;">등록 내역이 없습니다.</h3> 
	  </c:when>
	  <c:otherwise>
<table id="cartList1">
		<tr>
				<th>등록 날짜</th><th>등록 번호</th><th>상품명</th><th>금액</th><th>수량</th><th>등록 상세</th>				  
      </tr>      
      <c:forEach items="${productList}"  var="productVO">
		      <tr>  
			        <td><fmt:formatDate value="${productVO.indate}" type="date"/></td>
			        <td>${productVO.num} </td>    
			        <td><a href="product_detail?pseq=${productVO.num}"><h3 class="hhh">${productVO.name}</h3> </a></td>
			        <td><fmt:formatNumber value="${productVO.price}" type="currency"/> </td>
			        <td>${productVO.count} </td>
			        <%-- <td><a href="product_detail&oseq=${productVO.num}">조회</a></td> --%>
					<td>
							<c:if test="${productVO.classify=='1'}">대여</c:if>
							<c:if test="${productVO.classify=='2'}">판매</c:if>
					</td>
		      </tr>
      </c:forEach>
      </c:otherwise>    
      </c:choose>
</table>      
      
      <!-- <div id="buttons" style="float: right">
       <input type="button"    value="쇼핑 계속하기"  class="cancel"  
       onclick="location.href='index'"> 
      </div> -->

</form>
</article>
</div>
<%@ include file="/resources/headerfooter/footer.jsp" %>  