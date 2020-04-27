<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, Funding.model.vo.AdminFunding"%>
<%
	ArrayList<AdminFunding> list = (ArrayList<AdminFunding>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수요조사 작성 페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){  
		$("#admin_imageFile").hide();
		$(".topnav").hover(function() { //마우스를 topnav에 오버시
			$(this).parent().find(".subnav").slideDown('normal').show(); //subnav가 내려옴.
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".subnav").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		});
		var p = document.getElementById('allp');
		var p1 = document.getElementById('pay');
		var m = p.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		$('#funP').text(m + "원");
		var n = p1.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
		$('#wantP').text(n + "원");
	});
	  	
		$(window).scroll(function(){
		    var navbar = $(this).scrollTop();
		    console.log(navbar);
		    var header = $('header');
		    if(navbar > 35){
		        header.addClass('down');
		    }else{
		        header.removeClass('down');
		    }
		});

</script>
<link href="<%=request.getContextPath() %>/Resources/css/admin_movie_write.css" type="text/css" rel="stylesheet">
<style>
.btn{margin-top: 2%; margin-left: 30px;}
</style>

</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>

<form action="<%= request.getContextPath() %>/updateFun.adm" method="post">
	<div id="use_fix" style="width: 80%; margin:100px auto;">
		<h2>펀딩 승인 페이지</h2>
		<hr id="red_line">
		<br>
		
		
		
		<div class="admin_movie">
			<input type="hidden" name="dno" value="<%= list.get(0).getdNo()%>">
			<div id="admin_imageArea">
				<img id="admin_image" width="300" height="300" src="<%= request.getContextPath() %>/Resources/images/<%= list.get(0).getfNewName() %>">
			</div>
			<div class="joinm" style="padding-top: 40px;">
				<b>제목 : </b><input type="text" value="<%= list.get(0).getTitle()%>" readonly>
				<b style="margin-left: 6%;">장소 : </b><input type="text" value="<%= list.get(0).getSmName() %>" readonly>
				<br>
				<b>감독 : </b><input type="text" value="<%= list.get(0).getDirector()%>" readonly>
				<b style="margin-left: 6%;">총원 : </b><input type="text" value="<%= list.get(0).getMaxPeople()%>" style="width: 3%;"readonly>
				<br>
				<b>출연 : </b><input type="text" value="<%= list.get(0).getActor()%>" readonly>
				<b style="margin-left: 6%;">펀딩 총 금액 : </b><input type="text" id="allp" value="<%= list.get(0).getPrice()%>" readonly>&nbsp;&nbsp;<b id="funP"></b>
				<br>
				<b>장르 : </b><input type="text" value="<%= list.get(0).getGenre() %>" readonly>
				<b style="margin-left: 6%; ">결제 금액 : </b><input type="text" id="pay" value="<%= list.get(0).getWantPrice() %>" style="margin-left: 27px;"readonly>&nbsp;&nbsp;<b id="wantP"></b>
				<br>
				<b>영화 시간 : </b>
				<input type="text" 
				   value="<%= list.get(0).getrTime() %>" 
				   style="text-align:center;width:50px; padding-left: 0px;" readonly>
				<br>
				<b>줄거리 : </b><textarea id="admin_movie_story" rows="10" cols="40" style="overflow-y:scroll; resize: none; vertical-align: top;" readonly><%= list.get(0).getStory() %></textarea>
				<br>
			</div>
		</div>
		<div style="width: 100%; text-align:center;">
			<input type="submit" value="완료" class="btn" id="admin_movie_btn">
			<input type="button" value="취소" class="btn" id="admin_movie_btn">
		</div>
	</div>
</form>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>