<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>회원가입</title>
	</head>
    <body>
        <div>
            <form action="#">
                email:<input type="text" id="email"><br>
                pw:<input type="text" id="pw"><br>
                pw confirm:<input type="text" id="pwconfirm"><br>
                name:<input type="text" id="name"><br>
                sex:<input type="checkbox" name="sex" value="남성">남성
                     <input type="checkbox" name="sex" value="여성">여성<br>
                type:<input type="checkbox" name="type" value="감독">감독
                     <input type="checkbox" name="type" value="감독">배우<br>
                phone:<input type="text" id="phone"><br>
                birth:<input type="text" id="birth"><br>
                height:<input type="text" id="height"><br>
                weight:<input type="text" id="weight"><br>
                <input type="submit" value="회원가입">
             </form>
        </div>
    </body>
</html>