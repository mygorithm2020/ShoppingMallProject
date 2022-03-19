<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/header.jsp" %>  

<script type="text/javascript">
function go_search(){
	var theForm = document.frm
	if(theForm.product.value=="" ) { alert("검색 내용을 입력해 주세요"); return;}
	else{
	theForm.action =  "product_search_list";
	theForm.submit();
	}
	
}
</script>
</head>
<body>
<form name="frm" method="post">
<!--메인 이미지 들어가는 곳 시작 --->
<div id="main_img">

	<div id= "searchbox"><h3>편한 곳에서 제품을 빌려 써보세요</h3>
	 <input type="text" id="product" size="20" style="font-size:20px; float:left;" name="product">
	 <select id="gu" name="gu">
                <option value="">선택</option>
                <option>강동구 </option>
                <option>강남구</option>
                
            </select>
            <br>
	 <input type="button" value="검색" onclick="go_search()"><br>
	 </div>
	
   	<img src="<c:url value='/resources/images/main.jpg'/>" >    
</div>
<!--메인 이미지 들어가는 곳 끝--->

<div id="front">
<h3>&nbsp;인기상품</h3>
<div id="bestProduct">
		<c:forEach items="${bestProductList}"  var="productVo">
        		<div id="item">
						<a href="product_detail?pseq=${productVo.num}" style="color:black">
            			<img src="<c:url value='/resources/images/product/${productVo.img}'/> " width="250" height="240"/><br>
            			 ${productVo.title}   <br> ${productVo.name}<br>1일 대여 가격:
            			<fmt:formatNumber value="${productVo.price}" type="currency"></fmt:formatNumber>
             			</a>    
        		</div>
      </c:forEach>      
      	
</div> 
<div class="clear"></div>

<h3>&nbsp;새롭게 등록된 제품 </h3>     
<div id="newProduct">         
			<c:forEach items="${newProductList}"  var="productVo">
        		<div id="item">
						<a href="product_detail?pseq=${productVo.num}" style="color:black">
            			<img src="<c:url value='resources/images/product/${productVo.img}'/> " width="250" height="240"/><br>
            			 ${productVo.title}  <br> ${productVo.name}<br> 1일 대여 가격:
            			<fmt:formatNumber value="${productVo.price}" type="currency"></fmt:formatNumber>
             			</a>    
        		</div>
      </c:forEach>             		
      
</div>
<div class="clear"></div>
<h3>&nbsp;가까운 위치의 상품</h3>     
<div id="bestProduct">         
        
        		<div id="item" style="margin-left:55px; margin-right:55px; ">
					<img src="<c:url value='/resources/images/후기2.png'/> ">	
      			</div>
      			<div id="item" style="margin-left:50px; margin-right:50px; ">
				<img src="<c:url value='/resources/images/후기1.png'/> ">
        		</div>
        		<div id="item" style="margin-left:50px; margin-right:55px; ">
				<img src="<c:url value='/resources/images/후기3.png'/>">
        		</div>
        		
    	  
</div>


 
</div>
</form>
<%@ include file="/resources/headerfooter/footer.jsp" %>  