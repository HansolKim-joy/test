<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Member updateUser = (Member)session.getAttribute("updateUser");
	String mailing = updateUser.getMailingYN();
	
	String checkedMailingY = "";
	String checkedMailingN = "";
	if(mailing.equals("Y")){
		checkedMailingY = "checked"; 
	}else{
		checkedMailingN = "checked";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정 확인페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<style>
	#updateForm{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#updateMain{
		color: white;
		font-size: 25px;
	}
	.hline{
		border: 2px solid red;
	}
	#updateTabled{
		text-align: -webkit-center;
		font-size: 20px;
		color: white;
	}
	#userId{
		font-size: 20px;
		text-align: center;
		width: 250px;
	}
	.loginUser{
		font-size: 20px;
		text-align: center;
		width: 250px;
		color: gray;
	}
	#updateTable{
		border-spacing: 30px;
	}
	.tdlast{
		width: 100px;
	}
	#updateMemberBtn{
		border: 0;
		outline: 0;
		background-color: #545257;
		color: white;
		font-size: 20px;
	}
	.checkbox{
		width: 20px;
		height: 20px;
		font-size: 25px;
	}
	#pwdMessage{
		text-align: center;
		display: none;
	}
	#pwdMessage1{
		text-align: center;
		display: none;
	}
</style>
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>


<section>
	<div id="updateForm">
		<h2 id="updateMain">회원 정보 수정</h2>
		<hr class="hline">
		<form action="<%= request.getContextPath() %>/update.me" method="post">
			<div id="updateTabled">
				<table id="updateTable">
					<tr>
						<td>아이디 : &emsp;</td>
						<td><input type="text" id="userId" name="userId" value="<%= loginUser.getUserId() %>" readonly></td>
						<td class="tdlast"></td>
					</tr>
					<tr>
						<td>변경 비밀번호 : &emsp;</td>
						<td><input type="password" id="userPwd" name="userPwd" class="loginUser"></td>
						<td><label id="pwdMessage1"></label></td>
					</tr>
					<tr>
						<td>변경 비밀번호 확인 : &emsp;</td>
						<td><input type="password" id="userPwd2" name="userPwd2" class="loginUser"></td>
						<td><label id="pwdMessage"></label></td>
					</tr>
					<tr>
						<td>이름 : &emsp;</td>
						<td><input type="text" id="userName" name="userName" class="loginUser" value="<%= loginUser.getUserName() %>"></td>
						<td></td>
					</tr>
					<tr>
						<td>이메일 : &emsp;</td>
						<td><input type="text" id="userEmail" name="userEmail" class="loginUser" value="<%= loginUser.getEmail() %>"></td>
						<td></td>
					</tr>
					<tr>
						<td>연락처 : &emsp;</td>
						<td><input type="text" id="phone" name="userPhone" class="loginUser" value="<%=loginUser.getPhone() %>"></td>
						<td></td>
					</tr>
					<tr>
						<td>메일링 서비스 : &emsp;</td>
						<td>
							&emsp;&emsp;
							<input type="checkbox" id="mailingY" name="mailing" onclick="doOpenCheck(this);" value="Y" class="checkbox" <%= checkedMailingY %>>&emsp;Y
							&emsp;&emsp;
							<input type="checkbox" id="mailingN" name="mailing" onclick="doOpenCheck(this);" value="N" class="checkbox" <%= checkedMailingN %>>&emsp;N
						</td>
						<td></td>
					</tr>
					<tr></tr>
					<tr>
						<td colspan="2">
							&emsp;&emsp;&emsp;	
							<button id="updateMemberBtn" onclick="updateMemeber();">수정 완료</button>
							&emsp;&emsp;&emsp;&emsp;&emsp;
							<span id="cancelBtn" onclick="location.href='javascript:history.go(-1)'">취소하기</span>
						</td>
						
					</tr>
				</table>
			</div>
		</form>
	</div>
	
	<script>
		function doOpenCheck(chk){
			var obj = document.getElementsByName("mailing");
			for(var i = 0; i < obj.length; i++){
				if(obj[i] != chk){
					obj[i].checked = false;
				}
			}
		}
		
		
		$('#updateMemberBtn').click(function(){
			alert('수정완료');
			location.href="<%= request.getContextPath() %>/Resources/view/myPage/myPageMain.jsp";
		});
		
		$('#userPwd2').change(function(){
			var userPwd = $('#userPwd').val();
			var userPwd2 = $('#userPwd2').val();
			/* console.log(userPwd);
			console.log(userPwd2); */
			
			if(userPwd == userPwd2){
				/* console.log('같다구요!'); */
				$('#pwdMessage').text('일치').css({"color":"green", "display":"block"});
			}else{
				/* console.log('다르다구요!'); */
				$('#pwdMessage').text('불일치').css({"color":"red", "display":"block"});
			}
		});
		
		$('#userPwd').change(function(){
			var userPwd = $('#userPwd').val();
			var check = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
			/* console.log(userPwd); */
			
			if(check.test(userPwd)){
				/* console.log('되요!'); */
				$('#pwdMessage1').text('사용 가능').css({"color":"green", "display":"block"});
			}else{
				$('#pwdMessage1').text('사용 불가능').css({"color":"red", "display":"block"});
			}
		});
	</script>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>

<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>