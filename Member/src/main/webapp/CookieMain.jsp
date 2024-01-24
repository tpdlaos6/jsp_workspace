<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cookie</title>
	</head>
	<body>
		<h1>쿠키 생성</h1>
		<%
		Cookie cookie=new Cookie("myCookie","쿠키맛나요");
		cookie.setPath(request.getContextPath());//루트디렉토리부터 적용. 기본값
		cookie.setMaxAge(60*60); //1시간 유지. 초단위이므로 60*60 말고 걍 3600이라 써도 됨
		response.addCookie(cookie); // 쿠키등록
		%>
		
		<h1>쿠키 읽기</h1>
		<%
		Cookie[] cookies=request.getCookies(); // 모든 쿠키를 얻음
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("myCookie")){
				out.println(c.getValue());
				}
			}
		}
		%>
	</body>
</html>