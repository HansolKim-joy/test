<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>

<section>

	<div class="re_table">
	<h2>아이디 찾기 / 비밀번호 찾기</h2>
	<hr class="hline">
		<form id="re_form">
			<div>
				아이디 / 비밀번호 기억나지 않으세요?
				<br>
				"아이디 / 비밀번호는 회원가입 시, 입력하신 이메일로 확인 가능하십니다."
			</div>
			<div>
				<input type="email" maxlength="50" class="re_input" placeholder="이메일을 입력해주시오.">
				<button type="submit" class="re_btn" >아이디 / 비밀번호 찾기</button>
			</div>
		</form>
	</div>
	
</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>