<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, report.model.vo.*"%>
<%
	ArrayList<Report> BoardReport = (ArrayList<Report>)request.getAttribute("BoardReport");
	ArrayList<Report> CommReport = (ArrayList<Report>)request.getAttribute("CommReport");

%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>마이페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
	#mypage{
		font-size: 30px;
		color: white;
	} 
	.hline{
		border: 2px solid red;
	}
	#mypage_form{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#send{
		float: right;
		margin-top: -20px;
		height: 30px;
		width: 50px;
	}
	#mp_info{
		text-align: center;
		color: white;
		font-size: 18px;
	}
	.mp_hline{
		border: 1px solid red;
	}
	.mp_content{
		margin-top: 20px;
		text-align: center;
		color: white;
		font-size: 17px;
	}
	.mp_button{
		width: 23px;
		height: 23px;
		border-radius: 50%;
	}
	.mp_h_content{
		display: none;
		/* height: 200px; */
		/* border: 1px solid black; */
		text-align: -webkit-center;
	}
	
	.mp_middle{
		height: 10px;
	}
	.hline1{
		width: 30%;
		border: 1px solid red;
	}
	#mWrite{
		text-align: center;
	    margin-top: 40px;
	    color: white;
	    font-size: 17px;
	}
	#mp_tabled{
		font-size: 19px;
		text-align: -webkit-center;
	}
	#mp_table{
		background-color: dimgrey;
		color: white;
		text-align:center;
		width: 80%;
		height: 120px;
	}
	.mp_first{
		border-bottom: 1px solid white;
		border-right: 1px solid white;
	}
	.mp_third{
		border-right: 1px solid white;
		border-bottom : 1px solid white;
		width: 25%;
	}
	.mp_second{
		text-align: center;
		border-bottom: 1px solid white;
		/* border-top: 1px solid white; */
	}
	.mp_last{
		border-bottom : 1px solid white;
	}
	#searchId{
		height: 22px;
		width: 150px;
	}
	#deleteMemberBtn{
		background-color: red;
		color: white;
		width: 200px;
		font-size: 20px;
		height: 36px;
		border-radius: 200px;
		line-height: 33px;
	}
	.pageBtn{
		color: white;
		font-size: 20px;
		cursor: pointer;
	}
	#myBtnFrom{
		text-align: -webkit-center;
	}
	#myBtnTable{
		text-align: center;
		width: 500px;
	}
	.reportTable{
		width: 100%;
		text-align:center;
		border-spacing: 20px;
	}
	.reportTable td{
		width: 20%;
		
	}
	.reportTable tr.eq(0){
		color: lightyellow;
	}
	#moveTable{
		width: 100%;
		text-align: center;
	}
	#moveTable td{
		width: 20%;
	}
	.title{
		text-algin:center;
		color: lightyellow;
	}
</style>
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

	<section>
		<!-- 마이페이지 -->
		<div id="mypage_form">
			<h2 id="mypage">마이페이지</h2>
			<hr class="hline">
			
			<div id="mp_info">관리자 마이페이지입니다.</div>
			<a href="javascript:void(0);" onclick="letterPopup();"><img id="send" src="/Watch_Next/Resources/images/쪽지.png"></a>
			<script>
			function letterPopup(){
				window.open('<%=request.getContextPath()%>/letter.view','letter','width=700, height=700, left=100, top=50');
			}
			</script>
			<br><br><br>
			<div id="myBtnFrom">
				<table id="myBtnTable">
					<tr>
						<td><div class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/fundingList.adm'">펀딩 작성 이동</div></td>
						<td><div class="pageBtn" onclick="location.href='<%= request.getContextPath() %>/view/admin/Admin_movieWrite.jsp'">영화 작성 이동</div></td>
					</tr>
				</table>
			</div>
			<br><br><br>
			<hr class="mp_hline">
			
			<div id="mp_content1" class="mp_content">신고 확인 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button1" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content1" class="mp_h_content">
					<div class="title">게시글 신고</div>
					<table id="bReport" class="reportTable">
						<tr>
							<td> 신고 대상 번호 </td>
							<td> 신고 대상 </td>
							<td> 신고 이유 </td>
							<td> 신고 대상자 </td>
							<td> 신고 요청자 </td>
						</tr>
						<tr>
						<% if(BoardReport.isEmpty()){%>
							<td colspan="5">신고한 현황이 없습니다.</td>
						<%}else{ %>
							<% for(int i = 0; i < BoardReport.size(); i++) {%>
								<td><%= BoardReport.get(i).getBoardNo() %></td>
								<td><%= BoardReport.get(i).getTtorcc() %></td>
								<td><%= BoardReport.get(i).getDecContent() %></td>
								<td><%= BoardReport.get(i).getReporter() %></td>
								<td><%= BoardReport.get(i).getUserId() %></td>
							</tr>
							<%} %>
						<%} %>
					</table> 
					<br><br>
					<div class="title">댓글 신고</div>
					<table id="cReport" class="reportTable">
						<tr>
							<td> 신고 대상 번호 </td>
							<td> 신고 대상 </td>
							<td> 신고 이유 </td>
							<td> 신고 대상자 </td>
							<td> 신고 요청자 </td>
						</tr>
						<tr>
							<% if(CommReport.isEmpty()) {%>
								<td colspan="5">신고한 현황이 없습니다.</td>
							<%}else{ %>
								<% for(int i = 0; i < CommReport.size(); i++){ %>
									<td><%= CommReport.get(i).getBoardNo() %></td>
									<td><%= CommReport.get(i).getTtorcc() %></td>
									<td><%= CommReport.get(i).getDecContent() %></td>
									<td><%= CommReport.get(i).getReporter() %></td>
									<td><%= CommReport.get(i).getUserId() %></td>
								</tr>
								<%} %>
							<%} %>
					</table>
					<br><br><br>
					게시판 이동
					<table id="moveTable">
						<tr>
							<td><div id="moveReview" class="move" onclick="location.href='/Watch_Next/list.rv'">리뷰 게시판 이동</div></td>
							<td><div id="moveRecruit" class="move" onclick="location.href='/Watch_Next/list.recruit'">모집 게시판 이동</div></td>
							<td><div id="moveCreate" class="move" onclick="location.href='/Watch_Next/list.cr'">창작 게시판 이동</div></td>
							<td><div id="moveFunding" class="move" onclick="location.href='/Watch_Next/list.de'">펀딩 게시판 이동</div></td>
						
						</tr>
					</table>
				</div>
			</div>
			
			<div id="mp_content2" class="mp_content">회원 정보 조회 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button2" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content2" class="mp_h_content">
					검색할 아이디 : <input type="text" id="searchId"> <button id="searchIdBtn">검색</button>
					<br><br>
					<div id="mp_tabled">
						<table id="mp_table">
							<tr>
								<td class="mp_first" colspan="2">아이디</td>
								<td id="sUid" class="mp_second" colspan="2"></td>
							</tr>
							<tr>
								<td class="mp_first" colspan="2">이름</td>
								<td id="sUname" class="mp_second" colspan="2"></td>
							</tr>
							<tr>
							<td class="mp_third">게시글 수</td>
								<td class="mp_third" id="sUcboard"></td>
								<td class="mp_third">댓글 수</td>
								<td class="mp_last" id="sUccom"></td>
							</tr>
						</table>
					</div>
					<br>
					<div id="deleteMemberBtn">해당 회원 강제 탈퇴</div>
				</div>
			</div>
			
		</div>
	</section>
	<script>
		
		$('#mp_button1').click(function(){
			$('#mp_h_content1').slideToggle();
		});
		
		$('#mp_button2').click(function(){
			$('#mp_h_content2').slideToggle();
		});
		
		$('#searchIdBtn').click(function(){
			var searchUser = $('#searchId').val();
			/* console.log(searchUser); */
			$.ajax({
				url : "<%= request.getContextPath()%>/searchUser.do",
				data : {searchUser:searchUser},
				success: function(data){
					/* console.log('성공');
					console.log(data);
					console.log(typeof(data)); */
					if(data != null){
						$('#sUid').text(data.userId);
						$('#sUname').text(data.userName);
						$('#sUcboard').text(data.countBoard);
						$('#sUccom').text(data.countComment);
					}else{
						/* console.log('없는 회원'); */
						alert('존재하지 않는 회원입니다.');
					}
				}
			});
		});
		
		$('#deleteMemberBtn').click(function(){
			var searchId = $('#sUid').text();
			/* console.log("아이디인데 : " + searchId); */
			if(confirm('정말 회원을 삭제하시겠습니까?') == true){
				$.ajax({
					url : "deleteUser.me",
					data : {searchId:searchId},
					success: function(data){
						console.log('성공222');
						$('#searchId').val('');
						$('#sUid').text('');
						$('#sUname').text('');
						$('#sUcboard').text('');
						$('#sUccom').text('');
						alert('회원의 강제 탈퇴가 되었습니다.');
					}
				});
			}else{
				$('#searchId').val('');
				$('#sUid').text('');
				$('#sUname').text('');
				$('#sUcboard').text('');
				$('#sUccom').text('');
				alert('회원 삭제를 취소하였습니다.');
			}
		});
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>
</body>
</html>