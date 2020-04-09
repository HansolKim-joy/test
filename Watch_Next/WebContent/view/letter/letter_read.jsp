<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link type="text/css" href="<%=request.getContextPath() %>/Resources/css/letter_detail.css" rel="stylesheet" />
</head>
<body>
	<h2 style = color:red;>쪽지함</h2>
	<hr color='red'>
	<h4 style = color:white;>보낸 이 : </h4>
	<h4 style = color:white;>받는 이 : </h4>
	<h4 style = color:white;>제목 : </h4>
	<textarea cols="50" rows="20" style="overflow-y:scroll; resize: none;"></textarea>
	<br>
	<div id="letter_send_btn_area">
		<button onclick="location.href='letterMain.jsp'" id="letter_detail_btn">돌아가기</button>
	</div>
</body>
</html>