<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/funding_post.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>
	<!-- 펀딩 게시판 상세 -->
<br clear="all">

<div id="funding">
	<h2 id="fh2"><strong>펀딩 게시판</strong></h2>
	<hr class="hline">

	<div id="box">
    
<div id="cinema">
	<b>압구정 CGV</b>&nbsp;&nbsp;&nbsp;<label id=ftitle>타이타닉 재상영</label>
</div>
  
<hr>

<div id="wInfo">
<table>
	<tr>
		<td width="850px"></td>
		<td width="80px" style="font-size:17px;">글쓴이 : </td>
      <td width="70px" style="font-size:17px;" id="fpWriter">
         <ul>
            <li>
                kimhs
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
   <p style="font-size:15px;">
		<div id="fundingBox">
		<table id="fundingTable">
			<tr><td rowspan=7 width="500px"><img id="reposter" src="/Watch_Next/Resources/images/titanic.jpg"></td>
				<td rowspan=7 width="100px"></td></tr>
			<tr>
				<td id="dday">14일남음</td>
			</tr>
			<tr>
				<td id="ddaybar" height="30px">
					<div class="fbar">
					<span id="fcurrent"></span>
				</div>
				</td>
			</tr>
			<tr>
				<td>
					<b>30%</b>&nbsp;&nbsp;<label id=percentage>달성</label>
				</td>
			</tr>
			<tr>
				<td>
					<b>300,000</b>&nbsp;&nbsp;<label id=sum>원 펀딩</label>
				</td>
			</tr>
			<tr>
				<td>
					<b>28</b>&nbsp;&nbsp;<label id=supporter>명의 서포터</label>
				</td>
			</tr>
			<tr>
				<td height="40px">
					<input id="fundingSubmit" type="submit" value="펀딩하기">
				</td>
			</tr>
			
			
		</table>
		</div>
		
		<br>
		<div id="info">
		<p>
			지역 - 서울 압구정CGV<br>
			제목 - 타이타닉<br>
			장르 - 멜로/로맨스<br>
			감독 - 제임스 카메론<br>
			배우 - 레오나르도 디카프리오, 케이트 윈슬렛<br><br>

줄거리 - 우연한 기회로 티켓을 구해 타이타닉호에 올라탄 자유로운 영혼을 가진 화가 잭(레오나르도 디카프리오)은
 막강한 재력의 약혼자와 함께 1등실에 승선한 로즈(케이트 윈슬렛)에게 한 눈에 반한다.
 진실한 사랑을 꿈꾸던 로즈 또한 생애 처음 황홀한 감정에 휩싸이고, 둘은 운명 같은 사랑에 빠지는데…<br><br>
		</p>
		
		<div id="maxPeople">
		최대수용인원 - 100명
		</div>
		
		</div>
		
		
		<br><br><br><br><br><br><br><br><br><br>
</div>

    </div>
 
    <div id=listbtn>
        <button type=button title="수정" >수정</button>
        <button type=button title="삭제" >삭제</button>&nbsp;&nbsp;&nbsp;
        <button onclick="location.href='#'"
        		type=button title="목록" >목록</button>
    </div>

</div>	

</section>


<!--footer-->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>