<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/qna/sub_img.html" %>
<div id="front">
<h2>검색결과</h2>
<div id="bestProduct">
		<c:forEach items="${productSearchList}"  var="productVo">
        		<div id="item">
						<a href="product_detail?pseq=${productVo.num}" style="color:black">
            			<img src="<c:url value='/resources/images/product/${productVo.img}'/>"  width="250" height="240"/><br>
            			 ${productVo.title}   <br> ${productVo.name}<br>1일 대여 가격:
            			<fmt:formatNumber value="${productVo.price}" type="currency"></fmt:formatNumber>
             			</a>    
        		</div>
      </c:forEach>      
      	
</div> 
<div class="clear"></div>
</div>
<%@ include file="/resources/headerfooter/footer.jsp" %>  