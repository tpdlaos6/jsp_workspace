//id,pw validation
function loginCheck(){
	if(document.frm.userid.value.length==0){
		alert("id를 입력하세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value==""){
		alert("pw를 입력하세요");
		frm.pwd.focus();
		return false;
	}
}
//id중복체크창
function idCheck(){
	if(document.frm.userid.value==""){
		alert("id를 입력해 주세요");
		document.form.userid.focus();
		return;
	}
	var url="idCheck.do?userid="+document.frm.userid.value;
	window.open(url,"blank1","resizable=no,width=450,height=200");
}
//사용가능한id선택
function idok(userid){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close(); //팝업창닫기
}
//회원가입정보 validation
function joinCheck(){
	if(document.frm.name.value==""){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length==0){
		alert("id를 입력하세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length<3){
		alert("id는 3글자이상이어야 합니다.");
		frm.userid.select(); //수정시 select()
		return false;
	}	
	if(document.frm.pwd.value==""){
		alert("pw를 입력하세요");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd.value!=document.frm.pwd_check.value){
		alert("pw확인이 일치하지 않습니다.");
		frm.pwd_check.select(); //수정시 select()
		return false;
	}
	if(document.frm.userid.value!=document.frm.reid.value){
		alert("id중복체크 해주세요");
		frm.userid.focus();
		return false;
	}
	if(document.frm.email.value==""){
		alert("email을 입력해주세요");
		frm.email.focus();
		return false;
	}
	if(document.frm.phone.value==""){
		alert("전화번호를 입력해주세요");
		frm.phone.focus();
		return false;
	}
}