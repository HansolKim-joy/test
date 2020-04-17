<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="recruit.model.vo.*, java.util.ArrayList, common.Comment" %>
<%
	Recruit r = (Recruit)request.getAttribute("board"); 
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
					
					<input id="rNo" type="hidden" name="rNo" value="<%=r.getrNo() %>">
				
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
			<input type="text" name="bContent" class= "content" value="<%=r.getbContent() %>" style="border:0;">
			
		</p>
	</div>

	<!-- 신고버튼 -->
	<div id="btn">
		
			<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
				onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop', 
				'left'='+(screen.availWidth-500)/2+','top='+'(screen.availHeight-300)/2+', 'width=500px','height=300px')">
		
	</div>
	    <!-- 목록수정삭제 버튼 -->
 
		<div id=listbtn>
			
		    <% if(loginUser != null && loginUser.getUserId().equals(r.getUserId())) { %>
		    	<button type="submit" id="update" value="수정">수정</button>
		    	<button type="button" id="delete" onclick="deleteRe();" value="삭제">삭제</button>
		   <% } %>
		    	<button onclick="location.href='<%= request.getContextPath() %>/list.recruit'" id="menu"
		    		style="background-color:red; color:white;
				border:none; border-radius:5px; 
				width:50px; height:25px; font-size:14px; text-align:center;" >목록</button>
		</div>

    </div>
    </form>

    
    	<!-- 댓글 -->
	<div id="replybox1" >
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
		<table id="replySelectTable" class="Comment">
			<% if(comment.isEmpty()) { %>
				<tr><td colspan=3 style="font-size:14px; text-align:center">댓글이 없습니다.</td></tr>
			<% } else { %>
				<% for(int i = 0; i < comment.size(); i++){ %>
				<tr class="Comment2">
					
					<th><%= comment.get(i).getrWriter() %></th>
					<td>
						<% if(loginUser != null && loginUser.getUserId().equals(comment.get(i).getrWriter())) { %>
							<input type="hidden" name="rId" class="rId" value="<%= comment.get(i).getrId() %>">
							<input type="button" value="삭제" class="deleteC">
						<% } else {%>
						<button type=button class=report onclick="window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
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
			
			$(document).on('click', '.deleteC', function(){
				console.log("눌려")
				var rId = $(this).prev(".rId").val();
				var rNo = $('#rNo').val();
				$.ajax({
					url: 'delete.comment',
					data: {rId:rId, rNo:rNo},
					success: function(data){
						$replyTable = $('.Comment');
// 						$replyTable.html("");
						
// 						//console.log(data);
						
// 						for(var key in data){
// 							var $tr = $('<tr class="Comment">');
// 							var $writerTd = $('<td>').text(data[key].rWriter).css('color','red');
// 							var $contentTd = $('<td>').text(data[key].rContent).css('font-size','14px');
// 							var $buttonTd = $('<td><input type="button" value="삭제" class="deleteC"></td>').css('font-size','14px');
							
// 							$tr.append($writerTd);
// 							$tr.append($contentTd);
// 							$tr.append($buttonTd);
// 							$replyTable.append($tr);
// 						}
						
// 						$('#reply_content').val("");
						
						$("#replySelectTable").load(window.location.href + " #replySelectTable");
					}
				});
			});
			
			
				$('#reply_save').click(function(){
				var writer = '<%= loginUser.getUserId() %>';
				var rNo = '<%= r.getrNo() %>';
				var content = $('#reply_content').val();
				var rId = $('.rId').val();
				
				if($('#reply_content').val().trim().length == 0){
					alert("댓글을 작성해주세요");
				}else{
					//alert("댓글 작성 완료");
				}
				
				$.ajax({
					url : 'insertComment.recruit',
					data : {writer:writer, content:content, rNo:rNo},
					success: function(data){
						$replyTable = $("<table class='Comment' id='replySelectTable'></table>");
						
						$replyTable.html("");
						
						console.log(data);
						
						for(var key in data){
							
							var $tr = $('<tr class="Comment2"></tr>');
							var $writerTd = $('<td>').text(data[key].rWriter);
							var $contentTd = $('<td class="content">').text(data[key].rContent);
							
							
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
