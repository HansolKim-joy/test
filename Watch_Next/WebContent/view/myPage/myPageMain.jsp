<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
	#mypage{
		font-size: 30px;
		color: white;
	}
	.hline{
		border: 2px solid red;
	}
	#mypage_form{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#send{
		float: right;
		margin-top: -20px;
		height: 30px;
		width: 50px;
	}
	#mp_tabled{
		font-size: 19px;
		text-align: -webkit-center;
	}
	#mp_table{
		background-color: black;
		color: white;
	}
	.mp_first{
		width: 230px;
		border-bottom: 1px solid white;
		border-right: 1px solid white;
	}
	.mp_second{
		text-align: center;
		width: 400px;
		border-bottom: 1px solid white;
	}
	#mp_second{
		text-align: center;
	}
	#mp_info{
		text-align: center;
		color: white;
		font-size: 18px;
	}
	#mp_update{
		margin-top: -20px;
		float: right;
		height: 25px;
		width: 80px;
		font-size: 15px;
		border-radius: 20px;
	}
	.mp_hline{
		border: 1px solid red;
	}
	.mp_content{
		margin-top: 20px;
		text-align: center;
		color: white;
		font-size: 17px;
	}
	.mp_button{
		width: 23px;
		height: 23px;
		border-radius: 50%;
	}
	.mp_h_content{
		display: none;
		height: 200px;
		border: 1px solid black;
	}
	
	.mp_middle{
		height: 10px;
	}
</style>
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

	<section>
		<!-- 마이페이지 -->
		<div id="mypage_form">
			<h2 id="mypage">마이페이지</h2>
			<hr class="hline">
			
			<div id="mp_info"><%= loginUser.getUserName() %>님의 마이페이지입니다.</div>
			<a href="message.html"><img id="send" src="/Watch_Next/Resources/images/쪽지.png"></a>
			<br>
			<br>
			<form id="mp_profile" class="mp_profile" action="/Watch_Next/view/myPage/checkUser.jsp" method="post">
				<div id="mp_tabled">
					<table id="mp_table">
						<tr>
							<td class="mp_first">아이디</td>
							<td class="mp_second" height="30px"><%= loginUser.getUserId() %></td>
						</tr>
						<tr>
							<td class="mp_first">이름</td>
							<td class="mp_second" height="30px"><%= loginUser.getUserName() %></td>
						</tr>
						<tr>
							<td class="mp_first">전화번호</td>
							<td class="mp_second" height="30px"><%= loginUser.getPhone() %></td>
						</tr>
						<tr>
							<td class="mp_first">이메일</td>
							<td class="mp_second" height="30px"><%= loginUser.getEmail() %></td>
						</tr>
						<tr>
							<td>메일링 서비스 여부</td>
							<td id="mp_second" height="30px"><%= loginUser.getMailingYN() %></td>
						</tr>
					</table>
				</div>
				<button type="submit" id="mp_update">정보수정</button>
			</form>
			<br><br><br>
			<hr class="mp_hline">
			
			<div id="mp_content1" class="mp_content">참여한 펀딩 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button1" class="mp_button">+</button>
				<div class="mp_middle"></div>
				<div id="mp_h_content1" class="mp_h_content"> 내용</div>
			</div>
			<div id="mp_content2" class="mp_content">내 팔로우 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button2" class="mp_button">+</button>
				<div class="mp_middle"></div>
				<div id="mp_h_content2" class="mp_h_content"> 내용</div>
			</div>
			<div id="mp_content3" class="mp_content">참여한 펀딩 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button3" class="mp_button">+</button>
				<div class="mp_middle"></div>
				<div id="mp_h_content3" class="mp_h_content"> 내용</div>
			</div>
			<div id="mp_content4" class="mp_content">참여한 펀딩 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button4" class="mp_button">+</button>
				<div class="mp_middle"></div>
				<div id="mp_h_content4" class="mp_h_content"> 내용</div>
			</div>
			<div id="mp_content5" class="mp_content">참여한 펀딩 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button5" class="mp_button">+</button>
				<div class="mp_middle"></div>
				<div id="mp_h_content5" class="mp_h_content"> 내용</div>
			</div>
		</div>
	</section>
	<script>
		$(function(){
			$('#mp_button1').click(function(){
				$('#mp_h_content1').slideToggle();
			});
			$('#mp_button2').click(function(){
				$('#mp_h_content2').slideToggle();
			});
			$('#mp_button3').click(function(){
				$('#mp_h_content3').slideToggle();
			});
			$('#mp_button4').click(function(){
				$('#mp_h_content4').slideToggle();
			});
			$('#mp_button5').click(function(){
				$('#mp_h_content5').slideToggle();
			});
			
		});
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>