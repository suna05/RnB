<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jjomuregi</title>
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/assets/css/main.css" />
<!--2줄 추가  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css" />

<style type="text/css">
	#popularPhotoList{
		width: 300px;
		height: 300px;
	}
	#header{
		background-image: url("resources/assets/css/images/bong4.jpg");
		 background-repeat:  repeat,no-repeat;
		 background-size: auto 110%;
		 padding-top:3%;
	}
	#profileImg{
		width: 200px;
	    height: 200px;
	    object-fit: cover;
	    object-position: top;
	    border-radius: 50%;
	    /* margin-right: 35%; */
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
	<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
</head>

<body id="top">
	<!-- Header -->
	<header id="header"> 
			<c:choose>
				<c:when test="${sessionScope.memberProfile.pp_fullpath!=noimage}">
					<!-- 마이페이지 클릭 -->
					<div class="inner">
						<a href="#"  id="myPageArea" class="image avatar" data-toggle="modal"
							data-target="#mypage" onclick="myPage()" id="mypagebutton" style="margin-right: 20%;">
							<img id="profileImg" style="width: 200%;" src="${sessionScope.memberProfile.pp_fullpath }"
							alt=""/>
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
							data-target="#mypage" onclick="myPage()" id="mypagebutton"><img src="resources/images/no_avatar.jpg"
							alt=""/></a>
					</div>
				</c:otherwise>
				</c:choose>
				<!-- 왼쪽 메뉴 -->
				<ul class="nav nav-pills nav-stacked"
					style="font-family: 'Do Hyeon', sans-serif; font-size: 180%;">
					<li role="presentation"><a
					style="border-bottom: none; color: black" href="index.do">
						<img style="width: 30px;">HOME
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
					<li role="presentation"><a
						style="border-bottom: none; color: black" href="/intrornb">
							<img style="width: 30px;">회사소개
					</a></li>
				</ul>
	</header>
	<!-- Main -->
	<div id="main" style="padding-top: 3%;">
		<!-- Two -->
		<section id="one" style="text-align: center;">
		<h2 style="font-family: 'Jua', sans-serif; text-aling: center;">인기
			사진</h2>
		<div>
			<div id="popularPhoto" class="row"></div>
			<h2 style="font-family: 'Jua', sans-serif;">인기 글</h2>
			<table border="1" style="width: 600px"align:"center">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<colgroup>
					<col width='15%' />
					<col width='*%' />
				</colgroup>
				<tbody id="popularWrite">
				</tbody>
			</table>
		</div>
			<!-- 동료들 주소 -->
			<p style="margin-top: -12px">
				<em class="link"> <a href="javascript:void(0);"
					onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
						혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요. </a>
				</em>
			</p>
			<div id="map" style="width: 100%; height: 350px;"></div>
		</section>
			
		</section>
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

								<form id="updateForm" action="updateMember.do" class="form-horizontal">
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="email" class="form-control"
												id="inputNick_change" placeholder="변경할 닉네임" name="m_id" readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="password" class="form-control"
												id="inputPassword_change1" placeholder="변경할 비밀번호" name="changePw1" oninput="checkPwd()">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="password" class="form-control"
												id="inputPassword_change2" placeholder="변경할 비밀번호 확인" name="changePw2" oninput="checkPwd()">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-6" style="width: 100%">
											<input type="password" class="form-control"
												id="inputPassword_change3" placeholder="현재 비밀번호" name="m_pw" oninput="checkPwd2()">
											<input type="hidden" value="${sessionScope.member.m_pw }" id="currentPw">
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
						<button id="updateBtn" type="submit" class="btn btn-default"
							style="background-color: #787878; color: white;" onclick="clickUpdateBtn()">저장</button>
					</div>
					</form>
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

			<!-- 2줄 추가 -->
			<script src="node_modules/jquery/dist/jquery.min.js"></script>
			<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
			<!-- 다음 주소검색 js -->
			<!--  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->
			<script type="text/javascript">
				$(document).ready(function(){
					$.ajax({
						url:"getListPopular.do",
						dataTyple:"json",
						success:function(data){
							for(var ele in data){
									var addTag='<article id="pp" class="6u 12u$(xsmall) work-item">'+
									 "<a id='pp2' href=resources/boardPhoto/"+data[ele].bp_fullpath+" class='image fit thumb'>"+
									 "<img id='popularPhotoList' src=resources/boardPhoto/"+data[ele].bp_fullpath+" alt=''/></a>"+
								"<h3>"+data[ele].p_title+"</h3></article>";
								$("#popularPhoto").append(addTag);
							}
						}
					});
					$.ajax({
						url:"getListPopularWrite.do",
						dataType:"json",
						success:function(data){
							var m_id=$("#member_id").text();
							console.log(m_id);
							for(var ele in data){
								console.log(data[ele]);
								var addTag2="<tr><td>"+data[ele].rnum+"</td>"+
												"<td><a href='"+"getDetailPopularWrite.do?w_no="+data[ele].w_no+"&m_id="+
														m_id+"'>"
														+data[ele].w_title+"</a></td>"+
												"<td>"+data[ele].w_writer+"</td>"+
												"<td>"+data[ele].w_date+"</td>"+
												"<td>"+data[ele].w_count+"</td>"+
											"</tr>";
								$("#popularWrite").append(addTag2);
							}
						}
					})
				});
				<%-- <c:forEach items="${writeList}" var="write">
				<tr>
					<td>${write.rnum}</td>
					<td><a href='getDetailWrite.do?w_no=${write.w_no}&curPage=${pager.curPage}&m_id=${sessionScope.member.m_id }'>${write.w_title}</a></td>
					<td>${write.w_writer}</td>


					<td>${write.w_date}</td>

					<td>${write.w_count}</td>
				</tr>
			</c:forEach> --%>
			</script>
			<script>
				//마이페이지 객체데이터 받기
				function myPage() {
					$.ajax({
						url : "myPage.do",
						dataType:"json",
						success : function(data) {
							if(data!=null){
								$("#inputNick_change").val(data.m_id);
								$("#inputPhone_change").val(data.m_phone);
								$("#inputWork_change").val(data.m_address);
								$("#profileimage").attr('src',data.pp_fullpath);
								/* console.log(data[0].m_id);
								console.log(data[0].m_phone);
								console.log(data[0].m_address); */
								console.log(data[0].pp_fullpath);
							}
						}
					});
				}
			</script>
			<!-- 다음 지도 api -->
			<!-- 원래코드 -->
			<!-- src="//dapi.kakao.com/v2/maps/sdk.js?appkey=de91184cf14f6b2a0ab64e4322c77be4&libraries=services"> -->
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=de91184cf14f6b2a0ab64e4322c77be4&libraries=services">
			</script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level : 9
			// 지도의 확대 레벨
			};

			// 지도를 생성합니다    
			var map = new daum.maps.Map(mapContainer, mapOption);
			<c:forEach items="${memberList}" var="member">
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();
			// 주소로 좌표를 검색합니다
			geocoder
					.addressSearch(
							'${member.m_address }',
							function(result, status) {
								// 정상적으로 검색이 완료됐으면 
								if (status === daum.maps.services.Status.OK) {
									var coords = new daum.maps.LatLng(
											result[0].y, result[0].x);
									// 결과값으로 받은 위치를 마커로 표시합니다
									var marker = new daum.maps.Marker({
										map : map,
										position : coords
									});
									// 인포윈도우로 장소에 대한 설명을 표시합니다
									var addr = '${member.m_address}';
									var name = '${member.m_name}';
									var sameAddr = "";
									<c:forEach items="${memberList}" var="member">
									if (addr == '${member.m_address}'
											&& name != '${member.m_name}') {
										sameAddr += "," + '${member.m_name}';
									}
									</c:forEach>

									var infowindow = new daum.maps.InfoWindow(
											{
												content : '<div style="width:150px;text-align:center;padding:6px 0;">'
														+ name
														+ sameAddr
														+ '</div>'
											});
									infowindow.open(map, marker);
									// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									map.setCenter(coords);
								}
							});
			</c:forEach>
		</script>
		<script type="text/javascript">
		function checkPwd() {
			var inputed = $('#inputPassword_change1').val();
			var reinputed = $('#inputPassword_change2').val();
			var currentPw=$("#currentPw").val();
			console.log(currentPw);
			var currentPwInput=$("#inputPassword_change3").val();
			if (reinputed == ""
					&& (inputed != reinputed || inputed == reinputed)) {
				$("#inputPassword_change2").css("background-color",
						"#FFCECE");
			} else if (inputed == reinputed) {
				$("#inputPassword_change1")
						.css("background-color", "#B0F6AC");
				$("#inputPassword_change2").css("background-color",
						"#B0F6AC");
			} else if (inputed != reinputed) {
				pwdCheck = 0;
				$("#add-btn").prop("disabled", true);
				$("#add-btn").css("background-color", "#aaaaaa");
				$("#fi-password-check-add").css("background-color",
						"#FFCECE");
			} 
			
			
		}
		function checkPwd2(){
			var currentPw=$("#currentPw").val();
			console.log(currentPw);
			var currentPwInput=$("#inputPassword_change3").val();
			if(currentPw == currentPwInput){
				$("#inputPassword_change3")
				.css("background-color", "#B0F6AC");
			} else if(currentPw !=currentPwInput){
				$("#inputPassword_change3").css("background-color",
				"#FFCECE");
			}
		}
		/* function clickUpdateBtn(){
			function del() {
				$("#updateForm").action = "updateMember.do";
			};
		} */
		</script>
</body>
</html>