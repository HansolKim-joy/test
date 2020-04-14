<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
<style>
	#checkPwdMain{ 
		width: 500px;
		margin: 0 auto;
		margin-top: 100px;
	}
	#checkPwdHead{
		text-align: center;
		color: white;
		font-size: 25px;
	}
	.hline{
		border: 2px solid red;
	}
	#ppwd{
		margin-left: 100px;
		font-size: 20px;
		color: white;
	}
	#checkBtn{
		text-align: center;
		font-size: 20px;
		color: white;
		border: none;
		width: 150px;
		height: 30px;
		background-color: #ca0d0d;
		border-radius: 50px;
		margin: auto;
	}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/checkPwd.me" method='post'>
		<div id="checkPwdMain">
			<div id="checkPwdHead">비밀번호 확인</div>
			<br>		
			<hr class="hline">
			<br>
			<span id="ppwd">현재 비밀번호 : &ensp;</span>
			<span><input type="password" id="inputPwd" name="inputPwd"></span>
			<br><br><br><br>
			<button type="submit" id="checkBtn">확인</button>
		</div>
	</form>
</body>
</html>