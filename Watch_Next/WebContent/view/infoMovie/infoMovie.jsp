<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="movie.model.vo.*, review.model.vo.Review"%>
<% Movie m = (Movie)request.getAttribute("Movie");
   Review r = (Review)request.getAttribute("Review");
   Dib d = (Dib)request.getAttribute("Dib");
   String fName = (String)request.getAttribute("fName");
   String genre = (String)request.getAttribute("genre");
   String serviceSite[] = m.getService_Site().split(", ");%>
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
	
		<table id="m_movie">
			<tr>
				<td rowspan="4" id="m_td"><img src="<%=request.getContextPath() %>/Resources/images/<%=fName %>" id="m_poster"></td>
				<th id="m_Name"><%=m.getmTitle() %></th>
				<%if(loginUser != null){ %>
					<%if(d == null){ %>
					<td>
					<button id="m_want" onclick="myDib();">찜하기</button>
	     				<script>
	     					function myDib(){
	     						location.href="<%=request.getContextPath()%>/movie.dib?id=<%=loginUser.getUserId()%>&no=<%=m.getmNo()%>&title=<%=m.getmTitle()%>";
	     					}
	     				</script>
	     			</td>
	     			<%}else{ %>
	     			<td>
					<button id="m_want" onclick="delDib();">찜풀기</button>
	     				<script>
	     					function delDib(){
	     						location.href="<%=request.getContextPath()%>/del.dib?id=<%=loginUser.getUserId()%>&no=<%=m.getmNo()%>&title=<%=m.getmTitle()%>";
	     					}
	     				</script>
	     			</td>
	     			<%} %>
	     		<%} %>
     		</tr>
     		<tr>
     			<td id="m_info">장르 : <%=genre%><br>감독 : <%=m.getmDirector() %><br>배우 : <%=m.getmActor() %><br><br><%=m.getmStory() %></td>
     			<td>
     				<%for(int i=0; i<serviceSite.length; i++){
     					if(serviceSite[i].equals("3")){%>
     				<a href="http://www.netflix.com" target="_blank"> <img src="/Watch_Next/Resources/images/넷플릭스.png" id="m_wat"> </a>
     					<%} 
     					if(serviceSite[i].equals("2")){%>
     				<a href="https://play.watcha.net" target="_blank"><img src="/Watch_Next/Resources/images/왓챠.png" id="m_wat"></a>
     					<%} 
     					if(serviceSite[i].equals("1")){%>
     				<a href="https://movie.naver.com" target="_blank"><img src="/Watch_Next/Resources/images/네이버 영화.png" id="m_net" class="ci"></a>
     					<%}
     				  }%>
     			</td>
     		</tr>
     		
     		<tr>
     			<td id="m_review">
     			<%if(r != null){%>
     			<!-- 리뷰 내용 -->
     			<div style="  overflow: hidden;
									  text-overflow: ellipsis;
									  white-space: nowrap;
									  width: 100px;
									  height: 20px;">
									  <%=r.getbContent() %>
						</div>
     			<%}else{ %>
     			리뷰가 없습니다.
     			<%} %>
     			</td>
     		</tr>
     		
		</table>
	</div>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
