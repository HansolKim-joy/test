<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link type="text/css" href="<%=request.getContextPath() %>/Resources/css/letter.css" rel="stylesheet" />
</head>
<body>
<h2 style = color:red;>쪽지함 (받은 쪽지)</h2>
<hr color='red'>
<ul id="letter_top">
	<li><a href="#">받은 쪽지</a></li>
	<li><a href="#">보낸 쪽지</a></li>
	<li>쪽지 ?통/전체 ?통</li>
</ul>
<button onclick="location.href='letter_send.jsp'" id="letter_send">보내기</button>
<br clear="all">
<hr color='red' size='3'>
<table id="letter_list">
	<tr>
		<td id="l_l_choise">선택</td>
		<td id="l_l_nick">닉네임(아이디)</td>
		<td id="l_l_name">제목</td>
		<td id="l_l_time">받은시간</td>
		<td>상태</td>
	</tr>
</table>
<br><br>
<!-- 쪽지 목록 DB불러오는거 이양식대로 -->
<form action="/watch_next/letter_delete.do">
	<div id = "letter_contents">
		<table id = "letter_table">
			<tr>
				<td id = "l_t_choise"><input type="checkbox" id="letter_checkbox"></td>
				<td id = "l_t_nick">qkrtlsdn(rory)</td>
				<td id = "l_t_name">qkrtlsmary)</td>
				<td id = "l_t_time">qkrtlsmary)</td>
				<td>qkrtlsmary)</td>
			</tr>
			<tr>
				<td id = "l_t_choise"><input type="checkbox" id="letter_checkbox"></td>
				<td id = "l_t_nick">qkrtlsdn(rory)</td>
				<td id = "l_t_name">qkrtlsmary)</td>
				<td id = "l_t_time">qkrtlsmary)</td>
				<td>qkrtlsmary)</td>
			</tr>
			<tr>
				<td id = "l_t_choise"><input type="checkbox" id="letter_checkbox"></td>
				<td id = "l_t_nick">qkrtlsdn(rory)</td>
				<td id = "l_t_name">qkrtlsmary)</td>
				<td id = "l_t_time">qkrtlsmary)</td>
				<td>qkrtlsmary)</td>
			</tr>
		</table>
		<p id="letter_paging">
		&emsp;<a href="#">←</a>
		&emsp;<a href="#">1</a>
		&emsp;<a href="#">2</a>
		&emsp;<a href="#">3</a>
		&emsp;<a href="#">→</a>
		</p>
		<br>
		<input type="submit" value="삭제" id="letter_delete" class="letter_delete">
		<b id="letter_delete">선택한쪽지&emsp;</b>
		<script type="text/javascript">
			$('.letter_delete').click(function(){
				confirm('정말 삭제하시겠습니까?');
			});
		</script>
	</div>
</form>


</body>
</html>