<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>창작목록</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/창작목록.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>

<br clear="all">
<section>

<!-- 창작게시판 -->
	
	<div id="c_div">
	<form id="s_form">
	<h2 id="c_title">창작 게시판</h2>
	
	<hr class="hline">
	
	<br>
	
	<span id="c_s_1">당신의 리뷰가 큰 도움이 됩니다!</span>
	
	<!-- 창작 글 선택 목록 -->
	<select id='c'>
  				<option value='' selected>선택</option>
  				<option value='추천순'>추천순</option>
  				<option value='최신순'>최신순</option>
			</select>
	
	<br>
	
	<!-- 창작글 목록 -->
	<table id="ta1">
		<tr>
			<td class="t" id="c_t_1">글 번호</td>
			<th class="t" id="c_t_2" colspan="2">영화 내용</th>
			<th class="t" id="c_t_3">내용</th>
			<th class="t" id="c_t_4">등록일</th>
			<th class="t" id="c_t_5">조회수</th>
			<th class="t" id="c_t_6">기대되요</th>
			<th class="t" id="c_t_7">댓글수</th>	
		</tr>
		<tr>
			<td rowspan="2" class="c_td1">100</td>
			<td rowspan="2" class="c_td2"><img src="/Watch_Next/Resources/images/7.jpg" class="c_poster"></td>
			<td class="c_td3">Seven<br></td>
			<td rowspan="2" class="c_td4">7대죄악에 대한 이야기</td>
			<td rowspan="2" class="c_td5">2020-01-13</td>
			<td rowspan="2" class="c_td6">6</td>
			<td rowspan="2" class="c_td7">59</td>
			<td rowspan="2" class="c_td8">67</td>
			<tr>
			<td class="c_td3">데이빗핀쳐</td>
		</tr>
		
		<tr>
			<td rowspan="2" class="c_td1">100</td>
			<td rowspan="2" class="c_td2"><img src="/Watch_Next/Resources/images/7.jpg" class="c_poster"></td>
			<td class="c_td3">Seven<br></td>
			<td rowspan="2" class="c_td4">‘식탐’, ‘탐욕’… 그리고 ‘나태’, ‘분노’, ‘교만’, ‘욕정’. ‘시기’ 윌리엄 소머셋은 현장에 남은 흔적들로 기나긴 연쇄 살인이 
			시작되었음을 직감하고 성서의 7가지 죄악을 따라 발생하는 사건들을 추적하기 시작하는데… 가장 치밀한 일곱 개의 연쇄살인이 시작된다!</td>
			<td rowspan="2" class="c_td5">2020-01-13</td>
			<td rowspan="2" class="c_td6">6</td>
			<td rowspan="2" class="c_td7">59</td>
			<td rowspan="2" class="c_td8">67</td>
			<tr>
			<td class="c_td3">데이빗핀쳐</td>
		</tr>
		<tr>
			<td rowspan="2" class="c_td1">100</td>
			<td rowspan="2" class="c_td2"><img src="/Watch_Next/Resources/images/7.jpg" class="c_poster"></td>
			<td class="c_td3">Seven<br></td>
			<td rowspan="2" class="c_td4">7대죄악에 대한 이야기</td>
			<td rowspan="2" class="c_td5">2020-01-13</td>
			<td rowspan="2" class="c_td6">6</td>
			<td rowspan="2" class="c_td7">59</td>
			<td rowspan="2" class="c_td8">67</td>
			<tr>
			<td class="c_td3">데이빗핀쳐</td>
		</tr>
		<tr>
			<td rowspan="2" class="c_td1">100</td>
			<td rowspan="2" class="c_td2"><img src="/Watch_Next/Resources/images/7.jpg" class="c_poster"></td>
			<td class="c_td3">Seven<br></td>
			<td rowspan="2" class="c_td4">7대죄악에 대한 이야기</td>
			<td rowspan="2" class="c_td5">2020-01-13</td>
			<td rowspan="2" class="c_td6">6</td>
			<td rowspan="2" class="c_td7">59</td>
			<td rowspan="2" class="c_td8">67</td>
			<tr>
			<td class="c_td3">데이빗핀쳐</td>
		</tr>
		</table>
		</form>
	</div>
	
	<!-- 페이징 -->	
	
	<div class="list_number">
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
	</div>
	<br><br><br>
	
	<!-- 검색조건 -->
	<div id="c_d_3">
	<select>
		<option value='글번호'>글번호</option>
  		<option value='감독'>감독</option>
  		<option value='제목'>제목</option>
	</select>
	
	<input type="text">
	
	</div>

</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>