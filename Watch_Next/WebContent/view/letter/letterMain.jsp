<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="letter.model.vo.Letter, common.PageInfo, java.util.ArrayList"%>
<%
	ArrayList<Letter> letterList = (ArrayList<Letter>)request.getAttribute("letterList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int count = (int)request.getAttribute("count");
	int allCount = (int)request.getAttribute("allCount");
	String chk = (String)request.getAttribute("chk");
	int cnt = 0;
	for(int i=0; i<letterList.size(); i++){
		if(letterList.get(i).getState() == 'Y'){
			cnt++;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link type="text/css" href="<%=request.getContextPath() %>/Resources/css/letter.css" rel="stylesheet" />
<link rel= "stylesheet" type="text/css" href="/Watch_Next/Resources/css/a_tag.css">
<script>
	$(function(){
		self.resizeTo(800,700);
	});
</script>
</head>
<body>
<h2 style = color:red;>쪽지함 
<%if(chk == null){ %>(받은 쪽지)
<%}else{ %>(보낸 쪽지)
<%} %></h2>
<hr color='red'>
<ul id="letter_top">
	<li><a class="a_tag" href="<%=request.getContextPath()%>/letter.view">받은 쪽지</a></li>
	<li><a class="a_tag" href="<%=request.getContextPath()%>/letter.view?str=str">보낸 쪽지</a></li>
	<li>
	<%if(chk == null){ %>
	쪽지 <%=count-cnt%>통/
	<%}%>전체 <%=allCount%>통
	</li>
</ul>
<button onclick="location.href='view/letter/letter_send.jsp'" id="letter_send" class="btn">보내기</button>
<br clear="all">
<hr color='red' size='3'>
<table id="letter_list">
	<tr>
		<td class="l_l_choise">선택</td>
		<td class="l_l_nick">닉네임</td>
		<td class="l_l_name">제목</td>
		<td class="l_l_time">받은시간</td>
		<td class="l_l_state">상태</td>
	</tr>
</table>
<br><br>
<!-- 쪽지 목록 DB불러오는거 이양식대로 -->
<form action="/Watch_Next/letter.del">
	<div id = "letter_contents">
		<table id = "letter_table">
		<%if(!letterList.isEmpty()){ %>
			<%for(int i=0; i<letterList.size(); i++){ %>
				<tr>
					<td class = "l_l_choise"><input type="checkbox" class="letter_checkbox" name="letter_chk" value="<%=letterList.get(i).getMsgNo()%>"></td>
					<td class = "l_l_nick"><%=letterList.get(i).getUserName() %></td>
					<td class = "l_l_name"><a class="a_tag" href="/Watch_Next/letter.de?no=<%=letterList.get(i).getMsgNo()%>&chk=<%=chk%>"><%=letterList.get(i).getMsg_Title() %></a></td>
					<td class = "l_l_time"><%=letterList.get(i).getMsg_Date() %></td>
					<td class = "l_l_state">
					<%if(letterList.get(i).getState() == 'Y'){ %>
						읽었음
					<%}else{ %>
						안읽음
					<%} %>
					</td>
				</tr>
			<%} %>
		<%}else{ %>
				<tr>
					<td colspan=5>읽어올 쪽지가 없습니다.</td>
				</tr>
		<%} %>
		</table>
		<br>
		<input type="submit" value="삭제" id="letter_delete" class="btn">
		<b id="letter_delet">선택한쪽지&emsp;</b>
		<script type="text/javascript">
			$('#letter_delete').click(function(){
				if($("input:checkbox[name=letter_chk]:checked").length > 0){
					if("<%=chk%>" == "null"){
						if(confirm("받은 쪽지를 삭제하시겠습니까?") == false){
							return false;
						}
					}else{
						if(confirm("발송된 쪽지를 삭제하시겠습니까?") == false){
							return false;
						}
					}
				}else{
					alert('삭제할 쪽지를 선택해주세요.');
					return false;
				}
			});
		</script>
	</div>
</form>
<br clear="all">
<!-- 페이징 -->
		<div class="pagingArea" align="center">
		<%if(!letterList.isEmpty()){ %>
			<!-- 맨 처음으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/letter.view?currentPage=1'">&lt;&lt;처음</button>
			<!-- 이전 페이지로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/letter.view?currentPage=<%=currentPage - 1 %>'" id="beforeBtn">&lt;이전</button>
			<script>
				if(<%= currentPage %> <= 1){
					$('#beforeBtn').attr("disabled", "true");
				}
			</script>
			
			<!-- 10개 페이지 목록 -->
			<% for(int p = startPage; p<=endPage; p++){ %>
				<%if(p == currentPage){ %>
					<button id="choosen" disabled><%= p %></button>
				<%} else{%>
					<button id="numBtn" onclick="location.href='<%=request.getContextPath()%>/letter.view?currentPage=<%= p %>'"><%= p %></button>
				<%} %>
			<%} %>
			<!-- 다음 페이지로 -->
			<button id="afterBtn" onclick="location.href='<%=request.getContextPath()%>/letter.view?currentPage=<%=currentPage + 1 %>'">다음&gt;</button>
			<script>
				if(<%= currentPage %> >= <%=maxPage%>){
					$('#afterBtn').attr("disabled", "true");
				}
			</script>
			<!-- 맨 끝으로 -->
			<button onclick="location.href='<%=request.getContextPath()%>/letter.view?currentPage=<%=maxPage%>'">&gt;&gt;끝</button>
		<% } %>
		</div>

</body>
</html>