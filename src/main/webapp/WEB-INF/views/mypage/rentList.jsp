<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>


<div id="wrap2">
<%@ include file ="/resources/sub/mypage/sub_menu.jsp" %>
<article>
<h2> 대여 내역 </h2>
<form name="formm" method="post">
		<c:choose>
				<c:when test="${rentList.size()==0}">
						<h3 style="color: red;text-align: center;">대여내역이 없습니다.</h3> 
				</c:when>
				<c:otherwise>						
						<table id="cartList1">
								<tr><th>대여 번호</th><th>대여 물품</th><th>대여 개수</th><th>가 격</th><th>대여 일</th><th>반납 일</th><th>대여 장소</th><th>합 계</th><th>선택</th></tr>
								<c:forEach items="${rentList}" var="rentVo">
										<tr>
												<td>${rentVo.num}</td>
												<td><a href="rent_detail?rseq=${rentVo.rnum}">
												<h3 class="hhh"> ${rentVo.name} </h3></a></td>
												<td> ${rentVo.count} </td>
          										<td> 
												<fmt:formatNumber value="${rentVo.price}" type="currency"/> 
          										</td>      
          										<td><fmt:formatDate value="${rentVo.borrow}" type="date" /></td>
          										<td><fmt:formatDate value="${rentVo.turn}" type="date" /></td> 
          										<td>${rentVo.locationname}</td>     
          										<td> 
												<fmt:formatNumber value="${rentVo.price*rentVo.count}" type="currency"/> 
          										</td>   
          										<td><input type="checkbox" name="num" value= "${rentVo.num}"></td>          										
										</tr>
								</c:forEach>
								<%-- <tr>        
          								<th colspan="2"> 총 액 </th>		
          								<th colspan="2"><fmt:formatNumber value="${totalPrice}" type="currency" /><br>
          								</th> 
          								                  
        						</tr>  --%>
						</table>
				</c:otherwise>
		</c:choose>
		<div class="clear2"></div>
 		<div id="buttons1" style="float: right">
 				<input type="button" value="삭제하기"  class="submit" onclick="go_rent_delete();">
			    <input type="button" value="쇼핑 계속하기" class="cancel" 
			    onclick="location.href='/market/'">    
			   <%--  <c:if test= "${rentList.size() != 0}">
			      		<input type="button" value="주문하기"  class="submit" onclick="go_rent_insert();">
			    </c:if> --%>
     	</div>
</form>
</article>
</div>
<%@ include file="/resources/headerfooter/footer.jsp" %>  