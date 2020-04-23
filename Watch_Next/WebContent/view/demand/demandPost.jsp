<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Funding.model.vo.Demand, java.util.Date" %>
<%
	Demand d = (Demand) request.getAttribute("Demand");
	String fName = (String) request.getAttribute("fName");
	String genre = (String) request.getAttribute("genre");
	String smName = (String) request.getAttribute("smName");
	char chk = (char) request.getAttribute("chk");
	String wantMoney = String.format("$%,d",d.getWantMoney());
	String money = String.format("$%,d",d.getMoney());
	String sumMoney = String.format("$%,d",d.getSmWant());
	Date date = new Date(System.currentTimeMillis());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<style>
#dh2{font-size: 35px;}
</style>

<%@ include file="/view/layout/import.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link type="text/css" href="/Watch_Next/Resources/css/demand_post.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/view/layout/Header.jsp"%>
	<br clear="all">

	<section>
		<!-- 수요조사 게시판 상세 -->
		<div id="demandp">
			<h2 id="dh2">
				<strong>펀딩 게시판</strong>
			</h2>
			<hr class="hline">

			<div id="box">

				<div id="dcinema">
					<label id=dctitle><%=d.getMovieTitle()%> 펀딩</label>
				</div>

				<hr id="tbline" style="margin-top: 20px; margin-bottom: 20px; border: 0; border-top: 1px solid #000; margin: 0;">

				<div id="wInfo">
					<table>
						<tr>
							<td width="850px" style="font-size: 17px;"></td>
							<td width="150px" style="font-size: 17px;">글쓴이 : <%=d.getUserId()%></td>
							<td width="20px" style="font-size: 17px;" id="rpWriter">
								<ul>
									<li>
										<ul>
											<li><a href='#'>쪽지보내기</a></li>
											<li><a href='#'>팔로우하기</a></li>
										</ul>
									</li>
								</ul>
							</td>
							<td width="70px" style="font-size: 17px;">날짜 :</td>
							<td width="150px" style="font-size: 17px;"><%=d.getStartDate()%></td>
						</tr>
					</table>
				</div>

				<hr style="margin-top: 10px; margin-bottom: 20px; border: 0; border-top: 1px solid #000;">

				<div id="content">

					<div id="dposter">
						<img id="dcposter" src="/Watch_Next/Resources/images/<%=fName%>">
						
						<div id="dpinfo">
						<p style="font-size: 23px;">

							지역 -
							<%=smName%><br> 제목 -
							<%=d.getMovieTitle()%><br> 장르 -
							<%=genre%><br> 감독 -
							<%=d.getMovieDirector()%><br> 배우 -
							<%=d.getMovieActor()%><br> 줄거리 -
							<%=d.getMovieStory()%><br><br><br><br><br>
						</p>

						<div id="minPeople">
							<p style="font-size: 23px;">
								필요금액 -
								<%=wantMoney%>원
							</p>
						</div>

					</div>
						
					</div>
					
					
				</div>

				<!-- 기대돼요 신고버튼 -->
				<br> <br>
				<div id="btn">
					<%
						if (loginUser != null && d.getEndDate().compareTo(date) > 0) {
					%>
					<%
						if (chk == 0) {
					%>
					<!-- 보고싶어요 했는지 안했는지 검사 -->
					<button class="btn" id="want" onclick="onWant();">결제신청</button>
					<%
						} else {
					%>
					<button class="btn" id="want" onclick="onNoWant();">결제취소</button>
					<%
						}
					%>
					<script>
		function onWant(){
			location.href="<%=request.getContextPath()%>/view/demand/payment.jsp?name=<%=loginUser.getUserName()%>&email=<%=loginUser.getEmail()%>&phone=<%=loginUser.getPhone()%>&totalPrice=<%=d.getWantMoney()%>&no=<%=d.getdNo()%>&dID=<%=d.getUserId()%>";
		}
		function onNoWant(){
			location.href="<%=request.getContextPath()%>/demand.notFund?no=<%=d.getdNo()%>&userId=<%=d.getUserId()%>";
		}
	</script>
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" target="_self" style="vertical-align: middle;"> <img
						src="/Watch_Next/Resources/images/siren2.png" width="37px"
						height="37px"
						onclick="window.open('/Watch_Next/view/reportPop/reportPop.jsp', 'pop',
								'left='+(screen.availWidth-500)/2+',top='+(screen.availHeight-300)/2+', width=500px,height=300px')">
					</a>
					<%
						}
					%>
					<br>
					<h2>금액 : <%=money%> 원  / 모인 금액  : <%=sumMoney%> 원</h2>
				</div>


			</div>



			<!-- 목록수정삭제 버튼 -->
			<div id=listbtn>
				
				<button
					onclick="location.href='<%=request.getContextPath()%>/list.de'"
					type="button" class="btn" title="목록">목록</button>
			</div>

		</div>

	</section>


	<!-- footer -->
	<%@ include file="/view/layout/footer.jsp"%>
	<script src="<%=request.getContextPath()%>/Resources/js/Header.js"></script>
</body>
</html>