<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>id중복체크</title>
		<script src="script/member.js"></script>
	</head>
	<body>
		<h2>id중복확인</h2>
		<form action="idCheck.do" method="get" name="frm">
			id 
			<input type="text" name="userid" value="${userid}"> 
			<input type="submit" value="중복체크">
			<br>
			<c:if test="${result==1}">
				<script>
			 		opener.document.frm.userid.value=""; //부모창의 userid 초기화
			 	</script>	
			 	${userid}는 이미 사용중인 id입니다.	 
			</c:if>
			<c:if test="${result==-1}">
				${userid}는 사용가능 합니다. <input type="button" value="사용" class="cancel" onclick="idok('${userid}')">
			</c:if>
		</form>
	</body>
</html>