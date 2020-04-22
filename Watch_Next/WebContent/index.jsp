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
<style>
	.tablename{
		font-size: 25px;
	}
	.index_form{
		positon: relative;
		min-height: 100%;
		padding-bottom: 100px;
	}
	.pp_slide-wrap{
		margin: 0 auto;
		margin-top: 100px;
	}
	.pp_slider{
	    list-style: none outside none;
	    padding-left: 0;
	    margin: 0;
	}
	.pp_slide-content{
	    margin-bottom: 60px;
	    /* height: 400px; */
	}
	.pp_slider li{
		/* width: 20px; */
	    text-align: center;
	    color: #FFF;
	    background-size:cover;
	    background-position: center;
	}
	.pp_slide-content{
	    width:100%;
	    height:300px;
	}
	#pp_item_ct{
		border: 1px solid white;
	}
	.pp_item table{
		margin: 0 auto;
	}
	.pp_item table tb{
		height: 200px;
		width: 100%;
	}
	.pp_poster2{display: inline; vertical-align: baseline; width: 200px; height: 300px;}
	.pp_item1{
		width: 200px; 
		background-color: black; 
		height: 300px;
		font-size: 20px;
		text-align: center;
	}
	
		/* 최신글 */
	#review{width: 80%; margin:0 auto; margin-top: 100px; color:white;}
	.hline{border: 2px solid red;}
	#review>table{margin:30px auto; text-align:center;}
	#review td{height:50px;}
	#num{width:70px; height:60px;}
	#category{width:150px; height:60px;}
	#title{width:400px; height:60px;}
	#grade{width:125px; height:60px;}
	#date{width:200px; height:60px;}
	#writer{width:100px; height:60px;}
	#hits{width:150px; height:60px;}
	
	#wanted{width: 80%; margin:100px auto; color:white;}
	#wanted>table{margin:30px auto; text-align:center;}
	#wanted td{height:50px;}
</style>
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



<br><br><br><br><br>
<div class="index_form">
<!-- 메인 영화 정보 -->
    <div class="pp_slide-wrap">
        <div class="pp_slide-content">
            <ul id="pp_slider" class="pp_slider">
                <li class="pp_item">
                	<table id="mainMoviebody">
                		<tr>
                			<td><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></td>
                			<td>
                				<div class="pp_item1">
                					여러분 모두 힘내세요<br>
                					이제 얼마안남았어요<br>
                					모두가 힘을 내서 하다보면 <br>
                					우린 완성을 할 수 있어요<br>
                					공유해조 모두모두 화이팅<br>
                				</div>
                			</td>
                		</tr>
                	</table>
                </li>
                <li class="pp_item">
                	<table>
                		<tr>
                			<td><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></td>
                			<td>
                				<div class="pp_item1">
                					눈물이 차올라서 <br>
                					고갤들어 <br>
                					흐르지 못하게 <br>
                					살짝 웃어<br>
                					내가 왜이러는지<br>
                					부끄럼도 없는지<br>
                				</div>
                			</td>
                		</tr>
                	</table>
                </li>
                <li class="pp_item">
                	<table>
                		<tr>
                			<td><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></td>
                			<td>
                				<div class="pp_item1">
                					짜증날땐 짜장면<br>
                					우울할땐 울면<br>
                					복잡할땐 볶음밥<br>
                					타앝앝앝ㅇ 탕수육<br>
                				</div>
                			</td>
                		</tr>
                	</table>
                </li>
                <li class="pp_item">
                	<table>
                		<tr>
                			<td><img src="<%= request.getContextPath() %>/Resources/images/" class="pp_poster2"></td>
                			<td><div class="pp_item1">asdfasdfasdfa</div></td>s
                		</tr>
                	</table>
                </li>
                <li class="pp_item">
                	<table>
                		<tr>
                			<td><img src="/Watch_Next/Resources/images/어벤져스.jpg" class="pp_poster2"></td>
                			<td><div class="pp_item1">asdfasdfasdfa</div></td>
                		</tr>
                	</table>
                </li>
            </ul>
        </div>
    </div>
    
 
    
    <!-- 리뷰게시판 -->
	<div id="review">
		<h3 class="tablename">리뷰 게시판</h3>
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
		<h3 class="tablename">모집 게시판</h3>
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
		
		$.ajax({
			url: 'movielist.vo',
			success: function(data){
				$tableBody = $('#mainMoivebody');
				$tableBody.html("");
				
				for(var i in data){
					var $tr = $("<tr>"); 
					var $td = $("<td>"); // 영화 포스터
					var $divTd = $("<div>").text(data[i].mTitle + "<br>" + data[i].mDirector + "<br>" + data[i].mActor + "<br>" + data[i].mStory); // 타이틀, 감독, 출연, 줄거리
					
					$tr.append($divTd);
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