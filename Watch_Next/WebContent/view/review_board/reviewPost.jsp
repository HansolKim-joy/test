<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="review.model.vo.*, java.util.ArrayList" %>
<%
	Review r = (Review)request.getAttribute("review");
	ArrayList<ReviewReply> list = (ArrayList<ReviewReply>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/review_post.css" rel="stylesheet" >
</head>
<body>
	<%@ include file="/view/layout/Header.jsp" %>
	<br clear="all">

	<section>
		<!-- 리뷰 게시판 상세 -->
	
		<div id="review">
			<h2 id="rh2"><strong>리뷰 게시판</strong></h2>
			<hr class="hline">
			<form action="<%= request.getContextPath()%>/view/review_board/ReviewUpdateForm.jsp" id="detailForm" name="detailForm"> 
				<div id="box">
					<div id="spo">
						<b>
							<%if(r.getSpo().trim().equals("Y")) { %>
								스포있음
							<%} else { %>
								스포없음
							<% } %>	
							<input type="hidden" name="revW_spolier" value="<%= r.getSpo() %>">
						</b>
						&nbsp;&nbsp;&nbsp;
						
						<label id=rtitle>[<%= r.getmTitle() %>] <%= r.getbTitle() %></label>
						<input type="hidden" name="revW_reviewName" value="<%= r.getbTitle() %>">	 
						<input type="hidden" name="revW_movieName" value="<%= r.getmTitle() %>">	 									  
					</div>
					<input type="hidden" name="rv" value="<%=r.getbNo() %>">
		  
					<hr>
		
					<div id="wInfo">
						<table>
							<tr>
								<td width="850px" style="font-size:17px;">
									<% if(r.getPopcorn() ==1) { %>
										★☆☆☆☆
									<%} else if(r.getPopcorn() ==2) { %>
										★★☆☆☆
									<%} else if(r.getPopcorn() ==3) { %>
										★★★☆☆
									<%} else if(r.getPopcorn() ==4) { %>
										★★★★☆
									<%} else if(r.getPopcorn() ==5) { %>
										★★★★★
									<%} %>
								</td>
								<td width="80px" style="font-size:17px;">글쓴이 : </td>
								<td width="70px" style="font-size:17px;" id="rpWriter">
									<ul>
										<li>
											<%= r.getbWriter() %> 
											<ul>
												<li><a href='#'>쪽지보내기</a></li>
												<li><a href='#'>팔로우하기</a></li>
											</ul>
										</li>
									</ul>
								</td>
								<td width="70px" style="font-size:17px;">날짜 : </td>
						      	<td width="150px" style="font-size:17px;"><%= r.getbDate() %></td>
						      	<td width="80px" style="font-size:17px;">조회수 : </td>
						      	<td width="70px" style="font-size:17px;"><%= r.getbCount() %></td>
							</tr>
						</table>
					</div>
		
					<hr>
		
					<div id="content">
						<p style="font-size:15px;">
							<%= r.getbContent()%>
							<input type="hidden" name="editor_content" value="<%= r.getbContent() %>">	 
							<br><br><br><br><br><br><br><br><br><br>
						</p>
					</div>
		
					<!-- 좋아요 및 신고버튼 -->
					<table style="margin-left: auto; margin-right: auto; margin-bottom:10px; text-align: center; font-size:15px; color:red;">
						<tr>
							<td>
								<a href="#" target="_self">
									<img id="like" onclick="imgToggle()" src="/Watch_Next/Resources/images/like.png" width="35px" height="35px">
								</a>
							</td>
							<td width=5px></td>
							<td>
								<a href="#" target="_self">
									<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px"
										 onclick="window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
										'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">
								</a>
							</td>
						</tr>
						<tr>
							<td id="likeCnt">좋아요수</td>
							<td></td>
						</tr>
					</table>
				</div>
			
	    
	 
	    <div id=listbtn>
	        <button type=submit title="수정" >수정</button>
	        <button type=button title="삭제" onclick="deleterv();">삭제</button>&nbsp;&nbsp;&nbsp;
	        <button onclick="location.href='<%=request.getContextPath() %>/list.rv'" type=button title="목록" >목록</button>        		
	    </div>
	    </form>
	    
	   	<!-- 댓글 -->
		<div id="replybox1">
			<textarea id="reply_content" name="reply_content" rows="2" cols="167" placeholder="댓글을 입력하세요." style="resize: none; border:none;"></textarea>
		</div>
		<button id="reply_save">댓글 작성</button>
	
		<br clear="all">
	
		<div id="replybox2">
			<table id="replySelectTable">
				<%if(list.isEmpty()){ %>
					<tr><td rowspan=2 colspan=2 style="font-size:14px; text-align:center"><br>댓글이 없습니다.</td></tr>
				<% } else {%>
					<% for(int i=0; i<list.size(); i++) { %>
					<tr>
						<th>
							<%= list.get(i).getrWriter() %>
						</th>
						<td>
							<button type=button id=report onclick="window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
							'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">신고</button>
						</td>
					</tr>
					<tr>	
						<td colspan=2 style="font-size:14px">
							<%= list.get(i).getrContent() %>
						</td>
					</tr>
					
					<% } %>
				<% }  %>
			</table>
		</div> 
		</div>
	</section>

	<!-- footer -->
	<%@ include file="/view/layout/footer.jsp" %>
	<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
	
	<script>
		var cnt = 1;
		function imgToggle() {
			var img1 = document.getElementById("like");
			var img2 = document.getElementById("like");
			
			if(cnt%2==1){
				img1.src="/Watch_Next/Resources/images/likeee.png";
			    img2.src="/Watch_Next/Resources/images/like.png";
			    location.href="";
			} else {
			    img1.src="/Watch_Next/Resources/images/like.png";
			    img2.src="/Watch_Next/Resources/images/likeee.png";
			}
			
			cnt++; // cnt 변수 1씩 증가 시키기
		}
		
		function deleterv(){
			var bool = confirm('정말 삭제하시겠습니까?');
			if(bool) {
				location.href="<%= request.getContextPath()%>/delete.rv?rv="+"<%=r.getbNo()%>";
			}
		}
		
		$('#reply_save').click(function(){
			var writer = '임시';
			var bid = <%= r.getbNo() %>;
			var content = $('#reply_content').val();
			$.ajax({
				url: 'insertReply.rv',
				data: {writer:writer, content:content, bid:bid},
				success : function(data){
					$replyTable = $('#replySelectTable');
					$replyTable.text("");
					
					console.log(data);
										
					for(var key in data) {
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
	
	
</body>
</html>