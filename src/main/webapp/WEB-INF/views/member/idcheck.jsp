<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="<c:url value='/resources/css/shoping.css' />"  rel="stylesheet"> 
<script type="text/javascript" src="<c:url value = '/resources/script/member.js' />" ></script>   
<style type="text/css">
body{background-color:white;  font-family:"Times New Roman", Times, serif; }
#wrap{margin:0 100px; font-size:100%;}
h1{font-family:"Times New Roman", Times, serif;  font-size:40px; color:black; font-weight:bold; }
</style> 
</head>
<body>
<div id="wrap">
<h1>ID 중복 확인</h1>
<form method="post" name="formm" action="Id_Check_Form">
	User ID <input type="text" name="id" value="${id}"><input type="submit" value="검색" class="submit">
	<br>
	<div style="margin-top:20px">
			<c:if test="${message == 1}">
					<script type="text/javascript">
						opener.document.formm.id.value="";
					</script>
					${id}는 이미 사용 중인 아이디입니다.
			</c:if>
			<c:if test="${message == -1}">
					${id}는 사용 가능한 ID입니다.
					<input type="button" value="사용" class="cancel" onclick="idok()">  
			</c:if>
	</div>
</form>
</div>
</body>
</html>