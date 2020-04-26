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
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<h1 align="center">죄송합니다. 요청에 실패하였습니다.</h1>
	<% String msg = (String)request.getAttribute("msg"); %>
	<h1 align="center">3초 뒤 이전페이지로 돌아갑니다.</h1>
	
	<h1 align="center">에러 내용 : <%= msg %></h1>
	<script>
	setTimeout("history.go(-1);", 3000);
  	</script>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>