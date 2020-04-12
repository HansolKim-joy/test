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
<link type="text/css" href="/Watch_Next/Resources/css/create_post.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>


	<!-- 창작 게시판 상세 -->
<div id="createp">
	<h2 id="ch2"><strong>창작 게시판</strong></h2>
	<hr class="hline">
	
	<div id="box">
    
<div id="cfilm">
	<label id=cctitle>댄스영화 유월</label><label id=ccdirector>&nbsp;/&nbsp;베프</label>
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

  <div id="film">
  	<iframe width="560" height="315" src="https://www.youtube.com/embed/zOXFqZ9rGUo"></iframe><br>
  </div>
  
  <br><br>
  <div id="cpinfo">
  <p>
	
	■ 영 화 명 : 유월<br>
	■ 제 작 사 : 한국예술종합학교 영화과 예술사 졸업작품워크샵<br>
	■ 감    독 : 베프<br>
	■ 줄거리 : 한시도 몸을 가만두지 않고 춤추는 소년 유월은 어느날 사립초등학교에 발발한 집단무용증(a.k.a. 댄스바이러스)의 원흉으로 지목당하며, 질서에 목매는 담임선생 혜림과 옆반 선생들에게 추격당하기 시작하는데… 

	</p>

	</div>
</div>

	<!-- 기대돼요 신고버튼 -->
<br><br>
<div id="btn">
	<button id="expect" onclick="alert('기대돼요를 눌렀습니다')">기대돼요</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#" target="_self">
		<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
			onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop', 
								'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">
	</a>
</div>


</div>


    
    <!-- 목록수정삭제 버튼 -->
<div id=listbtn>
	<button type=button title="수정" >수정</button>
    <button type=button title="삭제" >삭제</button>&nbsp;&nbsp;&nbsp;
    <button onclick="location.href='reviewList.html'"
        		type=button title="목록" >목록</button>
</div>

    	<!-- 댓글 -->
<div id="replybox1">
<textarea id="reply_content" name="reply_content" rows="2" cols="167" 
		  placeholder="댓글을 입력하세요." style="resize: none; border:none;"></textarea>
</div>
<button id="reply_save" onclick="alert('댓글작성 완료')">댓글 작성</button>

<br clear="all">
<div id="replybox2">
<table>
<tr><th>한나나</th>
	<td><button type=button id=report onclick="window.open('reportPop.html', 'pop', 
												'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">신고</button></td></tr>
<tr><td colspan="2" style="font-size:14px;">재밌게 보고갑니다</td></tr>
</table>
</div>
	
</div>	

</div>


</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>