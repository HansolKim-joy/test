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
				<td id = "btns">
				<%for(int i=0; i<serviceSite.length; i++){
     					if(serviceSite[i].equals("3")){%>
     				<a href="http://www.netflix.com" target="_blank"> <img src="/Watch_Next/Resources/images/넷플릭스.png" id="m_wat"></a>
     					<%} 
     					if(serviceSite[i].equals("2")){%>
     				<a href="https://play.watcha.net" target="_blank"><img src="/Watch_Next/Resources/images/왓챠.png" id="m_wat"></a>
     					<%} 
     					if(serviceSite[i].equals("1")){%>
     				<a href="https://movie.naver.com" target="_blank"><img src="/Watch_Next/Resources/images/네이버 영화.png" id="m_net" class="ci"></a>
     					<%}
     				  }%>
				<%if(loginUser != null){ %>
					<%if(d == null){ %>
					<button id="m_want" onclick="myDib();">찜하기</button>
	     				<script>
	     					function myDib(){
	     						location.href="<%=request.getContextPath()%>/movie.dib?id=<%=loginUser.getUserId()%>&no=<%=m.getmNo()%>&title=<%=m.getmTitle()%>";
	     					}
	     				</script>
	     			<%}else{ %>
					<button id="m_want" onclick="delDib();">찜풀기</button>
	     				<script>
	     					function delDib(){
	     						location.href="<%=request.getContextPath()%>/del.dib?id=<%=loginUser.getUserId()%>&no=<%=m.getmNo()%>&title=<%=m.getmTitle()%>";
	     					}
	     				</script>
	     			<%} %>
	     		<%} %>
	     		</td>
     		</tr>
     		<tr>
     			<td id="m_info">장르 : <%=genre%>
     			<br>감독 : <%=m.getmDirector() %>
     			<br>배우 : <%=m.getmActor() %>
     			<br>상영 시간 : <%=m.getmRunningTime() %>
     			<br>국가 : <%=m.getmCountry() %>
     			<br>장르 : <%=genre %>
     			<br><br>줄거리 : <%=m.getmStory() %></td>
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
					<a class="a_tag" href="<%=request.getContextPath()%>/detail.rv?rv=<%=r.getbNo()%>"><%=r.getbContent()%></a>
				</div>
     			<%}else{ %>
     			리뷰가 없습니다.
     			<%} %>
     			</td>
     		</tr>
		</table>
	</div>
	<div>
		<%if(loginUser != null && loginUser.getAdminYN().equals("Y")){ %>
     		<button id="m_delete" type="button" onclick="m_delete();">영화 삭제</button>
     		<script>
     			function m_delete(){
     				if(confirm("정말 삭제하시겠습니까?") == false){
     					return false;
     				}else{
     					location.href="<%=request.getContextPath()%>/delete.mo?no=<%=m.getmNo()%>";
     				}
     			}
     		</script>
     	<%} %>
	</div>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
