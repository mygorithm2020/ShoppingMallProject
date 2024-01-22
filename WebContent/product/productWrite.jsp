<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<%@ include file="../qna/sub_img.html"%> 
<div id="wFrame">
<article>
<h2>상품등록</h2>  
<form name="frm" method="post" enctype="multipart/form-data">
<table id="list">
<tr>
	<th>상품분류</th>
	<td colspan="5">
		<select name="kind">
    		<c:forEach items="${kindList}" var="kind" varStatus="status">
      			<option value="${status.count}">${kind}</option>
   			</c:forEach>
  		</select>
  	</td>
  	
</tr>
<tr>
  	<th>제목</th>
  	<td width="343" colspan="5">
       	<input type="text" name="title" size="47" maxlength="100" >
       	<input type="hidden" name="id" value="${loginUser.id}">
       	
  	</td>
</tr>
<tr>
	<th>1일 대여가격 :</th><td width="70"><input type="text" name="price" size="11"></td>
  	<th>제품명 </th><td width="70"><input type="text" name="pname" size="11"></td>
	
</tr>
<tr><th>상세설명</th><td colspan="5"><textarea name="content" rows="8" cols="70"></textarea></td></tr>
<tr><th>상품이미지</th><td width="343" colspan="5"><input type="file" name="img"></td></tr>
<tr><th>지점선택</th>
	<td colspan="15">
		<select name="location">
    		<c:forEach items="${locationList}" var="location" varStatus="status">
      			<option >${location.gu} ${location.dong} ${location.name}점</option>점
   			</c:forEach>
  		</select>
  	</td></tr>
<tr style="border-bottom:1px solid white;"><td></td><td><input class="btn" type="button" value="등록" onClick="product_go_save()">           
<input class="btn" type="button" value="취소" onClick="product_go_mov()"></td></tr>
</table>

</form>
</article>
</div>


<%@ include file="../footer.jsp" %>  