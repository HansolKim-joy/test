<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, Funding.model.vo.*, common.PageInfo"%>
<%
	ArrayList<DemandList> list = (ArrayList<DemandList>)request.getAttribute("list");
	ArrayList<Demand> wlist = (ArrayList<Demand>)request.getAttribute("wlist");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	
	double percent = 0.0;
	int j = 4;
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
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
	<h2 id="f_h2">펀딩 신청 목록</h2>

	<hr class="hline">
	
	<div id="sel">
		<button class="btn" value="CGV"><img src="/Watch_Next/Resources/images/cgv.png" class="cinema"></button>
		<button class="btn" value="MEGA"><img src="/Watch_Next/Resources/images/메가박스.png" class="cinema"></button>
		<button class="btn" value="롯데"><img src="/Watch_Next/Resources/images/롯데.png" class="cinema"></button>
		<button class="btn" value="피카"><img src="/Watch_Next/Resources/images/피카디리.png" class="cinema"></button>
	</div>
	
	<br>
	
	

		
	<hr class="hline">
	
	<div id="suyotb">
	<% if(!list.isEmpty()) {%>
		   <% for(int i=0; i<list.size(); i++){ 
				 DemandList dl = list.get(i);
				 percent=0;
				 for(int a=0; a<wlist.size(); a++){ 
						Demand wl = wlist.get(a);
						if(dl.getdNo() == wl.getdNo()) {
							percent = (int)(((double)wl.getMoney()/dl.getprice())*10000)/100.0;
							System.out.println(dl.getprice());
							System.out.println(wl.getMoney());
						}
					}
				 if(i%j==0){ %>
					<ol>
						<li>
							
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/FunDetail.adm?no=<%=dl.getdNo()%>'">
							
							
							<div class="pro">
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div><%= dl.getTitle() %></div>
							<div style="display: inline-block;">D - <%= dl.getEndDay() %></div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
							
						</li>
					
				<%}else if(i%j==3){ %>
						<li>
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/FunDetail.adm?no=<%=dl.getdNo()%>'">
							<div class="pro">
							<%  %>
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div><%= dl.getTitle() %></div>
							<div style="display: inline-block;">D - <%= dl.getEndDay() %></div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
						</li>
					</ol>
						
				<%}else{%>
						<li>
							<img class="poster" src="<%= request.getContextPath() %>/Resources/images/<%= dl.getFileName() %>" onclick="location.href='<%=request.getContextPath()%>/FunDetail.adm?no=<%=dl.getdNo()%>'">
							<div class="pro">
								<span style="width: <%= percent %>%"></span>
							</div>
							<span>
							<div><%= dl.getTitle() %></div>
							<div style="display: inline-block;">D - <%= dl.getEndDay() %></div>
							<div style="display: inline-block;"><%= percent %>%</div>
							</span>
						</li>
				<%} %>		
			<% } %>   
		<%} else{%>
			<div>게시글이 없습니다.</div>
		<%} %>
	
	</div>
	<br>
	</div>
		
	
	
	<br><br><br>

</section>
<br clear="all">

	<!-- 페이징 -->
	<div class="list_number">
		<a type="a" id="btn" onclick="location.href='<%= request.getContextPath() %>/view/demand/demandWrite.jsp'">작성하기</a>
        <div class="list_n_menu">
        	<!--이전 페이지 -->
	        <a id="beforeBtn" onclick="location.href='<%= request.getContextPath()%>/fundingList.adm?currentPage=<%= currentPage -1  %>'">&lt; 이전</a>
	        <script>
					if(<%= currentPage %> <= 1 ){
						$('#beforeBtn').hide();
					}
			</script>
			<!--페이지 목록  -->
			<% for (int p=startPage; p<=endPage; p++){
				if(p == currentPage) {%>
					<a><%= p %></a>
				<%} else{ %>
					<a onclick="location.href='<%=request.getContextPath() %>/fundingList.adm?currentPage=<%= p %>'"><%= p %></a>
				<%} %>
			<%} %>	
			<a id="afterBtn" onclick="location.href='<%= request.getContextPath()%>/fundingList.adm?currentPage=<%= currentPage + 1 %>'">다음  &gt;</a>
	        <script>
				if(<%= currentPage %> >= <%= maxPage %>){
					
					$('#afterBtn').hide();
				}
			</script>
        
        </div>
	</div>
	
	
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>

<script type="text/javascript">
	$(function(){
		if(<%=percent %> >= 100){
			$('.pro').css('width','100%');
		}
	});


	$('.btn').click(function(){
		var cinema = $(this).val();
		location.href='<%= request.getContextPath() %>/listSort.adm?cinema=' + cinema;
	});
	
	
</script>
</body>
</html>