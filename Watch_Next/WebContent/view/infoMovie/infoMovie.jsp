<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="MovieBoard.model.vo.Movie, MovieBoard.model.vo.Review"%>
<% Movie m = (Movie)request.getAttribute("Movie"); 
   Review r = (Review)request.getAttribute("Review");
   String serviceSite[] = m.getServiceSite().split(", ");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="<%=request.getContextPath() %>/Resources/css/infoMovie.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>
<!-- 영화 정보 페이지 -->

	<div id="m_div">
	
	<h1 id="m_title">영화정보 게시판</h1>
	<hr class="hline">
	
	<form >
		<table id="m_movie">
			<tr>
				<td rowspan="4" id="m_td"><img src="<%=request.getContextPath() %>/Resources/images/<%=m.getFileNewName() %>" id="m_poster"></td>
				<th id="m_Name"><%=m.getMovieTitle() %></th>
				<td >
				<button id="m_want" onclick="mypage();">찜하기</button>
     				<script>
     					function mypage(){
     				
     					}
     			
     					/* $(function(){
     					$('#want').hover(function(){
     					$(this).css('background', 'white');
     					}, function(){
     					$(this).css('background', 'red');
     					}); */
     					
     				</script>
     				
     			</td>
     		</tr>
     		<tr>
     			<td id="m_info"><%=m.getStory() %></td>
     			<td>
     				<%for(int i=0; i<serviceSite.length; i++){
     					if(serviceSite[i].equals("3")){%>
     				<a href="http://www.netflix.com" target="_blank"> <img src="/Watch_Next/Resources/images/넷플릭스.png" id="m_net" class="ci"> </a>
     					<%} 
     					if(serviceSite[i].equals("2")){%>
     				<a href="https://play.watcha.net" target="_blank"><img src="/Watch_Next/Resources/images/왓챠.png" id="m_wat"></a>
     					<%} 
     					if(serviceSite[i].equals("1")){%>
     				<a href="https://movie.naver.com" target="_blank"><img src="/Watch_Next/Resources/images/네이버 영화.png" id="m_wat"></a>
     					<%}
     				  }%>
     			</td>
     		</tr>
     		
     		<tr>
     			<td id="m_review">
     			<%if(r != null){%>
     			<!-- 리뷰 내용 -->
     			<%=r.getReviewContent() %>
     			<%}else{ %>
     			리뷰가 없습니다.
     			<%} %>
     			</td>
     		</tr>
     		
		</table>
	</form>
	</div>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>