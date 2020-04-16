<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, recruit.model.vo.*"  %>
<%
	ArrayList<Recruit> list = (ArrayList<Recruit>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Recruit> cList = (ArrayList<Recruit>)request.getAttribute("cList");
	
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

<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<link type="text/css" href="/Watch_Next/Resources/css/recruit_list.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
	<br clear="all">
	
	<section>
	
		<!-- 모집 게시판 목록 -->
	<br clear="all">
	
		<div id="recruit">
		<h2><strong>모집 게시판</strong></h2>
			<hr class="hline">
			<table>
			<tr>
				<th id="num">번호</th>
				<th id="rccategory">말머리</th>
				<th id="title">글 제목</th>
				<th id="date">날짜</th>
				<th id="writer">글쓴이</th>
				<th id="hits">조회</th>
			</tr>
			<tr>
			<% if(list.isEmpty()) { %>
				<td colspan="6">조회된 리스트가 없습니다.</td>
			</tr>
			<% } else { %>
				<% for(Recruit r : list) { %>
			<tr>
				<td><%=r.getrNo() %></td>
				<td><%=r.getrHead() %></td>
				<td><%=r.getbTitle() %></td>
				<td><%=r.getbDate() %></td>	
				<td><%=r.getUserId() %></td>
				<td><%=r.getbViews() %></td>
				
			</tr>
				<% } %>
			<% } %> 
				</table>
		</div>
	
		<br><br><br><br>
	<!-- 페이징 -->
		<div class="list_number" align="center">
		<% if(!list.isEmpty()){ %>
		
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.recruit?currentPage=1'"> &gt;</button>
			
			<!-- 이전 페이지 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%= currentPage - 1 %>'" id="before">&gt;</button>
				<script>
					if(<%= currentPage %> <=1){
						$('#before').attr('disable', 'true');
						}	
				</script>
		
			<!-- 10개 페이지 목록 -->
				<% for(int p = startPage; p <= endPage; p++){ %>
					<% if(p == currentPage){ %>
						<button id="ch" disabled><%= p %></button>
					<%} else { %>
						<button id="num" onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%=p %>'"><%= p %></button>
					<%} %>
				<% } %>
				
			<!-- 다음 페이지로 -->
				<button id="after" onclick="location.href='<%=request.getContextPath() %>/list.recruit?currenPage=<%= currentPage + 1 %>'">&gt;</button>
					<script>
						if(<%= currentPage %> >= <%= maxPage %>){
							$('#after').attr('disable', 'true');
						}
					</script>
			
			<!-- 맨 끝으로 -->
				<button onclick="location.href='<%=request.getContextPath() %>/list.recruit?currentPage=<%= maxPage %>'">&gt;&gt;</button>
		<% } %>
	   
		   		<div class="search" align="right">
		   			 <% if(loginUser != null){ %> 
		   				 <button onclick="location.href='view/recruit/recruitWrite.jsp'" id="write">작성하기</button>
		   		 <% } %>   
		   		</div>  
		</div>
	
	<script>
		$(function(){
			$('#recruit td').mouseenter(function(){
				$(this).parent().css('cursor', 'pointer');
			}).click(function(){
				
				var rNo = $(this).parent().children().eq(0).text();
				 if('<%= loginUser %>' != 'null'){
					location.href='<%= request.getContextPath() %>/detail.recruit?rNo=' +rNo;
				}else{
					alert('로그인 해주세요.');
				}
			})
		});
		
	</script> 
	 
	<!-- 검색 -->
	<br clear="left">
	
	<div id="searchDiv">
	<form id="searchForm" action="<%=request.getContextPath() %>/list.recruit" method="get">
		<select id="searchType" name="searchType">
			<option value="all" selected >전체보기</option>
			<option value="netflix" >NETFLIX</option>
			<option value="watcha" >WATCHA</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
	
		<input id="blank" type="text" size="35" id="searchText" value="">&nbsp;
		<input id="botSearch" type="button" value="검색"/>
	</form>
	</div>
	<script>
		$('#botSearch').click(function(){
			var choice = $('#searchType').val();
			console.log(choice);
			$.ajax({
				url: 'list.recruit',
				data: {choice:choice},
				success : function(data){
					console.log(data);
				}
			});
		});
	
	</script>
	</section>


<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%= request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
