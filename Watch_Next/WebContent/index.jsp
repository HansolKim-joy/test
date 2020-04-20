<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, recruit.model.vo.*, review.model.vo.*" %>
	
<% 
	ArrayList<Recruit> RecruitList = (ArrayList<Recruit>)request.getAttribute("Recruitlist");
	ArrayList<Review> ReviewList = (ArrayList<Review>)request.getAttribute("Reviewlist");
// 	System.out.println("index"+ RecruitList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<link type="text/css" href="/Watch_Next/Resources/css/index.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>
<!-- <script src="/Watch_Next/WebContent/Resources/js/Index.js"></script> -->
<script>
$(document).ready(function() { 
    $(".pp_slider").lightSlider({
        mode:'slide',    // 이미지가 표시되는 형식 (fade / slide)
        loop:true,       // 무한반복 할 것인지
        auto:true,       // 자동 슬라이드
        keyPress:true,   // 키보드 탐색 허용
        pager:false,     // 페이지 표시
        speed:1500,      // 슬라이드 되는 속도
        pause:3000      // 이미지가 머무는 시간
    });
});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>

</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>

	<script>
		function myPage(){
			location.href="/Watch_Next/view/myPage/myPageMain.jsp";
		}
	</script>
<br clear="all">



<br><br><br><br><br><br><br><br><br>
<div class="index_form">
<!-- 메인 영화 정보 -->
    <div class="pp_slide-wrap">
        <div class="pp_slide-content1">
            <ul id="pp_slider" class="pp_slider">
                <li class="pp_item">
	           		<div><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></div>
                	<div class="pp_item1"></div>
                </li>
                <li class="pp_item">
                	<div><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></div>
                	<div class="pp_item2"></div>
                </li>
                <li class="pp_item">
                	<div><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster3"></div>
                	<div class="pp_item3"></div>
                </li>
            </ul>
        </div>
    </div>
    
 
    
    <!-- 리뷰게시판 -->
	<div id="review">
		<h3>리뷰 게시판</h3>
		<hr class="hline">
		<table id="mainReviewBody">
			<thead>
				<tr>
					<th id="num">번호</th>
					<th id="category">말머리</th>
					<th id="title">리뷰 제목</th>
					<th id="grade">평점</th>
					<th id="date">날짜</th>
					<th id="writer">글쓴이</th>
					<th id="hits">조회</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>

	<!-- 모집게시판 -->
	<div id="wanted">
		<h3>모집 게시판</h3>
		<hr class="hline">
		<table id="mainWantedBody">
				<thead>
					<tr>
						<th id="num">번호</th>
						<th id="category">말머리</th>
						<th id="title">모집 제목</th>
						<th id="date">날짜</th>
						<th id="writer">글쓴이</th>
						<th id="hits">조회</th>
					</tr>
				</thead>
				<tbody></tbody>
		</table>
	</div>
	<!-- footer -->
	<%@ include file="/view/layout/footer.jsp" %>
</div>
<script>

// 	ajax는 데이터를 보내고 받아 올 때 사용한다 ex) 댓글 순, 중복확인, 좋아요 순 등등
	$(document).ready(function(){
		var fi = 'fi';
		var se = 'se';
		
		$.ajax({
			url: 'listRecruit.vo',
			data: {fi:fi},
			success:function(data){
				$tableBody = $('#mainReviewBody tbody');
				$tableBody.html("");
				
				
				
				for(var i in data){
					var $tr = $("<tr>");
					var $numTd = $("<td>").text(data[i].bNo);
					
					switch(data[i].spo){
					case "Y": 
						var $spoTd = $("<td>").text("스포있음");
						break;
					case "N":
						var $spoTd = $("<td>").text("스포없음");
						break;
					}
					var $mTitleTd = $("<td>").text(" [ " + data[i].mTitle + " ] " + data[i].bTitle);
					var $gradeTd = $("<td>").text(data[i].popcorn);
					var $bDateTd = $("<td>").text(data[i].bDate);
					var $bWriterTd = $("<td>").text(data[i].bWriter);
					var $viewsTd = $("<td>").text(data[i].bCount);
					
					$tr.append($numTd);				
					$tr.append($spoTd);		
					$tr.append($mTitleTd);
					$tr.append($gradeTd);
					$tr.append($bDateTd);
					$tr.append($bWriterTd);
					$tr.append($viewsTd);
					$tableBody.append($tr);
				}
// 				console.log(data);
			}
		});
		
		$.ajax({
			url: 'listRecruit.vo',
			data: {se:se},
			success:function(data){
				$tableBody = $('#mainWantedBody tbody');
				$tableBody.html("");
				
				for(var i in data){
					var $tr = $("<tr>");
					var $numTd = $("<td>").text(data[i].rNo);
					var $categoryTd = $("<td>").text(data[i].rHead);
					var $titleTd = $("<td>").text(data[i].bTitle);
					var $dateTd = $("<td>").text(data[i].bDate);
					var $writerTd = $("<td>").text(data[i].userId);
					var $hitsTd = $("<td>").text(data[i].bViews);
				
					$tr.append($numTd);				
					$tr.append($categoryTd);				
					$tr.append($titleTd);				
					$tr.append($dateTd);				
					$tr.append($writerTd);				
					$tr.append($hitsTd);
					$tableBody.append($tr);
				}
// 				console.log(data);
			}
		});
		
		
	});
</script>

<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>