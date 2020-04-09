<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/review_list.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>

	<!-- 리뷰 게시판 목록 -->
<br clear="all">

<div id="reviewList">
	<h2><strong>리뷰 게시판</strong></h2>
	<hr class="hline">
	
	
	<table>
	<tr>
		<th id="num">번호</th>
		<th id="rlcategory">
			<ul>
				<li>
					말머리▼
					<ul>
						<li><a href='#'>스포있음</a></li>
						<li><a href='#'>스포없음</a></li>
					</ul>
				</li>
			</ul>
		</th>
		<th id="title">리뷰 제목</th>
		<th id="popcorn">팝콘 점수</th>
		<th id="date">날짜</th>
		<th id="writer">글쓴이</th>
		<th id="hits">조회</th>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>
	<tr>
		<td>166</td>
		<td>스포있음</td>
		<td>리뷰제목입니다</td>
		<td>★★★☆☆</td>
		<td>2020-03-20</td>
		<td>아이디</td>
		<td>6</td>
	</tr>

	</table>
	
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

<input id="write" type="button" value="글쓰기">


<!-- 검색 -->
<br clear="left">

<div id="searchDiv">
<form id="searchForm" action="" method="get">
	<select id="searchType">
		<option value="all">영화제목</option>
		<option value="subject">라뷰제목</option>
		<option value="writer">작성자</option>
		<option value="contents">내용</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;

	<input id="blank" type="text" size="35" id="searchText" value="">&nbsp;
	<input id="botSearch" type="submit" value="검색"/>
</form>
</div>

</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>