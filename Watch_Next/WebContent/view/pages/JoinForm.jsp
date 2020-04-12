<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/Join.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>

<section>
	<div class="jn_table">
	<h2>회원가입</h2>
	<hr class="hline">
		<div id="div_form">
		<form action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text"  class="jn_input" id="user_ID" name="user_ID" placeholder="아이디를 입력하시오."></td>
					<td><div id="idCheck" onclick="checkId();">중복확인</div></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="jn_input" id="user_Pass" onkeyup="check_pwd()"name="user_Pass" placeholder="비밀번호를 입력하시오."></td>
				</tr>
				<tr>
					<td colspan="2"><label id="pwdCheck1"></label></td>		
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" class="jn_input" id="user_Pass1" onkeyup="check_pwd1()" name="user_Pass1" placeholder="비밀번호를 입력하시오."></td>
				</tr>
				<tr>
					<td colspan="2"><label id="pwdCheck2"></label></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="jn_input" id="jn_input" name="user_Name"placeholder="이름을 입력하시오."></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" class="jn_input" id="jn_input" name="user_Phone" placeholder="전화번호를 입력하시오."></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" class="jn_input" id="jn_input" name="user_Email" placeholder="이메일을 입력하시오."></td>
				</tr>
				<tr>
					<td>메일링 서비스</td>
					<td>
						<input type="checkbox"  name="user_Check" value="Y"><label>수신</label>
						<input type="checkbox"  name="user_Check" value="N"><label>비수신</label>
					</td>
				</tr>
				<tr>
					<td>SNS 소식</td>
					<td>
						<input type="checkbox" name="em_get" value="수신"><label>수신</label>
						<input type="checkbox" name="em_get" value="비수신"><label>비수신</label>
					</td>
				</tr>
			</table>
				<div id="jn_btn">
					<button type="submit" id="bu_sty">가입하기 </button>
					<button type="reset" id="bu_sty">취소</button>
				</div>	
		</form>
		</div>
	</div>
	<script>
		function check_pwd(){
			var pwd1 = $('#user_Pass').val();
			var check = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
			
			if(check.test(pwd1)){
				pwdCheck1.innerHTML = "사용 가능합니다.";
				return true;
			} else {
				pwdCheck1.innerHTML = "대문자 , 소문자 8자리 이상 입력해주세요.";				
				return false;
			}
			if(pwd1 == pwd2){
				pwdCheck2.innerHTML = "비밀번호가 일치합니다.";
			}
		}
		function check_pwd1(){
			var pwd2 = document.getElementById('user_Pass1');
			var pwdCheck2 = document.getElementById('pwdCheck2');
			var pwd1 = document.getElementById('user_Pass');
			
			if(pwd1.value != pwd2.value){
				pwdCheck2.innerHTML = "비밀번호가 일치하지 않습니다."
				return false;
			} else {
				pwdCheck2.innerHTML = "비밀번호가 일치합니다."
				return true;	
			}
		}
		
		function checkId(){
			window.open('idCheck.jsp', 'checkForm', 'width=500, height=300');
		}	
	</script>
</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>