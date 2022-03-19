function go_next() {
	if (document.formm.okon1[0].checked == true) {   
		document.formm.action = "join_form";
		document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
		alert("약관에 동의하셔야 회원가입이 가능합니다.")
	}
}

function customer_id() {
	document.formm.action = "login";
	document.formm.submit();	
}


function admin_id() {
	document.formm.action = "admin";
	document.formm.submit();	
}

function idcheck() {
	if(document.formm.id.value=="") {
		alert('아이디를 입력하여 주세요');
		document.formm.id.focus();
		return;
	}
	var url="Id_Check_Form?id=" + document.formm.id.value;
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=250";
	window.open(url, "Id_check", opt);
}


function idok() {
	opener.formm.id.value=document.formm.id.value;
	opener.formm.reid.value=document.formm.id.value;
	self.close();
}


function find_id() {
	alert('관리자에게 문의하세요.');
	document.formm.id.focus();
}


function go_save(){
	if(document.formm.id.value=="") {
		alert("아이디를 입력하여 주세요.");
		document.formm.id.focus();
	}else if(document.formm.id.value != document.formm.reid.value){
		alert("아이디 중복확인을 클릭해주세요.");
		document.formm.id.focus();
	}else if(document.formm.pw.value =="") {
		alert("비밀번호를 입력해주세요.");
		document.formm.pw.focus();
	}else if(document.formm.pw.value != document.formm.pwCheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.formm.pw.focus();
	}else if(document.formm.name.value=="") {
		alert("이름을 입력하여 주세요.");
		document.formm.name.focus();
	}else if(document.formm.email.value=="") {
		alert("이메일을 입력하여 주세요.");
		document.formm.email.focus();
	} else if(document.formm.phone.value=="") {
		alert("전화번호를 입력하여 주세요.");
		document.formm.email.focus();
	} else if(document.formm.year.value=="" || document.formm.month.value=="" || document.formm.day.value=="" ) {
		alert("생년월일을 입력해 주세요.");
		document.formm.email.focus();
	} else {
		document.formm.action = "join";
		document.formm.submit();
	}		
}


function go_update() {
	if(document.formm.pw.value=="") {
		alert("비밀번호를 입력해주세요.");
		document.formm.pw.focus();
	} else if((document.formm.pw.value != document.formm.pwCheck.value)) {
		alert("비밀번호가 일치하지 않습니다.");
		document.formm.pw.focus();
	} else if(document.formm.name.value=="") {
		alert("이름을 입력하여 주세요.");
		document.formm.name.focus();
	}else if(document.formm.email.value=="") {
		alert("이메일을 입력하여 주세요.");
		document.formm.email.focus();
	}else {
		document.formm.action = "Member_Update";
		document.formm.submit();
	}	
}


function go_delete() {
	document.formm.action = "Member_Delete_Form";
	document.formm.submit();
}



function go_delete_last(){
	alert('회원탈퇴가 완료되었습니다.');
	document.formm.action = "Member_Delete";
	document.formm.submit();
}



// or

/* function go_delete() {
	if(document.formm.id.value=="") {
		alert('탈퇴를 원하실 경우 아래 버튼을 눌러주세요');
		document.formm.id.focus();
		return;
	}
	var url="Member_Delete&id=" + document.formm.id.value;
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=250";
	window.open(url, "Delete", opt);
}

*/




	