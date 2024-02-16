<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Diary</title>
		<link rel="stylesheet" type="text/css" href="css/diary.css">
		<script src="script/diary.js"></script>
	</head>
	<body>
		<div id="wrap" align="center">
			<h1>일기 작성</h1>
			<form name="frm" method="post" action="DiaryController.do">
				<table>
					<tr>
						<th>날씨</th>
						<td><input type="text" name="weather"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" size="68" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols="70" rows="15" name="content"></textarea></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="등록">
				<input type="reset" value="다시작성">
			</form>
		</div>
	</body>
</html>