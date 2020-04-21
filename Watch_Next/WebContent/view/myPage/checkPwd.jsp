<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<%@ include file="/view/layout/import.jsp" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
	#checkPwdMain{
		width: 80%;
		margin: 0 auto;
		margin-top: 100px;
	}
	#checkPwdHead{
		text-align: center;
		color: white;
		font-size: 25px;
	}
	.hline{
		border: 2px solid red;
	}
	#checkPwdTabled{
		text-align: -webkit-center;
	
	}
	#checkPwdTable{
		border-spacing: 30px;
	}
	#ppwd{
		text-align: center;
		font-size: 20px;
		color: white;
		display: inline-block; 
	}
	
	#checkBtn{
		text-align: center;
		font-size: 20px;
		color: white;
		border: none;
		width: 150px;
		height: 30px;
		background-color: #ca0d0d;
		border-radius: 50px;
		margin: 0 auto;
	}
	#td11{
		text-align: center;
	}
</style>
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">
	<form action="<%= request.getContextPath() %>/view/myPage/checkUser.jsp" method="post">
		<div id="checkPwdMain">
				<div id="checkPwdHead">비밀번호 확인</div>
				<br>		
				<hr class="hline">
				<br>
				<div id="checkPwdTabled">
					<table id="checkPwdTable">
						<tr>
							<td id="ppwd">현재 비밀번호 : &nbsp;</td>
							<td><input type="password" id="inputPwd" name="inputPwd"></td>
							<td><input type="hidden" id="hidden"></td>
						</tr>
						<tr height="50">
							<td colspan="2" id="td11"><button type="submit" id="checkBtn" onclick="return checkPwd();">확인</button></td>
						</tr>
					</table>
				</div>
				<br><br><br><br>
				
		</div>
	</form>
	<script>
		$('#inputPwd').change(function(){
			var inputPwd = $('#inputPwd').val();
			console.log("inputPwd" + inputPwd);
			$.ajax({
				url:'<%= request.getContextPath() %>/ckPresent.pwd',
				data:{inputPwd:inputPwd},
				success:function(data){
					console.log("successData" + data.inputPwd);
					var changeInputPwd = data.inputPwd;
					$('#hidden').val(changeInputPwd);
					console.log("hidden" + $('#hidden').val());
				}
			});
		});

		function checkPwd(){
			var lockInputPwd = $('#hidden').val();
			var userPwd = '<%= loginUser.getUserPwd() %>';
			console.log("lockInputPwd" + lockInputPwd);
			console.log("userPwd" + userPwd);
			
			if(inputPwd.equals(userPwd)){
				console.log('같다!!');
				window.close();
			}else{
				console.log('다르다!!');
				alert('비밀번호가 일치하지 않습니다!');
				return false;
			}
		};
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>