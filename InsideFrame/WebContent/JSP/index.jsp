<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="../CSS/index.css">


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <title>INSIDEFRAME STUDIO</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
</head>

<body>
    <div id="navigater">
        <div class="navi">
            <div class="nav-bar">
                <ul class="catalog">
                    <li>
                        <a href="loginPage.do">LOGIN</a></li>

                    <li>
                        <a href="joinPage.do">JOIN</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div id="carousel">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="../photo/carousel_4.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="../photo/carousel_5.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="../photo/carousel_7.jpg" alt="Third slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="../photo/carousel_6.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
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
        <div class="contents2">
            <div class="find-area">
                <div class="find">
                   <img src="../photo/find_1.jpg" alt="">
                </div>
                <div class="find">
                    <img src="../photo/find_2.jpeg" alt="">
                </div>
            </div>
            <div class="find-area">
               <img class="competition" src="../photo/find_3.png" alt="">
            </div>
        </div>

       
    </div>














   </body>

</html>