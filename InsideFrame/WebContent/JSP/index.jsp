<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
    <script type="text/javascript" >
        $(document).ready(function() {
            $("#nav-bar").click(function() {
                $("#menu").fadeToggle();
            });
        });
    </script>

    <!-- jQuery library -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../CSS/index.css">



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>INSIDEFRAME STUDIO</title>
	
</head>



<body>
   <header id="header">
        <nav>
            <div id="nav-logo">
                <a href="index.do">
                    <h1>INSIDEFRAME</h1>
                </a>
            </div>
            <div id="nav-bar">
                <i class="fa fa-bars"></i>
            </div>
        </nav>
    </header>

    <menu id="menu">
        <nav>
            <li>LOOK FOR</li>
            <li class="look">
                <a class="mlist" href="#">DIRECTOR</a>
            </li>
            <li class="look">
                <a class="mlist" href="#">ACTOR</a>
            </li>
            <li class="look">
                <a class="mlist" href="cinemaSearchPage.do?category=all">CINEMA</a>
            </li>
            <li class="look">
              	<a class="mlist" href="boardlist.do?page=1">BOARD</a>
            </li>
            <li class="look">
                <a class="mlist" href="#">NOTICE</a>
            </li>
            <c:choose>
                <c:when test="${sessionScope.member!=null }">
                     <li class="login" >
                      	<a class="mlist2" href="profilePage.do">MYPAGE</a>
                        <a class="mlist2" href="logout.do">LOGOUT</a>
                     </li>
                </c:when>
                <c:otherwise>                            
                     <li class="login">
                      	<a class="mlist2" href="loginPage.do">LOGIN</a>
                        <a class="mlist2" href="joinPage.do">JOIN</a>
                     </li>
                </c:otherwise>
            </c:choose>
        </nav>
    </menu>

    <div id="carousel">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">

                <div class="item active">
                    <img class="d-block w-100" src="../photo/carousel_4.jpg" alt="first slide">
                    <div class="carousel-caption">
                        <h3>Inside Frame</h3>
                        <p>Thank you, I love HODOO!</p>
                    </div>
                </div>

                <div class="item">
                    <img class="d-block w-100" src="../photo/carousel_1.jpg" alt="second slide">
                    <div class="carousel-caption">
                        <h3>Inside Frame</h3>
                        <p>We love the Big Apple!</p>
                    </div>
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div id="contents">
        <div class="contents1">
            <div class="films-title">
                <h2>BEST FILMES of INSIDEFRAME STUDIO.</h2>
            </div>
            <div class="films-area">
                <div class="films">
                    <a href="#" class="film opacity">
                            <img src="../photo/photo_1.jpeg" alt="">
                        </a>

                    <a href="#" class="film">
                            <img src="../photo/photo_2.jpeg" alt="">
                    </a>

                    <a href="#" class="film">
                            <img src="../photo/photo_3.jpeg" alt="">
                    </a>
                </div>
            </div>
        </div>
        <div class="contents2">
            <div class="search-title">
                <div class="title">
                    <h2>SEARCHING ACTOR</h2>
                </div>
                <div class="title">
                    <h2>SEARCHING DIRECTOR</h2>
                </div>
                <div class="title">
                    <h2>NOTICE</h2>
                </div>
            </div>
            <div class="search-area">
                <div class="search">

                </div>
                <div class="search">

                </div>
                <div class="search">

                </div>
            </div>
        </div>

        <div class="contents3">
            <div class="films-title">
                <h2>BEST FILMES of INSIDEFRAME STUDIO.</h2>
            </div>
            <div class="films-area">
                <div class="films">
                    <a href="#" class="film">
                    <iframe src="https://www.youtube.com/embed/E0R0U9K-MEY" frameborder="0" allowfullscreen></iframe> 
                    </a>

                    <a href="#" class="film">
                    <iframe src="https://www.youtube.com/embed/DuszRqLHzYU" frameborder="0" allowfullscreen></iframe> 
                    </a>

                    <a href="#" class="film">
                    <iframe src="https://www.youtube.com/embed/3tmd-ClpJxA" frameborder="0" allowfullscreen></iframe> 
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!--
<script type="text/javascript" src="js/smooth-scroll.js"></script>
<script type="text/javascript">
    smoothScroll.init();

    function movedownClick() {
        var d = document.querySelector('#header');
        d.style.height = '8%';
    }
</script>-->
</body>

</html>