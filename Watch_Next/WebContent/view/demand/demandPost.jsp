<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
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
		<td width="80px" style="font-size:17px;">글쓴이 : </td>
		<td width="70px" style="font-size:17px;" id="rpWriter">
			<ul>
				<li>
					kimsj
					<ul>
						<li><a href='#'>쪽지보내기</a></li>
						<li><a href='#'>팔로우하기</a></li>
					</ul>
				</li>
			</ul>
		</td>
		<td width="70px" style="font-size:17px;">날짜 : </td>
      	<td width="150px" style="font-size:17px;">2020-03-26</td>
      	<td width="80px" style="font-size:17px;">조회수 : </td>
      	<td width="70px" style="font-size:17px;">3</td>
	</tr>
</table>
</div>

<hr>


<div id="content">

  <div id="dposter">
  	<img id="dcposter" src="/Watch_Next/Resources/images/singstreet.jpg"><br>
  </div>
  
  <br><br>
  <div id="dpinfo">
  <p style="font-size:15px;">
	
	지역 - 서울 종로피카디리<br>
	제목 - 싱스트리트<br>
	장르 - 드라마 /로맨스<br>
	감독 - 존 카니<br>
	배우 - 페리다 월시-필로, 루시 보인턴<br><br>

	줄거리 -  첫 눈에 반한 그녀를 위한 인생 첫 번째 노래!
 	‘싱 스트리트’의 가슴 설레는 사운드가 지금 시작된다!<br><br>
	</p>
		
	<div id="minPeople">
	<p style="font-size:15px;">
	최소인원 - 10명</p>
	</div>

	</div>
</div>

	<!-- 기대돼요 신고버튼 -->
<br><br>
<div id="btn">
	<button id="want" onclick="alert('보고싶어요를 눌렀습니다')">보고싶어요</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#" target="_self">
		<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
			onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop', 
								'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">
	</a>
</div>


</div>


    
    <!-- 목록삭제 버튼 -->
<div id=listbtn>
    <button type=button title="삭제" >삭제</button>&nbsp;&nbsp;&nbsp;
    <button onclick="location.href='reviewList.html'"
        		type=button title="목록" >목록</button>
</div>

</div>

</section>


<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>