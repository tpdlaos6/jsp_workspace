function productCheck() {
	if (document.frm.name.value.length == 0) {
		alert("상품명을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	
	// is not a number? : 굳이 직역하자면.. 숫자가 아닌가요? 라는 의미. 즉, 숫자가 아니면 true, 숫자면 false
	// 숫자가 아닌 문자로 입력하면 true로써 {} 안에 alert가 발동됨. 
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다");
		frm.price.focus();
		return false;
	}
	return true;
}