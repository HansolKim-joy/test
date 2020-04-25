<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, movie.model.vo.*, common.PageInfo"%>
<%
	request.setCharacterEncoding("UTF-8");
	ArrayList<Movie> mlist = (ArrayList<Movie>)request.getAttribute("mlist");
	ArrayList<String> fNameList = (ArrayList<String>)request.getAttribute("fNameList");
	int choice = 0;
	if(request.getAttribute("choice") != null){
		choice = (int)request.getAttribute("choice");
	}
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = 1;
	int maxPage = 1;
	int startPage = 1;
	int endPage = 1;
	if(pi != null){
		currentPage = pi.getCurrentPage();
		maxPage = pi.getMaxPage();
		startPage = pi.getStartPage();
		endPage = pi.getEndPage();
	}
	int moviecheck = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link type="text/css" href="/Watch_Next/Resources/css/hedaer_footer.css" rel="stylesheet" />
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
  		<option value='0' selected>-- 선택 --</option>
  		<option value='1'>오름차순</option>
  		<option value='2'>내림차순</option>
	</select>
	<script>
		$(function(){
			$('#m_choice').val("<%=choice%>");
		});
		$('#m_choice').change(function(){
			var choice = $('#m_choice option:selected').val();
			if(choice == 1){
				location.href="<%=request.getContextPath()%>/movie.all?currentPage=<%=currentPage%>&choice=1";
			}else if(choice == 2){
				location.href="<%=request.getContextPath()%>/movie.all?currentPage=<%=currentPage%>&choice=2";
			}
		});
	</script>
	<hr class="hline">
	</div>
	<br><br>
	
	<table id="m_poster">
		<%if(mlist.isEmpty()){ %>
			<tr>
				<th colspan="5" class="m_t">조회된 리스트가 없습니다.</th>
			</tr>
		<%} else{%>
			<% for(int i=0; i<mlist.size(); i++){
				String title = mlist.get(i).getmTitle();
				if(title.length() > 12){
					title = title.substring(0,11) + "...";
				}
				String director = mlist.get(i).getmDirector();
				if(director.length() > 12){
					director = director.substring(0,11) + "...";
				}
				String actor = mlist.get(i).getmActor();
				if(actor.length() > 12){
					actor = actor.substring(0,11) + "...";
				}%>
				<%if(moviecheck % 5 == 1){%>
					<tr>
				<%} %>
						<td class="m_t">
							<a class="a_tag" href="<%=request.getContextPath()%>/detail.mo?movieTitle=<%= mlist.get(i).getmTitle()%>&no=<%=mlist.get(i).getmNo()%>">
								<img src="<%=request.getContextPath() %>/Resources/images/<%=fNameList.get(i)%>" class="m_p">
								<br>&emsp;<b><%= title%></b>
								<br>&emsp;<%= director%>
								<br>&emsp;<%= actor%>
							</a>
						</td>
				<%if(moviecheck % 5 == 0){%>
					</tr>
				<%} %>
			<% moviecheck++;} %>
		<%} %>
	</table>
	
	
	<!-- 페이징 -->	
	
	<!-- <div class="list_number">
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a></div>
	</div> -->
	
	<!-- 페이징 -->
			<div class="list_n_menu">
			<%if(!mlist.isEmpty()){ %>
				<!-- 맨 처음으로 -->
				<a class="prev" href='<%=request.getContextPath()%>/movie.all?currentPage=1&choice=<%=choice%>'>&lt;&lt;</a>
				<!-- 이전 페이지로 -->
				<a id="beforeBtn" class="prev" href='<%=request.getContextPath()%>/movie.all?currentPage=<%=currentPage - 1 %>&choice=<%=choice%>'>&lt;</a>
				<script>
					if(<%= currentPage %> <= 1){
						$('#beforeBtn').css({ 'pointer-events': 'none' });
					}
				</script>
				
				<!-- 10개 페이지 목록 -->
				<% for(int p = startPage; p<=endPage; p++){ %>
					<%if(p == currentPage){ %>
						<span class="current" id="choosen"><%= p %></span>
					<%} else{%>
						<a href='<%=request.getContextPath()%>/movie.all?currentPage=<%= p %>&choice=<%=choice%>'><%= p %></a>
					<%} %>
				<%} %>
				<!-- 다음 페이지로 -->
				<a id = "afterBtn" href='<%=request.getContextPath()%>/movie.all?currentPage=<%=currentPage + 1 %>&choice=<%=choice%>'>&gt;</a>
				<script>
					if(<%= currentPage %> >= <%=maxPage%>){
						$('#afterBtn').css({ 'pointer-events': 'none' });
					}
				</script>
				<!-- 맨 끝으로 -->
				<a href='<%=request.getContextPath()%>/movie.all?currentPage=<%=maxPage%>&choice=<%=choice%>'>&gt;&gt;</a>
			<% } %>
			</div>

</section>	
<br><br><br>

	<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
