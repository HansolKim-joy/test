<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/펀딩목록.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>
	<br clear="all">
<section>

	<!-- 펀딩목록 -->
	
	<div id="funding">
	<h2 id="f_h2">펀딩목록</h2>

	<hr class="hline">
	
	<div id="sel">
		<a href="#"><img src="/Watch_Next/Resources/images/cgv.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/메가박스.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/롯데.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/피카디리.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/제작.jpg" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/상영회.png" class="cinema"></a>
	</div>
	
	<br>
	
	<span id="allview">전체보기</span>
	
	<span id="selSearch">
		<input type="text" placeholder='검색어를 입력하세요'>
		<button id="sbtn">검색</button>&nbsp;&nbsp;
		
		<select>
	  		<option value='' selected>전체</option>
	  		<option value='압구정 CGV'>압구정 CGV</option>
	  		<option value='COEX MEGABOX'>COEX MEGABOX</option>
	  		<option value='강남역 롯데시네마'>강남역 롯데시네마</option>
	  		<option value='종로 피카디리'>종로 피카디리</option>
	  		<option value='제작비 지원'>제작비 지원</option>
	  		<option value='상영회'>상영회</option>
		</select>
		<select>
	  		<option value='' selected>선택</option>
	  		<option value='추천순'>추천순</option>
	  		<option value='인기순'>인기순</option>
	  		<option value='마감 임박순'>마감 임박순</option>
		</select>
	</span>
		
	<hr class="hline">
	
	
	<!-- 진행상황 -->
	<form>
		<table id="f_t">
			<tr class="f_tr1">
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p1.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p2.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p3.jpg"></td>
			</tr>
			<tr class="f_tr2">
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>
			</tr>
			<tr class="f_tr3">
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
			</tr>
			<tr class="f_tr4">
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p4.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p7.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p8.jpg"></td>
			</tr>
			<tr class="f_tr2">
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>	
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>	
				<td colspan="2">
					<div class="bar">
						<span id="current"></span>
					</div>
				</td>	
			</tr>
			<tr class="f_tr3">
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
			</tr>
		</table>
	
	</form>
	<br>
	</div>
	
	<!-- 페이징 -->	
	<div class="list_number">
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
	</div>
	
	<br><br><br>
	

</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>