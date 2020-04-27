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
		margin-top: 10%;
	}
	input{ color: black; transition:width 1s, height 1s, background-color 1s, transform 1s;}
	input:focus{background-color: #e74c3c; color: white;}
	input{
		background-color: white;
	    color: black;
	    height: 35px;
	    width: 266px;
	    border-radius: 7px;
	    padding-left: 10px;
	    border: 0px;
	    outline: 0;
	    border: none;
    }
    #footer{margin-top: 11%;}
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
		border: 1px;
	    color: white;
	    margin: 0 auto;
	    margin-top: 7%;
	    background-color: #00000014;
	    height: 150px;
	    width: 600px;
	    border-radius: 20px;
	    padding-top: 100px;
	}
	#ppwd{
		text-align: center;
		font-size: 20px;
		color: white;
		display: inline-block; 
	}
	
	#checkBtn{
		text-align: center;
		font-size: 15px;
		color: white;
		border: none;
		background-color: #ca0d0d;
		border-radius: 50px;
		margin: 0 auto;
		margin-top: 7%;
	}
	#td11{
		text-align: center;
	}
.mybtn {
   box-shadow:inset 0px 1px 0px 0px #f5978e;
   background:linear-gradient(to bottom, #f24537 5%, #c62d1f 100%);
   background-color:#f24537;
   border-radius:6px;
   border:1px solid #db1f11;
   display:inline-block;
   cursor:pointer;
   color:#ffffff;
   font-family:Arial;
   font-size:15px;
   font-weight:bold;
   padding:6px 24px;
   text-decoration:none;
   text-shadow:0px 1px 0px #810e05;
}
.mybtn:hover {
   background:linear-gradient(to bottom, #c62d1f 5%, #f24537 100%);
   background-color:#c62d1f;
}
.mybtn:active {
   position:relative;
   top:1px;
}
</style>
</head>
<body>
<%@ include file="/view/layout/Header.jsp" %>
<br clear="all">
	<form action="<%= request.getContextPath() %>/view/myPage/checkUser.jsp" method="post" onsubmit="return checkPwd();">
		<div id="checkPwdMain">
				<div id="checkPwdHead">비밀번호 확인</div>
				<br>		
				<hr class="hline">
				<br>
				<div id="checkPwdTabled">
					<div id="checkPwdTable">
							<div style="display: inline-block; font-size: 15px;">현재 비밀번호 : &nbsp;</div>
								<input type="password" id="inputPwd" name="inputPwd">
								<input type="hidden" id="hidden">
							<div>
								<button type="submit" id="checkBtn" class="mybtn">확인</button>
							</div>
					</div>
				</div>
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
			
			if(lockInputPwd == userPwd){
				console.log('같다!!');
				window.close();
				return true;
			}else{
				console.log('다르다!!');
				alert('비밀번호가 일치하지 않습니다!');
				$('#inputPwd').val('');
				$('#inputPwd').focus();
				return false;
			}
		}
	</script>
<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>
<script src="<%=request.getContextPath() %>/Resources/js/Header.js"></script>
</body>
</html>