<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/login.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>


<section>

   <div id="lg_table">
   <h2>로그인</h2>
   <hr class="hline">
      <form class="lg_form" onsubmit="return validate();" action="<%= request.getContextPath() %>/login.me" method="post">
         <div class="lg">
            <input type="text" class="lg_text" id="userId"  name="userId" placeholder="아이디">
            <input type="password" class="lg_text1" id="userPwd" name="userPwd" placeholder="비밀번호">
         <div>
            <input type="submit"  class="lg_button1" value="로그인">
         </div>
            <button type="button" class="lg_button" onclick="location='/Watch_Next/view/pages/JoinForm.jsp'"></button>
            <button type="button" class="lg_button" id="find_member" onclick="location='/Watch_Next/view/pages/FindUserForm.jsp'" ></button>
         </div>
      </form>
    </div>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script>
   function validate(){
      if($('#userId').val().trim().length == 0){
         alert('아이디를 입력해주세요');
         $('#userId').focus();
         return false;
      }
      
      if($('#userPwd').val().trim().length == 0){
         alert('비밀번호를 입력해주세요');
         $('#userPwd').focus();
         
         return false;
      }
      
      return true;
   }

</script>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>