<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩 작성 페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		    if(navbar > 35){
		        header.addClass('down');
		    }else{
		        header.removeClass('down');
		    }
		});
	});
</script>
<script type="text/javascript">
    function inputTimeColon(time) {

        // 먼저 기존에 들어가 있을 수 있는 콜론(:)기호를 제거한다.
        var replaceTime = time.value.replace(/\:/g, "");

        // 글자수가 4 ~ 5개 사이일때만 동작하게 고정한다.
        if(replaceTime.length >= 4 && replaceTime.length < 5) {

            // 시간을 추출
            var hours = replaceTime.substring(0, 2);

            // 분을 추출
            var minute = replaceTime.substring(2, 4);

            // 시간은 24:00를 넘길 수 없게 세팅
            if(hours + minute > 2400) {
                alert("시간은 24시를 넘길 수 없습니다.");
                time.value = "24:00";
                return false;
            }

            // 분은 60분을 넘길 수 없게 세팅
            if(minute > 60) {
                alert("분은 60분을 넘길 수 없습니다.");
                time.value = hours + ":00";
                return false;
            }
졸려요

            // 콜론을 넣어 시간을 완성하고 반환한다.
            time.value = hours + ":" + minute;
        }
    }
</script>
<link href="<%=request.getContextPath() %>/Resources/css/admin_movie_write.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<form>
	<div id="use_fix" style="width: 80%; margin:100px auto;">
		<h2>펀딩 작성 페이지</h2>
		<hr id="red_line">
		<br>
		<div class="admin_image" name="admin_image">
		<br><br><br><br><br>
		<b>drag your image</b>
		</div>
		
<!-- 이미지 드래그 스크립트 -->
<script type="text/javascript">
	$('.admin_image')
	.on("dragover", dragOver)
	.on("dragleave", dragOver)
	.on("drop", uploadFiles);

	function dragOver(e){
		e.stopPropagation();
		e.preventDefault();
		if (e.type == "dragover") {
		    $(e.target).css({
		        "background-color": "black",
		        "outline-offset": "-20px"
		    });
		} else {
		    $(e.target).css({
		        "background-color": "gray",
		        "outline-offset": "-10px"
		    });
		}
	}

	function uploadFiles(e){
		e.stopPropagation();
		e.preventDefault();
		dragOver(e); //1
		 
	    e.dataTransfer = e.originalEvent.dataTransfer; //2
	    var files = e.target.files || e.dataTransfer.files;
	 
	    if (files.length > 1) {
	        alert('하나만 올려주세요.');
	        return;
	    }
	    if (files[0].type.match(/image.*/)) {
	        $(e.target).css({
	            "background-image": "url(" + window.URL.createObjectURL(files[0]) + ")",
	            "outline": "none",
	            "background-size": "100% 100%"
	        });
	        console.log(files);
	        /* files안에 이미지파일이 담김 */
	    }else{
	      alert('이미지가 아닙니다.');
	      return;
	    }

    }
</script>
		
		<div class="admin_movie">
			<b>제목 : </b><input type="text" id="admin_movie_name" name="admin_movie_name">
			<b>장소 : </b><input type="text" id="admin_movie_spot" name="admin_movie_spot"><br>
			<b>감독 : </b><input type="text" id="admin_movie_director" name="admin_movie_director">
			<b>총원 : </b><input type="text" id="admin_movie_max" name="admin_movie_max"><br>
			<b>출연 : </b><input type="text" id="admin_movie_actor" name="admin_movie_actor"><br>
			<b>장르 : </b>
			<select id = "admin_movie_genre" name="admin_movie_genre">
				<option value="action">액션 영화</option>
				<option value="SF">SF 영화</option>
				<option value="comedy">코미디 영화</option>
				<option value="thriller">스릴러 영화</option>
				<option value="war">전쟁 영화</option>
				<option value="sports">스포츠 영화</option>
				<option value="fantasy">판타지 영화</option>
				<option value="music">음악 영화</option>
				<option value="romance">로맨스 영화</option>
			</select>
			<br>
			<b>영화 시간 : </b>
			<input type="text" 
				   value="00:00" 
				   onKeyup="inputTimeColon(this);" 
				   maxlength="5" 
				   id="admin_movie_time" name="admin_movie_time"
				   style="text-align:center;width:50px;"/>
			<br>
			<br>
			<br>
			<b>줄거리 : </b>
			<br><br>
			<textarea rows="10" cols="40" style="overflow-y:scroll; resize: none;" id="admin_movie_story" name="admin_movie_story"></textarea>
			<br>
		</div>
		<div style="width: 100%; text-align:center;">
			<input type="submit" value="완료" id="admin_movie_btn">
			<input type="reset" value="취소" id="admin_movie_btn">
		</div>
	</div>
</form>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>