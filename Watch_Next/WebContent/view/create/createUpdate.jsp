<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="create.model.vo.*, java.sql.Date"%>
<%-- <%  --%>
// 	Create c=(Create)request.getAttribute("review");
<%-- %>   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>창작게시물 수정</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/Resources/js/editor.js"></script>
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
		    if(navbar > 100){
		        header.addClass('down');
		    }else{
		        header.removeClass('down');
		    }
		  });
		$('.creW_submit').click(function(){
			if($('#creW_createName').val().length==0){
				alert("제목을 입력하세요.");
				$('#creW_createName').focus();
				return false;
			}else if($('#creW_directorName').val().length==0){
				alert("감독을 입력하세요.");
				$('#creW_directorName').focus();
				return false;
			}else if($('#taContent').val().length==0){
				alert("내용을 입력하세요.");
				$('#taContent').focus();
				return false;
			} else if($('#thumb_file').val()=="") {
				alert("썸네일을 첨부하세요.");
				return false;
			} else if($('#creW_file').val()=="") {
				alert("동영상을 첨부하세요.");
				return false;
			}else{
				alert("작성이 완료되었습니다.");
				return true;
			}
		});
	});  
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath() %>/Resources/css/editor.css" type="text/css" rel="stylesheet"/>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath() %>/Resources/css/create_write.css">
<style>
	.subnav li {width: 120px;}
	#taDiv{width:1000px; margin-top:30px; margin-left:10%;}
	#filetag1{float:left; font-size:20px;}
	#thumb_file{padding-left:20px;}
	#filetag2{float:left; font-size:20px;}
	#creW_file{padding-left:20px;}
</style>
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>
	<!-- 창작 게시판 작성 -->
<br clear="all">
<form action="<%= request.getContextPath() %>/update.cr" method="post" encType="multipart/form-data">
	<div id="creW_create">
		<h2><strong>창작 게시판 수정</strong></h2>
		<hr id="red_line">
		<br>
		<input type="hidden" name="cNo" value="<%= request.getParameter("cNo") %>">
		<h4><strong>제목 : &ensp;<input type="text" id="creW_createName" name="creW_createName" value="<%= request.getParameter("cTitle") %>"></strong></h4>
		<h4><strong>감독 : &ensp;<input type="text" id="creW_directorName" name="creW_directorName" value="<%= request.getParameter("cDirector") %>"></strong></h4>

	</div>
	<!-- 파일첨부 태그 -->
	<div id = "creW_videos">
	<span id="filetag1">썸네일 : </span>
		<input type="file" id="thumb_file" name="thumb_file" onchange="thumb(this, this.value)"><br>
	<span id="filetag2">동영상 : </span>
		<input type="file" id="creW_file" name="creW_file" onchange="cmv(this, this.value)" value="<%= request.getParameter("videofno")%>">
	</div>
	
		<script>
		function thumb(value, filevalue) {
			var reg = /(.*?)\.(jpg|jpeg|png|gif|bmp)$/i;
			if(value.files && value.files[0]) {
				if(!filevalue.match(reg)){
					alert("이미지 파일이 아닙니다.");
					history.go(0);
				}
			}
		}
		
		function cmv(value, filevalue) {
			var reg = /(.*?)\.(avi|mp4|mpeg|flv|mkv)$/i;
			if(value.files && value.files[0]) {
				if(!filevalue.match(reg)){
					alert("동영상 파일이 아닙니다.");
					history.go(0);
				}
			}
		}

		
	</script>
	
	<!-- textarea 부분 -->
	<br clear="all">
	<div id="taDiv">
		<textarea name="taContent" id="taContent" cols=150 rows=20 style="overflow-y:scroll; resize:none;"><%= request.getParameter("bContent") %></textarea>
	</div>	
	
	<div id = "creW_roop">
	&nbsp;<br>&nbsp;<br>&nbsp;<br>
	<p>&nbsp;</p>
	<input type="reset" value="취소" id="cancel_button" onclick="location.href='javascript:history.go(-1);'">
	<input type="submit" value="완료" id="creW_button" class="creW_submit">
	</div>
</form>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>

</body>
</html>