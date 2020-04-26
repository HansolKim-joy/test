<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, create.model.vo.*, movie.model.vo.*"%>
    
<%
	ArrayList<Create> list = (ArrayList<Create>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<CFile> flist = (ArrayList<CFile>)request.getAttribute("fList");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>창작목록</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/창작목록.css" rel="stylesheet" />
<style>
	.pagingArea{margin-top:30px; margin-bottom:50px;}
	#searchType{font-size:14px; height:25px;}
	#searchInput{font-size:14px; height:20px;}
</style>
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>

<br clear="all">
<section>

<!-- 창작게시판 -->

	
	<div id="c_div">
<!-- 	<form id="s_form"> -->
	<h2 id="c_title">창작 게시판</h2>
	
	<hr class="hline">
	
	<br>
	
	<span id="c_s_1">당신의 리뷰가 큰 도움이 됩니다!</span>
	
	<!-- 창작 글 선택 목록 -->
	<form action="<%=request.getContextPath() %>/list.cr" method="get">
		<select onchange="this.form.submit()" name="sk2" id='c'>
	  		<option ${(param.sk2=="최신순")?"selected":""} value='최신순'>최신순</option>
	  		<option ${(param.sk2=="추천순")?"selected":""} value='추천순'>추천순</option>
		</select>
	</form>	


	
	<br>
	
	<!-- 창작글 목록 -->
	<table id="ta1">
		<tr>
			<th class="t" id="c_t_1" height=80px>글 번호</th>
			<th class="t" id="c_t_2" colspan="2">영화 내용</th>
			<th class="t" id="c_t_3">내용</th>
			<th class="t" id="c_t_4">등록일</th>
			<th class="t" id="c_t_5">조회수</th>
			<th class="t" id="c_t_6">기대되요</th>
			<th class="t" id="c_t_7">댓글수</th>	
		</tr>
		<% if(list.isEmpty()) {%>
			<tr>
				<td colspan="7">조회된 리스트가 없습니다.</td>
			</tr>
		<% } else { 
			for(Create c : list) {
		%> 
		

		
		<tr>
		<% for(int j=0; j<flist.size(); j++) {
			CFile f = flist.get(j);
			
			if(c.getbNO() == f.getbNo()) { %>
			<td rowspan="2" class="c_td1"><%= c.getbNO() %></td>
			<td rowspan="2" class="c_td2"><img src="<%=request.getContextPath()%>/Resources/crethumb_uploadFiles/<%= f.getNewNames() %>" width="200px" height="150px" class="c_poster"></td>
			<td class="c_td3"><%= c.getbTitle() %><br></td>
			<td rowspan="2" width=30px class="c_td4" ><div id="conEllipsis"><%=c.getbContent() %></div></td>
			<td rowspan="2" class="c_td5"><%=c.getcDate() %></td>
			<td rowspan="2" class="c_td6"><%=c.getbCount() %></td>
			<td rowspan="2" class="c_td7"><%=c.getcLike() %></td>
			<td rowspan="2" class="c_td8"><%=c.getComm() %></td>
			<tr>
			<td class="c_td3"><%= c.getcDirector() %></td>
		</tr>
		
			
		<% } %>
		<% } %>
			<% }%>
			 <%} %>	
		
		</table>
<!-- 		</form> -->
	</div>
	
		<!-- 페이징 -->	

	<div class="pagingArea" align="center">
	<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.cr?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.cr?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
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
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.cr?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/list.cr?currentPage=<%= currentPage + 1 %>'">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					$('#afterBtn').attr('disabled', 'true');
				}
			</script>
			
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.cr?currentPage=<%= maxPage %>'">&gt;&gt;</button>
	</div>
	
	<!-- 글쓰기 -->
	<% if(loginUser != null){ %>
		<input id="write" type="button" value="글쓰기" class="myButton"
			   onclick="location.href='<%= request.getContextPath() %>/view/create/createWrite.jsp'">
	<% } %>
	
	<!-- 검색조건 -->
	<div id="c_d_3">
	<form action="<%=request.getContextPath() %>/list.cr" method="get">
		<select id="searchType" name="sk">
	  		<option ${(param.sk=="전체")?"selected":""} value="전체">전체</option>
	  		<option ${(param.sk=="제목")?"selected":""} value='제목'>제목</option>
	  		<option ${(param.sk=="감독")?"selected":""} value='감독'>감독</option>
	  		<option ${(param.sk=="내용")?"selected":""} value="내용">내용</option>
		</select>
			
		<input type="text" id="searchInput" name="sv" value="${param.sv}">
		<input id="botSearch" type="submit" value="검색"/>
	</form>
	
	</div>
	




	<script>
		$(function(){
			
				
				$('#ta1 td').mouseenter(function(){
					$(this).parent().css('cursor', 'pointer');
				}).click(function(){
					var cNo = $(this).parent().children().eq(0).text();
					
				    if('<%= loginUser %>' != 'null' && cNo != '조회된 리스트가 없습니다.'){
			            location.href="<%= request.getContextPath() %>/detail.creat?cNo="+cNo;
			         } else if('<%= loginUser %>' != 'null' && cNo == '조회된 리스트가 없습니다.'){
			            alert('리스트가 없습니다!');
			         } else{
			            alert('로그인 해주세요^^');
			         }
			         

				});
			});
	
	</script>
</section>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>