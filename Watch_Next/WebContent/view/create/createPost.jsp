<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="create.model.vo.*, java.util.ArrayList, common.Comment"      %>
<%
	Create c = (Create)request.getAttribute("create");
	ArrayList<Comment> comment = (ArrayList<Comment>)request.getAttribute("comment");
	char chk = (char)request.getAttribute("chk");
	char fchk = (char)request.getAttribute("fchk");
	
	ArrayList<CFile> flist = (ArrayList<CFile>)request.getAttribute("fileList");
	
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>창작글 상세보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link type="text/css" href="/Watch_Next/Resources/css/create_post.css" rel="stylesheet" >
<style>
	.subnav li {width: 120px;}
	.like{width:35px; height:35px;}
	.likeb{background-color:transparent; border:none;}
	#fo,#my,#nf,#le{cursor: pointer}
#fo:hover{text-decoration: underline;}
#my:hover{text-decoration: underline;}
#nf:hover{text-decoration: underline;}
#le:hover{text-decoration: underline;}
#sirenb{background-color:transparent; border:none;}

</style>
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<section>

	<!-- 창작 게시판 상세 -->
		<div id="createp">
			<h2 style="color: white; font-size: 30px; font-weight:bold;">창작 게시글 상세보기</h2>
			<hr class="hline">
			
			<form action="view/create/createUpdate.jsp" id="detailForm" name="detailForm">
			<div id="box">

				<div id="cfilm">
					<label id="cfilml"><%= c.getbTitle() %>
					<input type="hidden" readonly="<%= c.getbTitle() %>" value="<%= c.getbTitle() %>" name="cTitle" style="border:0; ,font-size: 20px;">	
					/ <%= c.getcDirector() %></label>
					<input type="hidden" readonly="<%= c.getcDirector() %>" id="cDirector" name="cDirector" value="<%= c.getcDirector() %>" style="border: 0; font-size: 17px;">
					
					<input id="cNo" type="hidden" name="cNo" value="<%= c.getbNO() %>">
				</div>

				<hr>

				<div id="wInfo">
					<table>
						<tr>
							<td width="850px" style="font-size: 17px;"></td>
							<td width="80px" style="font-size: 17px;">글쓴이 :</td>
							<td width="70px" style="font-size: 17px;" id="rpWriter">
								<ul>
									<li>
										<input type="hidden"  name="rpWriter" value="<%= c.getbWriter()%>"><%= c.getbWriter() %>
												<% if(!loginUser.getUserId().equals(c.getbWriter())) { %>
												<ul>
												<li><a onclick="window.open('<%= request.getContextPath()%>/view/letter/letter_send.jsp', 'message',
														'left='+(screen.availWidth-450)/2+',top='+(screen.availHeight-650)/2+', width=450px,height=650px')">
													쪽지보내기</a>
												</li>
												<li>
													<% if(fchk == 'N' || fchk == 0) {%>
														<a onclick="onFollow()">팔로우추가</a>
													<%} else if(fchk == 'Y') {%>
														<a onclick="onNoFollow()">팔로우해제</a>
													<%} %>
												</li>
												<% } %>
												</ul>
									</li>
								</ul>
							</td>
							<td width="70px" style="font-size: 17px;">날짜 :</td>
							<td width="150px" style="font-size: 17px;"><%=c.getcDate() %></td>
							<td width="80px" style="font-size: 17px;">조회수 :</td>
							<td width="70px" style="font-size: 17px;"><%= c.getbCount() %></td>
						</tr>
					</table>
					
					<script>
						function onFollow(){
							var fwriter = "<%=c.getbWriter()%>";
							var cNo = <%=c.getbNO() %>;
							
							$.ajax({
								url: 'putFollow.cr',
								data: {fwriter:fwriter, cNo:cNo},
								success: function(){
									alert('팔로우성공');
									location.reload();
								}
							})
						}
						
						function onNoFollow(){
							var fwriter = "<%=c.getbWriter()%>";
							var cNo = <%=c.getbNO() %>;
							
							$.ajax({
								url: 'notFollow.cr',
								data: {fwriter:fwriter, cNo:cNo},
								success: function(){
									alert('팔로우해제 성공');
									location.reload();
								}
							})
						}	
					</script>
				</div>

				<hr>


				<div id="content">

					<div id="film">
						
					</div>

					<br>
					<br>
					<div id="cpinfo">
					<!-- 내용넣는곳 -->
					<% for(int j=0; j<flist.size(); j++) { %>
						<p style="font-size:15px;">
							<video controls src="<%= request.getContextPath()%>/Resources/crethumb_uploadFiles/<%= flist.get(j).getNewNames() %>"></video>
							<input type="hidden" name="videofno" value="<%= flist.get(j).getfNo()%>">
							<% System.out.println("뷰에서 동영상fno:"+flist.get(j).getfNo()); %>
							<br><br>
							<%=c.getbContent() %>
							<input type="hidden" name="bContent" class="content" value="<%= c.getbContent() %>">
						</p>
					<% } %>	

					</div>
				</div>

				<!-- 기대돼요 신고버튼 -->
				<br>
				<br>
				<table style="margin-left: auto; margin-right: auto; margin-bottom:10px; text-align: center; font-size:15px; color:red;">
						<tr>
							<td>	
									<% if(chk == 'N' || chk==0) {%>
							 			<button type="button" class="likeb" onclick="onLike();"><img class="like" src="<%=request.getContextPath()%>/Resources/images/like.png"></button>
									<% } else if(chk =='Y') {%>
										<button type="button" class="likeb" onclick="onNoLike();"><img class="like" src="<%=request.getContextPath()%>/Resources/images/likeee.png"></button>
									<% } %>
									<script>
										function onLike(){
											var cNo = <%=c.getbNO() %>;
 											location.href="<%=request.getContextPath()%>/like.create?cNo="+cNo;
										}
										function onNoLike(){
											var cNo = <%= c.getbNO()%>;
											location.href="<%=request.getContextPath()%>/notlike.create?cNo="+cNo;
										}
									</script>
							</td>
							<td width=5px></td>
							<td>

									<input type="hidden" name="rbNo" value="<%= c.getbNO()%>">
									<button type="button" id="sirenb" value="popup" onclick="sendPop();" >
										<img src="/Watch_Next/Resources/images/siren2.png" width="37px" height="37px">
									</button>

									

									<script>
									var win;
									  function sendPop(){
											win = window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
											'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px');	
											setTimeout(function(){
												win.document.getElementById("bno").value="<%=c.getbNO() %>";
											},600)
										   }
									
 									</script>
							</td>
							
						</tr>
							
						<tr>
							<td id="likeCnt"><%= c.getcLike()%></td>
							<td></td>
						</tr>
					</table>


			</div>



			<!-- 목록수정삭제 버튼 -->
			<div id=listbtn>
			<% if(loginUser != null && loginUser.getUserId().equals(c.getbWriter())) { %>
	        <button  class="lbtn" id="bupBtn" type=submit title="수정" >수정</button>
	        <button  class="lbtn" id="bdelBtn" type=button title="삭제" onclick="deleterv();">삭제</button>&nbsp;&nbsp;&nbsp;
	        <button class="lbtn" id="bliBtn" onclick="location.href='<%=request.getContextPath() %>/list.cr'" type=button title="목록" >목록</button>
		    <% } else if(!loginUser.getUserId().equals(c.getbWriter())) { %>
		        <button style="margin-left:120px" class="lbtn" id="bliBtn" onclick="location.href='<%=request.getContextPath() %>/list.cr'" type=button title="목록" >목록</button>
		    <% } %>    
			</div>
			</form>
			
			 
			<!-- 댓글 -->
			<div id="replybox1" style="width:1095px;">
				<table>
				<tr>
					<td>
						<textarea id="reply_content" name="reply_content" rows="2" cols="167"  
					  placeholder="댓글을 입력하세요." ></textarea>
					</td>
					<td>
						<button id="reply_save" style="margin-top:-5px; margin-left:10px;">댓글 작성</button>
					</td>
				</tr>
				</table>
			</div>
			
			<br><br><br><br><br><br><br>
			<div id="replybox2">
				<table id="replySelectTable" class="Comment">
					<% if(comment.isEmpty()) { %>
						<tr><td colspan=3 style="font-size:14px; text-align:center; vertical-align:middle;">댓글이 없습니다.</td></tr>
					<% } else { %>
						<% for(int i = 0; i < comment.size(); i++){ %>
						<tr class="Comment2">
							
							<th><%= comment.get(i).getrWriter() %></th>
							<td>
								<% if(loginUser != null && loginUser.getUserId().equals(comment.get(i).getrWriter())) { %>
									<input type="hidden" name="rId" class="rId" value="<%= comment.get(i).getrId() %>">
									<input type="button" id="report" value="삭제" class="deleteC">
								<% } else {%>
									<button type=button id=report onclick="sendPopR();">신고</button>				
									<% } %>
									
									<script>
									  function sendPopR(){
											win = window.open('<%=request.getContextPath() %>/view/reportPop/reportPop.jsp', 'pop', 
											'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px');	
											setTimeout(function(){
												win.document.getElementById("rno").value="<%=comment.get(i).getrId() %>";
											},600)
										}
									</script>
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
		
		<script>
		//게시글삭제
		function deleterv(){
			var bool = confirm('정말 삭제하시겠습니까?');
			//System.out.println("cNo " + cNo);
			var cNo = <%=request.getParameter("cNo")%>;
			if(bool) {
				
				location.href="<%= request.getContextPath()%>/delete.cr?cNo=" + <%=c.getbNO()%>;
			}
		}
		
		//댓글삭제
		$(document).on('click', '.deleteC', function(){
				var rId = $(this).prev(".rId").val();
				var rNo = $('#cNo').val();
				$.ajax({
					url: 'delete.co',
					data: {rId:rId, rNo:rNo},
					success: function(data){
						$replyTable = $('.Comment');
						$replyTable.html("");
						
						//console.log(data);
						
						for(var key in data){
							var $tr = $('<tr class="Comment">');
							var $writerTd = $('<td>').text(data[key].rWriter).css('color','red');
							var $contentTd = $('<td>').text(data[key].rContent).css('font-size','14px');
							var $buttonTd = $('<td><input type="button" value="삭제" class="deleteC"></td>').css('font-size','14px');
							
							$tr.append($writerTd);
							$tr.append($contentTd);
							$tr.append($buttonTd);
							$replyTable.append($tr);
						}
						
						$('#reply_content').val("");
						
						$("#replySelectTable").load(window.location.href + " #replySelectTable");
					}
				});
			});
			
				//댓글작성
				$('#reply_save').click(function(){
				var writer = '<%= loginUser.getUserId() %>';
				var rNo = '<%= c.getbNO() %>';
				var content = $('#reply_content').val();
				var rId = $('.rId').val();
				
				if($('#reply_content').val().trim().length == 0){
					alert("댓글을 작성해주세요");
				}else{
					//alert("댓글 작성 완료");
				}
				
				$.ajax({
					url : 'insert.co',
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



	</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>