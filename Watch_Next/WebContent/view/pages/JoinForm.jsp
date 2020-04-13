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
					<td><label id="idResult"></label>
<!--   	 			<td><div id="idCheck" onclick="checkId();">중복확인</div></td> -->
					
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="jn_input" id="user_Pass" onkeyup="check_pwd()"name="user_Pass" placeholder="비밀번호를 입력하시오."></td>
					<td><label id="pwdCheck1"></label></td>		
				</tr>
<!-- 				<tr> -->
<!-- 				</tr> -->
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" class="jn_input" id="user_Pass1" onkeyup="check_pwd1()" name="user_Pass1" placeholder="비밀번호를 입력하시오."></td>
					<td><label id="pwdCheck2"></label></td>
				</tr>
<!-- 				<tr> -->
<!-- 				</tr> -->
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
						<input type="checkbox"  id="user_Check" name="user_Check" value="Y">수신
						<input type="checkbox"  id="user_Check" name="user_Check" value="N">비수신
					</td>
				</tr>
				<tr>
					<td>SMS 소식</td>
					<td>
						<input type="checkbox" name="em_get" value="수신">수신
						<input type="checkbox" name="em_get" value="비수신">비수신
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
// 				pwdCheck1.innerHTML = "사용 가능합니다.";
				$('#pwdCheck1').text('사용 가능합니다.');
				$('#pwdCheck1').css({'color' : 'white', 'float':'left', 'display':'inline-block', 'font-size' : 'x-small'});
				return true;
			} else {
// 				pwdCheck1.innerHTML = "대문자 , 소문자 8자리 이상 입력해주세요.";				
				$('#pwdCheck1').text('대/소문자, 특수문자, 숫자 포함하여 8자리 이상 입력해주세요.');
				$('#pwdCheck1').css({'color' : 'red', 'float':'left', 'display':'inline-block', 'font-size' : 'x-small'});
				return false;
			}
			if(pwd1 == pwd2){
// 				pwdCheck2.innerHTML = "비밀번호가 일치합니다.";
				$('#pwdCheck2').text('대/소문자, 특수문자, 숫자 포함하여 8자리 이상 입력해주세요.');
				$('#pwdCheck2').css({'color' : 'white', 'float':'left', 'display':'inline-block', 'font-size' : 'x-small'});
			}
		}
		function check_pwd1(){
			var pwd2 = document.getElementById('user_Pass1');
			var pwdCheck2 = document.getElementById('pwdCheck2');
			var pwd1 = document.getElementById('user_Pass');
			
			if(pwd1.value != pwd2.value){
// 				pwdCheck2.innerHTML = "비밀번호가 일치하지 않습니다."
				$('#pwdCheck2').text('비밀번호가 일치하지 않습니다.');
				$('#pwdCheck2').css({'color' : 'red', 'float':'left', 'display':'inline-block', 'font-size' : 'x-small'});
				return false;
			} else {
// 				pwdCheck2.innerHTML = "비밀번호가 일치합니다."
				$('#pwdCheck2').text('비밀번호가 일치합니다.');
				$('#pwdCheck2').css({'color' : 'white', 'float':'left', 'display':'inline-block', 'font-size' : 'x-small'});
				return true;	
			}
		}
		
		<!-- 아이디 중복 팝업창 -->
// 		function checkId(){
// 			window.open('idCheck.jsp', 'checkForm', 'width=500, height=300');
// 		} 	

		var isUsable = false;
		var isIdChecked = false;
		$("#user_ID").on('change paste keyup', function(){
			isIdChecked = false;
		});
		$("#user_ID").change(function(){
			var userId = $("#user_ID");
			if(!userId || userId.val().length < 4){
				alert('아이디는 최소 4자리 이상이어야 합니다.');
				userId.focus();
			} else {
				$.ajax({
					url: '<%= request.getContextPath() %>/idCheck.me',
					data: {userId:userId.val()},
					success: function(data){
						if(data == "success"){
							$('#idResult').text('사용 가능합니다.');
							$('#idResult').css({'color' : 'green', 'float':'left', 'display':'inline-block', 'font-size' : 'medium'});
							isUsable = true;
							isIdChecked = true;
						} else {
							$('#idResult').text('사용 불가능 합니다.');
							$('#idResult').css({'color' : 'red', 'float':'left', 'display':'inline-block', 'font-size' : 'medium'});
							userId.focus();							
							isUsable = false;
							isIdChecked = false;
						}
					}
				});
			}
		});
		
		function validate(){
			if(isUsable && isIdChecked){
				return true;
			} else {
				alert('아이디 중복을 확인해주세요.');
				return false;
			}
		}
		
		
	</script>
</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>