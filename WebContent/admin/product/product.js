function go_total(){
	var theForm = document.frm;
	theForm.all_view.value="y";
	theForm.key.value="";
	theForm.action =  "market.do?command=admin_product_list";
	theForm.submit();
}

function go_search(){
	var theForm = document.frm;
	if(theForm.key.value=="" && theForm.all_view.value=='y') return;
	theForm.all_view.value="n";
	theForm.action =  "shop.do?command=admin_product_list";
	theForm.submit();
}


function go_detail(pseq) {
	document.frm.action = "shop.do?command=admin_product_detail&pseq=" + pseq;
	document.frm.submit();
}

function go_mov(){
	document.frm.action = "shop.do?command=admin_product_list";
	document.frm.submit();
}


function go_mod(pseq){
	document.frm.action = "shop.do?command=admin_product_update_form&pseq=" + pseq;
	document.frm.submit();
}


function go_mod_save() {
	 if (document.frm.kind.value == '') {
		  alert('상품분류를 선택하세요');
		  document.frm.kind.focus();
	 } else if (document.frm.name.value == '') {
		  alert('상품명을 입력하세요');
		  document.frm.name.focus();
	 } else if (document.frm.price1.value == '') {
		  alert('원가를 입력하세요');
		  document.frm.price1.focus();
	 } else if (document.frm.price2.value == '') {
		  alert('판매가를 입력하세요');
		  document.frm.price2.focus();
	 } else if (document.frm.content.value == '') {
		  alert('상품상세를 입력하세요');
		  document.frm.content.focus();
	 } else {
		 if (confirm('수정하시겠습니까?')) {
			 if( document.frm.useyn.checked == true)  document.frm.useyn.value = "y";
			 if( document.frm.bestyn.checked == true)  document.frm.bestyn.value = "y";
			 document.frm.encoding = "multipart/form-data";
			 document.frm.action = "shop.do?command=admin_product_update";
			 document.frm.submit();
		 }
	 }
}


function go_wrt(){
	document.frm.action = "shop.do?command=admin_product_write_form";
	document.frm.submit();
}


function go_save(){
	var theForm = document.frm;
	if (theForm.kind.value == '') {
		alert('상품분류를 선택하세요.');
		theForm.kind.focus();
	} else if (theForm.name.value == '') {
		alert('상품명을 입력하세요.');
		theForm.name.focus();
	} else if (theForm.price1.value == '') {
		alert('원가를 입력하세요.');
		theForm.price1.focus();
	} else if (theForm.price2.value == '') {
		alert('판매가를 입력하세요.');
		theForm.price2.focus();
	} else if (theForm.content.value == '') {
		alert('상품상세를 입력하세요.');
		theForm.content.focus();
	} else if (theForm.image.value == '') {
		alert('상품이미지들 입력하세요.');
		theForm.image.focus();
	} else {
		theForm.encoding = "multipart/form-data";
		theForm.action = "shop.do?command=admin_product_write";
		theForm.submit();
	}
}








