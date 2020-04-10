<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/전체 영화.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">
2222222222222222222222222222222
<section>

<!-- 전체영화목록  -->
	<div id="m_a">
	
	<h2 id="m_title">전체 영화</h2>
	
	<select id='m_choice'>
  		<option value='' selected>-- 선택 --</option>
  		<option value='오름차순'>오름차순</option>
  		<option value='내림차순'>내림차순</option>
	</select>
	
	<hr class="hline">
	</div>
	<br><br>
	
	<table  id="m_poster">
		<tr>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
		</tr>
		
		<tr>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
		</tr>
		
		<tr>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
			<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th class="m_t"><img src="/Watch_Next/Resources/images/p1.jpg" class="m_p"><br>1917</th>
		</tr>
		
	</table>
	
	
	<!-- 페이징 -->	
	
	<div class="list_number">
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
	</div>

</section>	
<br><br><br>

	<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>