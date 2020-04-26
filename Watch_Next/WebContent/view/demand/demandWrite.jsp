<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		// 왼쪽 회색배경 점선테두리 사각형 공간을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수
		$("#admin_imageArea").click(function(){
			$("#admin_imageFile").click();
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

            // 콜론을 넣어 시간을 완성하고 반환한다.
            time.value = hours + ":" + minute;
        }
    }
    function inputPrice(money){
    	var m = money.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    	$('#funP').text(m + "원");
    }
 	function inputWantPrice(money){
 		var m = money.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")
 		$('#wantP').text(m + "원");
    }
 	
 	function check(){
 		var f = document.submitForm;
 		if(	f.admin_movie_name.value.length < 1 || 
 			f.admin_movie_director.value.length < 1 || 
 			f.admin_movie_actor.value.length < 1 || 
 			f.admin_movie_min.value.length < 1 || 
 			f.movie_wantprice.value.length < 1 || 
 			f.admin_movie_story.value.length < 1 ||
 			f.admin_movie_time.value.length < 1 ||
 			f.admin_imageFile.value.length < 1){
 			alert("비어있는 곳 없이 모두 입력해 주십시오.");
 			return false;
 		}else if(parseInt(f.admin_movie_min.value) < parseInt(f.movie_wantprice.value)){
 			alert("목표 금액보다 참여 금액이 더 큽니다.");
 			return false;
 		}else if(f.admin_imageFile.value == ""){
 			console.log("영화 포스터를 등록해주세요.");
 			return false;
 		}else if(f.admin_movie_time.value == "00:00"){
 			if(confirm("영화시간 없이 등록하시겠습니까?") == false){
 				return false;
 			}
 		}
 		return true;
 	}
</script>
<link href="<%=request.getContextPath() %>/Resources/css/admin_movie_write.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<form action="<%= request.getContextPath() %>/insert.demand" name = "submitForm" onSubmit="return check();" method="post" encType="multipart/form-data">
	<div id="use_fix" style="width: 80%; margin:100px auto;">
		<h2>펀딩 작성 페이지</h2>
		<hr id="red_line">
		<br>
		
		<div class="admin_movie">
			<div id="admin_imageArea">
		<img id="admin_image" width="300" height="300">
		<script>
		// 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
		function LoadImg(value,filevalue){
			var reg = /(.*?)\.(jpg|jpeg|png|gif|bmp)$/i;
			if(value.files && value.files[0]){
				if(filevalue.match(reg)){
				var reader = new FileReader();
				reader.onload = function(e){
					$("#admin_image").attr("src", e.target.result);
				}
				}else{
					alert("이미지 파일이 아닙니다.");
					history.go(0);
				}
							
			reader.readAsDataURL(value.files[0]);
			}
			$("#admin_imageArea").css("outline","none");
		}
		</script>
		</div>
		<input type="file" id="admin_imageFile" name="admin_imageFile" onchange="LoadImg(this,this.value)">
		
		<div class="joinm" style="padding-top: 40px;">
			<b>제목 : </b><input type="text" id="admin_movie_name" name="admin_movie_name">
			<b style="margin-left: 8%;">장소 : </b>
			<select id = "admin_movie_spot" name="admin_movie_spot">
				<option value="1">압구정 CGV</option>
				<option value="2">COXE MEGABOX</option>
				<option value="3">강남역 롯데시네마</option>
				<option value="4">종로 피카다리</option>
			</select>
			<script>
				$('#admin_movie_spot').change(function(){
					var spot = $('#admin_movie_spot option:selected').val();
					if(spot == 1){
						$('#admin_movie_max').val('150');
					}else if(spot == 2){
						$('#admin_movie_max').val('200');
					}else if(spot == 3){
						$('#admin_movie_max').val('250');
					}else if(spot == 4){
						$('#admin_movie_max').val('300');
					}
				});
			</script>
			<br>
			<b>감독 : </b><input type="text" id="admin_movie_director" name="admin_movie_director">
			<b style="margin-left: 8%;">총원 : </b><input type="text" id="admin_movie_max" name="admin_movie_max" value='150' readonly><br>
			<b>출연 : </b><input type="text" id="admin_movie_actor" name="admin_movie_actor">
			<b style="margin-left: 8%;">펀딩 총 금액 : </b><input type="text" id="admin_movie_min" name="admin_movie_min" onKeyup="inputPrice(this);">&nbsp;&nbsp;<b id="funP"></b><br>
			<b>장르 : </b>
			<select id = "admin_movie_genre" name="admin_movie_genre">
				<option value="1">액션 영화</option>
				<option value="2">SF 영화</option>
				<option value="3">코미디 영화</option>
				<option value="4">스릴러 영화</option>
				<option value="5">전쟁 영화</option>
				<option value="6">스포츠 영화</option>
				<option value="7">판타지 영화</option>
				<option value="8">음악 영화</option>
				<option value="9">로맨스 영화</option>
			</select>
			<b style="margin-left: 13.5%;">결제 금액 : </b><input type="text" id="movie_wantprice" name="movie_wantprice" onKeyup="inputWantPrice(this);">&nbsp;&nbsp;<b id="wantP"></b>
			<br>
			<b>영화 시간 : </b>
			<input type="text" 
				   value="00:00" 
				   onKeyup="inputTimeColon(this);"
				   maxlength="5" 
				   id="admin_movie_time" name="admin_movie_time"
				   style="text-align:center;width:50px;"/>
			<br>
		
			<b>줄거리 : </b>
			<textarea rows="10" cols="40" id="admin_movie_story" name="admin_movie_story" placeholder="이미지를 넣으려면 왼쪽 영역을 클릭하세요"></textarea>
			<br>
			</div>
		</div>
		<div id="btndiv">
			<input type="submit" value="완료" class="btn red" id="admin_movie_btn">
			<input type="button" value="취소" class="btn red" id="admin_movie_btn2" onclick="location.href='<%= request.getContextPath()%>/list.de'">
		</div>
	</div>
</form>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>