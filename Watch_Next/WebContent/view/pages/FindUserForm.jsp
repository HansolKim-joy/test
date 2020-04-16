<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/Find_Id-Pass.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>
<% 
   String msg = (String)request.getAttribute("msg"); 

//    System.out.println("qkqh" + msg);
%>
<section>

   <div class="re_table">
   <h2>아이디 찾기 / 비밀번호 찾기</h2>
   <hr class="hline">
      <form action="<%= request.getContextPath() %>/finduser.to" id="re_form">
         <div id="re_div">
            아이디 / 비밀번호 기억나지 않으세요?
            <br>
            "아이디 / 비밀번호는 회원가입 시, 입력하신 이메일로 확인 가능하십니다."
         </div>
         <div>
            <input type="email" maxlength="50" class="re_input" name="find_User" placeholder="이메일을 입력해주시오.">
            <button type="submit" class="re_btn" >아이디 / 비밀번호 찾기</button>
         </div>
      </form>
   </div>
   
   
</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script>
   $(function(){
      var msg = '<%= msg %>';
      if(msg.trim() == '없는 이메일 주소입니다.'){
         alert(msg)
      }
   })
</script>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>