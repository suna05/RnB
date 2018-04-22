<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jjomuregi</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="resources/assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>


<!--2줄 추가  -->
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
   href="node_modules/bootstrap/dist/css/bootstrap.min.css" />

<body id="top">

   <!-- Header -->
   <header id="header"> <c:choose>
      <c:when test="${sessionScope.member!=null }">
         <p>${sessionScope.member.m_name }님환영합니다.</p>
         <a href="logout.do">Logout</a>
      </c:when>
      <c:otherwise>
         <button id="login1" class="btn btn-default"
            style="background-color: #33cc99; color: white; margin-bottom: 5px;"
            data-toggle="modal" data-target="#login">Login</button>

         <button id="join1" class="btn btn-default"
            style="background-color: #33cc99; color: white; margin-bottom: 5px;"
            data-toggle="modal" data-target="#join">Join Us</button>
      </c:otherwise>
   </c:choose>


   <div class="inner">
      <a href="#" class="image avatar" data-toggle="modal"
         data-target="#mypage"><img src="resources/images/avatar.jpg"
         alt="" /></a>
      <h1>
         <strong>I am Strata</strong>, a super simple<br /> responsive site
         template freebie<br /> crafted by <a href="http://html5up.net">HTML5
            UP</a>.
      </h1>
   </div>



   </header>




   <!-- Main -->
   <div id="main">

      <!-- One -->
      <section id="one"> <header class="major">
      <h2>
         Ipsum lorem dolor aliquam ante commodo<br /> magna sed accumsan arcu
         neque.
      </h2>
      </header>
      <p>Accumsan orci faucibus id eu lorem semper. Eu ac iaculis ac
         nunc nisi lorem vulputate lorem neque cubilia ac in adipiscing in
         curae lobortis tortor primis integer massa adipiscing id nisi
         accumsan pellentesque commodo blandit enim arcu non at amet id arcu
         magna. Accumsan orci faucibus id eu lorem semper nunc nisi lorem
         vulputate lorem neque cubilia.</p>
      <ul class="actions">
         <li><a href="#" class="button">Learn More</a></li>
      </ul>
      </section>

      <!-- Two -->
      <section id="two">
      <h2>Recent Work</h2>
      <div class="row">
         <article class="6u 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/foot.png" class="image fit thumb"><img
            src="resources/images/thumbs/foot.png" alt="" /></a>
         <h3>월화수목금토일</h3>
         <p>월화수목금토일월화수목금토일월화수목금토일월화수목금토일월화수목금토일</p>
         </article>
         <article class="6u$ 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/02.jpg" class="image fit thumb"><img
            src="resources/images/thumbs/02.jpg" alt="" /></a>
         <h3>Ultricies lacinia interdum</h3>
         <p>Lorem ipsum dolor sit amet nisl sed nullam feugiat.</p>
         </article>
         <article class="6u 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/03.jpg" class="image fit thumb"><img
            src="resources/images/thumbs/03.jpg" alt="" /></a>
         <h3>Tortor metus commodo</h3>
         <p>Lorem ipsum dolor sit amet nisl sed nullam feugiat.</p>
         </article>
         <article class="6u$ 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/04.jpg" class="image fit thumb"><img
            src="resources/images/thumbs/04.jpg" alt="" /></a>
         <h3>Quam neque phasellus</h3>
         <p>Lorem ipsum dolor sit amet nisl sed nullam feugiat.</p>
         </article>
         <article class="6u 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/05.jpg" class="image fit thumb"><img
            src="resources/images/thumbs/05.jpg" alt="" /></a>
         <h3>Nunc enim commodo aliquet</h3>
         <p>Lorem ipsum dolor sit amet nisl sed nullam feugiat.</p>
         </article>
         <article class="6u$ 12u$(xsmall) work-item"> <a
            href="resources/images/fulls/06.jpg" class="image fit thumb"><img
            src="resources/images/thumbs/06.jpg" alt="" /></a>
         <h3>Risus ornare lacinia</h3>
         <p>Lorem ipsum dolor sit amet nisl sed nullam feugiat.</p>
         </article>
      </div>
      <ul class="actions">
         <li><a href="#" class="button">Full Portfolio</a></li>
      </ul>
      </section>



      <!-- 회원가입 모달창 -->
      <div class="modal fade" id="join" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true"
         style="position: center;">
         <div class="modal-dialog joinmodal">
            <div class="modal-content"
               style="width: 80%; height: 108%; position: center;">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">
                     <span aria-hidden="true">×</span><span class="sr-only">Close</span>
                  </button>
                  <h4 class="modal-title" id="myModalLabel"
                     style="text-align: center">
                     <b>회원가입</b>
                  </h4>
               </div>

               <div class="modal-body">
                  <div style="vertical-align: top;">
                     <div style="text-align: center; padding-top: 3%;">
                        <form action="insertMember.do" class="form-horizontal"
                           style="width: 100%" method="post">

                           <div class="form-group">
                              <div class="col-sm-10 main-id" style="width: 100%">
                                 <input type="email" class="form-control" name="m_id"
                                    placeholder="이메일" oninput="checkId()" id="id">
                              </div>
                           </div>



                           <div class="form-group">
                              <div class="col-sm-10 main-pwd" style="width: 100%">
                                 <input type="password" class="form-control"
                                    id="fi-password-add" name="m_pw" placeholder="비밀번호"
                                    oninput="checkPwd()">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-10 main-pwd" style="width: 100%">
                                 <input class="form-control" type="password" name="pwConfirm"
                                    id="fi-password-check-add" placeholder="비밀번호 확인"
                                    oninput="checkPwd()"> <span id="confirmMessage"
                                    class="confirmMessage"></span>
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-10 main-name" style="width: 100%">
                                 <input class="form-control" type="text" name="m_name"
                                    id="name" placeholder="이름">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-10 main-phone" style="width: 100%">
                                 <input class="form-control" type="text" name="m_phone"
                                    id="phone" placeholder="ex)010-6611-8156">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-10 main-birth" style="width: 100%">
                                 <input class="form-control" type="text" name="m_birth"
                                    id="birth" placeholder="ex)921223">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-10 main-addr" style="width: 100%">
                                 <input class="form-control" type="hidden" name="m_address"
                                    id="addr" placeholder="근무지주소" value="">
                                 <input class="form-control" type="hidden"
                                    id="sample6_postcode" placeholder="우편번호" disabled="disabled">
                                 <input class="form-control" type="button"
                                    onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                                 <br> 
                                 <input class="form-control" type="text"
                                    id="sample6_address" placeholder="주소" disabled="disabled" value="서울"> 
                                 <input class="form-control" type="text"
                                    id="sample6_address2" placeholder="상세주소" disabled="disabled" value="강북구">
                              </div>
                           </div>


                           <div class="modal-footer">
                              <button id="add-btn" type="submit"
                                 class="form-control btn btn-primary"
                                 style="background-color: #787878; color: white;" disabled="disabled" onclick="onButton()">가입</button>
                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>

      <!-- 마이페이지 모달 -->
      <!-- 회원 : 마이페이지 모달창 -->
      <div class="modal fade" id="mypage" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true"
         style="position: center;">
         <div class="modal-dialog mypagemodal">
            <div class="modal-content"
               style="width: 80%; height: 95%; position: center;">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">
                     <span aria-hidden="true">×</span><span class="sr-only">Close</span>
                  </button>
                  <h4 class="modal-title" id="myModalLabel"
                     style="text-align: center">
                     <b>My Page</b>
                  </h4>
               </div>

               <div class="header" style="text-align: center; padding-top: 3%;">

                  <img class="image avatar" src="resources/images/avatar.jpg" alt="" />

               </div>

               <div class="modal-body">
                  <div style="vertical-align: top; width: 100%;">
                     <div style="text-align: center; padding-top: 3%;">

                        <form class="form-horizontal">
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="email" class="form-control"
                                    id="inputNick_change" placeholder="변경할 닉네임"
                                    value=${sessionScope.member.m_name } disabled="disabled">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="password" class="form-control"
                                    id="inputPassword_change1" placeholder="변경할 비밀번호">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="password" class="form-control"
                                    id="inputPassword_change2" placeholder="변경할 비밀번호 확인">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="password" class="form-control"
                                    id="inputPassword_change3" placeholder="현재 비밀번호">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="text" class="form-control"
                                    id="inputPhone_change" placeholder="현재 비밀번호"
                                    disabled="disabled" value=${sessionScope.member.m_phone }>
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-6" style="width: 100%">
                                 <input type="text" class="form-control" id="inputWork_change"
                                    value=${sessionScope.member.m_address } placeholder="근무지"
                                    disabled="disabled">
                              </div>
                           </div>

                           <!-- 우편번호 -->
                           <!-- <div class="form-group">
                                 <div class="col-sm-6" style="width: 100%">
                                    <input type="button" class="form-control"
                                       id="inputWork_change" value="우편번호찾기" onclick="postOpen();" />
                                 </div>
                              </div> -->

                        </form>
                     </div>

                  </div>

                  <hr />
                  <div style="text-align: center">
                     <h4 style="text-align: center; color: #787878;">
                        <b>목표달성도</b>
                     </h4>
                  </div>
                  <!— ProgressBar —>
                  <div class="progress" style="text-align: center">
                     <div class="progress-bar" role="progressbar" aria-valuenow="70"
                        aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
                        70%</div>
                  </div>

               </div>


               <div class="modal-footer" style="bottom: 2%;">
                  <button type="button" class="btn btn-default"
                     style="background-color: #787878; color: white;"
                     data-dismiss="modal">취소</button>
                  <button type="button" class="btn btn-default"
                     style="background-color: #787878; color: white;">저장</button>
               </div>
            </div>
         </div>
      </div>


      <!--로그인 모달창  -->
      <div class="modal fade" id="login" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true"
         style="position: center;">
         <div class="modal-dialog loginmodal" style="height:85%">
            <div class="modal-content"
               style="width: 80%; height: 50%; position: center;">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">
                     <span aria-hidden="true">×</span><span class="sr-only">Close</span>
                  </button>
                  <h4 class="modal-title" id="myModalLabel"
                     style="text-align: center">
                     <b>Login</b>
                  </h4>
               </div>

               <div class="modal-body">
                  <!-- <div style="vertical-align: top; width: 80%;"> -->
                  <div style="vertical-align: top;">
                     <div style="text-align: center; padding-top: 3%;">
                        <form action="login.do" class="form-horizontal" id="login-form"
                           method="post">

                           <div class="form-group">
                              <div class="col-sm-11 main-id"">
                                 <input type="text" class="form-control id" name="m_id"
                                    placeholder="Username" autofocus id="login_id">
                              </div>
                           </div>
                           <div class="form-group">
                              <div class="col-sm-11 main-id">
                                 <input type="password" class="form-control pass" name="m_pw"
                                    placeholder="Password" id="login_pw">
                              </div>
                           </div>
                           <div style="color: red; display: none;" id="warning">아이디
                              혹은 비밀번호를 확인해주세요.</div>
                           <div class="modal-footer">

                              <div>
                                 <button id="login-btn" id="ex-login-btn" id="mypage"
                                    type="button" class="form-control btn btn-primary signupbtn"
                                    style="background-color: #787878; color: white;"
                                    onclick="checkLogin()">로그인</button>
                              </div>


                           </div>
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         </div>



         <!-- Footer -->
         <footer id="footer">
         <div class="inner">
            <ul class="icons">
               <li><a href="#" class="icon fa-twitter"><span
                     class="label">Twitter</span></a></li>
               <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
               <li><a href="#" class="icon fa-dribbble"><span
                     class="label">Dribbble</span></a></li>
               <li><a href="#" class="icon fa-envelope-o"><span
                     class="label">Email</span></a></li>
            </ul>
            <ul class="copyright">
               <li>&copy; Untitled</li>
               <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
            </ul>
         </div>
         </footer>

         <!-- Scripts -->
         <script src="resources/assets/js/jquery.min.js"></script>
         <script src="resources/assets/js/jquery.poptrox.min.js"></script>
         <script src="resources/assets/js/skel.min.js"></script>
         <script src="resources/assets/js/util.js"></script>
         <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
         <script src="resources/assets/js/main.js"></script>

         <!-- 3줄 추가 -->
         <script src="node_modules/jquery/dist/jquery.min.js"></script>
         <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
         <script>
         function onButton(){
            console.log("버튼~");
            var $address=$("#sample6_address").val()+"";
            console.log($address);
            var $detailAddress=$("#sample6_address2").val()+"";
            console.log($detailAddress);
         </script>
         <script>
            $("#login-form").keydown(function(key) {
               if (key.keyCode == 13)
                  checkLogin();
            });
            //아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활성화를 위한 변수설정
            var idCheck = 0;
            //var nickCheck = 0;
            var pwdCheck = 0;
            //var checkLogin=0;
            function checkLogin() {
               var inputedId = $('#login_id').val();
               var inputedPw = $('#login_pw').val();
               console.log(inputedId);
               console.log(inputedPw)
               $.ajax({
                  data : {
                     m_id : inputedId,
                     m_pw : inputedPw
                  },
                  url : "login.do",
                  success : function(data) {
                     if (data == 1) {
                        $("#warning").css("display", "inline");
                        $('#login_pw').val("");
                     } else {
                        location.href = "index.do";
                     }
                  }
               });
            }
            //아이디 체크하여 가입버튼 비활성화, 중복확인.
            function checkId() {
               var inputed = $('#id').val();
               console.log(inputed);
               $.ajax({
                  data : {
                     m_id : inputed
                  },
                  url : "checkId.do",
                  success : function(data) {
                     if (inputed == "" && data == '0') {
                        $("#add-btn").prop("disabled", true);
                        $("#add-btn")
                              .css("background-color", "#aaaaaa");
                        $("#id").css("background-color", "#FFCECE");
                        idCheck = 0;
                     } else if (data == '0') {
                        $("#id").css("background-color", "#B0F6AC");
                        idCheck = 1;
                        if (idCheck == 1 && pwdCheck == 1) {
                           $("#add-btn").prop("disabled", false);
                           $("#add-btn").css("background-color",
                                 "#4CAF50");
                        }
                     } else if (data == '1') {
                        $("#add-btn").prop("disabled", true);
                        $("#add-btn")
                              .css("background-color", "#aaaaaa");
                        $("#id").css("background-color", "#FFCECE");
                        idCheck = 0;
                     }
                  }
               });
            }
            //재입력 비밀번호 체크하여 가입버튼 비활성화 또는 맞지않음을 알림.
            function checkPwd() {
               var inputed = $('#fi-password-add').val();
               var reinputed = $('#fi-password-check-add').val();
               console.log(inputed);
               console.log(reinputed);
               if (reinputed == ""
                     && (inputed != reinputed || inputed == reinputed)) {
                  $("#add-btn").prop("disabled", true);
                  $("#add-btn").css("background-color", "#aaaaaa");
                  $("#fi-password-check-add").css("background-color",
                        "#FFCECE");
               } else if (inputed == reinputed) {
                  $("#fi-password-add")
                        .css("background-color", "#B0F6AC");
                  $("#fi-password-check-add").css("background-color",
                        "#B0F6AC");
                  pwdCheck = 1;
                  if (idCheck == 1 && pwdCheck == 1) {
                     $("#add-btn").prop("disabled", false);
                     $("#add-btn").css("background-color", "#4CAF50");
                  }
               } else if (inputed != reinputed) {
                  pwdCheck = 0;
                  $("#add-btn").prop("disabled", true);
                  $("#add-btn").css("background-color", "#aaaaaa");
                  $("#fi-password-check-add").css("background-color",
                        "#FFCECE");

               }
            }
         </script>
         <!-- 다음 주소검색 js -->
         <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
         <script>
            function sample6_execDaumPostcode() {
               new daum.Postcode(
                     {
                        oncomplete : function(data) {
                           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                           // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                           var fullAddr = ''; // 최종 주소 변수
                           var extraAddr = ''; // 조합형 주소 변수

                           // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                           if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                              fullAddr = data.roadAddress;

                           } else { // 사용자가 지번 주소를 선택했을 경우(J)
                              fullAddr = data.jibunAddress;
                           }

                           // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                           if (data.userSelectedType === 'R') {
                              //법정동명이 있을 경우 추가한다.
                              if (data.bname !== '') {
                                 extraAddr += data.bname;
                              }
                              // 건물명이 있을 경우 추가한다.
                              if (data.buildingName !== '') {
                                 extraAddr += (extraAddr !== '' ? ', '
                                       + data.buildingName
                                       : data.buildingName);
                              }
                              // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                              fullAddr += (extraAddr !== '' ? ' ('
                                    + extraAddr + ')' : '');
                           }

                           // 우편번호와 주소 정보를 해당 필드에 넣는다.
                           /* document.getElementById('sample6_postcode').value = data.zonecode; */ //5자리 새우편번호 사용
                           document.getElementById('sample6_address').value = fullAddr;

                           // 커서를 상세주소 필드로 이동한다.
                           document.getElementById('sample6_address2')
                                 .focus();
                        }
                     }).open();
            }
            
         </script>
</body>
</html>