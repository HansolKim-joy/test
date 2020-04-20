<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.*, recruit.model.vo.*, movie.model.vo.*, common.Comment"%>
<%
	ArrayList<Review> ReviewList = (ArrayList<Review>)request.getAttribute("ReviewList");
	ArrayList<Recruit> RecruitList = (ArrayList<Recruit>)request.getAttribute("RecruitList");
	ArrayList<Movie> DibList = (ArrayList<Movie>)request.getAttribute("DibList");
	ArrayList<Comment> ReviewComlist = (ArrayList<Comment>)request.getAttribute("ReviewComlist");
	ArrayList<Comment> RecruitComlist = (ArrayList<Comment>)request.getAttribute("RecruitComlist");
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
	#mp_tabled{
		font-size: 19px;
		text-align: -webkit-center;
	}
	#mp_table{
		background-color: dimgrey;
		color: white;
		text-align:center;
		width: 80%;
	}
	.mp_first{
		width: 230px;
		border-bottom: 1px solid white;
		border-right: 1px solid white;
	}
	.mp_last{
		border-right: 1px solid white;
	}
	.mp_second{
		text-align: center;
		width: 400px;
		border-bottom: 1px solid white;
	}
	/* #mp_second{
		text-align: center;
	} */
	#mp_info{
		text-align: center;
		color: white;
		font-size: 18px;
	}
	#mp_update{
		margin-top: -20px;
		float: right;
		height: 25px;
		width: 80px;
		font-size: 15px;
		border-radius: 20px;
	}
	 #updatePwdBtn{
	 	margin-top: 15px;
	 	margin-right:-90px;
	 	float: right;
		height: 25px;
		width: 100px;
		font-size: 15px;
		border-radius: 20px;
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
	
	.listTabled{
		text-align: -webkit-center;
	}
	.listTable{
		text-align: center;
		width: 80%;
	}
	#allMTable{
		width: 100%;
		border-spacing: 0 10px;
	}
	#myReviewContent{
		display: none;
	}
	.myTable{
		display: none;
		text-align: center;
		width: 100%;
		margin-top: 5px;
	}
	.myBtn{
		width: 100px;
		border: 1px solid white;
		border-radius: 20px;
		text-align: center;
	}
	#listTable{
		border-spacing: 20px;
		margin-top: -15px;
		width: 60%;
	}
	#listTablec{
		border-spacing: 20px;
		margin-top: -15px;
		width: 60%;
	}
	.hline1{
		width: 30%;
		border: 1px solid red;
	}
	.hline2{
		width: 30%;
		border: 1.7px solid red;
	}
	.mPhoto{
		width: 200px;
		height: 200px;
	}
	#dibTable{
		text-align: center;
		border-spacing: 20px;
	}
	#commentTable{
		text-align: center;
		width: 100%;
	}
	.myBtn{
		cursor: pointer;
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
			
			<div id="mp_info"><%= loginUser.getUserName() %>님의 마이페이지입니다.</div>
			<a href="javascript:void(0);" onclick="letterPopup();"><img id="send" src="/Watch_Next/Resources/images/쪽지.png"></a>
			<script>
			function letterPopup(){
				window.open('<%=request.getContextPath()%>/letter.view','letter','width=700, height=700, left=100, top=50');
			}
			</script>
			<br>
			<br>
			<form id="mp_profile" class="mp_profile" action="<%= request.getContextPath() %>/view/myPage/checkPwd.jsp">
				<div id="mp_tabled">
					<table id="mp_table">
						<tr>
							<td class="mp_first">아이디</td>
							<td class="mp_second" height="30px"><%= loginUser.getUserId() %></td>
						</tr>
						<tr>
							<td class="mp_first">이름</td>
							<td class="mp_second" height="30px"><%= loginUser.getUserName() %></td>
						</tr>
						<tr>
							<td class="mp_first">전화번호</td>
							<td class="mp_second" height="30px"><%= loginUser.getPhone() %></td>
						</tr>
						<tr>
							<td class="mp_first">이메일</td>
							<td class="mp_second" height="30px"><%= loginUser.getEmail() %></td>
						</tr>
						<tr>
							<td class="mp_last">메일링 서비스 여부</td>
							<td id="mp_second" height="30px"><%= loginUser.getMailingYN() %></td>
						</tr>
					</table>
				</div>
				<button type="submit" id="mp_update">정보수정</button>
			</form>
			<br><br><br>
			<hr class="mp_hline">
			
			
			<div id="mp_content1" class="mp_content">참여한 펀딩 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button1" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content1" class="mp_h_content"> 내용</div>
			</div>
			
			<div id="mp_content2" class="mp_content">내 팔로우 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button2" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content2" class="mp_h_content"> 내용</div>
			</div>
			
			<div id="mp_content3" class="mp_content">나의 찜 영화&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button3" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content3" class="mp_h_content">
					<% if(DibList == null) {%>
						찜 목록이 존재하지 않습니다.
					<% } else { %>
						<table id="dibTable">
						<% for(int i = 0; i < DibList.size(); i++) {%>
							<% if((i+1) % 4 == 1) {%>
								<tr>
									<td>
										<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>">
										<br>
										영화 제목 : <%= DibList.get(i).getmTitle() %> 
										<% 
											String service = DibList.get(i).getService_Site();
											String[] serviceArr = service.split(", ");
											String where = "";
											for(int j = 0; j < serviceArr.length; j++){
												if(j != serviceArr.length -1){
													switch(serviceArr[j]){
													case "1": where += "네이버 영화 / "; break;
													case "2": where += "왓챠 / "; break;
													case "3": where += "넷플릭스 / "; break;
													}
												}else{
													switch(serviceArr[j]){
													case "1": where += "네이버 영화"; break;
													case "2": where += "왓챠"; break;
													case "3": where += "넷플릭스"; break;
													}
												}
											}
										%>
										<br>
										해당 사이트 : <%= where %>
									</td> 
								<% }else if((i+1) % 4 == 2 || (i+1) % 4 == 3){ %>
									<td>
										<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>">
										<br>
										영화 제목 : <%= DibList.get(i).getmTitle() %> 
										<% 
											String service = DibList.get(i).getService_Site();
											String[] serviceArr = service.split(", ");
											String where = "";
											for(int j = 0; j < serviceArr.length; j++){
												if(j != serviceArr.length -1){
													switch(serviceArr[j]){
													case "1": where += "네이버 영화 / "; break;
													case "2": where += "왓챠 / "; break;
													case "3": where += "넷플릭스 / "; break;
													}
												}else{
													switch(serviceArr[j]){
													case "1": where += "네이버 영화"; break;											
													case "2": where += "왓챠"; break;
													case "3": where += "넷플릭스"; break;
													}
												}
											}
										%>
										<br>
										해당 사이트 : <%= where %>
									</td>
							<% } else if((i+1) % 4 == 0) {%>
								<td>
									<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>">
									<br>
									영화 제목 : <%= DibList.get(i).getmTitle() %> 
									<% 
										String service = DibList.get(i).getService_Site();
										String[] serviceArr = service.split(", ");
										String where = "";
										for(int j = 0; j < serviceArr.length; j++){
											if(j != serviceArr.length -1){
												switch(serviceArr[j]){
												case "1": where += "네이버 영화 / "; break;
												case "2": where += "왓챠 / "; break;
												case "3": where += "넷플릭스 / "; break;
												}
											}else{
												switch(serviceArr[j]){
												case "1": where += "네이버 영화"; break;											
												case "2": where += "왓챠"; break;
												case "3": where += "넷플릭스"; break;
												}
											}
										}
									%>
									<br>
									해당 사이트 : <%= where %>
								</td>
							</tr>
							<% } %>
						<% } %>
						</table>
					<% } %>
				</div>
			</div>
			
			
			<div id="mp_content4" class="mp_content">게시글 확인 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button4" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content4" class="mp_h_content">
					<table id="listTable">
						<tr>
							<td> <div id="myReview" class="myBtn"> 리뷰 </div> </td>
							<td> <div id="myRecruit" class="myBtn"> 모집  </div> </td>
							<td> <div id="myMade" class="myBtn"> 창작 </div> </td>
							<td> <div id="myFunding" class="myBtn"> 펀딩 </div> </td>
						</tr>
					</table>
					<table id="myReviewTable" class="myTable">
						<tr>
							<td>리뷰 번호</td>
							<td>스포 여부</td>
							<td>리뷰 제목</td>
							<td>리뷰 점수</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
							<% if(ReviewList.isEmpty()) {%>
							<tr>
								<td colspan="5"> 게시글이 존재하지 않습니다. </td>
							</tr>
							<% }else{ %>
								<% for(int i = 0; i < ReviewList.size(); i++) {%>
								<tr>
									<td><%= ReviewList.get(i).getbNo() %></td>
									<td>
										<% String checkSpo = ""; 
											switch(ReviewList.get(i).getSpo()){
											case "Y" : checkSpo = "스포있음"; break;
											case "N" : checkSpo = "스포없음"; break;
											}
										%>
										<%= checkSpo %>
									</td>
									<td>[<%= ReviewList.get(i).getmTitle() %>]<%= ReviewList.get(i).getbTitle() %></td>
									<td><%= ReviewList.get(i).getPopcorn() %></td>
									<td><%= ReviewList.get(i).getbDate() %></td>
									<td><%= ReviewList.get(i).getbCount() %></td>
								<tr>
								<%} %>
							<% } %>
					</table>
					<table id="myRecruitTable" class="myTable">
						<tr>
							<td>모집 번호</td>
							<td>모집 종류</td>
							<td>모집 제목</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
						<tr>
							<% if(RecruitList.isEmpty()){ %>
								<td colspan="5">게시글이 존재하지 않습니다.</td>
						</tr>
							<% } else { %>
								<% for(int i = 0; i < RecruitList.size(); i++) {%>
									<tr>
										<td><%= RecruitList.get(i).getrNo() %></td>
										<td><%= RecruitList.get(i).getrHead() %></td>
										<td><%= RecruitList.get(i).getbTitle() %></td>
										<td><%= RecruitList.get(i).getbDate() %></td>
										<td><%= RecruitList.get(i).getbViews()%></td>
									</tr>
								<% } %>
							<% } %>
					</table>
				</div>
			</div>
			
			<div id="mp_content5" class="mp_content">댓글 확인 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button5" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content5" class="mp_h_content">
					<table id="listTablec">
						<tr>
							<td> <div id="myReviewc" class="myBtn"> 리뷰 </div> </td>
							<td> <div id="myRecruitc" class="myBtn"> 모집  </div> </td>
							<td> <div id="myMadec" class="myBtn"> 창작 </div> </td>
							<td> <div id="myFundingc" class="myBtn"> 펀딩 </div> </td>
						</tr>
					</table>
					<table id="myReviewTablec" class="myTable">
						<tr>
							<% if(ReviewComlist.isEmpty()) { %>
								<td colspan="5">작성한 댓글이 존재하지 않습니다.</td>
							<% }else{ %>
								<td>글 번호</td>
								<td>리뷰 제목</td>
								<td>리뷰 작성자</td>
								<td>댓글내용</td>
								<td>댓글 작성일</td>
							</tr>
							<% for(int i = 0; i < ReviewComlist.size(); i++) {%>
								<tr>
									<td><%= ReviewComlist.get(i).getRefBid() %></td>
									<td>[<%= ReviewComlist.get(i).getmTitle() %>]<%= ReviewComlist.get(i).getbTitle() %></td>
									<td><%= ReviewComlist.get(i).getbWriter() %></td>
									<td><%= ReviewComlist.get(i).getrContent() %></td>
									<td><%= ReviewComlist.get(i).getCreateDate() %></td>
								</tr>
							<% } %>
						<% } %>
					</table>
					
					<table id="myRecruitTablec" class="myTable">
						<tr>
							<% if(RecruitComlist.isEmpty()) { %>
								<td colspan="5">작성한 댓글이 존재하지 않습니다.</td>
							<% }else{ %>
								<td>글 번호</td>
								<td>모집 종류</td>
								<td>모집글 제목</td>
								<td>글 작성자</td>
								<td>댓글내용</td>
								<td>댓글 작성일</td>
							</tr>
							<% for(int i = 0; i < RecruitComlist.size(); i++) {%>
								<tr>
									<td><%= RecruitComlist.get(i).getRefBid() %></td>
									<td><%= RecruitComlist.get(i).getmTitle() %></td>
									<td><%= RecruitComlist.get(i).getbTitle() %></td>
									<td><%= RecruitComlist.get(i).getbWriter() %></td>
									<td><%= RecruitComlist.get(i).getrContent() %></td>
									<td><%= RecruitComlist.get(i).getCreateDate() %></td>							
								</tr>
						<% } %>
					<% } %>
					</table>
				</div>
			</div>
		</div>
	</section>
	<script>
		
		$('#mp_button3').click(function(){
			$('#mp_h_content3').slideToggle();
		});
		
		$('#mp_button4').click(function(){
			$('#mp_h_content4').slideToggle();
		});
		
		$('#mp_button5').click(function(){
			$('#mp_h_content5').slideToggle();
		});
		
		$('#myReview').click(function(){
			$('#myReviewTable').slideToggle();
			$('#myRecruitTable').css({"display":"none"});
		});
		
		$('#myRecruit').click(function(){
			$('#myReviewTable').css({"display":"none"});
			$('#myRecruitTable').slideToggle();
		});
		
		$('#myReviewc').click(function(){
			$('#myReviewTablec').slideToggle();
			$('#myRecruitTablec').css({"display":"none"});
		});
		
		$('#myRecruitc').click(function(){
			$('#myReviewTablec').css({"display":"none"});
			$('#myRecruitTablec').slideToggle();
		});
		
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>
</body>
</html>