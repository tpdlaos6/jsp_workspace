<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
		<script src="script/member.js"></script>
	</head>
	<body>
		<h2>회원수정</h2>
		'*'는 필수 입력항목입니다.
		<form action="memberUpdate.do" method="post" name="frm">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${mVo.name}">*</td>
				</tr>
				<tr>
					<td>id</td>
					<td>
						<input type="text" name="userid" value="${mVo.userid}" readonly>*
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
					<td><input type="text" name="email" value="${mVo.email}">*</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" value="${mVo.phone}">*</td>
				</tr>
				<tr>
					<td>등급</td>
					<td>
						<c:choose>
							<c:when test="${mVo.admin==0}">
								<input type="radio" name="admin" value="0" checked>일반회원
								<input type="radio" name="admin" value="1">관리자
							</c:when>
							<c:otherwise>
								<input type="radio" name="admin" value="0">일반회원
								<input type="radio" name="admin" value="1" checked>관리자
							</c:otherwise>
						</c:choose>
						
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정" onclick="return joinCheck()">
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