<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 보내기</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel= "stylesheet" type="text/css" href="/Watch_Next/Resources/css/a_tag.css">
<link type="text/css" href="<%=request.getContextPath() %>/Resources/css/letter_detail.css" rel="stylesheet" />
</head>
<body>
<form action="/Watch_Next/letter_send.do">
	<h2 style = color:red;>쪽지 보내기</h2>
	<hr color='red'>
	<h4 style = color:white;>받는 이 : <input type="text" placeholder="내용을 입력하세요." id="send_name" name="send_name"></h4>
	<h4 style = color:white;>제목 : &emsp;&nbsp;<input type="text" placeholder="내용을 입력하세요." id="send_title" name="send_title"></h4>
	<textarea cols="50" rows="20" style="overflow-y:scroll; resize: none;" id="send_content" name="send_content"></textarea>
	<br>
	<div id="letter_send_btn_area">
		<input type="submit" value="보내기" id="letter_detail_btn" class="letter_detail_send">
		<input type="reset" value="취소" id="letter_detail_btn">
	</div>
	<script type="text/javascript">
		$('.letter_detail_send').click(function(){
			if($('#send_name').val().length==0){
				alert("받는 이 를 입력하세요.");
				$('#send_name').focus();
				return false;
			}else if($('#send_title').val().length==0){
				alert("쪽지 제목을 입력하세요.");
				$('#send_title').focus();
				return false;
			}else if($('#send_content').val().length==0){
				alert("쪽지 내용을 입력하세요.");
				$('#send_content').focus();
				return false;
			}else{
				if(confirm('이대로 보내시겠습니까?') == false){
					return false;	
				}
			}
		});
	</script>
</form>
</body>
</html>