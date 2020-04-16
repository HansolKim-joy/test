<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Funding.model.vo.Demand"%>
<%  Demand d = (Demand)request.getAttribute("Demand");
	String fName = (String)request.getAttribute("fName");
	String genre = (String)request.getAttribute("genre");
	String smName = (String)request.getAttribute("smName");
	char chk = (char)request.getAttribute("chk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link type="text/css" href="/Watch_Next/Resources/css/demand_post.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>
	<!-- 수요조사 게시판 상세 -->
<div id="demandp">
	<h2 id="dh2"><strong>수요조사 게시판</strong></h2>
	<hr class="hline">
	
	<div id="box">
    
<div id="dcinema">
	<label id=dctitle>싱스트리트 재상영 수요조사</label>
</div>
  
<hr>

<div id="wInfo">
<table>
	<tr>
		<td width="850px" style="font-size:17px;"></td>
		<td width="150px" style="font-size:17px;">글쓴이 : <%=d.getUserId() %></td>
		<td width="70px" style="font-size:17px;" id="rpWriter">
			<ul>
				<li>
					<ul>
						<li><a href='#'>쪽지보내기</a></li>
						<li><a href='#'>팔로우하기</a></li>
					</ul>
				</li>
			</ul>
		</td>
		<td width="70px" style="font-size:17px;">날짜 : </td>
      	<td width="150px" style="font-size:17px;"><%=d.getStartDate() %></td>
	</tr>
</table>
</div>

<hr>

<div id="content">

  <div id="dposter">
  	<img id="dcposter" src="/Watch_Next/Resources/images/<%=fName%>"><br>
  </div>
  
  <br><br>
  <div id="dpinfo">
  <p style="font-size:15px;">
	
	지역 - <%=smName %><br>
	제목 - <%=d.getMovieTitle() %><br>
	장르 - <%=genre %><br>
	감독 - <%=d.getMovieDirector() %><br>
	배우 - <%=d.getMovieActor() %><br><br>

	줄거리 -  <%=d.getMovieStory() %><br><br>
	</p>
		
	<div id="minPeople">
	<p style="font-size:15px;">
	최소인원 - <%=d.getMinPeople() %>명</p>
	</div>

	</div>
</div>

	<!-- 기대돼요 신고버튼 -->
<br><br>
<div id="btn">
<%if(loginUser != null){ %>
	<%if(chk == 'N' || chk == 0){ %>
	<!-- 보고싶어요 했는지 안했는지 검사 -->
	<button id="want" onclick="onWant();">보고싶어요</button>
	<%}else if(chk == 'Y'){%>
	<button id="wantcancel" onclick="onNoWant();">보고싶어요</button>
	<%} %>
	<script>
		function onWant(){
			location.href="<%=request.getContextPath()%>/demand.putWant?no=<%=d.getdNo()%>&userId=<%=d.getUserId()%>";
		}
		function onNoWant(){
			location.href="<%=request.getContextPath()%>/demand.notWant?no=<%=d.getdNo()%>&userId=<%=d.getUserId()%>";
		}
	</script>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#" target="_self">
		<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
			onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop',
								'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">
	</a>
<%} %>
	<br>
	<h2><%=d.getSmWant() %>명이 보고싶어합니다.</h2>
</div>


</div>


    
    <!-- 목록수정삭제 버튼 -->
<div id=listbtn>
	<%if(d.getUserId().equals(loginUser.getUserId())){ %>
	<button type=button onclick="location.href='<%=request.getContextPath()%>/updatePage.de?no=<%=d.getdNo()%>'" title="수정" >수정</button>&nbsp;&nbsp;&nbsp;
    <button type=button onclick="demdel();" title="삭제" >삭제</button>&nbsp;&nbsp;&nbsp;
	<script>
		function demdel(){
			if(confirm('정말 삭제하시겠습니까?') == true){
				location.href="<%=request.getContextPath()%>/delete.de?no=<%=d.getdNo()%>";
			}
		}
	</script>
	<%} %>
    <button onclick="location.href='<%=request.getContextPath()%>/list.de'" type=button title="목록" >목록</button>
</div>

</div>

</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>