<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천게시판</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>
<script src="/Watch_Next/WebContent/Resources/js/rec_board.js"></script>
<link type="text/css" href="/Watch_Next/Resources/css/rec_board.css" rel="stylesheet" />
<script>
$(document).ready(function() {
    $(".p_slider").lightSlider({
    	item:5,
        mode:'slide',    // 이미지가 표시되는 형식 (fade / slide)
        loop:true,       // 무한반복 할 것인지
        auto:true,       // 자동 슬라이드
        keyPress:true,   // 키보드 탐색 허용
        pager:true,     // 페이지 표시
        speed:1500,      // 슬라이드 되는 속도
        pause:3000      // 이미지가 머무는 시간
    });
});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>

</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

	<section>
		<!-- 추천게시판 -->
		<div class="p_slide-wrap">
			<h2 id="rec_title">추천게시판</h2>
			<hr class="hline">
			<span class="rec_subtitle">추천 순</span>
			<div class="p_slide-content">
				<ul id="p_slider1" class="p_slider">
					<li class="p_item1">
						<h3>사과</h3>
					</li>
					<li class="p_item2">
						<h3>체리</h3>
					</li>
					<li class="p_item3">
						<h3>딸기</h3>
					</li>
					<li class="p_item4">
						<h3>포도</h3>
					</li>
					<li class="p_item5">
						<h3>레몬</h3>
					</li>
					<li class="p_item6">
						<h3>자몽</h3>
					</li>
				</ul>
			</div>
			<hr class="md_line">
			<span class="rec_subtitle">별점 순</span>
			<div class="p_slide-content">
				<ul id="p_slider2" class="p_slider">
					<li class="p_item1">
						<h3>사과</h3>
					</li>
					<li class="p_item2">
						<h3>체리</h3>
					</li>
					<li class="p_item3">
						<h3>딸기</h3>
					</li>
					<li class="p_item4">
						<h3>포도</h3>
					</li>
					<li class="p_item5">
						<h3>레몬</h3>
					</li>
					<li class="p_item6">
						<h3>자몽</h3>
					</li>
				</ul>
			</div>
			<hr class="md_line">
			<span class="rec_subtitle">이용자 최다 찜순</span>
			<div class="p_slide-content">
				<ul id="p_slider3" class="p_slider">
					<li class="p_item1">
						<h3>사과</h3>
					</li>
					<li class="p_item2">
						<h3>체리</h3>
					</li>
					<li class="p_item3">
						<h3>딸기</h3>
					</li>
					<li class="p_item4">
						<h3>포도</h3>
					</li>
					<li class="p_item5">
						<h3>레몬</h3>
					</li>
					<li class="p_item6">
						<h3>자몽</h3>
					</li>
				</ul>
			</div>
		</div>
	</section>


	<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>