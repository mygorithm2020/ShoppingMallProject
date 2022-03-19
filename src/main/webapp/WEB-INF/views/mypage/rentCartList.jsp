<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/mypage/sub_menu.jsp" %>
<article>
<h2> 장바구니 </h2>
<form name="formm" method="post">
		<c:choose>
				<c:when test="${rentCartList.size()==0}">
						<h3 style="color: red;text-align: center;">장바구니가 비었습니다.</h3> 
				</c:when>
				<c:otherwise>						
						<table id="cartList1">
								<tr><th>물품 명</th><th>수 량</th><th>가 격</th><th>대여 일</th><th>반납 일</th><th>합 계</th><th>선택</th></tr>
								<c:forEach items="${rentCartList}" var="rentCartVo">
										<tr>
												<td><a href="product_detail?pseq=${rentCartVo.rnum}">
												<h3 class="hhh"> ${rentCartVo.name} </h3></a></td>
												<td> ${rentCartVo.count} </td>
          										<td> 
												<fmt:formatNumber value="${rentCartVo.price}" type="currency"/> 
          										</td>      
          										<td><fmt:formatDate value="${rentCartVo.borrow}" type="date" /></td> 
          										<td><fmt:formatDate value="${rentCartVo.turn}" type="date" /></td>         
          										<td> 
												<fmt:formatNumber value="${rentCartVo.price*rentCartVo.count}" type="currency"/> 
          										</td>   
          										<td><input type="checkbox" name="num" value= "${rentCartVo.num}"></td>          										
										</tr>
								</c:forEach>
								<tr>        
          								<th colspan="2"> 총 액 </th>		
          								<th colspan="2"><fmt:formatNumber value="${totalPrice}" type="currency" /><br>
          								</th>           								                
        						</tr> 
						</table>
				</c:otherwise>
		</c:choose>
		<div class="clear2"></div>
 		<div id="buttons1" style="float: right">
 				<input type="button" value="삭제하기"  class="submit" onclick="go_cart_delete();"> 		
			    <input type="button" value="쇼핑 계속하기" class="cancel" 
			    onclick="location.href='/market/'">    
		</div>
</form>
</article>
</div>

<%@ include file="/resources/headerfooter/footer.jsp" %>  