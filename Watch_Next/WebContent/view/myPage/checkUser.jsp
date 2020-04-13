<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정 확인페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<style>
	#updateForm{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#updateMain{
		color: white;
		font-size: 25px;
	}
	.hline{
		border: 2px solid red;
	}
	.updateTabled{
		border: 1px solid black;
	}
	.updateTable{
		border: 1px solid black;
	}
</style>
</head>
<body>
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>


<section>
	<div id="updateForm">
		<h2 id="updateMain">회원 정보 수정</h2>
		<hr class="hline">
		<div id="updateTabled">
			<table id="updateTable">
				<tr>
					<td>아이디 : </td>
					<td><input type="text" id="userId"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			
			
			
			
			
			</table>
		
		
		
		
		</div>
	
	
	</div>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>

<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>