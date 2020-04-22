<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/view/layout/import.jsp" %>
<%@ include file="/view/layout/Header.jsp" %>
	<h1 align="center">요청에 실패하였습니다.</h1>
	<% String msg = (String)request.getAttribute("msg"); %>
	<h1 align="center">에러 내용 : <%= msg %></h1>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>