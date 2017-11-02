<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>회원가입</title>
	</head>
    <body>
        <div>
            <form action="join.do">
                email:<input type="text" name="email"><br>
                pw:<input type="text" name="pw"><br>
                pw confirm:<input type="text" name="pwconfirm"><br>
                name:<input type="text" name="name"><br>
                sex:<input type="checkbox" name="sex" value="남성">남성
                     <input type="checkbox" name="sex" value="여성">여성<br>
                type:<input type="checkbox" name="type" value="감독">감독
                     <input type="checkbox" name="type" value="감독">배우<br>
                phone:<input type="text" name="phone"><br>
                birth:<input type="text" name="birth"><br>
                height:<input type="text" name="height"><br>
                weight:<input type="text" name="weight"><br>
                <input type="submit" value="회원가입">
             </form>
        </div>
    </body>
</html>