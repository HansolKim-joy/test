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
<title>모집 게시판</title>
<link type="text/css" href="/Watch_Next/Resources/css/recruit_list.css" rel="stylesheet" >

<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
	/*사이드바 */
#sidebar{
	position: fixed;
	width: 100px;
	height: 700px;
	left: 94%;
	top: 15%;
}
#sidebar a{
	color: #545357;
}
#mlink{
	border: 1px solid;
 	width: 80px; 
	height: 80px;
	margin-bottom: 4px;
}
#topbtn{
	text-align: center;
	font-weight: bold;
	background-color: yellow;
}

#footer{margin-top: 5.6%;}
</style>

</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
	<br clear="all">
	
<div id="sidebar">
	<table>
		<tr>
			<td><a href="https://play.watcha.net/" target="_blank"><img src="Resources/images/왓챠.png" id="mlink" class="mwha"></a></td>
		</tr>
		<tr>
			<td><a href="https://www.netflix.com/kr/" target="_blank"><img src="Resources/images/넷플릭스.png" id="mlink" class="mnet"></a></td>
		</tr>
		<tr>
			<td><a href="https://movie.naver.com/" target="_blank"><img src="Resources/images/네이버 영화.png" id="mlink" class="mnav"></a></td>
		</tr>
		<tr>
			<td><a href="#" target="_self"><img src="Resources/images/top.png" id="mlink" ></a></td>
		</tr>
	
	</table>
</div>	
	
	<section>
	
		<!-- 모집 게시판 목록 -->
	<br clear="all">
	
		<div id="recruit">
		<h2 style="font-size: 30px; margin-top: 10%; margin-bottom: 2%;"><strong>모집 게시판</strong></h2>
			<hr class="hline">
			<table class="tablearea">
			<thead>
			<tr id="tr">
				<th id="num" height ="100px;">번호</th>
				<th id="rccategory">모집사이트</th>
				<th id="title">글 제목</th>
				<th id="date">날짜</th>
				<th id="writer">글쓴이</th>
				<th id="hits">조회</th>
			</tr>
			</thead>
				<tbody id="tbody-area">
					<tr>
					<% if(list.isEmpty()) { %>
						<td colspan="6" style="height: 330px; font-size: 30px">조회된 리스트가 없습니다.</td>
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
	

   		
	<!-- 페이징 -->
	<div class="pagingArea" align="center">
	<!-- 맨 처음으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%= currentPage - 1 %>'" id="beforeBtn">&lt;</button>
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
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%= currentPage + 1 %>'">&gt;</button>
			<script>
				if(<%= currentPage %> >= <%= maxPage %>){
					$('#afterBtn').attr('disabled', 'true');
				}
			</script>
			
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.recruit?currentPage=<%= maxPage %>'">&gt;&gt;</button>
	</div>
	   
	
	<script>
	$(function(){
		$('#recruit td').mouseenter(function(){
			$(this).parent().css('cursor', 'pointer');
		}).click(function(){
			var rv = $(this).parent().children().eq(0).text();
			
			if('<%= loginUser %>' != 'null' && rv != '조회된 리스트가 없습니다.'){
				location.href="<%= request.getContextPath() %>/detail.recruit?rNo="+rv;
			} else if('<%= loginUser %>' != 'null' && rv == '조회된 리스트가 없습니다.'){
				alert('리스트가 없습니다!');
			} else{
				alert('로그인 해주세요^^');
			}
			
		});
	});
		
	</script> 
	
	 	<div class="search">
   			 <% if(loginUser != null){ %> 
   				 <button onclick="location.href='view/recruit/recruitWrite.jsp'" id="write" class="myButton">작성하기</button>
   		 <% } %>   
   		</div>  
   		
	<!-- 검색 -->
	<br clear="left">
	
	<div id="searchDiv">
	<form id="searchForm" action="<%=request.getContextPath() %>>/list.recruit" method="get">
		<select id="searchType" name="searchType">
			<option value="all" selected >전체보기</option>
			<option value="NETFLIX" >NETFLIX</option>
			<option value="WATCHA" >WATCHA</option>
		</select>&nbsp;&nbsp;&nbsp;
		
		<select id="searchType2" name="searchType2">
			<option value="all" selected>전체보기</option>
			<option value="title">글제목</option>
			<option value="userId">작성자</option>
			<option value="content">내용</option>
		</select>
		
	
		<input id="blank" type="text" size="35" id="searchText">&nbsp;
		<input id="botSearch" type="button" value="검색" class="myButton">
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
