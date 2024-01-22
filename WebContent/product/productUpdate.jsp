<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../qna/sub_img.html"%> 
<div id="wFrame">
<article>
<h2>상품수정</h2>  
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="pseq" value="${productVo.num}">
<input type="hidden" name="nonmakeImg" value="${productVo.img}">
<table id="list">
		<tr>
			<th>상품분류</th>
			<td colspan="5">
				<select name="kind">
					<c:forEach items="${kindList}" var="kind" varStatus="status">
				        <c:choose>
          					<c:when test="${productVo.category==status.count}">
            					<option value="${status.count}" selected="selected">${kind}</option>
          					</c:when>
          					<c:otherwise>
            					<option value="${status.count}">${kind}</option>
          					</c:otherwise>
        				</c:choose>
      				</c:forEach>
    			</select> 
    		</td>
    		
		</tr>
		
		<tr>
				<th>제목</th>
	    		<td width="343" colspan="5">
	      			<input type="text" name="title" size="47" maxlength="100" value="${productVo.title}">
	      			<input type="hidden" name="id" value="${loginUser.id}">
	    		</td>
  		</tr>
  		<tr>
	<th>1일 대여가격 :</th><td width="70"><input type="text" name="price" size="11" value="${productVo.price}"></td>
  	<th>제품명 </th><td width="70"><input type="text" name="pname" size="11" value="${productVo.name}"></td>
	</tr>
  		  		
  		<tr>
    		<th>상세설명</th>
    		<td colspan="5">
      			<textarea name="content" rows="8" cols="70" >${productVo.content}</textarea>
    		</td>
  		</tr>
  		<tr>
    		<th>상품이미지</th>
    		<td colspan="5">
      			<img src="product/productimage/${productVo.img}" width="200">     
      			<br><input type="file" name="img">
    		</td>
  	</tr> 
  	<tr><th>지점선택</th>
	<td colspan="15">
		<select name="location">
    		<c:forEach items="${locationList}" var="location" varStatus="status">
      			<option >${location.gu} ${location.dong} ${location.name}점</option>점
   			</c:forEach>
  		</select>
  	</td></tr>
  	<tr style="border-bottom:1px solid white;"><td></td><td><input class="btn" type="button" value="수정" onClick="product_go_mod_save()">           
<input class="btn" type="button" value="취소" onClick="go_mov()"></td></tr>
</table>

</form>
</article>
</div>
<%@ include file="../footer.jsp"%>