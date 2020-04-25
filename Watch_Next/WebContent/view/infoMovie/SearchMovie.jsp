<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="movie.model.vo.*, review.model.vo.Review, java.util.ArrayList"%>
<% ArrayList<Movie> m = (ArrayList<Movie>)request.getAttribute("Movie");
   ArrayList<String> fName = (ArrayList<String>)request.getAttribute("fName");
   ArrayList<String> genre = (ArrayList<String>)request.getAttribute("genre");
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
	<input type="hidden" id="chk" value="4">
	<h1 id="m_title">영화검색 결과 <%=m.size()%> 개</h1>
	<hr class="hline">
			<table id="m_movie">
			<%for(int i=0; i<m.size(); i++){ %>
				<%if(i > 3){ %>
				<tr class="<%=i%>" style="display:none;">
				<%}else{%>
				<tr>
				<%} %>
					<td style="width:140px;"></td>
					<td id="m_td">
					<a href="<%=request.getContextPath()%>/detail.mo?movieTitle=<%= m.get(i).getmTitle()%>&no=<%=m.get(i).getmNo()%>">
					<img src="<%=request.getContextPath() %>/Resources/images/<%=fName.get(i) %>" id="m_poster">
					</a>
					</td>
					<th id="m_info" style="vertical-align: top;">
					<font size="50px"><%=m.get(i).getmTitle() %></font>
					<br>
					<br>장르 : <%=genre.get(i)%>
	     			<br>감독 : <%=m.get(i).getmDirector() %>
	     			<br>배우 : <%=m.get(i).getmActor() %>
	     			<br>상영 시간 : <%=m.get(i).getmRunningTime() %>
	     			<br>국가 : <%=m.get(i).getmCountry() %>
					</th>
	     		</tr>
	     		<%if(i > 3){ %>
				<tr class="<%=i%>" style="display:none;">
				<%}else{%>
				<tr>
				<%} %><td><br></td></tr>
	     	<%} %>
			</table>
	</div>
</section>
	<%if(m.size() > 4){ %>
	<button id="more_btn" type="button" style="margin-left:50%;"onclick="More();">더보기</button>
	<%} %>
<script>
	function More(){
		var chk = document.getElementById("chk");
		for(var i = 4; i<chk.value*1+6; i++){
			console.log(chk.value = <%=m.size()%>);
			if(chk.value = <%=m.size()%>){
				document.getElementById("more_btn").style.display="none";
			}
			document.getElementsByClassName(i)[0].style.display="";
			document.getElementsByClassName(i)[1].style.display="";
		}
		chk.value = chk.value*1+6;
	}
</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
