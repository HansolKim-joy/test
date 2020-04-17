<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="recruit.model.vo.*, java.util.ArrayList" %>
<%
	Recruit r = (Recruit)request.getAttribute("board"); 
	Member m = (Member)request.getAttribute("m");
	ArrayList<Comment> comment = (ArrayList<Comment>)request.getAttribute("comment");
	
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
				<td width="90px" style="font-size:17px;">글쓴이 : </td>
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
		      	<td width="90px" style="font-size:17px;">조회수 : </td>
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
			
		    <% if(loginUser != null && loginUser.getUserId().equals(r.getUserId())) { %>
		    	<button type="submit" id="update" value="수정">수정</button>
		    	<button type="button" id="delete" onclick="deleteRe();" value="삭제">삭제</button>
		   <% } %>
		    	<div onclick="location.href='<%= request.getContextPath() %>/list.recruit'" id="menu"
		    		style="background-color:red; color:white;
				border:none; border-radius:5px; 
				width:50px; height:25px; font-size:14px; text-align:center;" >목록</div>
		</div>

    </div>
    </form>

    
    	<!-- 댓글 -->
	<div id="replybox1">
		<table>
			<tr>
				<td>
					<textarea id="reply_content" name="reply_content" rows="2" cols="167"  
				  placeholder="댓글을 입력하세요." ></textarea>
				</td>
				<td>
					
					<button id="reply_save">댓글 작성</button>
				</td>
			</tr>
		</table>
	</div>
	
	
	<br clear="all">
	<div id="replybox2">
		<table>
			<% if(comment.isEmpty()) { %>
				<tr><td colspan=3 style="font-size:14px; text-align:center">댓글이 없습니다.</td></tr>
			<% } else { %>
				<% for(int i = 0; i < comment.size(); i++){ %>
				<tr>
					<th><%= comment.get(i).getrWriter() %></th>
					<td>
						<% if(loginUser != null && loginUser.getUserId().equals(comment.get(i).getrWriter())) { %>
						<button type="button" id="deleteComment" onclick="dCo();" style="margin-top:10px; margin-left:90%; background-color:red; color:white; 
								font-size:13px; border:none; border-radius:5px;">삭제</button>
						<% } else {%>
						<button type=button id=report onclick="window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
							'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">신고</button>
							<% } %>
					</td>
				</tr>
				<tr>	
					<td colspan=2 style="font-size:14px">
						<%= comment.get(i).getrContent() %>
					</td>
				</tr>
					
				<% } %>
			<% } %>	
			</table>
		</div>
		
	</div>
	
	</section>
	
	<script>
			function deleteRe(){
				var d = confirm('게시글을 삭제하시겠습니까?');
				
					if(d){
						location.href="<%=request.getContextPath() %>/delete.recruit?rNo=" + <%=r.getrNo() %>;
					}
			}
			
			function dCo(){
				var de = confirm('댓글을 삭제하시겠습니까?');
				
				if(de){
					location.href="<%=request.getContextPath() %>/delete.comment";
				}
			}
			
				$('#reply_save').click(function(){
				var writer = '<%= loginUser.getUserId() %>';
				var rNo = '<%= r.getrNo() %>';
				var content = $('#reply_content').val();
				
				if($('#reply_content').val(); == null){
					alert("댓글을 작성해주세요");
				}else{
					alert("댓글 작성 완료");
				}
				
				$.ajax({
					url : 'insertComment.recruit',
					data : {writer:writer, content:content, rNo:rNo},
					success: function(data){
						$replyTable = $('#replySelectTable');
						$replyTable.text("");
						
						console.log(data);
						
						for(var key in data){
							var $tr = $('<tr>');
							var $writerTd = $('<td>').text(data[key].rWriter).css('color','red');
							var $contentTd = $('<td>').text(data[key].rContent).css('font-size','14px');
							
							$tr.append($writerTd);
							$tr.append($contentTd);
							$replyTable.append($tr);
						}
						
						$('#reply_content').val("");
						
						$("#replySelectTable").load(window.location.href + " #replySelectTable");
					}
				});
			});
		</script>

<!— footer —>
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>
