<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="letter.model.vo.Letter, member.model.vo.Member"%>
<%	Letter l = (Letter)request.getAttribute("letter"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel= "stylesheet" type="text/css" href="/Watch_Next/Resources/css/a_tag.css">
<link type="text/css" href="<%=request.getContextPath() %>/Resources/css/letter_detail.css" rel="stylesheet" />
<script>
	$(function(){
		self.resizeTo(550,650);
	});
</script>
</head>
<body>
	<h2 style = color:red;>쪽지함</h2>
	<hr color='red'>
	<h4 style = color:white;>보낸 이 : <%=l.getUserName() %></h4>
	<h4 style = color:white;>받는 이 : <%=l.getUserId() %></h4>
	<h4 style = color:white;>제목 : <%=l.getMsg_Title() %></h4>
	<textarea cols="60" rows="15" style="overflow-y:scroll; resize: none;" readonly><%=l.getMsg_Content() %></textarea>
	<br>
	<div id="letter_send_btn_area">
		<button onclick="location.href='<%=request.getContextPath()%>/letter.view'" id="letter_detail_btn">돌아가기</button>
	</div>
</body>
</html>