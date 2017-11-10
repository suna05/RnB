<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>영화재생창 영역(유투브링크를 받아서 iframe)</div>
		<c:choose>
			<c:when test="${movie.movieImage!=null }">
				<div>영화포스터영역:${movie.movieImage }</div>
			</c:when>
			<c:otherwise>
				<div><img src="../photo/noimage.png" alt="movie image" /></div>
			</c:otherwise>
		</c:choose>
		<div>영화줄거리,제작날짜영역:${movie.movieInfo }<br>
							 ${movie.mdate }
		</div>
		<c:forEach var="people" items="${peopleList }">
		<div>
			<c:choose>
				<c:when test="${people.mimage!=null }">
					<div>출연진(감독)사진영역:${people.mimage }</div>
				</c:when>
				<c:otherwise>
					<div><img src="../photo/noimage.png" alt="movie image" /></div>
				</c:otherwise>
			</c:choose>
			타입:${people.mType }<br>
			이름:${people.name }<br>
			역할:${people.roll }
		</div>
		</c:forEach>
	</div>
	<div>
		<table border="1">
			    <c:if test="${commentList !=null }">
			    	<c:forEach var="comment" items="${commentList }">
			    		<tr>
			    			<td>
			    				<div>
			    					${comment.commentId }<br>
			    					${comment.commentDate}
			    				</div>
			    			</td>
			    			<td>
			    				<div>
			    					${comment.commentContent }
			    				</div>
			    			</td>
			    			<td>
			    				<div>
			    					<c:if test="${comment.commentId==sessionScope.member.email }">
			    						<a href="#">[삭제]</a>
			    					</c:if>
			    				</div>
			    			</td>
			    		</tr>
			    	</c:forEach>
			    </c:if>
				<c:if test="${sessionScope.member!=null }">
			    	<tr>
			    		<form action="movieReply.do">
			    			<input type="hidden" name="movieno" value="${param.movieno }">
			    			<input type="hidden" name="commentid" value="${sessionScope.member.email }">
				    		<td>
				    			<div>
				    				${sessionScope.member.email }
				    			</div>
				    		</td>
				    		<td>
				    			<div>
				    				<textarea name="commentcontent" rows="4" cols="70"></textarea>
				    			</div>
				    		</td>
				    		<td>
				    			<div>
				    				<input type="submit" value="등록">
				    			</div>
				    		</td>
			    		</form>
			    	</tr>
			    </c:if>
			    </table>
			<div>
			    <c:choose>
		        	<c:when test="${param.commentPage==1}">
		        		<a href="movieDetailView.do?movieno=${param.movieno }&commentPage=1">이전</a>
		        	</c:when>
		        	<c:otherwise>
		        		<a href="movieDetailView.do?movieno=${param.movieno }&commentPage=${param.commentPage-1}">이전</a>
		        	</c:otherwise>
		        </c:choose>
		        <c:forEach var="i" begin="${paging.startPageNo }" end="${paging.endPageNo }" step="1">
		        	<a href="movieDetailView.do?movieno=${param.movieno }&commentPage=${i }">${i }</a>
		        </c:forEach>
		        <c:choose>
		        	<c:when test="${param.commentPage == paging.endPageNo}">
		        		<a href="movieDetailView.do?movieno=${param.movieno }&commentPage=${param.commentPage }">다음</a>
		        	</c:when>
		        	<c:otherwise>
		        		<a href="movieDetailView.do?movieno=${param.movieno }&commentPage=${param.commentPage+1 }">다음</a>
		        	</c:otherwise>
		        </c:choose>
	        </div>
        </div>
</body>
</html>