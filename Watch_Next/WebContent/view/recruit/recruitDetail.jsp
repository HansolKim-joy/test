<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="recruit.model.vo.*, java.util.ArrayList" %>
<%
	Recruit r = (Recruit)request.getAttribute("board"); 
	Member m = (Member)request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모집 글 상세보기</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
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
	<h2 style="color: white; font-size: 30px;">모집 게시판글 상세보기</h2>
	<hr class="hline">
	
	<form action="view/recruit/recruitUpdate.jsp" id="detailForm" name="detailForm">
		<div id="box">
	    
			<div id="now">
				<b>
				<%= r.getrHead() %>
				<input type="hidden" value="<%= r.getrHead() %>" name="rHead">	
				</b>&nbsp;&nbsp;&nbsp; 
				<input type="text" readonly="<%= r.getbTitle() %>" id=rctitle name="bTitle" value="<%= r.getbTitle() %>" style="border: 0;">
				
				<input type="hidden" name="rNo" value="<%=r.getrNo() %>">
				
			</div>
  
<hr>

<div id="wInfo">
<table>
	<tr>
		<td width="850px" style="font-size:17px;"></td>
		<td width="80px" style="font-size:17px;">글쓴이 : </td>
		<td width="70px" style="font-size:17px;" id="rpWriter">
			<input type="text" readonly="<%=r.getUserId() %>" name="userId" value="<%=r.getUserId()%>" style="border: 0;">
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
      	<td width="150px" style="font-size:17px;" >
      		<input type="text" readonly="<%=r.getbDate() %>" name="bDate" value="<%=r.getbDate()%>" style="border: 0;">
      	</td>
      	<td width="80px" style="font-size:17px;">조회수 : </td>
      	<td width="70px" style="font-size:17px;" >
      		<input type="text" readonly="<%=r.getbViews() %>" name="bViews"	value="<%= r.getbViews() %>" style="border:0;">
      	</td>
	</tr>
</table>
</div>

<hr>

<div id="content">
	<p style="font-size:15px;" >
		<input type="text" name="bContent" value="<%=r.getbContent() %>" style="border:0;">
		
	</p>
</div>

	<!-- 신고버튼 -->
<div id="btn">
	<button  >
		<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
			onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop', 
			'left'='+(screen.availWidth-500)/2+','top='+'(screen.availHeight-300)/2+', 'width=500px','height=300px')">
	</button>
</div>
	    <!-- 목록수정삭제 버튼 -->
 
		<div id=listbtn>
			<!-- <button type=button title="수정" >수정</button>
		    <button type=button title="삭제" >삭제</button>&nbsp;&nbsp;&nbsp;
		    <button onclick="location.href='reviewList.html'"
		        		type=button title="목록" >목록</button> -->
		    <% if(loginUser != null && loginUser.getUserId().equals(r.getUserId())) { %>
		    	<button type="submit" id="update" value="수정">수정</button>
		    	<button type="button" id="delete" onclick="deleteR();" value="삭제">삭제</button>
		   <% } %>
		    	<div onclick="location.href='<%= request.getContextPath() %>/list.recruit'" id="menu" >목록</div>
		</div>

    </div>
    </form>

    
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
	<td>
		<button type=button id=report onclick="window.open('reportPop.html', 'pop', 'left'='+(screen.availWidth-500)/2'+',top'='+(screen.availHeight-300)/2+',
				width=500px,height=300px')">신고</button>
	</td>
</tr>
<tr><td colspan="2" style="font-size:14px;">공감합니다</td></tr>
</table>
</div>
	
</div>	

<script>
	function deleteR(){
		var d = confirm('게시글을 삭제하시겠습니까?');
		
		if(d){
			location.href="<%=request.getContextPath() %>/delete.recruit?rNo=" + <%=r.getrNo() %>;
			
		}
	}
</script>

</section>


<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
