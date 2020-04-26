<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정 확인페이지</title>
<%@ include file="/view/layout/import.jsp" %>
<style>
	#footer{margin-top: 5%;}
	#s2 label, #s3{font-size: 15px;}

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
   #updateTabled{
      text-align: -webkit-center;
      font-size: 20px;
      color: white;
      margin-top: 5%;
   }
   #userId{
      font-size: 20px;
      text-align: center;
      width: 260px;
   }
   .loginUser{
      border-radius: 10px;
    border: none;
    font-size: 15px;
    height: 30px;
    width: 260px;
    outline: 0;
    padding-left: 10px;
   }
   #updateTable{
      color: white;
	    margin: 0 auto;
	    background-color: #00000014;
	    height: 80%;
	    width: 50%;
	    border-radius: 20px;
   }
   .tdlast{
      width: 100px;
   }
   #updateMemberBtn{
      border: 0;
      outline: 0;
      background-color: #545257;
      color: white;
      font-size: 16px;
   }
   .checkbox{
      width: 20px;
      height: 20px;
      font-size: 25px;
   }
   #pwdMessage{
      text-align: center;
      display: none;
   }
   #pwdMessage1{
      text-align: center;
      display: none;
   }
   #ckck{
   		text-align:center;
   }
   /*폼 css*/
   .span input[type=text],input[type=password]{color: black; transition:width 1s, height 1s, background-color 1s, transform 1s;}
   .span input[type=text]:focus,input[type=password]:focus{background-color: #e74c3c; color: white;}
    
   label.star{color:red;}
   .span{
       margin-left: 7%;
    display: inline-block;
    margin-top: 4%;}
    .title{font-size: 15px; font-weight: bold;}
   #j1{font-size: 15px;
    float: right;
    margin-right: 15px;
    padding-top: 10px;}
    
    #s1{margin-left: 3%;}
    #s1 input{margin-left: 113px;}
    
    #s2 {margin-left: 0%;}
    #s2 input{margin-left: 68px;}
    
    #s3 {margin-left: 0.5%;}
    #s3 input{margin-left: 35px;}
    
    #s4{margin-left: 3%;}
    #s4 input{margin-left: 135px;}
    
    
    #s5{margin-left: 3%;}
    #s5 input{margin-left: 118px;}
    
    #s6{margin-left: 3%;}
    #s6 input{margin-left: 118px;}
    
    #s7{margin-left: 3%;}
    
    
    
    /* checkbox css */
#s7 input[type=checkbox]{display:none;}
#s7 label.chkred { 
  display: inline-block;
  font-size: 13px;
  cursor: pointer;
  }
#s7 label.chkred::before {
  display: inline-block;
  margin:0 20px;
  font-family: FontAwesome;
  font-size: 20px;
  color: #ff5843;
  transition: transform 0.2s ease-out, color 0.2s ease;
  transform: scale3d(0.8,0.8,1);
}
#s7 label.chkred.chkbox::before {
  content: "\f0c8";
}
#s7 input.userChk + label.chkred:hover::before {
  transform: scale3d(1,1,1);
}

#s7 input.userChk + label.chkred:active::before {
  transform: scale3d(1.5,1.5,1);
}

#s7 input.userChk:checked + label.chkred::before {
  display: inline-block; 
  font-family: FontAwesome; 
  color:#ff5843;
  transform: scale3d(1,1,1);
}

#s7 input.userChk:checked + label.chkred::before {
    content:"\f14a";
}
.chkdiv{margin-top: -5px;
    margin-left: 25px;}
/* 내꺼 끝 */
/*버튼 */
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
<!--header -->
<%@ include file="/view/layout/Header.jsp" %>


<section>
   <div id="updateForm">
      <h2 id="updateMain">회원 정보 수정</h2>
      <hr class="hline">
      <form action="<%= request.getContextPath() %>/update.me" method="post" onsubmit="return updateMe();">
         <div id="updateTabled">
               <div id="updateTable">
                  
                  <div id="j1"><label class="star">*</label> 필수항목</div>
                  <br clear="all">
                  <div id="s1" class="span">
                     <label class="title">아이디</label>
                     <input type="text" id="userId" name="userId" class="loginUser"
                        value="<%= loginUser.getUserId() %>" readonly>
                  </div>
                  <br>
                  <div id="s2" class="span">
                  	 <label class="star">*</label>
                     <label class="title">변경 비밀번호 :</label>
                     <input type="password" id="userPwd" name="userPwd"
                        class="loginUser">
                     <label id="pwdMessage1"></label>
                  </div>
                  <br>
                  <div id="s3" class="span">
                  	 <label class="star">*</label>
                     <label class="title">변경 비밀번호 확인 :</label>
                     <input type="password" id="userPwd2" name="userPwd2"
                        class="loginUser">
                     <label id="pwdMessage"></label>
                  </div>
                  <br>
                  <div id="s4" class="span">
                     <label class="title">이름 :</label>
                     <input type="text" id="userName" name="userName"
                        class="loginUser" value="<%= loginUser.getUserName() %>">
                  </div>
                  <br>
                  <div id="s5" class="span">
                     <label class="title">이메일 :</label>
                     <input type="text" id="userEmail" name="userEmail"
                        class="loginUser" value="<%= loginUser.getEmail() %>">
                  </div>
                  <br>
                  <div id="s6" class="span">
                     <label class="title">연락처 :</label>
                     <input type="text" id="phone" name="userPhone"
                        class="loginUser" value="<%=loginUser.getPhone() %>">
                  </div>
                  <br>
                  <div id="s7" class="span">
                     <label class="title">메일링 서비스 :</label>

                     <% 
                     String mailing = loginUser.getMailingYN();
                     String checkedMailingY = "";
                     String checkedMailingN = "";
                     if(mailing.equals("Y")){
                        checkedMailingY = "checked"; 
                     }else{
                        checkedMailingN = "checked"; 
                     }
                  %>
                     <input type="checkbox" id="mailingY"
                        name="mailing" onclick="doOpenCheck(this);" value="Y"
                        class="userChk" <%= checkedMailingY %>>
                     <label for="mailingY" class="chkred chkbox">수신</label>
                        
                     <input type="checkbox" id="mailingN" name="mailing"
                        onclick="doOpenCheck(this);" value="N" class="userChk"
                        <%=checkedMailingN%>>
                     <label for="mailingN" class="chkred chkbox">비수신</label>
                  </div>
                  <br>
                  <div style="margin-top: 5%;">
                        <button class="mybtn" id="updateMemberBtn">수정완료 </button> 
                        <button class="mybtn" id="cancelBtn" onclick="location.href='javascript:history.go(-2)'">취소하기</button>
                  </div>
                  <div style="margin-top: 2%;">
                     <button class="mybtn" id="deleteBtn">회원탈퇴</button>
                  </div>
               </div>
            </div>
      </form>

   </div>
   
   <script>
      function doOpenCheck(chk){
         var obj = document.getElementsByName("mailing");
         for(var i = 0; i < obj.length; i++){
            if(obj[i] != chk){
               obj[i].checked = false;
            }
         }
      }
      
      $('#updateMemberBtn').on('click', function(){
    	  var userPwd = $('#userPwd').val();
    	  console.log(typeof(userPwd));
    	  if(userPwd.trim().length==0){
     		 alert('비밀번호를 입력해주세요.');
     		 return false;
     	 }else{
     		 alert('수정완료');
             location.href="<%= request.getContextPath() %>/list.all";
             return true;
     	 } 
      })
      
      $('#userPwd2').change(function(){
         var userPwd = $('#userPwd').val();
         var userPwd2 = $('#userPwd2').val();
         /* console.log(userPwd);
         console.log(userPwd2); */
         
         if(userPwd == userPwd2){
            /* console.log('같다구요!'); */
            $('#pwdMessage').text('일치').css({"color":"green", "display":"block"});
         }else{
            /* console.log('다르다구요!'); */
            $('#pwdMessage').text('불일치').css({"color":"red", "display":"block"});
         }
      });
      
      $('#userPwd').change(function(){
         var userPwd = $('#userPwd').val();
         var check = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
         /* console.log(userPwd); */
         
         if(check.test(userPwd)){
            /* console.log('되요!'); */
            $('#pwdMessage1').text('사용 가능').css({"color":"green", "display":"block"});
         }else{
            $('#pwdMessage1').text('사용 불가능').css({"color":"red", "display":"block"});
         }
      });
      
      $('#deleteBtn').click(function(){
          location.href='<%= request.getContextPath() %>/deleteMember.me';
          alert("탈퇴가 성공적으로 완료되었습니다.");
      });
   </script>
</section>


<!-- footer -->
<%@ include file="/view/layout/footer.jsp" %>

<script src="/Watch_Next/Resources/js/Header.js"></script>

</body>
</html>