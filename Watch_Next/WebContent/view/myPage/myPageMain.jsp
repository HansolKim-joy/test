<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.*, recruit.model.vo.*,
     movie.model.vo.*, common.Comment, Funding.model.vo.Demand, listAll.model.vo.*, create.model.vo.*"%>
<%
	ArrayList<Review> ReviewList = (ArrayList<Review>)request.getAttribute("ReviewList");
	ArrayList<Recruit> RecruitList = (ArrayList<Recruit>)request.getAttribute("RecruitList");
	ArrayList<Movie> DibList = (ArrayList<Movie>)request.getAttribute("DibList");
	/* System.out.println("diblist" + DibList); */
	ArrayList<Comment> ReviewComlist = (ArrayList<Comment>)request.getAttribute("ReviewComlist");
	ArrayList<Comment> RecruitComlist = (ArrayList<Comment>)request.getAttribute("RecruitComlist");
	ArrayList<Demand> IwriteFund = (ArrayList<Demand>)request.getAttribute("IwriteFund");
	ArrayList<MyFollow> FollowList = (ArrayList<MyFollow>)request.getAttribute("FollowList");
	ArrayList<Demand> OpenFunding = (ArrayList<Demand>)request.getAttribute("OpenFunding");
	ArrayList<Demand> CloseFunding = (ArrayList<Demand>)request.getAttribute("CloseFunding");
	ArrayList<Create> CreateList = (ArrayList<Create>)request.getAttribute("CreateList");
	ArrayList<Comment> CreateComList = (ArrayList<Comment>)request.getAttribute("CreateComList");
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
		border-radius: 20px;
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
		cursor: pointer;
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
	.myTable td{
		width: 100px;
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
		cursor: pointer;
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
	#followTable{
		text-align:center;
		width: 80%;
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
			
			<div id="mp_info"><%= loginUser.getUserName() %>님 마이페이지</div>
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
				<div id="mp_h_content1" class="mp_h_content">
					<table id="listTablec">
						<tr>
							<td> <div id="fundinging" class="myBtn"> 진행 중</div> </td>
							<td> <div id="fundingclose" class="myBtn"> 완료  </div> </td>
						</tr>
					</table>
					<table id="OpenFundingTable" class="myTable">
						<tr>
							<% if(OpenFunding.isEmpty()) { %>
								<td colspan="5">진행 중인 펀딩 중 참여한 펀딩이 없습니다.</td>
							<% }else{ %>
								<td>펀딩 영화</td>
								<td>펀딩 극장</td>
								<td>펀딩 작성자</td>
								<td>참여 금액</td>
								<td>완료 금액</td>
							</tr>
							<% for(int i = 0; i < OpenFunding.size(); i++) {%>
								<tr onclick="location.href='<%= request.getContextPath() %>/demand.detail?no=<%= OpenFunding.get(i).getdNo() %>'">
									<td><%= OpenFunding.get(i).getMovieTitle() %></td>
									<td><%= OpenFunding.get(i).getSmName() %></td>
									<td><%= OpenFunding.get(i).getUserId() %></td>
									<td><%= OpenFunding.get(i).getWantMoney() %></td>
									<td><%= OpenFunding.get(i).getMoney() %></td>
								</tr>
							<% } %>
						<% } %>
					</table>
					
					<table id="CloseFundingTable" class="myTable">
						<tr>
							<% if(CloseFunding.isEmpty()) { %>
								<td colspan="5">완료된 펀딩 중 참여한 펀딩이 없습니다.</td>
							<% }else{ %>
								<td>펀딩 영화</td>
								<td>펀딩 극장</td>
								<td>펀딩 작성자</td>
								<td>참여 금액</td>
								<td>완료 금액</td>
							</tr>
							<% for(int i = 0; i < CloseFunding.size(); i++) {%>
								<tr onclick="location.href='<%= request.getContextPath() %>/demand.detail?no=<%= CloseFunding.get(i).getdNo() %>'">
									<td><%= CloseFunding.get(i).getMovieTitle() %></td>
									<td><%= CloseFunding.get(i).getSmName() %></td>
									<td><%= CloseFunding.get(i).getUserId() %></td>
									<td><%= CloseFunding.get(i).getWantMoney() %></td>
									<td><%= CloseFunding.get(i).getMoney() %></td>							
								</tr>
						<% } %>
					<% } %>
					</table>
				</div>
			</div>
		
			<div id="mp_content2" class="mp_content">내 팔로우 &nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button2" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content2" class="mp_h_content">
					<table id="followTable">
						<tr>
						<% if(FollowList.isEmpty()) {%>
							<td colspan="3">팔로우 한 사람이 없습니다.</td>
						<% }else{ %>
							<td colspan="<%= FollowList.size() %>">팔로우 아이디</td>
						</tr>
						<tr>
							<% for(int i = 0; i < FollowList.size(); i++) {%>
								<td id="follow<%=i%>"><%= FollowList.get(i).getFollowedUser() %></td>
							<% } %>
						</tr>	
						<% } %>
					</table>
				</div>
			</div>
			
			<div id="mp_content3" class="mp_content">나의 찜 영화&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" id="mp_button3" class="mp_button">+</button>
				<hr class="hline1">
				<div class="mp_middle"></div>
				<div id="mp_h_content3" class="mp_h_content">
					<% if(DibList.isEmpty()) {%>
						찜 목록이 존재하지 않습니다.
					<% } else { %>
						<table id="dibTable">
						<% for(int i = 0; i < DibList.size(); i++) {%>
							<% if((i+1) % 4 == 1) {%>
								<tr>
									<td>
										<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>" onclick="location.href='<%= request.getContextPath() %>/detail.mo?movieTitle=<%= DibList.get(i).getmTitle() %>&no=<%=DibList.get(i).getmNo()%>'">
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
										제공 사이트 : <%= where %>
									</td> 
								<% }else if((i+1) % 4 == 2 || (i+1) % 4 == 3){ %>
									<td>
										<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>" onclick="location.href='<%= request.getContextPath() %>/search.mo?movieTitle=<%= DibList.get(i).getmTitle() %>'">
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
										제공 사이트 : <%= where %>
									</td>
							<% } else if((i+1) % 4 == 0) {%>
								<td>
									<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= DibList.get(i).getNewFileName() %>" onclick="location.href='<%= request.getContextPath() %>/search.mo?movieTitle=<%= DibList.get(i).getmTitle() %>'">
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
									 제공 사이트 : <%= where %>
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
								<td colspan="5">작성한 리뷰 게시글이 존재하지 않습니다. </td>
							</tr>
							<% }else{ %>
								<% for(int i = 0; i < ReviewList.size(); i++) {%>
								<tr onclick="location.href='<%= request.getContextPath() %>/detail.rv?rv=<%= ReviewList.get(i).getbNo() %>'">
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
								<td colspan="5">작성한 모집 게시글이 존재하지 않습니다.</td>
						</tr>
							<% } else { %>
								<% for(int i = 0; i < RecruitList.size(); i++) {%>
									<tr onclick="location.href='<%= request.getContextPath() %>/detail.recruit?rNo=<%= RecruitList.get(i).getrNo() %>'">
										<td><%= RecruitList.get(i).getrNo() %></td>
										<td><%= RecruitList.get(i).getrHead() %></td>
										<td><%= RecruitList.get(i).getbTitle() %></td>
										<td><%= RecruitList.get(i).getbDate() %></td>
										<td><%= RecruitList.get(i).getbViews()%></td>
									</tr>
								<% } %>
							<% } %>
					</table>
					
					<table id="myCreateTable" class="myTable">
						<tr>
							<% if(CreateList.isEmpty()){ %>
								<td colspan="4">작성한 창작 게시글이 존재하지 않습니다.</td>
							<%}else{ %>
								<% for(int i = 0; i < CreateList.size(); i++) {%>
									<% if((i+1) % 4 == 1) {%>
										<tr>
											<td onclick="location.href='<%= request.getContextPath() %>/detail.creat?cNo=<%= CreateList.get(i).getbNO() %>'">
												<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/crethumb_uploadFiles/<%= CreateList.get(i).getcName() %>">
												<br>
												영화 제목 : <%= CreateList.get(i).getbTitle() %> <br>
												감독 : <%= CreateList.get(i).getcDirector() %><br>
												작성일 : <%= CreateList.get(i).getcDate() %><br>
											</td> 
										<% }else if((i+1) % 4 == 2 || (i+1) % 4 == 3){ %>
											<td onclick="location.href='<%= request.getContextPath() %>/detail.creat?cNo=<%= CreateList.get(i).getbNO() %>'">
												<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/crethumb_uploadFiles/<%= CreateList.get(i).getcName() %>">
												<br>
												영화 제목 : <%= CreateList.get(i).getbTitle() %><br> 
												감독 : <%= CreateList.get(i).getcDirector() %><br>
												작성일 : <%= CreateList.get(i).getcDate() %><br>
											</td>
									<% } else if((i+1) % 4 == 0) {%>
										<td onclick="location.href='<%= request.getContextPath() %>/detail.creat?cNo=<%= CreateList.get(i).getbNO() %>'">
											<img class="mPhoto" src="<%= request.getContextPath() %>/Resources/crethumb_uploadFiles/<%= CreateList.get(i).getcName() %>">
											<br>
												영화 제목 : <%= CreateList.get(i).getbTitle() %> <br>
												감독 : <%= CreateList.get(i).getcDirector() %><br>
												작성일 : <%= CreateList.get(i).getcDate() %><br>
										</td>
									</tr>
									<% } %>
								<% } %>
							<%} %>
					</table>
					
					<table id="myFundingTable" class="myTable">
						<tr>
							<td>펀딩 영화</td>
							<td>상영 극장</td>
							<td>총 금액</td>
							<td>모인 금액</td>
							<td>종료일</td>
						</tr>
						<tr>
							<% if(IwriteFund.isEmpty()){ %>
								<td colspan="5">작성한 펀딩 게시글이 존재하지 않습니다.</td>
						</tr>
							<% } else { %>
								<% for(int i = 0; i < IwriteFund.size(); i++) {%>
									<tr onclick="location.href='<%= request.getContextPath() %>/demand.detail?no=<%= IwriteFund.get(i).getdNo() %>'">
										<td><%= IwriteFund.get(i).getMovieTitle() %></td>
										<td><%= IwriteFund.get(i).getSmName() %></td>
										<td><%= IwriteFund.get(i).getMoney() %></td>
										<td><%= IwriteFund.get(i).getSmWant() %></td>
										<td><%= IwriteFund.get(i).getEndDate() %></td>
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
						</tr>
					</table>
					<table id="myReviewTablec" class="myTable">
						<tr>
							<% if(ReviewComlist.isEmpty()) { %>
								<td colspan="5">작성한 리뷰 댓글이 없습니다.</td>
							<% }else{ %>
								<td>글 번호</td>
								<td>리뷰 제목</td>
								<td>리뷰 작성자</td>
								<td>댓글내용</td>
								<td>댓글 작성일</td>
							</tr>
							<% for(int i = 0; i < ReviewComlist.size(); i++) {%>
								<tr onclick="location.href='<%= request.getContextPath() %>/detail.rv?rv=<%= ReviewComlist.get(i).getRefBid() %>'">
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
								<td colspan="5">작성한 모집 댓글이 없습니다.</td>
							<% }else{ %>
								<td>글 번호</td>
								<td>모집 종류</td>
								<td>모집글 제목</td>
								<td>글 작성자</td>
								<td>댓글내용</td>
								<td>댓글 작성일</td>
							</tr>
							<% for(int i = 0; i < RecruitComlist.size(); i++) {%>
								<tr onclick="location.href='<%= request.getContextPath() %>/detail.recruit?rNo=<%= RecruitComlist.get(i).getRefBid() %>'">
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
					 
					<table id="myCommentTablec" class="myTable">
						<tr>
							<% if(CreateComList.isEmpty()){ %>
								<td colspan="6">작성한 창작 댓글이 없습니다.</td>
							<%}else{%>
								<td>글 번호</td>
								<td>영화 제목</td>
								<td>영화 감독</td>
								<td>작성자</td>
								<td>댓글작성</td>
								<td>댓글작성일</td>
							</tr>
								<% for(int i = 0; i < CreateComList.size(); i++){ %>
									<tr onclick="location.href='<%= request.getContextPath() %>/detail.creat?cNo=<%= CreateComList.get(i).getRefBid() %>'">
										<td><%= CreateComList.get(i).getRefBid()%></td>
										<td><%= CreateComList.get(i).getmTitle() %></td>
										<td><%= CreateComList.get(i).getbTitle() %></td>
										<td><%= CreateComList.get(i).getbWriter() %></td>
										<td><%= CreateComList.get(i).getrContent() %></td>
										<td><%= CreateComList.get(i).getCreateDate()%></td>
									</tr>
								<%} %>
							<%} %>
					</table>
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
		
		$('#mp_button3').click(function(){
			$('#mp_h_content3').slideToggle();
		});
		
		$('#mp_button4').click(function(){
			$('#mp_h_content4').slideToggle();
		});
		
		$('#mp_button5').click(function(){
			$('#mp_h_content5').slideToggle();
		});
		
		// 작성글 
		$('#myReview').click(function(){
			$('#myReview').css({"background-color":"white", "color":"black"});
			$('#myRecruit').css({"background-color":"#545257", "color":"white"});
			$('#myMade').css({"background-color":"#545257", "color":"white"});
			$('#myFunding').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTable').slideToggle();
			$('#myRecruitTable').css({"display":"none"});
			$('#myCreateTable').css({"display":"none"});
			$('#myFundingTable').css({"display":"none"});
		});
		
		$('#myRecruit').click(function(){
			$('#myRecruit').css({"background-color":"white", "color":"black"});
			$('#myReview').css({"background-color":"#545257", "color":"white"});
			$('#myMade').css({"background-color":"#545257", "color":"white"});
			$('#myFunding').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTable').css({"display":"none"});
			$('#myRecruitTable').slideToggle();
			$('#myCreateTable').css({"display":"none"});
			$('#myFundingTable').css({"display":"none"});
		});
		
		$('#myMade').click(function(){
			$('#myMade').css({"background-color":"white", "color":"black"});
			$('#myRecruit').css({"background-color":"#545257", "color":"white"});
			$('#myFunding').css({"background-color":"#545257", "color":"white"});
			$('#myReview').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTable').css({"display":"none"});
			$('#myRecruitTable').css({"display":"none"});
			$('#myCreateTable').slideToggle();
			$('#myFundingTable').css({"display":"none"});
			
		});
		
		$('#myFunding').click(function(){
			$('#myFunding').css({"background-color":"white", "color":"black"});
			$('#myRecruit').css({"background-color":"#545257", "color":"white"});
			$('#myMade').css({"background-color":"#545257", "color":"white"});
			$('#myReview').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTable').css({"display":"none"});
			$('#myRecruitTable').css({"display":"none"});
			$('#myCreateTable').css({"display":"none"});
			$('#myFundingTable').slideToggle();
			
		});
		
		// 댓글
		$('#myReviewc').click(function(){
			$('#myReviewc').css({"background-color":"white", "color":"black"});
			$('#myRecruitc').css({"background-color":"#545257", "color":"white"});
			$('#myMadec').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTablec').slideToggle();
			$('#myRecruitTablec').css({"display":"none"});
			$('#myCommentTablec').css({"display":"none"});
		});
		
		$('#myRecruitc').click(function(){
			$('#myRecruitc').css({"background-color":"white", "color":"black"});
			$('#myReviewc').css({"background-color":"#545257", "color":"white"});
			$('#myMadec').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTablec').css({"display":"none"});
			$('#myRecruitTablec').slideToggle();
			$('#myCommentTablec').css({"display":"none"});
		});
		
		$('#myMadec').click(function(){
			$('#myMadec').css({"background-color":"white", "color":"black"});
			$('#myReviewc').css({"background-color":"#545257", "color":"white"});
			$('#myRecruitc').css({"background-color":"#545257", "color":"white"});
			$('#myReviewTablec').css({"display":"none"});
			$('#myRecruitTablec').css({"display":"none"});
			$('#myCommentTablec').slideToggle();
		});
		
		// 펀딩
		$('#fundinging').click(function(){
			$('#fundinging').css({"background-color":"white", "color":"black"});
			$('#fundingclose').css({"background-color":"#545257", "color":"white"});
			$('#OpenFundingTable').slideToggle();
			$('#CloseFundingTable').css({"display":"none"});
		});
		
		$('#fundingclose').click(function(){
			$('#fundingclose').css({"background-color":"white", "color":"black"});
			$('#fundinging').css({"background-color":"#545257", "color":"white"});
			$('#OpenFundingTable').css({"display":"none"});
			$('#CloseFundingTable').slideToggle();
		});
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="/Watch_Next/Resources/js/Header.js"></script>
</body>
</html>