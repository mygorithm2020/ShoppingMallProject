function go_cart() {
	 if (document.formm.count.value == "") {
		    alert("수량을 입력하여 주세요.");
		    document.formm.count.focus();
	 }else{
		 	document.formm.action ="market.do?command=Cart_Insert";
		 	document.formm.submit();
	 }
}


function go_cart_delete(){
	var quantity=0;
	//전달된 체크박스의 갯수가 1개이면 length 는 undefined
	//전달된 체크박스의 갯수가 2개 이상이면 length 는 그 갯수를 숫자로저장
	if(document.formm.num.length==undefined){
			//alert("현재 체크박스 하나입니다");
			if (document.formm.num.checked == true){
				quantity++;
			}
	}else{
			//alert("현재 체크박스 두개 이상입니다");
			for(var i=0; i<document.formm.num.length; i++){
				if(document.formm.num[i].checked == true){
					quantity++;
				}
			}// 0 부터 document.formm.cseq.length 에 저장된 숫자까지 체크 박스를 배열처럼 방문하여 체크되었는지 검사 
	}
	
	if (quantity == 0) {
	    alert("삭제할 항목을 선택해 주세요.");
	}else{
		document.formm.action = "market.do?command=rent_cart_delete";
	    document.formm.submit();
	}
}

function go_rent_delete(){
	var quantity=0;
	//전달된 체크박스의 갯수가 1개이면 length 는 undefined
	//전달된 체크박스의 갯수가 2개 이상이면 length 는 그 갯수를 숫자로저장
	if(document.formm.num.length==undefined){
			//alert("현재 체크박스 하나입니다");
			if (document.formm.num.checked == true){
				quantity++;
			}
	}else{
			//alert("현재 체크박스 두개 이상입니다");
			for(var i=0; i<document.formm.num.length; i++){
				if(document.formm.num[i].checked == true){
					quantity++;
				}
			}// 0 부터 document.formm.cseq.length 에 저장된 숫자까지 체크 박스를 배열처럼 방문하여 체크되었는지 검사 
	}
	
	if (quantity == 0) {
	    alert("삭제할 항목을 선택해 주세요.");
	}else{
		document.formm.action = "market.do?command=rent_delete";
	    document.formm.submit();
	}
}

function go_rent_insert(){
	var quantity=0;
	//전달된 체크박스의 갯수가 1개이면 length 는 undefined
	//전달된 체크박스의 갯수가 2개 이상이면 length 는 그 갯수를 숫자로저장
	if(document.formm.num.length==undefined){
			//alert("현재 체크박스 하나입니다");
			if (document.formm.num.checked == true){
				quantity++;
			}
	}else{
			//alert("현재 체크박스 두개 이상입니다");
			for(var i=0; i<document.formm.num.length; i++){
				if(document.formm.num[i].checked == true){
					quantity++;
				}
			}// 0 부터 document.formm.cseq.length 에 저장된 숫자까지 체크 박스를 배열처럼 방문하여 체크되었는지 검사 
	}
	
	if (quantity == 0) {
	    alert("대여할 항목을 선택해 주세요.");
	}else{
		document.formm.action ="market.do?command=rent_insert";
		document.formm.submit();
	}
	
}
function go_rent_list(){
	

		document.frm.action ="market.do?command=rent_list";
		document.frm.submit();
	
	
}



