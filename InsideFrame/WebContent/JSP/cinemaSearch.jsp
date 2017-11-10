<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Eutf-8">
<title>Insert title here</title>
<style type="text/css">
   .profiles{
      display: inline-block;
      width: 300px;
      height: 200px;
      position: relative;
   }
   #blackbox{
      position: absolute;
      left:0;top:0;
      display: inline-block;
      width:100%;
      height: 100%;
      z-index: 1;
      background-color: black;
      opacity : 0.5;
   }
   #search{
      visibility: hidden;
   }
</style>
</head>
<body>
	 <div>
       <a href="cinemaSearch.do?category=actionAndThriller">액션/스릴러</a><br>
       <a href="cinemaSearch.do?category=romance">로맨스</a><br>
       <a href="cinemaSearch.do?category=comedy">코미디</a><br>
       <a href="cinemaSearch.do?category=drama">드라마</a><br>
       <a href="cinemaSearch.do?category=horror">공포</a>
       
   </div>
   <div>
      <form action="cinemaSearch.do">
         <fieldset>
            <input type="text" name="category" value="" placeholder="영화제목을 입력해주세요.">
            <input type="submit" value="검색">
            <input type="text" id="search" name="search" value="true">
         </fieldset>
      </form>
   </div>
   
   <div class="profilelist">
  		 <c:forEach var="movie" items="${movieList }">
				<div class="profiles">
	               <a href="movieDetailView.do?movieno=${movie.movieNo }&commentPage=1">
	                  <div id="blackbox"></div>
	                  <img id="profileimg"/>
	                  <p>
	                                        제목:${movie.mTitle}<br>
	                                        감독:${movie.director }<br>
	                                        제작일:${movie.mdate }                      
	                  </p>
	               </a>
	            </div>
	     </c:forEach>
	</div>
	
</body>
</html>