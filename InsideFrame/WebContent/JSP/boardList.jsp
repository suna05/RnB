<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시판</title>
</head>
<body>
	<table class="type09">
            <thead>
            <tr>
                <th scope="cols">번호</th>
                <th scope="cols">타이틀</th>
                <th scope="cols">카테고리</th>
                <th scope="cols">작성일</th>
                <th scope="cols">작성자</th>
                <th scope="cols">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="board" items="${boardlist }">
            	<tr>
	                <td scope="row">${board.idx }</td>
	                <td class="title"><a href="boardDetailView.do?idx=${board.idx }&commentPage=1">${board.btitle }</a></td>
	                <td>${board.btype }</td>
	                <td>${board.bdate }</td>
	                <td>${board.writer }</td>
	                <td>${board.bcount }</td>
           		</tr>
            </c:forEach>
            </tbody>
        </table>
        <c:choose>
        	<c:when test="${param.page==1}">
        		<a href="boardlist.do?page=1">이전</a>
        	</c:when>
        	<c:otherwise>
        		<a href="boardlist.do?page=${param.page-1}">이전</a>
        	</c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${paging.startPageNo }" end="${paging.endPageNo }" step="1">
        	<a href="boardlist.do?page=${i }">${i }</a>
        </c:forEach>
        <c:choose>
        	<c:when test="${param.page ==paging.endPageNo }">
        		<a href="boardlist.do?page=${param.page }">다음</a>
        	</c:when>
        	<c:otherwise>
        		<a href="boardlist.do?page=${param.page+1 }">다음</a>
        	</c:otherwise>
        </c:choose>
</body>
</html>