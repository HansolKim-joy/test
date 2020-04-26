<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap, movie.model.vo.File"%>
<% 
	HashMap<String, ArrayList<File>> list = (HashMap<String, ArrayList<File>>)request.getAttribute("list");
	ArrayList<File> rlist = list.get("manyReview");			// 리뷰 많은 순
	ArrayList<File> Slist = list.get("manyStar");			// 별점 순 
	ArrayList<File> Llist = list.get("manyLike");			// 좋아요 순
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
		font-size: 30px;
		margin-top: 10%;
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
	
		/*사이드바 */
#sidebar{
	position: fixed;
	width: 100px;
	height: 700px;
	left: 94%;
	top: 15%;
}
#sidebar a{
	color: #545357;
}
#mlink{
	border: 1px solid;
 	width: 80px; 
	height: 80px;
}
#topbtn{
	text-align: center;
	font-weight: bold;
	background-color: yellow;
}
	
</style>

</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">

<div id="sidebar">
	<table>
		<tr>
			<td><a href="https://play.watcha.net/" target="_blank"><img src="Resources/images/왓챠.png" id="mlink" class="mwha"></a></td>
		</tr>
		<tr>
			<td><a href="https://www.netflix.com/kr/" target="_blank"><img src="Resources/images/넷플릭스.png" id="mlink" class="mnet"></a></td>
		</tr>
		<tr>
			<td><a href="https://movie.naver.com/" target="_blank"><img src="Resources/images/네이버 영화.png" id="mlink" class="mnav"></a></td>
		</tr>
		<tr>
			<td><a href="#" target="_self"><img src="Resources/images/top.png" id="mlink" ></a></td>
		</tr>
	
	</table>
</div>

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
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= rlist.get(i).getNewName() %>" onclick="location.href='<%= request.getContextPath()%>/detail.mo?movieTitle=<%= rlist.get(i).getTitle()%>&no=<%= rlist.get(i).getdNo()%>'">
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
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= Slist.get(i).getNewName() %>" onclick="location.href='<%= request.getContextPath()%>/detail.mo?movieTitle=<%= Slist.get(i).getTitle()%>&no=<%= Slist.get(i).getdNo()%>'">
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
							<img class="listPhoto" src="<%= request.getContextPath() %>/Resources/images/<%= Llist.get(i).getNewName() %>" onclick="location.href='<%=request.getContextPath()%>/detail.mo?movieTitle=<%= Llist.get(i).getTitle()%>&no=<%= Llist.get(i).getdNo()%>'">
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