<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.*"  %>
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/review_list.css" rel="stylesheet" >
<style>
	.subnav li {width: 120px;}
 	#rlcategory li ul {
	font-weight:bold;
	font-size:18px;
	background: lightgray;
	display:none; 
	height:auto;
	padding:5px;
	border:0px;
	position:absolute;
	width:100px;
	z-index:200;
	color:red;
	}
	
	#rlcategory li:hover ul {
	display:block;
	} 
	
	.spo{border:none; background:transparent;}
	.spo:hover{border:none;}
</style>
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
	
	
	<table id="rvtable">
	<tr>
		<th id="num">번호</th>
		<th id="rlcategory">
			<ul>
				<li>
					말머리▼
					<ul>
						<li><button class="spo" id="spoY">스포있음</button></li>
						<li><button class="spo" id="spoN">스포없음</button></li>
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
	<% if(list.isEmpty()){ %>
	<tr>
		<td colspan="7">조회된 리스트가 없습니다.</td>
	</tr>
	<% } else{ 
		for(Review r : list){ 
	%>
	<tr>
		<td><%= r.getbNo() %></td>
		<td>
		<%if( r.getSpo().trim().equals("Y")) { %>
			스포있음
		<%} else { %>
			스포없음
		<% } %>	
		
		</td>
		<td align="left">[ <%= r.getmTitle() %> ] <%= r.getbTitle() %></td>
		<td>
			<% if(r.getPopcorn() ==1) { %>
				★☆☆☆☆
			<%} else if(r.getPopcorn() ==2) { %>
				★★☆☆☆
			<%} else if(r.getPopcorn() ==3) { %>
				★★★☆☆
			<%} else if(r.getPopcorn() ==4) { %>
				★★★★☆
			<%} else if(r.getPopcorn() ==5) { %>
				★★★★★
			<%} %>
			
		
		</td>
		<td><%= r.getbDate() %></td>
		<td><%= r.getbWriter() %></td>
		<td><%= r.getbCount() %></td>
	</tr>
			<% }
		      }%>
		

	</table>
	
</div>

<!-- 페이징 -->
	<div class="pagingArea" align="center">
	<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.rv?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.rv?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
			<script>
				if(<%= currentPage %> <= 1){
					$('#beforeBtn').attr('disabled', 'true');
				}
			</script>
			
			<!-- 10개 페이지 목록 -->
			<% for(int p = startPage; p <= endPage; p++){ %>
				<% if(p == currentPage){ %>
					<button id="choosen" disabled><%= p %></button>
				<% } else { %>
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.rv?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/list.rv?currentPage=<%= currentPage + 1 %>'">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					$('#afterBtn').attr('disabled', 'true');
				}
			</script>
			
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.rv?currentPage=<%= maxPage %>'">&gt;&gt;</button>
	</div>


<!-- 글쓰기 -->
<input id="write" type="button" value="글쓰기"
	   onclick="location.href='<%= request.getContextPath() %>/view/review_board/reviewWrite.jsp'">


<!-- 검색 -->
<br clear="left">

<div id="searchDiv">
<form id="searchForm" action="<%=request.getContextPath() %>/list.rv" method="get">
	<select id="searchType" name="sk">
		<option ${(param.sk=="전체")?"selected":""} value="전체">전체</option>
		<option ${(param.sk=="영화제목")?"selected":""} value="영화제목">영화제목</option>
		<option ${(param.sk=="리뷰제목")?"selected":""} value="리뷰제목">리뷰제목</option>
		<option ${(param.sk=="작성자")?"selected":""} value="작성자">작성자</option>
		<option ${(param.sk=="내용")?"selected":""} value="내용">내용</option>
	</select>&nbsp;&nbsp;&nbsp;&nbsp;

	<input id="blank" name="sv" type="text" size="35" id="searchText" value="${param.sv}">&nbsp;
	<input id="botSearch" type="submit" value="검색"/>
</form>
</div>

</section>

<script>
	
	$(function(){
		$('#reviewList td').mouseenter(function(){
			$(this).parent().css('cursor', 'pointer');
		}).click(function(){
			var rv = $(this).parent().children().eq(0).text();
			location.href="<%= request.getContextPath() %>/detail.rv?rv="+rv;
		})
	});
	
	$('#spoY').click(function(){
		var spo = "Y";
		$.ajax({
			url: 'list.spo',
			data: {spo:spo},
			success : function(data){
				console.log("ysuccess");
				console.log(data);
				
				$reviewTable = $('#rvtable');
				$reviewTable.text("");
			
				for(var key in data) {
					var $tr = $('<tr>');
					var $yno = $('<td>').text(data[key].bNo);
					var $yspo = $('<td>').text(data[key].spo);
					var $yrtitle = $('<td>').text(data[key].bTitle);
					var $ypopcorn = $('<td>').text(data[key].popcorn);
					var $ydate = $('<td>').text(data[key].bDate);
					var $ywriter = $('<td>').text(data[key].bWriter);
					var $yview = $('<td>').text(data[key].bCount);
					
					console.log($yno);
					
					$tr.append($yno);
					$tr.append($yspo);
					$tr.append($yrtitle);
					$tr.append($ypopcorn);
					$tr.append($ydate);
					$tr.append($ywriter);
					$tr.append($yview);
					$reviewTable.append($tr);
				}
				
				
				
				$("#rvtable").load(window.location.href + " #rvtable");
				
				
			} 
			
		});
	});
	
	$('#spoY').click(function(){
		var spo = "N";
		$.ajax({
			url: 'list.rv',
			data: {spo:spo},
			success : function(data){
				console.log("nsuccess");
				console.log(data);
				
				$reviewTable = $('#rvtable');
				$reviewTable.text("");
			
				for(var key in data) {
					var $tr = $('<tr>');
					var $yno = $('<td>').text(data[key].bNo);
					var $yspo = $('<td>').text(data[key].spo);
					var $yrtitle = $('<td>').text(data[key].bTitle);
					var $ypopcorn = $('<td>').text(data[key].popcorn);
					var $ydate = $('<td>').text(data[key].bDate);
					var $ywriter = $('<td>').text(data[key].bWriter);
					var $yview = $('<td>').text(data[key].bCount);
					
					console.log($yno);
					
					$tr.append($yno);
					$tr.append($yspo);
					$tr.append($yrtitle);
					$tr.append($ypopcorn);
					$tr.append($ydate);
					$tr.append($ywriter);
					$tr.append($yview);
					$reviewTable.append($tr);
				}
				
				
				
				$("#rvtable").load(window.location.href + " #rvtable");
				
				
			} 
			
		});
	});
	
</script>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>