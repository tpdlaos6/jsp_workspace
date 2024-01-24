<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="script/member.js"></script>
	</head>
	<body>
		<h2>회원가입</h2>
		'*'는 필수 입력항목입니다.
		<form action="join.do" method="post" name="frm">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name">*</td>
				</tr>
				<tr>
					<td>id</td>
					<td>
						<input type="text" name="userid">*
						<input type="hidden" name="reid"> 
						<input type="button" value="중복체크" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" name="pwd">*</td>
				</tr>
				<tr>
					<td>pw확인</td>
					<td><input type="password" name="pwd_check">*</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email">*</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone">*</td>
				</tr>
				<tr>
					<td>등급</td>
					<td>
						<input type="radio" name="admin" value="0" checked>일반회원
						<input type="radio" name="admin" value="1">관리자
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록" onclick="return joinCheck()">
						<input type="reset" value="취소">
					</td>
				</tr>
				<tr>
					<td colspan="2">${message}</td>
				</tr>
			</table>
		</form>
	</body>
</html>