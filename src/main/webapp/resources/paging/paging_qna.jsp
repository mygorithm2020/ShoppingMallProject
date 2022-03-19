<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{text-align:center;}
#paging{font-size: 120%;}
</style>
</head>
<body>
<div id="paging">
		<c:url var="action" value="admin_qna_list"/>
		<c:if test="${param.prev}">
		    	<a href="${action}?page=${param.beginPage-1}">◀</a>
		</c:if><!-- prev 변수가 참이면 ◀버튼 표시 아니면 표시 안함-->
		
		<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
			    <c:choose>
				        <c:when test="${param.page==index}">${index}</c:when>
				        <c:otherwise><a href="${action}?page=${index}">${index}</a></c:otherwise>
			    </c:choose>
		</c:forEach>
		
		<c:if test="${param.next}">
		    	<a href="${action}?page=${param.endPage+1}">▶</a>
		</c:if><!-- next 변수가 참이면 ▶버튼 표시 아니면 표시 안함-->
</div>
</body>
</html>
