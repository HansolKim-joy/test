<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	String msg = (String)request.getAttribute("msg");
	String msg1 = (String)request.getAttribute("msg1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp"%>
<link type="text/css" href="/Watch_Next/Resources/css/login.css"
	rel="stylesheet" />
<style>
#footer{margin-top: 10.5%;}
</style>
</head>
<body>
	<!--header -->
	<%@ include file="/view/layout/Header.jsp"%>

	<section>
		<div id="lg_table">
			<h2>로그인</h2>
			<hr class="hline">
			<form class="lg_form" onsubmit="return validate();"
				action="<%= request.getContextPath() %>/login.me" method="post">
				<div class="lg">
					<div id="lgbtn">
					<div class="in">
						<div class="div">
							<label>아이디</label>
							<input type="text" class="lg_text" id="userId" name="userId">
						</div>
						<div class="div">
							<label>비밀번호</label>
							<input type="password" class="lg_text1" id="lg_userPwd" name="lg_userPwd" >
						</div>
					</div>
					<div id="buttons">
						<input type="submit" class="btn red" value="로그인">
					</div>
					</div>
					<div id="botbtn">
						<a class="lg_button" id="insert" onclick="location='/Watch_Next/view/pages/JoinForm.jsp'">회원가입</a>
						<span class="bar">|</span>
						<a class="lg_button" id="find_member" onclick="location='/Watch_Next/view/pages/FindUserForm.jsp'">아이디/비밀번호 찾기</a>
					</div>
				</div>
			</form>
		</div>
	</section>

	<!-- footer -->
	<%@ include file="/view/layout/footer.jsp"%>
	<script>
   function validate(){
      if($('#userId').val().trim().length == 0){
         alert('아이디를 입력해주세요');
         $('#userId').focus();
         return false;
      }
      
      if($('#lg_userPwd').val().trim().length == 0){
         alert('비밀번호를 입력해주세요');
         $('#lg_userPwd').focus();
         
         return false;
      }
      
      return true;
   }
   $(function(){
      var msg = '<%= msg %>';
      	if(msg.trim() == '가입하지 않은 아이디거나, 또는 비밀번호가 틀립니다.'){
      		alert(msg);
      	}
      
     	 if(msg.trim() == '이메일로 회원님의 정보를 보냈습니다. 확인 후 다시 로그인 해주세요.'){
        	alert(msg);
      	}
   });
//       }
//       if(msg.trim() == "없는 회원입니다. 회원가입 해주세요."){
//         alert(msg);
//       }
//       if(msg.trim() == "아이디 또는 비밀번호가 잘못되었습니다."){
//    	  	alert(msg);
//       }
      
<%--       var msg1 = '<%= msg1 %>'; --%>
// //       if(msg1.trim() == "회원가입을 다시해주세요."){
//     	 alert(msg1);
//       }
   
   
   
</script>
	<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>