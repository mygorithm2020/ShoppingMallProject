<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/headerfooter/ADheader.jsp" %>  
<%@ include file ="/resources/sub/admin/sub_img.html" %>
<%@ include file ="/resources/sub/admin/sub_menu.jsp" %>
<script type="text/javascript">
function go_order_save(){
	var count = 0;
    if (document.frm.result.length == undefined) {
      	if (document.frm.result.checked == true) {
        	count++;
      	}
    } else {
      	for ( var i = 0; i < document.frm.result.length; i++) {
        	if (document.frm.result[i].checked == true) {
          		count++;
        	}
        }
    }
    
    if (count == 0) {
        alert("주문처리할 항목을 선택해 주세요.");
    } else {
        document.frm.action = "admin_order_save";
        document.frm.submit();
    }
}

function go_search_order() {
	var theForm = document.frm;
	if(theForm.key.value=="" && theForm.all_view.value=='y') return;
	theForm.all_view.value="n";
	theForm.action =  "admin_order_list";
	theForm.submit();
}

function go_total_order() {
	var theForm = document.frm;
	theForm.all_view.value="y";
	theForm.key.value="";
	theForm.action =  "admin_order_list";
	theForm.submit();
}
</script>
<article>
<h1>대여리스트</h1>
<form name="frm" method="post">
<br>
<table>
	<tr>
	    <td>주문자 이름 <input type="text" name="key" value="${key}"> 
		    <input class="btn" type="button" value="검색" 	onclick="go_search_order()">
		    <!-- <input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total_order()">		 -->			
		    <input type="hidden" name="all_view" value="y">
	    </td>
	</tr>
</table>
<br>
<table id="orderList">
	<tr>
	    <th>대여번호</th><th>주문자</th><th>상품명</th><th>수량</th>
	    <th>대여 장소</th><th>대여 금액</th><th>대여일</th><th>반납일</th>
    </tr>
    <c:forEach items="${orderList}" var="orderVO">
		<tr>
			<td>
		    	<%-- <c:choose>
		        	<c:when test='${orderVO.result=="1"}'>
		        		<span style="font-weight: bold; color: blue">${orderVO.odseq}</span>
		        		(<input type="checkbox" name="result" value="${orderVO.odseq}"> 미처리)
		        	</c:when>
			        <c:otherwise>
			        	<span style="font-weight: bold; color: red">${orderVO.odseq}</span>
			        	(<input type="checkbox" checked="checked" disabled="disabled">처리완료)
			        </c:otherwise>
		        </c:choose> --%>
		        <span style="font-weight: bold; color: red">${orderVO.num}</span>
			        	<!-- (<input type="checkbox" checked="checked" disabled="disabled">처리완료) -->
		    </td>
		    <td>${orderVO.id}</td><td>${orderVO.name}</td>
		    <td>${orderVO.count}</td><td>${orderVO.locationname}</td>
		    <td>${orderVO.price}</td> <td><fmt:formatDate value="${orderVO.borrow}" /></td>
		    <td><fmt:formatDate value="${orderVO.turn}" /></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/resources/paging/paging_order.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
<br>
<!-- <input type="button" class="btn" style="width: 200px" value="주문처리(입금확인)" onClick="go_order_save()"> -->
</form>
</form>
</article>

<%@ include file="/resources/headerfooter/ADfooter.jsp" %>  