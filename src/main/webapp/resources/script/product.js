function go_total(){
	var theForm = document.frm;
	theForm.all_view.value="y";
	theForm.key.value="";
	theForm.action =  "admin_product_list";
	theForm.submit();
}

function go_search(){
	var theForm = document.frm;
	if(theForm.key.value=="" && theForm.all_view.value=='y') return;
	theForm.all_view.value="n";
	theForm.action =  "admin_product_list";
	theForm.submit();
}
function product_go_cart() {
	var theForm = document.frm;

	if (theForm.from.value == '') {
	alert('대여날짜를 입력해 주세요 ');
	theForm.from.focus();
} else if (theForm.to.value == '') {
	alert('반납날짜를 선택해주세요.');
	theForm.to.focus();
} else {
		 
	alert("장바구니에 들어갔습니다.")
			 document.frm.action ="cart_insert";
			 	document.frm.submit();
		 
	 }
	
		
}
function product_go_rent() {
	var theForm = document.frm;

	if (theForm.from.value == '') {
	alert('대여날짜를 입력해 주세요 ');
	theForm.from.focus();
} else if (theForm.to.value == '') {
	alert('반납날짜를 선택해주세요.');
	theForm.to.focus();
} else {
		 if (confirm('대여하시겠습니까?')) {
			 
			 document.frm.action ="rent_write";
			 	document.frm.submit();
		 }
	 }
	
	
	
	
 	

}

function go_detail(pseq) {
	document.frm.action = "admin_product_detail&pseq=" + pseq;
	document.frm.submit();
}

function product_go_mov(){
	document.frm.action = "mypage";
	document.frm.submit();
}

function product_go_delete(){
	var pseq=document.frm.pseq.value;
	var name=document.frm.name.value;
	 if (confirm(name + '제품을 삭제하시겠습니까?')) {
	document.frm.action = "product_delete?pseq=" + pseq;
	document.frm.submit();
	
	 }
	
}
function product_go_mod_form(){
	var pseq=document.frm.pseq.value;	
	document.frm.action = "product_update_form?pseq=" + pseq;
	document.frm.submit();
}


function product_go_mod_save() {
	var theForm = document.frm;

	if (theForm.title.value == '') {
	alert('제목을 입력하세요.');
	theForm.title.focus();
} else if (theForm.price.value == '') {
	alert('대여가격를 입력하세요.');
	theForm.price.focus();
} else if (theForm.pname.value == '') {
	alert('상품명를 입력하세요.');
	theForm.pname.focus();
} else if (theForm.img.value == '') {
	alert('상품이미지들 입력하세요.');
	theForm.img.focus();
}else if (theForm.content.value == '') {
	alert('상품명를 입력하세요.');
	theForm.content.focus();
	 } else {
		 if (confirm('수정하시겠습니까?')) {
			 
			 document.frm.encoding = "multipart/form-data";
			 document.frm.action = "product_update";
			 document.frm.submit();
		 }
	 }
}


function go_wrt(){
	document.frm.action = "admin_product_write_form";
	document.frm.submit();
}


function product_go_save(){
	
	
	var theForm = document.frm;

		if (theForm.title.value == '') {
		alert('제목을 입력하세요.');
		theForm.title.focus();
	} else if (theForm.price.value == '') {
		alert('대여가격를 입력하세요.');
		theForm.price.focus();
	} else if (theForm.pname.value == '') {
		alert('상품명를 입력하세요.');
		theForm.pname.focus();
	} else if (theForm.img.value == '') {
		alert('상품이미지들 입력하세요.');
		theForm.img.focus();
	}else if (theForm.content.value == '') {
		alert('상품명를 입력하세요.');
		theForm.content.focus();
	} 	else {
		theForm.encoding = "multipart/form-data";
		theForm.action = "write_product";
		theForm.submit();
	}
}








