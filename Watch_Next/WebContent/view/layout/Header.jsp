<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!-- 헤더 -->
<header>
	<div class="nav">
		<div class="navi_set">
			<div class="topnav">
				<a href="<%=request.getContextPath()%>/index.jsp"><img id="logo" src="/Watch_Next/Resources/images/logo.png"></a>
			</div>
		</div>
		<div class="navi_set">
			<div class="topnav">영화</div>
			<ul class="subnav">
				<li>정보</li>
				<li>추천</li>
			</ul>
		</div>

		<div class="navi_set">
			<div class="topnav">게시판</div>
			<ul class="subnav">
				<li onclick="location.href='/Watch_Next/view/review/reviewWrite.jsp'">리뷰 게시판</li>
				<li>모집 게시판</li>
				<li>창작 게시판</li>
			</ul>
		</div>

		<div class="navi_set">
			<div class="topnav">펀딩</div>
			<ul class="subnav">
				<li>수요조사</li>
				<li>펀딩참여</li>
			</ul>
		</div>
	</div>
	<div class="nav2">
		<form autocomplete="off" method="post" id="header_action">
			<div class="navi_set2">
				<div class="container-4">
					<input type="search" name="search" id="search"
						placeholder="검색어를 입력하세요.." />
					<button class="icon">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<div class="navi_set2">
				<div class="topnav2">
					<a href="/Watch_Next/view/pages/loginForm.jsp" class="a_tag">로그인</a>
				</div>
			</div>
			<div class="navi_set2">
				<div class="topnav2">
					<a href="/Watch_Next/view/pages/JoinForm.jsp" class="a_tag">회원가입</a>
				</div>
			</div>
		</form>
	</div>
</header>
<script>
	$(function(){
		$('.icon').click(function(){
			$("#header_action").attr("action", "<%=request.getContextPath()%>/search.mo?movieTitle=" + $("#search").val());
		});
	});
</script>
<br clear="all">
