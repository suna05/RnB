<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
            <tr><td>글번호:${board.idx }</td></tr>
            <tr><td>글제목:${board.btitle }</td></tr>
            <tr><td>작성자:${board.writer }</td></tr>
            <tr><td>작성일:${board.bdate }</td></tr>
            <tr><td>조회수:${board.bcount }</td></tr>
            <tr><td>내용:${board.content }</td></tr>
            
    </table>
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
		    		<form action="reply.do">
		    			<input type="hidden" name="comment_board" value="${board.idx }">
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
	        		<a href="boardDetailView.do?idx=${param.idx }&commentPage=1">이전</a>
	        	</c:when>
	        	<c:otherwise>
	        		<a href="boardDetailView.do?idx=${param.idx }&commentPage=${param.commentPage-1}">이전</a>
	        	</c:otherwise>
	        </c:choose>
	        <c:forEach var="i" begin="${paging.startPageNo }" end="${paging.endPageNo }" step="1">
	        	<a href="boardDetailView.do?idx=${param.idx }&commentPage=${i }">${i }</a>
	        </c:forEach>
	        <c:choose>
	        	<c:when test="${param.commentPage == paging.endPageNo}">
	        		<a href="boardDetailView.do?idx=${param.idx }&commentPage=${param.commentPage }">다음</a>
	        	</c:when>
	        	<c:otherwise>
	        		<a href="boardDetailView.do?idx=${param.idx }&commentPage=${param.commentPage+1 }">다음</a>
	        	</c:otherwise>
	        </c:choose>
        </div>
    </div>
</body>
</html>