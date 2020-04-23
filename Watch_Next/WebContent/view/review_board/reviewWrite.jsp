<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="review.model.vo.Review, java.sql.Date"%>
<% 
	Review review=(Review)request.getAttribute("review");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Resources/js/editor.js"></script>
<style>
	.subnav li {width: 120px;}
</style>
<script>
	$(document).ready(function() {
		$("#txtEditor").Editor();
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){  
	  
		$(".topnav").hover(function() { //마우스를 topnav에 오버시
			$(this).parent().find(".subnav").slideDown('normal').show(); //subnav가 내려옴.
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".subnav").slideUp('fast'); //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		});  
	  	
		$(window).scroll(function(){
		    var navbar = $(this).scrollTop();
		    console.log(navbar);
		    var header = $('header');
		    if(navbar > 30){
		        header.addClass('down');
		    }else{
		        header.removeClass('down');
		    }
		  });
		$('.revW_submit').click(function(){
			if($('#revW_reviewName').val().length==0){
				alert("리뷰 제목을 입력하세요.");
				$('#revW_reviewName').focus();
				return false;
			}else if($('#revW_movieName').val().length==0){
				alert("영화 제목을 입력하세요.");
				$('#revW_movieName').focus();
				return false;
			}else if($('div.Editor-editor')[0].innerHTML.length==0){
				alert("리뷰 내용을 입력하세요.");
				$('div.Editor-editor').focus();
				return false;
			}else if($('#pop_point')[0].innerText.length==0) {
				alert("팝콘 점수를 입력하세요.");
				return false;
			}else{
				$('#editor_content').val($('div.Editor-editor')[0].innerHTML);
				alert("작성이 완료되었습니다.");
				return true;
			}
		});
		$('.popcorn1').click(function(){
			$('#pop_point')[0].innerText = "1 점";
			$('.pop_point').val(1);
		});
		$('.popcorn2').click(function(){
			$('#pop_point')[0].innerText = "2 점";
			$('.pop_point').val(2);
		});
		$('.popcorn3').click(function(){
			$('#pop_point')[0].innerText = "3 점";
			$('.pop_point').val(3);
		});
		$('.popcorn4').click(function(){
			$('#pop_point')[0].innerText = "4 점";
			$('.pop_point').val(4);
		});
		$('.popcorn5').click(function(){
			$('#pop_point')[0].innerText = "5 점";
			$('.pop_point').val(5);
		});
	});  
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath() %>/Resources/css/editor.css" type="text/css" rel="stylesheet"/>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath() %>/Resources/css/review_write.css">
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>
<!-- 리뷰 게시판 작성 -->
<form action="<%= request.getContextPath() %>/insert.rv">
	<br clear="all">
	<div id="revW_review">
		<h2><strong>리뷰 게시판 작성</strong></h2>
		<hr id="red_line">
		<br>
		<h4><strong>리뷰 제목 : &nbsp;<input type="text" id="revW_reviewName" name="revW_reviewName"></strong></h4>
		<!-- 여기 -->
		<%-- <input type="hidden" name="no" value="<%= review.getbNo() %> "> --%>
		<h4><strong>영화 제목 : &nbsp;<input type="text" id="revW_movieName" name="revW_movieName"> 
		&emsp;&emsp;&emsp;
		<input type="checkbox" id="revW_spolier" name="revW_spolier" value="Y"> 스포 있음</strong></h4>
				
		<%-- <input type="hidden" name="writer" value="세션id값 받아와서넘겨주기" readonly:readonly> --%>
		
	</div>
	<!-- 텍스트 편집기 부분 -->
	<div class="col-lg-12 nopadding">
		<textarea id="txtEditor"></textarea>
		<input type="hidden" id="editor_content" name="editor_content">
	</div>
	
	<div id = "revW_roop">
		<!-- 텍스트 편집기와 팝콘 점수와의 공백 -->
		&nbsp;<br>&nbsp;<br>&nbsp;<br>
		<strong id="revW_popcorn">팝콘 점수 : &ensp;</strong>
		<img src="<%=request.getContextPath() %>/Resources/images/popcorn.png" width="60px" height='60px' id="popcorn" class="popcorn1">
		<img src="<%=request.getContextPath() %>/Resources/images/popcorn.png" width="60px" height='60px' id="popcorn" class="popcorn2">
		<img src="<%=request.getContextPath() %>/Resources/images/popcorn.png" width="60px" height='60px' id="popcorn" class="popcorn3">
		<img src="<%=request.getContextPath() %>/Resources/images/popcorn.png" width="60px" height='60px' id="popcorn" class="popcorn4">
		<img src="<%=request.getContextPath() %>/Resources/images/popcorn.png" width="60px" height='60px' id="popcorn" class="popcorn5">
		<b id="pop_point"></b>
		<input type="hidden" name="pop_point" class="pop_point"repRp>
		<input type="reset" value="취소" id="revW_button" onclick="location.href='javascript:history.go(-1);'">
		<input type="submit" value="완료" id="revW_button" class="revW_submit">
		
		
	</div>
</form>
<%-- <!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html> --%>