<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/영화정보.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>
<!-- 영화 정보 페이지 -->

	<div id="m_div">
	
	<h1 id="m_title">영화정보 게시판</h1>
	<hr class="hline">
	
	<form >
		<table id="m_movie">
			<tr>
				<td rowspan="4" id="m_td"><img src="/Watch_Next/Resources/images/p8.jpg" id="m_poster"></td>
				<th id="m_Name">문영</th>
				<td >
				<button id="m_want" onclick="mypage();">찜하기</button>
     				<script>
     					function mypage(){
     				
     					}
     			
     					/* $(function(){
     					$('#want').hover(function(){
     					$(this).css('background', 'white');
     					}, function(){
     					$(this).css('background', 'red');
     					}); */
     					
     				</script>
     				
     			</td>
     		</tr>
     		<tr>
     			<td id="m_info">카메라에 사람들의 얼굴을 담는 말 없는 소녀 '문영'추운 겨울, 술주정하는 아버지를 피해 뛰쳐나온 문영은연인과 울며 헤어지는 희수를 몰래 찍다가 들키게 되는데...
     				학교에서도, 집에서도 혼자이던 문영의 곁으로 희수가 들어온다.</td>
     			<td>
     			<a href="http://www.netflix.com" target="_blank"> <img src="/Watch_Next/Resources/images/넷플릭스.png" id="m_net" class="ci"> </a>
     				<a href="https://play.watcha.net"><img src="/Watch_Next/Resources/images/왓챠.png" id="m_wat"></a>
     				<a href="https://movie.naver.com"><img src="/Watch_Next/Resources/images/네이버 영화.png" id="m_wat"></a>
     			</td>
     		</tr>
     		
     		<tr>
     			<td id="m_review">
     			어쩌면 문영과 희수는 모두 그리움과 외로움 속에 사는 사람들인 것 같다.
     			</td>
     		</tr>
     		
		</table>
	</form>
	</div>
</section>


<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>