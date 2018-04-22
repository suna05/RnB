<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판읽기</title>
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
			<strong>게시판 읽기</a>.
		</h1>
	</div>



	</header>




	<!-- Main -->
	<div id="main">


		<!-- Two -->
		<section id="two">
		<div id="photo">
				<table border="1" style="width: 600px">
					<caption>게시판 읽기</caption>
					<colgroup>
						<col width='15%' />
						<col width='*%' />
					</colgroup>
					<tbody>
		<c:forEach items="${getListPhoto}" var="photo">
						<tr>
							<td>글 번호</td>
							<td>${photo.p_no}</td>
						</tr>
						
						<tr>
							<td>제목</td>
							<td>${photo.p_title}</td>
						</tr>
						
						<tr>
							<td>작성자</td>
							<td>${photo.p_writer}</td>
						</tr>
						
						<tr>
							<td>등록일</td>
							<td>${photo.p_date}</td>
						</tr>
						<tr>
							<td>
							<img src='${photo.bp_fullpath}'>
							</td>
						</tr>
							<tr>
							<td>
							<img src="<%= request.getContextPath() %>${photo.bp_fullpath}"/>
							</td>
						</tr>
						
					</c:forEach>
					</tbody>
				</table>
			</div>


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
												id="addr" placeholder="근무지주소" value=""> <input
												class="form-control" type="hidden" id="sample6_postcode"
												placeholder="우편번호" disabled="disabled"> <input
												class="form-control" type="button"
												onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
											<br> <input class="form-control" type="text"
												id="sample6_address" placeholder="주소" disabled="disabled"
												value="서울"> <input class="form-control" type="text"
												id="sample6_address2" placeholder="상세주소" disabled="disabled"
												value="강북구">
										</div>
									</div>


								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


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
var upload = document.getElementsByTagName('input')[0],
    holder = document.getElementById('holder'),
    state = document.getElementById('status');

if (typeof window.FileReader === 'undefined') {
  state.className = 'fail';
} else {
  state.className = 'success';
  //state.innerHTML = 'File API & FileReader available';
}
 
upload.onchange = function (e) {
  e.preventDefault();

  var file = upload.files[0],
      reader = new FileReader();
  reader.onload = function (event) {
    var img = new Image();
    img.src = event.target.result;
    // note: no onload required since we've got the dataurl...I think! :)
    if (img.width > 560) { // holder width
      img.width = 560;
    }
    holder.innerHTML = '';
    holder.appendChild(img);
  };
  reader.readAsDataURL(file);

  return false;
};
</script>
</body>
</html>