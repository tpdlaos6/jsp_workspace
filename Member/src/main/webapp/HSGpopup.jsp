<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";   //기본값 on
Cookie[] cookies = request.getCookies();
if(cookies != null){
   for(Cookie c : cookies){
      String cookieName = c.getName();
      String cookieValue = c.getValue();
      if(cookieName.equals("PopupClose")){
         popupMode = cookieValue;
      }
   }
}
%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>쿠키를 사용한 팝업관리</title>
      <style>
         #popup{
            position : absolute;
            top : 10px;
            left :10px;
            color : yellow;
            width:400px;
            height : 100px;
            background : gray;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
         }
         #popup>div{
            position : relative;
            background:#ffffff;
            top : 0px;
            border: 1px solid gray;
            padding : 10px; 
            color : black;
         }
      </style>
      
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
      <script>
         $(function(){
            $("#closeBtn").click(function(){
               $("#popup").hide();
               var chkVal =$("input:checkbox[id=inactiveToday]:checked").val();
               //체크박스에 체크되어 있으면 
               if(chkVal == 1){
                  $.ajax({
                     url : "/PopupCookie.jsp",
                     type : "get",
                     data : {inactiveToday : chkVal},
                     dataType : "text",
                     success : function(resData){
                         if (resData != ''){
                            location.reload();
                           console.log(resData);
                         }
                     }
                  });
               }
            });
         });
      </script>
      
      
   </head>
   
   <body>
      <h2>팝업 메인페이지</h2>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>   
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      <div>프로젝트란?</div>
      
      
      <% 
       for (int i = 1; i <= 10; i++) {
           out.print("현재 팝업창은 " + popupMode + " 상태입니다.<br/>");
       }
      
      if (popupMode.equals("on")) {
         
         
      %>
         <div id ="popup">
            <H2>공지사항</H2>
            <div align="right">
               1. 일정계획서 수요일 오전까지 제출해주세요.<br>
               2. 기획서 수요일 오전까지 제출해주세요. <br>
               3. 오후에는 화면설계서 작성법 수업 예쩡입니다.         
            
               <form name="popFrm">
                  <input type="checkbox" id="inactiveToday" value="1"/> 하루동안 열지 않음
                  <input type="button" value ="닫기" id="closeBtn"/>
               </form>
            </div>
         </div>
      <%} %>
   </body>
</html>