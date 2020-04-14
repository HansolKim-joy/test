<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, movie.model.vo.*, common.PageInfo%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Movie> mlist = (ArrayList<Movie>)request.getAttribute("mlist");
	ArrayList<String> fNameList = (ArrayList<String>)request.getAttribute("fNameList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	int moviecheck = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link type="text/css" href="/Watch_Next/Resources/css/hedaer_footer.css" rel="stylesheet" />
<link type="text/css" href="/Watch_Next/Resources/css/hedaer_footer(AFTER).css" rel="stylesheet" />
<link type="text/css" href="/Watch_Next/Resources/css/login.css" rel="stylesheet" />
<!--페이지에 적용되는 css넣기 -->
<link rel= "stylesheet" type="text/css" href="/Watch_Next/Resources/css/a_tag.css">
<link type="text/css" href="<%=request.getContextPath()%>/Resources/css/allMovie.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

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
	
	<table id="m_poster">
		<%if(mlist.isEmpty()){ %>
			<tr>
				<th colspan="5" class="m_t">조회된 리스트가 없습니다.</th>
			</tr>
		<%} else{%>
			<% for(int i=0; i<mlist.size(); i++){%>
				<%if(moviecheck % 6 == 0 || moviecheck == 1){%>
					<tr>
				<%} %>
				<th class="m_t"><a class="a_tag" href="<%=request.getContextPath()%>/search.mo?movieTitle=<%= mlist.get(i).getmTitle()%>"><img src="<%=request.getContextPath() %>/Resources/images/<%=fNameList.get(i)%>" class="m_p"><br><%= mlist.get(i).getmTitle()%></a></th>
				<%if(moviecheck % 5 == 0){%>
					</tr>
				<%} %>
			<% moviecheck++;} %>
		<%} %>
	</table>
	
	
	<!-- 페이징 -->	
	<!-- 
	<div class="list_number">
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
	</div> -->	
	
	<!-- 페이징 -->
		<div class="pagingArea" align="center">
		<%if(!mlist.isEmpty()){ %>
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/Movie.all?currentPage=1'">&lt;&lt;</button>
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/Movie.all?currentPage=<%=currentPage - 1 %>'" id="beforeBtn">&lt;</button>
			<script>
				if(<%= currentPage %> <= 1){
					$('#beforeBtn').attr("disabled", "true");
				}
			</script>
			
			<!-- 10개 페이지 목록 -->
			<% for(int p = startPage; p<=endPage; p++){ %>
				<%if(p == currentPage){ %>
					<button id="choosen" disabled><%= p %></button>
				<%} else{%>
					<button id="numBtn" onclick="location.href='<%=request.getContextPath()%>/Movie.all?currentPage=<%= p %>'"><%= p %></button>
				<%} %>
			<%} %>
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%=request.getContextPath()%>/Movie.all?currentPage=<%=currentPage + 1 %>'">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%=maxPage%>){
					$('#afterBtn').attr("disabled", "true");
				}
			</script>
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/Movie.all?currentPage=<%=maxPage%>'">&gt;&gt;</button>
		<% } %>
		</div>

</section>	
<br><br><br>

	<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
