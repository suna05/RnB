<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/homeBackground.css">
   <link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
<!------ Include the above in your HEAD tag ---------->
<html lang="ko">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="charset=utf-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
		<title>Jjomuregi</title>
		<style type="text/css">
			body, html{
			    height: 120%;
			 	background-color: #d3d3d3;
			 	font-family: 'Oxygen', sans-serif;
			}
			
			.main{
			 	margin-top: 70px;
			}
			
			h1.title { 
				font-size: 50px;
				font-family: 'Passion One', cursive; 
				font-weight: 400; 
			}
			
			hr{
				width: 10%;
				color: #fff;
			}
			
			.form-group{
				margin-bottom: 10px;
			}
			
			label{
				margin-bottom: 15px;
			}
			
			input,
			input::-webkit-input-placeholder {
			    font-size: 11px;
			    padding-top: 3px;
			}
			
			.main-login{
			 	background-color: #fff;
			    /* shadows and rounded borders */
			    -moz-border-radius: 2px;
			    -webkit-border-radius: 2px;
			    border-radius: 2px;
			    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			
			}
			
			.main-center{
			 	margin-top: 30px;
			 	margin: 0 auto;
			 	max-width: 330px;
			    padding: 40px 40px;
			
			}
			
			.login-button{
				margin-top: 5px;
			}
			
			.login-register{
				font-size:11px;
				text-align: center;
			}
			.btn-lg{
				font-size:13px;
			}
			.btn{
				margin-top: 10px;
			}
			.join-button{
				margin-top:5px;
			}
		</style>
		
	</head>
	<body>
		<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title" style="color:#787878">jjomuregi of RnB </h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form id="login-form" class="form-horizontal" method="post" action="login.do">
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="m_id" id="login_id"  placeholder="Enter your Username"/>
								</div>
							</div>
						</div>
						<div style="color: red; display: none;" id="warning">아이디 혹은 비밀번호를 확인해주세요.</div>
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="m_pw" id="login_pw"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="button" style="background-color: #787878" class="btn btn-primary btn-lg btn-block login-button" onclick="checkLogin()">로그인</button>
						</div>
						<div class="login-register">
					</form>
					<div class="form-group ">
						<button type="button" style="background-color: #787878" class="btn btn-primary btn-lg btn-block join-button"
						data-toggle="modal" data-target="#join">회원가입</button>
						<br>
					</div>
				    </div>
				</div>
			</div>
		</div>
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
								<p id="status"></p>
								<div id="holder"></div>
								<br>
								<form action="insertMember.do" class="form-horizontal"
									style="width: 100%" method="post" enctype="multipart/form-data">
									<div class="form-group">
										<div class="col-sm-10 main-id" style="width: 100%">
											<input type="file" id="profilefile" class="form-control" name="profilePhoto"/>
										</div>
									</div>
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
											<input class="form-control" type="hidden"
												id="sample6_postcode" placeholder="우편번호" disabled="disabled">
											<input class="form-control" type="button"
												onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
											<br> 
											<input class="form-control" type="text"
												id="sample6_address" placeholder="주소" disabled="disabled"> 
											<input class="form-control" type="text"
												id="sample6_address2" placeholder="상세주소" name="m_address">
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
		<!-- <script type="text/javascript" src="assets/js/bootstrap.js"></script> -->
		<script>
				function onButton(){
					var address=$("#sample6_address").val();
					var detailAddress=$("#sample6_address2").val();
					$("#sample6_address2").val(address+" "+detailAddress);
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
				$("#login-form").keydown(function(key) {
					if (key.keyCode == 13)
						checkLogin();
				});
				/* function otherChecked(){
					var mname=$("#name").val();
					var mphone=$("#phone").val();
					var mbirth=$("#birth").val();
					var address1=$("#sample6_address").val();
					var address2=$("#sample6_address2").val();
					
					if(mname=="" || mphone=="" || mbirth=="" || address1=="" || address2==""){
						alert('모든 항목을 다 작성해주세요.');
						return false;
					}
				} */
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
							console.log(data);
							if (data == 1) {
								$("#warning").css("display", "inline");
								$('#login_pw').val("");
							} else {
								location.href = "index.do";
							}
						}
					});
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
	<script>
		var upload = document.getElementById('profilefile'), holder = document
				.getElementById('holder'), state = document
				.getElementById('status');

		if (typeof window.FileReader === 'undefined') {
			//state.className = 'fail';
		} else {
			state.innerHTML = '';
		}

		upload.onchange = function(e) {
			e.preventDefault();

			var file = upload.files[0], reader = new FileReader();
			reader.onload = function(event) {
				var img = new Image();
				img.src = event.target.result;
				// note: no onload required since we've got the dataurl…I think! :)
				img.width = 200;
				holder.innerHTML = '';
				//미리보기 이미지 사이즈 줄이기
				$(img).css('width', '40%');
				holder.appendChild(img);
			};
			reader.readAsDataURL(file);

			return false;
		};
	</script>
</body>
</html>