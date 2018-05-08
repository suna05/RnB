<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
<style type="text/css">
.pageNo {
	list-style: none;
	margin: 0;
	padding: 0;
	position: absolute;
}

.no {
	float: left;
	margin: 5px;
}

.no>a:ACTIVE {
	color: orange;
}
}
</style>
<title>Jjomuregi</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/assets/css/main.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
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


	<!-- Header -->
	<header id="header"> 
			<c:choose>
				<c:when test="${sessionScope.memberProfile.pp_fullpath!=noimage}">
					<!-- 마이페이지 클릭 -->
					<div class="inner">
						<a href="#"  id="myPageArea" class="image avatar" data-toggle="modal"
							data-target="#mypage" onclick="myPage()" id="mypagebutton" style="margin-right: 20%;">
							<img style="width: 200%;" src="${sessionScope.memberProfile.pp_fullpath }"
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
				</ul>
	</header>

	<!-- Main -->
	<div id="main">

		<!-- Two -->
		<section id="two">
		<div id="write">
			<table border="1" style="width: 600px">

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
				<tbody>
					<c:forEach items="${writeList}" var="write">
						<tr>
							<td>${write.rnum}</td>
							<td><a href='getDetailWrite.do?w_no=${write.w_no}&curPage=${pager.curPage}&m_id=${sessionScope.member.m_id }'>${write.w_title}</a></td>
							<td>${write.w_writer}</td>


							<td>${write.w_date}</td>

							<td>${write.w_count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
     	  <!-- page list --> <nav aria-label="Page navigation example">
   <ul class="pagination pageNo"
      style="padding-left: 15%; display: block;">
      <c:choose>
         <c:when test="${pager.curPage!=1 }">
            <li class="no"><a aria-label="Previous"
               href="getListWrite.do?curPage=${pager.curPage-1 }">Previous</a></li>
         </c:when>
      </c:choose>
      <c:forEach var="pageNo" begin="${pager.startPage }"
         end="${pager.endPage }" step="1">
         <li class=" page-item no"><a
            href="getListWrite.do?curPage=${pageNo }">${pageNo }</a></li>
      </c:forEach>
      <c:choose>
         <c:when test="${pager.curPage!=pager.lastPage }">
            <li class="no"><a
               href="getListWrite.do?curPage=${pager.curPage+1 }">next</a></li>
         </c:when>
      </c:choose>
   </ul>
   </nav> </section>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10" style="margin-left: 0">
         <a href="write.do" class="btn btn-primary wirte-new" id="add-btn">추가</a>
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
		
		<!-- 2줄 추가 -->
			<script src="node_modules/jquery/dist/jquery.min.js"></script>
			<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
		


		<script src="resources/assets/js/jquery.min.js"></script>
		<script src="resources/assets/js/jquery.poptrox.min.js"></script>
		<script src="resources/assets/js/skel.min.js"></script>
		<script src="resources/assets/js/util.js"></script>
		<script src="assets/js/ie/respond.min.js"></script>
		<script src="resources/assets/js/main.js"></script>
		<script scr="js/getDetailWrite.js"></script>
</body>
</html>