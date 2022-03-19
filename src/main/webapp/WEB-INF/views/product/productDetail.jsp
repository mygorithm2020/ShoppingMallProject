<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  
<%@ include file ="/resources/sub/mypage/sub_img.html" %>

<article>

<div id="detaFrame">


		<form  method="post" name="frm">
		
		<div id="detail">
		<h3>제품상세</h3>
				<fieldset>
						<legend></legend>
						<span style="float: left;">						
								<img src="<c:url value='/resources/images/product/${productVo.img}'/>" style="border-radius:20px; " width="500" height="350"/>
	           			</span>
	           			<p> </p>  
	           			<p style="font-size:200%"> ${productVo.title} </p>  
	           			<p>${productVo.name}</p>
	           			<input  type="hidden" name="pname"	 value="${productVo.name}">
	           			
	           			<p>${productVo.id}</p>
	           			<input  type="hidden" name="id"	 value="${productVo.id}">
	           			<input  type="hidden" name="loginid"	 value="${loginUser.id}">
						<p>1일 대여가격: <fmt:formatNumber value="${productVo.price}" type="currency"></fmt:formatNumber>원</p>  
						<input  type="hidden" name="price"value="${productVo.price}">
						
	          			
	          			<label> 제품설명 : </label><label>${productVo.content}</label>	          			
	          			<input  type="hidden" name="pseq"	 value="${productVo.num}">
	          			<input  type="hidden" name="location"	 value="${productVo.locationname}">
				</fieldset> 
				</div>
				<div id="detaButtons">
						
						<label style="font-size:130%;">&nbsp;대여할 수량을 선택해주세요.  </label><br>&nbsp;<input  style="font-size:140%;" type="text" name="quantity" size="2" value="1" ><br>
						<label for="from" style="font-size:130%;">&nbsp;대여할 날짜를 정해주세요.</label><br>&nbsp;<input style="font-size:140%;" type="text" id="from" name="from"  data-date-format='yy-mm-dd'><br>
						<label for="to" style="font-size:130%;">&nbsp;반납할 날짜를 정해주세요.</label><br>&nbsp;<input style="font-size:140%;" type="text" id="to" name="to"  data-date-format='yy-mm-dd'>
						<label for="to" style="font-size:130%;">&nbsp;대여지점</label><br><label>&nbsp;스타벅스 ${productVo.locationname}점</label><br>
				        <input type="button" value="장바구니에 담기" class="submit"    onclick="product_go_cart()" style="background-color: #B1C7DB;"><br> 
				        <input type="button" value="대여하기" class="submit"    onclick="product_go_rent()" style="background-color: #B1C7DB;"><br> 
				        <input type="reset"  value="취소" 	class="cancel" style="background-color: #B1C7DB;"><br>
				        <c:choose>
				        	<c:when test="${loginUser.id==productVo.id}">
							  <input type="button" value="제품 정보 수정" class="submit"  onclick="product_go_mod_form();">
							  <input type="button" value="제품 등록  삭제" class="submit"  onclick="product_go_delete();">							  
							</c:when>
				        </c:choose>
        		</div>
		</form>
		<div class="clear" style="border-bottom:1px solid black"></div>
		<div class="clear"><h3>&nbsp;새롭게 등록된 제품 </h3></div>
		
		<div id="newProduct" style="line-height:1.2em;">	     
			<c:forEach items="${newProductList}"  var="productVo">
        		<div id="item">
						<a href="product_detail?pseq=${productVo.num}" style="color:black">						
            			<img src="<c:url value='/resources/images/product/${productVo.img}'/>" width="250" height="240"/><br>
            			 ${productVo.title}  <br> ${productVo.name}<br> 1일 대여 가격:
            			<fmt:formatNumber value="${productVo.price}" type="currency"></fmt:formatNumber>
             			</a>    
        		</div>
      		</c:forEach>             		
      
</div>
</div>
</article>

<%@ include file="/resources/headerfooter/footer.jsp" %>  