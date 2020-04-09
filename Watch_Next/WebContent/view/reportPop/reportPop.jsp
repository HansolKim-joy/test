<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title</title>
<style>
	#reportfrm{padding-top:10px; padding-left:60px;}
	#reason{margin-top:10px; font-size:15px; color:white; font-weight:bold;}
	#reportSubmit{background-color:red; color:white; width:380px; height:35px;
				  border:none; border-radius:5px; font-size:15px; font-weight:bold;}
</style>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
<br clear="all">

<section>

	<form>
	<div id="reportfrm">
		<div id="reason">
				! 신고 사유를 적어주세요
		</div>
		
		<br>
		<div id="reportBox">
			<textarea cols=75 rows=12 style="resize:none"></textarea>
		</div>
		
		<br>
	
		<input id="reportSubmit" type="submit" value="보 내 기"
			   onclick="alert('신고 완료')">
	</div>
    </form>

</section>
