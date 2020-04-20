<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap, movie.model.vo.File"%>
<% 
	HashMap<String, ArrayList<File>> list = (HashMap<String, ArrayList<File>>)request.getAttribute("list");
	ArrayList<File> rlist = list.get("manyReview");			// 리뷰 많은 순
	ArrayList<File> Slist = list.get("manyStar");			// 별점 순 
	ArrayList<File> Llist = list.get("manyLike");			// 좋아요 순
	System.out.println("rlist" + rlist);
	System.out.println("Slist" + Slist);
	System.out.println("Llist" + Llist);
			
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천게시판</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>
<script src="/Watch_Next/WebContent/Resources/js/rec_board.js"></script>
<script>
$(document).ready(function() {
    $(".p_slider").lightSlider({
    	item:5,
        mode:'slide',    // 이미지가 표시되는 형식 (fade / slide)
        loop:true,       // 무한반복 할 것인지
        auto:true,       // 자동 슬라이드
        keyPress:true,   // 키보드 탐색 허용
        pager:true,     // 페이지 표시
        speed:1500,      // 슬라이드 되는 속도
        pause:3000      // 이미지가 머무는 시간
    });
});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>

<style>
	#rec_title{
		font-size: 25px;
	}
	.p_slide-wrap{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#rec_title{
		color: white;
	}
	.hline{
		border: 2px solid red;
	}
	.rec_subtitle{
		color: white;
		font-size: 20px;
	}
	
	.p_slider{
	    list-style: none outside none;
	    padding-left: 0;
	    margin: 0;
	}
	
	.p_slide-content{
	    margin-bottom: 60px;
	}
	
	.p_slider li{
	    text-align: center;
	    color: #FFF;
	    background-size:cover;
	    background-position: center;
	    margin-top:20px;
	}
	.p_slide-content{
	    width: 100%;
	    height:300px;
	}
	.md_line{border: 2px solid red;}
	
	.listPhoto{
		width: 200px;
		height: 300px;
	}
</style>

</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

	<section>
		<!-- 추천게시판 -->
		<div class="p_slide-wrap">
			<h2 id="rec_title">추천게시판</h2>
			<hr class="hline">
			<span class="rec_subtitle">최다 리뷰순</span>
			<div class="p_slide-content">
				<ul id="p_slider1" class="p_slider">
					<% for(int i = 0; i < rlist.size(); i++) {%>
						<li class="p_item1">
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= rlist.get(i).getNewName() %>">
						</li>
					<%} %>
				</ul>
			</div>
			<hr class="md_line">
			<span class="rec_subtitle">최다 별점 순</span>
			<div class="p_slide-content">
				<ul id="p_slider2" class="p_slider">
					<% for(int i = 0; i < Slist.size(); i++) {%>
						<li class="p_item1">
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= Slist.get(i).getNewName() %>">
						</li>
					<% } %>
				</ul>
			</div>
			<hr class="md_line">
			<span class="rec_subtitle">최다 찜순</span>
			<div class="p_slide-content">
				<ul id="p_slider3" class="p_slider">
					<% for(int i = 0; i < Llist.size(); i++){ %>
						<li class="p_item1">
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= Llist.get(i).getNewName() %>">
						</li>
					<%} %>
				</ul>
			</div>
		</div>
	</section>


	<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>