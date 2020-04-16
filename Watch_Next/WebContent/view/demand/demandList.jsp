<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, Funding.model.vo.*"%>
<%
	ArrayList<DemandList> list = (ArrayList<DemandList>)request.getAttribute("list");
	ArrayList<Demand> wlist = (ArrayList<Demand>)request.getAttribute("wlist");
	double percent = 0.0;
	int j = 4;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


</style>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/demand_list.css" rel="stylesheet" />
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>
	<br clear="all">
<section>

	<!-- 수요조사목록 -->
	
	<div id="funding">
	<h2 id="f_h2">수요조사</h2>

	<hr class="hline">
	
	<div id="sel">
		<a href="#"><img src="/Watch_Next/Resources/images/cgv.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/메가박스.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/롯데.png" class="cinema"></a>
		<a href="#"><img src="/Watch_Next/Resources/images/피카디리.png" class="cinema"></a>
	</div>
	
	<br>
	
	<span id="allview">전체보기</span>
	
	<span id="selSearch">
		<input type="text" placeholder='검색어를 입력하세요'>
		<button id="sbtn">검색</button>&nbsp;&nbsp;
		
		<select>
	  		<option value='' selected>전체</option>
	  		<option value='압구정 CGV'>압구정 CGV</option>
	  		<option value='COEX MEGABOX'>COEX MEGABOX</option>
	  		<option value='강남역 롯데시네마'>강남역 롯데시네마</option>
	  		<option value='종로 피카디리'>종로 피카디리</option>
		</select>
		<select>
	  		<option value='' selected>선택</option>
	  		<option value='추천순'>추천순</option>
	  		<option value='인기순'>인기순</option>
	  		<option value='마감 임박순'>마감 임박순</option>
		</select>
	</span>
		
	<hr class="hline">
	
	<div id="suyotb">
	<% if(!list.isEmpty()) {%>
		   <% for(int i=0; i<list.size(); i++){ 
				 DemandList dl = list.get(i);
				 percent=0;
				 for(int a=0; a<wlist.size(); a++){ 
						Demand wl = wlist.get(a);
						if(dl.getdNo() == wl.getdNo()) {
							percent = Math.round((((double)wl.getSmWant()/dl.getMinPeople())*100)*100)/100.0;
						}
					}
				 if(i%j==0){ %>
					<ol>
						<li>
							
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/demand.detail?no=<%=dl.getdNo()%>'">
							
							
							<div class="pro">
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div style="display: inline-block;"><%= dl.getEndDay() %>일 남음</div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
							
						</li>
					
				<%}else if(i%j==3){ %>
						<li>
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/demand.detail?no=<%=dl.getdNo()%>'">
							<div class="pro">
							<%  %>
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div style="display: inline-block;"><%= dl.getEndDay() %>일 남음</div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
						</li>
					</ol>
						
				<%}else{%>
						<li>
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/demand.detail?no=<%=dl.getdNo()%>'">
							<div class="pro">
							<% System.out.println(percent); %>
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div style="display: inline-block;"><%= dl.getEndDay() %>일 남음</div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
						</li>
				<%} %>		
			<% } %>   
		<%} else{%>
			<div>게시글이 없습니다.</div>
		<%} %>
	<!-- 진행상황 --> 
	
	
		 <!--  <table id="f_t">
			<tr class="f_tr1">
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p1.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p2.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p3.jpg"></td>
			</tr>
			<tr class="f_tr2">
				<td colspan="2">
					<div class="pro">
						<span style="width: 20%"></span>
					</div>
				</td>
				<td colspan="2">
					<div class="pro">
						<span style="width: 40%"></span>
					</div>
				</td>
				<td colspan="2">
					<div class="pro">
						<span style="width: 60%"></span>
					</div>
				</td>
			</tr>
			<tr class="f_tr3">
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td> 
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
			</tr>
			<tr class="f_tr4">
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p4.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p7.jpg"></td>
				<td colspan="2" class = "f_t_p"><img class="poster" src="/Watch_Next/Resources/images/p8.jpg"></td>
			</tr>
			<tr class="f_tr2">
				<td colspan="2">
					<div class="pro">
						<span style="width: 30%"></span>
					</div>
				</td>	
				<td colspan="2">
					<div class="pro">
						<span style="width: 50%"></span>
					</div>
				</td>	
				<td colspan="2">
					<div class="pro">
						<span style="width: 70%"></span>
					</div>
				</td>	
			</tr>
			<tr class="f_tr3">
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
				<td id="dDay">22일남음</td>
				<td id="percent">60%달성</td>
			</tr>
		</table>   -->
	
	</div>
	<br>
	</div>
		
	
	
	<br><br><br>

</section>
<br clear="all">

	<!-- 페이징 -->
	<div class="list_number">
		<button type="button" id="btn" onclick="location.href='<%= request.getContextPath() %>/view/demand/demandWrite.jsp'">작성하기</button>
        <div class="list_n_menu">
        <span class="prev">이전</span>
        <span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>
        <a href="">다음  ></a>
        
        </div>
	</div>
	
	
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>