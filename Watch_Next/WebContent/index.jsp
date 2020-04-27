<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, recruit.model.vo.*, review.model.vo.*" %>
	
<% 
	ArrayList<Recruit> RecruitList = (ArrayList<Recruit>)request.getAttribute("Recruitlist");
	ArrayList<Review> ReviewList = (ArrayList<Review>)request.getAttribute("Reviewlist");
	Member loginUser1 = (Member)request.getAttribute("loginUser");
// 	Recruit r = (Recruit)request.getAttribute("board");
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://han3283.cafe24.com/js/lightslider/css/lightslider.css">
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<!-- <script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script> -->
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->
<!-- <script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script> -->
<style>
	.tablename{
		font-size: 30px;
		margin-top: 10%;
	}
	.index_form{
		positon: relative;
		min-height: 100%;
	}
	.pp_slide-wrap{
		margin: 0 auto;
		margin-top: 100px;
		z-index: 9999;
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
	    padding-left: 2%;
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
		background-color: #545357; 
		height: 300px;
		font-size: 18px;
		text-align: initial;
	    padding-left: 15px;
/* 	    font-family: 'Nanum Myeongjo', serif; */
		font-family: 'Noto Sans KR', sans-serif;
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
	
	/*사이드바 */
#sidebar{
	position: fixed;
	width: 100px;
	height: 700px;
	left: 94%;
	top: 55%;
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
/*footer*/
#footer {
    
    margin-top: 9.6%;
}
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



<br><br><br><br><br>
<div class="index_form">
<!-- 메인 영화 정보 -->
    <div class="pp_slide-wrap">
        <div class="pp_slide-content">
            <ul id="pp_slider1" class="pp_slider">
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
	$(document).ready(function() { 
		$.ajax({
			url: 'movielist.vo',
			success: function(data){
				$liBody = $('.pp_slider');
			
				for(var i in data){
					var $li = $("<li>");
					var $table = $("<table>");
					var $tr = $("<tr>");
					var $td1 = $("<td>");
					var $td2 = $("<td>");
					var $movieTd = $("<img class='pp_poster2'>").attr("src", "/Watch_Next/Resources/images/" + data[i].newFileName);
					var $divTd = $("<div class='pp_item1'>").html(data[i].mTitle + "<br>" + "감독 : " + data[i].mDirector + "<br>" + "출연진 : " + data[i].mActor + "<br>" + "줄거리 : " + data[i].mStory); // 타이틀, 감독, 출연, 줄거리
					var $mtitle = $("<input type='hidden' id='title'>").attr('value', data[i].mTitle);
					var $mNotd =  $("<input type='hidden' id='title1'>").attr('value', data[i].mNo);
					
// 					console.log($mtitle);
					
					
					$tr.click(function(){
						$mno = $(this).find('#title').val();
						$mNo = $(this).find('#title1').val();
						
// 						console.log(mNo)
						
						location.href='<%= request.getContextPath() %>/detail.mo?movieTitle=' + $mno + "&no=" + $mNo;
						
						
					}).mouseenter(function(){
						$(this).parent().css('cursor', 'pointer');
					});
					
					$td1.append($movieTd);
					$td2.append($divTd);
					$td1.append($mtitle);
					$td1.append($mNotd);
					$tr.append($td1);
					$tr.append($td2);
					$table.append($tr);
					$li.append($table);
					
					$liBody.append($li);
				}
				$(".pp_slider").lightSlider({
			        mode:'slide',    // 이미지가 표시되는 형식 (fade / slide)
			        loop:true,       // 무한반복 할 것인지
			        auto:true,       // 자동 슬라이드
			        keyPress:true,   // 키보드 탐색 허용
			        pager:false,     // 페이지 표시
			        speed:1500,      // 슬라이드 되는 속도
			        pause:3000,      // 이미지가 머무는 시간
			    });
			}
		}); 
		
	});
</script>

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
// 				$tableBody.html("");
				
				for(var i in data){
					var $tr = $("<tr>");
					var $numTd = $("<td id='dno'>").text(data[i].bNo);
					var dataArr = (data[i].bDate.split("월"));
					var dd = (data[i].bDate).split("월");
					dataArr[0] = dd[0];
					var mi = dd[1].split(", ");
					dataArr[1] = mi[0];
					dataArr[2] = mi[1];
					var date = dataArr[2]+"-"+dataArr[0]+"-"+dataArr[1].trim();
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
					var $bDateTd = $("<td>").text(date);
					var $bWriterTd = $("<td>").text(data[i].bWriter);
					var $viewsTd = $("<td>").text(data[i].bCount);
					
						$tr.click(function(){
							$dno = $(this).find('#dno').eq(0).text();

						if('<%= loginUser %>' != 'null'){ 
							location.href= "<%= request.getContextPath() %>/detail.rv?rv=" + $dno;
						} else{
							alert("로그인 후 이용해주세요.");
						}	
						}).mouseenter(function(){
							$(this).parent().css('cursor', 'pointer');
						});
					
						$tr.append($numTd);				
						$tr.append($spoTd);		
						$tr.append($mTitleTd);
						$tr.append($gradeTd);
						$tr.append($bDateTd);
						$tr.append($bWriterTd);
						$tr.append($viewsTd);
						$tableBody.append($tr);
				console.log(typeof(data[i].bDate));
				}
			}
		});
		
		$.ajax({
			url: 'listRecruit.vo',
			data: {se:se},
			success:function(data){
				$tableBody = $('#mainWantedBody tbody');
// 				$tableBody.html("");
				
				for(var i in data){
					var $tr = $("<tr>");
					var $rNo = data[i].rNo;
// 					console.log($rNo);
					var $numTd = $("<td id='rno'>").text(data[i].rNo);
					var $categoryTd = $("<td>").text(data[i].rHead);
					var $titleTd = $("<td class='day'>").text(data[i].bTitle);
					var dataArr = (data[i].bDate.split("월"));
					var dd = (data[i].bDate).split("월");
					dataArr[0] = dd[0];
					var mi = dd[1].split(", ");
					dataArr[1] = mi[0];
					dataArr[2] = mi[1];
					var date = dataArr[2]+"-"+dataArr[0]+"-"+dataArr[1].trim();
// 					console.log("변한날짜 " + date);
					var $dateTd = $("<td>").text(date);
					var $writerTd = $("<td>").text(data[i].userId);
					var $hitsTd = $("<td>").text(data[i].bViews);
					
					$tr.click(function(){
						$rno = $(this).find('#rno').eq(0).text();
					if('<%= loginUser %>' != 'null'){	
						location.href="<%= request.getContextPath() %>/detail.recruit?rNo=" + $rno;
					} else {
						alert('로그인 후 이용해주세요.');
					}	
					}).mouseenter(function(){
						$(this).parent().css('cursor', 'pointer');
					});
					
					$tr.append($numTd);				
					$tr.append($categoryTd);				
					$tr.append($titleTd);				
					$tr.append($dateTd);				
					$tr.append($writerTd);				
					$tr.append($hitsTd);
					$tableBody.append($tr);
				}
			}
		});
		
		
		$('.day')
	});
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://han3283.cafe24.com/js/lightslider/js/lightslider.js"></script>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>

</body>
</html>