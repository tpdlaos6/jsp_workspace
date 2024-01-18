// id, pw validation
function loginCheck(){
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}

//id중복체크창
function idCheck(){
	if (document.frm.userid.value == ""){
		alert('아이디를 입력하여 주십시오.');
		document.form.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(rl, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

//사용가능한id선택
function idok(userid){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();  // 팝업창 닫기
}

//회원가입정보 validation
function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 3) {
		alert("아이디는 3글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.")
		frm.pwd.focus();
		return false;
	}
	if (document.frm.userid.value!=document.frm.reid.value) { 
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
//	if (document.frm.email.value!=document.frm.reid.value) { 
//		alert("중복 체크를 하지 않았습니다.");
//		frm.userid.focus();
//		return false;
//	}
//	if (document.frm.userid.value!=document.frm.reid.value) { 
//		alert("중복 체크를 하지 않았습니다.");
//		frm.userid.focus();
//		return false;
//	}
	return true;
}