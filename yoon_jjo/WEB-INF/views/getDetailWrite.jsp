<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jjomuregi</title>
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="resources/assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<style type="text/css">
#popularPhotoList {
	width: 300px;
	height: 300px;
}

	#header{
		background-image: url("resources/assets/css/images/bong4.jpg");
		 background-repeat:  repeat,no-repeat;
		 background-size: auto 110%;
		 padding-top:3%;
	}
	#writeContent{
		height: 300px;
	}
	#profileImg{
		width: 200px;
	    height: 200px;
	    object-fit: cover;
	    object-position: top;
	    border-radius: 50%;
	    margin-right: 5%;
	}
	#profileimage{
		border-radius: 0%;
	}
</style>
<!-- 구글 폰트 추가  -->
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>


<!--2줄 추가  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="node_modules/bootstrap/dist/css/bootstrap.min.css" />

<body id="top">


	<!-- Header -->
	<header id="header"> <c:choose>
		<c:when test="${sessionScope.memberProfile.pp_fullpath!=noimage}">
			<!-- 마이페이지 클릭 -->
			<div class="inner">
				<a href="#" id="myPageArea" class="image avatar" data-toggle="modal"
					data-target="#mypage" onclick="myPage()" id="mypagebutton"
					style="margin-right: 20%;"> <img style="width: 200%;"
					src="${sessionScope.memberProfile.pp_fullpath }" alt="" />
				</a>
				<p id="member_id" style="visibility: hidden;">${sessionScope.member.m_id }</p>
				<p
               style="color: black; padding-bottom: 3%; font-size: 140%; margin: 0px; font-family: 'Jua', sans-serif;">${sessionScope.member.m_name}님
               환영합니다. <a href="logout.do" class="glyphicon glyphicon-off"
                  aria-hidden="true" style="color: #d4324e;"></a>
            </p>
			</div>

		</c:when>
		<c:otherwise>
			<!-- 마이페이지 클릭 -->
			<div class="inner">
				<a href="#" class="image avatar" data-toggle="modal"
					data-target="#mypage" onclick="myPage()" id="mypagebutton"><img
					src="resources/images/no_avatar.jpg" alt="" /></a>
			</div>
		</c:otherwise>
	</c:choose> <!-- 왼쪽 메뉴 -->
	<ul class="nav nav-pills nav-stacked"
		style="font-family: 'Do Hyeon', sans-serif; font-size: 180%;">
		<li role="presentation"><a
			style="border-bottom: none; color: black" href="index.do"> <img
				style="width: 30px;">HOME
		</a></li>
		<li role="presentation"><a
			style="border-bottom: none; cursor: pointer; color: black"
			onclick="window.open('chat.do','window','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no, width=442,height=545,left=0, top=0, scrollbars=no');return false">
				<img style="width: 30px;" src="resources/images/chat2.png">Chat
		</a></li>
		<li role="presentation"><a
			style="border-bottom: none; cursor: pointer; color: black"
			onclick="location.href='todolist.do?m_id=${sessionScope.member.m_id}';">
				<img style="width: 30px;" src="resources/images/checkList.png">To
				do list
		</a></li>
		<li role="presentation"><a
			style="border-bottom: none; color: black" href="getListWrite.do">
				<img style="width: 30px;" src="resources/images/edit.png">글
				게시판
		</a></li>
		<li role="presentation"><a
			style="border-bottom: none; color: black" href="getListPhoto.do">
				<img style="width: 30px;" src="resources/images/photo.png">사진
				게시판
		</a></li>
	</ul>
	</header>




	<!-- Main -->
	<div id="main">


		<!-- Two -->
		<section id="two">
		<form name="form" method="post">
			<table border="1" style="width: 600px">
				<caption>글 게시판</caption>
				<colgroup>
					<col width='15%' />
					<col width='*%' />
				</colgroup>
				<tbody>
					<tr>
						<td>글 번호</td>
						<td><input type="text" size="70" id="writeNo" name="w_no"
							maxlength="250" value="${getDetail.w_no}" readonly></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" size="70" id="writeTitle"
							name="w_title" value="${getDetail.w_title}" maxlength="250"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea type="text" size="70" id="writeContent"
								name="w_content" maxlength="250">${getDetail.w_content}</textarea>
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" size="20" id="writeWriter"
							name="w_writer" maxlength="20" value="${getDetail.w_writer}"></td>
					</tr>
					<tr>
						<td>등록일</td>
						<td><input type="text" size="70" id="writeDate" name="w_date"
							maxlength="250" value="${getDetail.w_date}"></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td><input type="text" size="70" id="writeDate" name="w_date"
							maxlength="250" value="${getDetail.w_count}"></td>
					</tr>

				</tbody>
			</table>
			<div style="text-align:center;">
			<c:if test="${sessionScope.member.m_name==getDetail.w_writer }">
				<button id="up-btn" class="btn btn-success" onclick='up();'>변경</button>
            <button id="del-btn" class="btn btn-warning" onclick='del();'>삭제</button>
			</c:if>
			<a href="getListWrite.do?curPage=${curPage }" class="btn btn-primary" id="list-btn">목록</a>
         </div>
		</form>


		<caption>댓글 리스트</caption>
		<c:forEach items="${getReply}" var="reply">
			<form action="updateReply.do" name="formReply"
				style="margin-bottom: -4%">
				<table border="1" style="width: 600px">
					<colgroup>
						<col width='15%' />
						<col width='*%' />
					</colgroup>
					<tbody>
						<tr>
							<td>${reply.r_writer}</td>
							<td style="width: 40%"><input type="text" size="70"
								id="replyContent" name="r_content" value="${reply.r_content}"
								maxlength="250"></td>
							<td>${reply.r_date}</td>
							<td>
							<c:if test="${sessionScope.member.m_name==reply.r_writer }">
								<button id="re-btn"
									class="glyphicon glyphicon-pencil btn btn-link"
									style="padding-bottom: 12%;"margin-left: 90%;""></button> 
								<a class="glyphicon glyphicon-remove"
								href="deleteReply.do?r_no=${reply.r_no}&w_no=${getDetail.w_no}&curPage=${curPage }&m_id=${sessionScope.member.m_id }"></a>							
							</c:if>
							<td>
						</tr>
						<input type="hidden" name="m_id"
							value="${sessionScope.member.m_id }" />
						<input type="hidden" name="curPage" value="${curPage }">
						<input type="hidden" name="r_no" value="${reply.r_no }">
						<input type="hidden" size="70" id="writeNo" name="w_no"
							maxlength="250" value="${getDetail.w_no}" readonly>
					</tbody>
				</table>
				
			</form>
		</c:forEach>


		<form action="insertReply.do" method="post" style="padding-top: 4%;">
			<table border="1" style="width: 600px">
				<colgroup>
					<col width='15%' />
					<col width='*%' />
				</colgroup>
				<tbody>
					<tr>
						<td style="width: 80%;"><input type="text" size="270"
							name="r_content" placeholder="댓글을 입력하세요"></td>
						<td>
							<button type="submit"
								class="btn btn-link glyphicon glyphicon-plus" id="add-reply"
								style="margin-left: 38%;"></button>
						<td>
					</tr>
					<input type="hidden" name="m_id"
						value="${sessionScope.member.m_id }" />
					<input type="hidden" name="curPage" value="${curPage }">
					<input type="hidden" size="70" id="writeNo" name="w_no"
						maxlength="250" value="${getDetail.w_no}" readonly />
					<c:choose>
						<c:when test="${sessionScope.member!=null}">
							<input type="hidden" size="20" id="replyWriter" name="r_writer"
								maxlength="20" value="${sessionScope.member.m_name}" readonly />
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</form>
		
		
		
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

						<img style="width:40%" id="profileimage"class="image avatar" src="resources/images/avatar.jpg" alt="" />

					</div>

					<div class="modal-body">
						<div style="vertical-align: top; width: 100%;">
							<div style="text-align: center; padding-top: 3%;">

								<form class="form-horizontal">
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="email" class="form-control"
												id="inputNick_change" placeholder="변경할 닉네임" disabled="disabled">
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
												id="inputPhone_change" placeholder=""
												disabled="disabled">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="text" class="form-control" id="inputWork_change"
												 placeholder="근무지"	disabled="disabled">
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
						<!-- progressbar -->
						<div class="progress" style="text-align: center">
							<div class="progress-bar" role="progressbar" aria-valuenow="${rate }"
								aria-valuemin="0" aria-valuemax="100" style="width: ${rate }%;">
								${rate }%
							</div>
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
		
		
		
		
		</section>


		<!-- Scripts -->
		<script src="resources/assets/js/jquery.min.js"></script>
		<script src="resources/assets/js/jquery.poptrox.min.js"></script>
		<script src="resources/assets/js/skel.min.js"></script>
		<script src="resources/assets/js/util.js"></script>
		<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
		<script src="resources/assets/js/main.js"></script>
		
		
		
		<!-- 2줄 추가 -->
			<script src="node_modules/jquery/dist/jquery.min.js"></script>
			<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

		<!--모달 스크립트 추가  -->
		<script>
			//마이페이지 객체데이터 받기
			function myPage() {
				$.ajax({
					url : "myPage.do",
					dataType : "json",
					success : function(data) {
						if (data != null) {
							$("#inputNick_change").val(data.m_id);
							$("#inputPhone_change").val(data.m_phone);
							$("#inputWork_change").val(data.m_address);
							$("#profileimage").attr('src', data.pp_fullpath);
							/* console.log(data[0].m_id);
							console.log(data[0].m_phone);
							console.log(data[0].m_address); */
							console.log(data[0].pp_fullpath);
						}
					}
				});
			}
		</script>



		<script>
function del() {
	form.action="deleteWrite.do";
};
</script>
		<script>
function up() {
	form.action="updateWrite.do";
};
</script>
		<!-- 3줄 추가 -->
		<script src="node_modules/jquery/dist/jquery.min.js"></script>
		<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>