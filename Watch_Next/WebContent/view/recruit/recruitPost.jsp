<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/recruit_post.css" rel="stylesheet" >
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>

<!-- 모집 게시판 상세 -->
<div id="recruitp">
	<h2 id="rh2"><strong>모집 게시판</strong></h2>
	<hr class="hline">
	
	<div id="box">
    
<div id="now">
	<b>WATCHA</b>&nbsp;&nbsp;&nbsp;<label id=rctitle>왓챠 세달 같이보실분 구해요</label>
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
	<p style="font-size:15px;">
		옷을 위하여서 미인을 구하기 위하여서 그리하였는가? 아니다 그들은 커다란 이상 곧 만천하의 대중을 품에 안고 그들에게 밝은 길을 찾아 주며 그들을 행복스럽고 평화스러운 곳으로 인도하겠다는 커다란 이상을 품었기 때문이다 그러므로 그들은 길지
		<br><br><br><br><br><br><br><br><br><br>
	</p>
</div>

	<!-- 신고버튼 -->
<div id="btn">
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
<tr><th>김땡땡</th>
	<td><button type=button id=report onclick="window.open('reportPop.html', 'pop', 
												'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">신고</button></td></tr>
<tr><td colspan="2" style="font-size:14px;">공감합니다</td></tr>
</table>
</div>
	
</div>	

</section>


<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>