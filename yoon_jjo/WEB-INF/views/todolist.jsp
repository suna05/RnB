<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jjomuregi</title>
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon"/>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="resources/assets/css/main.css" />
<style type="text/css">
	#popularPhotoList{
		width: 300px;
		height: 300px;
	}
	#header {
		background-image: url("resources/assets/css/images/bong4.jpg");
		background-repeat: repeat, no-repeat;
		background-size: auto 110%;
		padding-top: 3%;
	}	
	#myDIV{
		background-color: #787878;
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
							<span aria-hidden="true"></span><span class="sr-only">Close</span>
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
		
	<style type="text/css">
		/* Include the padding and border in an element's total width and height */
		/* * {
		    box-sizing: border-box;
		} */
		
		#main{
			padding-top: 3%;
			padding-right: 0%;
		}
		
		body{
			text-align: center;
		}
		
		th {
			text-align: center;
		}
		
		/* Remove margins and padding from the list */
		#myToDoList {
		    margin: 0;
		    padding: 0;
		}
		
		/* Style the list items */
		#myToDoList li {
		    cursor: pointer;
		    position: relative;
		    padding: 12px 8px 12px 40px;
		    background: #eee;
		    font-size: 18px;
		    transition: 0.2s;
		    text-align: left;
		
		    /* make the list items unselectable */
		    -webkit-user-select: none;
		    -moz-user-select: none;
		    -ms-user-select: none;
		    user-select: none;
		}
		
		/* Set all odd list items to a different color (zebra-stripes) */
		#myToDoList li:nth-child(odd) {
		    background: #f9f9f9;
		}
		
		/* Darker background-color on hover */
		#myToDoList li:hover {
		    background: #ddd;
		}
		
		/* When clicked on, add a background color and strike out text */
		#myToDoList li.checked {
		    background: #888;
		    color: #fff;
		    text-decoration: line-through;
		}
		
		/* Add a "checked" mark when clicked on */
		#myToDoList li.checked::before {
		    content: '';
		    position: absolute;
		    border-color: #fff;
		    border-style: solid;
		    border-width: 0 2px 2px 0;
		    top: 10px;
		    left: 16px;
		    transform: rotate(45deg);
		    height: 15px;
		    width: 7px;
		}
		
		/* Style the close button */
		.close {
		    position: absolute;
		    right: 0;
		    top: 0;
		    padding: 12px 16px 12px 16px;
		}
		
		.close:hover {
		    background-color: #787878;
		    color: white;
		}
		
		/* Style the header */
		#myDIV {
		    background-color: #787878;
		    padding: 30px 40px;
		    color: white;
		    text-align: center;
		    width: 100%;
		}
		
		/* Clear floats after the header */
		.header:after {
		    content: "";
		    display: table;
		    clear: both;
		}
		
		/* Style the input */
		#myInput {
		    border: none;
		    width: 90%;
		    padding: 10px;
		    float: left;
		    font-size: 16px;
		    color: black;
		    text-align: left;
		}
		
		/* Style the "Add" button */
		.addBtn {
		    padding: 10px;
		    width: 10%;
		    background: #d9d9d9;
		    color: #555;
		    float: left;
		    text-align: center;
		    font-size: 16px;
		    cursor: pointer;
		    transition: 0.3s;
		}
		
		.addBtn:hover {
		    background-color: #bbb;
		}
		
	</style>
		


<script type="text/javascript">
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
				console.log(data[0].m_address);
				console.log(data[1].pp_fullpath); */
			}
		}
	});
}
	function formCheck()
	{
		var liTag = document.getElementsByName("t_content");	// ToDoList 내용
		var t_writer = document.getElementById("t_writer");			// 작성자 이름
		var m_id = document.getElementById("m_id");
		
		//var obtain = "0";
		var t_content = [];		// ToDoList를 담아서 Controller로 전달하기 위한 배열 선언
		
		for(var i=0; i<liTag.length; i++)
		{
			t_content[i] = liTag[i].getAttribute("data-value");
		}
		
		//alert(strArr);			// 값 전달 테스트용
		//alert(input.value);		// 값 전달 테스트용
		
		if(t_content == "")
		{
			alert("ToDoList를 작성하세요.");
			
			return false;
		}
		
		location.href="register.do?t_content=" + t_content + "&t_writer=" + t_writer.value + "&m_id=" + m_id.value;
	}
	
	function completeCheck(t_no)
	{
		var id = document.getElementById("m_id");
		
		if(!confirm("목표를 달성하였습니까?"))
		{
			return;
		}
		
		location.href="todolistComplete.do?t_no=" + t_no + "&m_id=" + id.value;
	}
	
	function deleteCheck(t_no)
	{
		var id = document.getElementById("m_id");
		
		if(!confirm("정말로 삭제하시겠습니까?"))
		{
			return;
		}
		
		location.href = "todolistDelete.do?t_no=" + t_no + "&m_id=" + id.value;
	}
</script>

<div id="myDIV" class="header">
	<h2>My To Do List</h2>
	<input type="text" id="myInput" placeholder="To Do List.."/>
	<span onclick="newElement()" class="addBtn">Add</span>
</div>
<form style="width: 100%;">
	<input type="hidden" id="t_writer" name="t_writer" value="${sessionScope.member.m_name }" />
	<input type="hidden" id="m_id" name="m_id" value="${sessionScope.member.m_id }" />
	<div style="width:100%; height:200px; overflow:auto">
	
	<ul id="myToDoList">
  		<!-- li tag 입력된다. -->
	</ul>
	
	</div>
	<br/><br/><br/>
	<button type="button" class="btn btn-primary" name="complete" onclick="formCheck();">완료</button>
	<button type="button" class="btn btn-primary" name="main_btn" onclick="location.href='index.do?rate=${rate }';">메인</button>
</form>

<hr/>
<input type="hidden" id="t_writer" name="t_writer" value="${ sessionScope.member.m_name}" />
	<div style="width:100%; height:200px; overflow:auto">
	<table id="listTable" class="table table-striped">
	<thead>
		<colgroup>
			<col width="5%" />
			<col width="30%" />
			<col width="15%" />
			<col width="20%" />
			<col width="15%" />
			<col width="15%" />
		</colgroup>
		<tr>
			<th>number</th>
			<th style="text-align: center;">content</th>
			<th style="text-align: center;">writer</th>
			<th style="text-align: center;">date</th>
			<th style="text-align: center;">complete</th>
			<th style="text-align: center;">delete</th>
		</tr>
	</thead>
	<tbody id="tableBody">
		<c:forEach items="${list }" var="list" varStatus="loop">
		<tr>
			<td>${ list.t_no}</td>
			<td>${ list.t_content}</td>
			<td>${ list.t_writer}</td>
			<td>${ list.t_date}"</td>
			<c:if test="${ list.obtain eq 0}">
			<td>
				<button type="button" class="btn btn-primary" onclick="completeCheck(${list.t_no});">완료</button>
			</td>
			</c:if>
			<c:if test="${ list.obtain eq 1}">
			<td>
				목표달성완료
			</td>
			</c:if>
			<td>
				<button type="button" class="btn btn-danger" onclick="deleteCheck(${list.t_no});">삭제</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
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
				var address=$("#sample6_address").val();
				var detailAddress=$("#sample6_address2").val();
				$("#sample6_address2").val(address+" "+detailAddress);
			}
			</script>
			
			
			<!-- ToDoList Script -->
			<script type="text/javascript">
			
				$("#myInput").keydown(function(key) {
					if (key.keyCode == 13)
						newElement();
				});
				
				//Create a "close" button and append it to each list item
				var myNodelist = document.getElementById("myToDoList");
				var i;
				
				for (i = 0; i < myNodelist.length; i++)
				{
				  var span = document.createElement("SPAN");
				  var txt = document.createTextNode("\u00D7");
				  
				  span.className = "close";
				  span.appendChild(txt);
				  myNodelist[i].appendChild(span);
				}
				
				// Click on a close button to hide the current list item
				var close = document.getElementsByClassName("close");
				var i;
				for (i = 0; i < close.length; i++)
				{
				  close[i].onclick = function() 
				  {
				    var div = this.parentElement;
				    // div.style.display = "none";
				    div.remove();
				  }
				}
				
				// Add a "checked" symbol when clicking on a list item
				var list = document.querySelector('ul');
				
				list.addEventListener('click', function(ev) {
				  if (ev.target.tagName === 'LI') 
				  {
				    ev.target.classList.toggle('checked');
				  }
				}, false);
				
				// Create a new list item when clicking on the "Add" button
				function newElement() 
				{
				  var li = document.createElement("li");
				  var inputValue = document.getElementById("myInput").value;
				  var t = document.createTextNode(inputValue);
				  
				  li.appendChild(t);
				  li.setAttribute("data-value", inputValue);
				  li.setAttribute("name", "t_content");
				  
				  if (inputValue === '')
				  {
				    alert("ToDoList를 작성하세요.");
				  } 
				  else
				  {
				    document.getElementById("myToDoList").appendChild(li);
				    
				  }
				  document.getElementById("myInput").value = "";
				
				  var span = document.createElement("SPAN");
				  var txt = document.createTextNode("\u00D7");
				  
				  span.className = "close";
				  span.appendChild(txt);
				  li.appendChild(span);
				
				  for (i = 0; i < close.length; i++) 
				  {
				    close[i].onclick = function()
				    {
				      var div = this.parentElement;
				      // div.style.display = "none";
				      div.remove();
				    }
				  }
				}
			</script>
		</div>
</body>
</html>