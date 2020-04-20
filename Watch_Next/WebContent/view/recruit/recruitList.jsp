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
			<table class="tablearea">
			<thead>
			<tr>
				<th id="num">번호</th>
				<th id="rccategory">말머리</th>
				<th id="title">글 제목</th>
				<th id="date">날짜</th>
				<th id="writer">글쓴이</th>
				<th id="hits">조회</th>
			</tr>
			</thead>
				<tbody id="tbody-area">
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
				</tbody>
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
	<form id="searchForm" action="<%=request.getContextPath() %>>/list.recruit" method="get">
		<select id="searchType" name="searchType">
			<option value="all" selected >전체보기</option>
			<option value="NETFLIX" >NETFLIX</option>
			<option value="WATCHA" >WATCHA</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		
		<select id="searchType2" name="searchType2">
			<option value="all" selected>전체</option>
			<option value="title">글제목</option>
			<option value="userId">작성자</option>
			<option value="content">내용</option>
		</select>
		
	
		<input id="blank" type="text" size="35" id="searchText">&nbsp;
		<input id="botSearch" type="button" value="검색">
	</form>
	</div>
	<script>
		$('#botSearch').click(function(){
			var choice = $('#searchType').val();
			var choice2 = $('#searchType2').val();
			var choice3 = $('#blank').val();
			if(choice3.trim().length == 0){
				choice3 = "blank"
			}
			console.log("choice " + choice);
			console.log("choice2 " + choice2);
			console.log("choice3 " + choice3);
			$.ajax({
				url: 'list.recruit',
				data: {choice:choice, choice2:choice2, choice3:choice3},
				success : function(data){
					$tablearea = $('#tbody-area');
					$tablearea.html("");
					
					console.log(data);
					
					if(data.length == 0){
						var $trnull = $('<tr><td colspan=6>조회된 리스트가 없습니다.</td></tr>');
						
						$('#tbody-area').append($trnull);
						
					}else {
						for(var key in data){
							var $tr = $('<tr></tr>'); 
							var $rNo = $('<td>').text(data[key].rNo);
							var $rHead = $('<td>').text(data[key].rHead);
							var $bTitle = $('<td>').text(data[key].bTitle);
							var $bDate = $('<td>').text(data[key].bDate);
							var $UserId = $('<td>').text(data[key].userId);
							var $bViews = $('<td>').text(data[key].bViews);
							
							$tr.append($rNo, $rHead, $bTitle, $bDate, $UserId, $bViews);
							$('#tbody-area').append($tr);
							
						}
						
						$('#tbody-area').val("");
					}
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
