<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ include file="/view/layout/import.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"/> 
<link type="text/css" href="/Watch_Next/Resources/css/demand_list.css" rel="stylesheet" />
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>

	<!-- 수요조사 목록 -->
<br clear="all">

<div id="dem">
	<h2><strong>수요조사</strong></h2>
	<hr class="hline">

	
	<div id="sel">
		<a href="#"><img src="/Watch_Next/Resources/images/cgv.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/메가박스.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/롯데.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/피카디리.png" class="cinema"></a>
	</div>
	
	<div id="allview">전체보기</div>
	
	<div id="selSearch">
		<input type="text" placeholder='검색어를 입력하세요'>
		<button id="sbtn">검색</button>&nbsp;&nbsp;&nbsp;
		
		<select>
	  		<option value='' selected>전체</option>
	  		<option value='압구정 CGV'>압구정 CGV</option>
	  		<option value='COEX MEGABOX'>COEX MEGABOX</option>
	  		<option value='강남역 롯데시네마'>강남역 롯데시네마</option>
	  		<option value='종로 피카디리'>종로 피카디리</option>
		</select>
		<select>
	  		<option value='' selected>선택</option>
	  		<option value='추천순'>추천순</option>
	  		<option value='인기순'>인기순</option>
	  		<option value='마감 임박순'>마감 임박순</option>
		</select>
	</div>
		
	<hr class="hline">
	
	<div id="demdiv">
	
	<!-- 진행상황 -->
	<div id = "poster1">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p1.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	<div id = "poster2">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p2.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	<div id = "poster3">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p3.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	
	<br clear="left">
	
	<div id = "poster4">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p4.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	<div id = "poster5">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p5.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	<div id = "poster6">
		<table>
			<tr><td colspan="2"><img class="poster" src="/Watch_Next/Resources/images/p6.jpg"></td></tr>
			<tr><td colspan="2">
				<div class="bar">
					<span id="current"></span>
				</div>
			</td></tr>
			<tr><td id="dDay">22일남음</td><td id="percent">60%달성</td></tr>
		</table>
	</div>
	
	
	</div>
	
	
</div>

<!-- 페이징 -->
<div class="list_number">
    <div>
        <div class="list_n_menu">
        <span class="prev"><  이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
    </div>
</div>

<!-- 글쓰기 -->
<input id="write" type="button" value="글쓰기" onclick="goUrl('');" />
</section><br>

<br>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>