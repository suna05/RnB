<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="../node_modules/bootstrap/dist/css/bootstrap.min.css" />

<body id="top">

	<!-- Header -->
	<header id="header">


	<button id="login1" class="btn btn-default"
		style="background-color: #33cc99; color: white; margin-bottom: 5px;"
		data-toggle="modal" data-target="#login" onclick="login_click();">Login</button>

	<button id="join1" class="btn btn-default"
		style="background-color: #33cc99; color: white; margin-bottom: 5px;"
		data-toggle="modal" data-target="#join">Join Us</button>




	<div class="inner">
		<a href="#" class="image avatar"><img
			src="resources/images/avatar.jpg" alt="" /></a>
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

		<!--로그인 모달창  -->
		<div class="modal fade" id="login" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="position: center;">
			<div class="modal-dialog loginmodal">
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
								<form class="form-horizontal" id="login-form" method="post">

									<div class="form-group">
										<div class="col-sm-11 main-id"">
											<input type="text" class="form-control id" name="id" 
												 placeholder="Username" autofocus>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-11 main-id">
											<input type="password" class="form-control pass" name="pw" placeholder="Password">
										</div>
                       <div>
									</div>
								</form>
							</div>
										 <c:if test="${loginFail==true }">
                          <div style="color:red">
                             아이디 혹은 비밀번호를 확인해주세요.
                          </div>
                       </c:if>
						</div>

<!-- 						<div class="modal-footer" style="margin-top: 0%;">
							<button type="button" class="btn btn-default"
								style="background-color: #33cc99; color: white; margin-left:2%"
								data-dismiss="modal">취소</button>
								 -->
								 
							<button id="login-btn" id="ex-login-btn" id="mypage"
								type="submit" class="form-control btn btn-primary signupbtn"
								style="background-color: #33cc99; color: white;">로그인</button>
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
							<div style="vertical-align: top; width: 100%;">
								<div style="text-align: center; padding-top: 3%; width: 100%">
									<form class="form-horizontal" style="width: 100%">

										<div class="form-group">
											<div class="col-sm-10 main-id" style="left: 5%; right: 15%">
												<input type="text" class="form-control"
													name="id" placeholder="아이디">
											</div>
										</div>
										
										
										<div class="form-group">
											<div class="col-sm-10 main-id" style="left: 5%; right: 15%">
												<input type="text" class="form-control" id="fi-nickname-add"
													name="nickname" placeholder="닉네임">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-10 main-pwd" style="left: 5%; right: 15%">
												<input type="password" class="form-control"
													id="fi-password-add" name="password" placeholder="비밀번호"
													onkeyup="checkPass(); return false;">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-10 main-pwd" style="left: 5%; right: 15%">
												<input class="form-control" type="password" name=""
													id="fi-password-check-add" placeholder="비밀번호 확인"
													onkeyup="checkPass(); return false;"> <span
													id="confirmMessage" class="confirmMessage"></span>
											</div>
										</div>
									</form>
								</div>



							</div>
						</div>


						<div class="modal-footer" style="margin-top: 26%;">
							<button type="button" class="btn btn-default"
								style="background-color: #fa507b; color: white;"
								data-dismiss="modal">취소</button>
							<button id="add-btn" type="button" class="btn btn-default"
								style="background-color: #fa507b; color: white;">가입</button>
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
			<script src="../js/mainLogin.js"></script>
			<script src="../node_modules/jquery/dist/jquery.min.js"></script>
			<script src="../node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>