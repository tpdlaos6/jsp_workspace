<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="/register" method="post">
        ID <input type="text" name="id"><br>
        PW <input type="password" name="pw"><br>
        email <input type="email"><br>
        name <input type="text" name="name"><br>
        phone <input type="text" name="phone"><br>
        job <select name="job">
            <option value="학생">학생</option>
            <option value="군인">군인</option>
            <option value="공무원">공무원</option>
            <option value="회사원">회사원</option>
            <option value="기타">기타</option>
            </select><br>
        
        hobby <input type="checkbox" name="hobby" value="운동">운동   
            <input type="checkbox" name="hobby" value="낚시">낚시   
            <input type="checkbox" name="hobby" value="등산">등산   
            <input type="checkbox" name="hobby" value="독서">독서   
            <input type="checkbox" name="hobby" value="공부">공부 
            <br>
        email reception <input type="radio" name="emailReception" value="y" checked>예    
                        <input type="radio" name="emailReception" value="n">아니오
            <br>    
        picture <input type="file" name="picture">
            <br>
        who i am <br>
        <textarea name="who" cols="50" rows="10"></textarea>    
        <br>

     <input type="submit" value="회원가입">
    </form>


</body>
</html>