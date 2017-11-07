<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>프로필</title>
		<title></title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#imgInp").on('change', function(){
                readURL(this);
            });
        });
        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#blah').attr('src', e.target.result);
                }
              reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
    <style>
        
        #imagezone{
            display: inline-block;            
            height: 200px;
            width: 180px;
        }
        #blah{
            height: 160px;
            width: 160px;
        }
    </style>
	</head>
    <body>
        <div>
            <form action="profilealter.do" method="post">
           		<div id="imagezone">	
               		 <img id="blah" src="../photo/noimage.png" alt="your image" />
                </div><br>   
                image:<input type='file' id="imgInp" name="mimage"/><br>
                email:<input type="text" name="email" disabled value="${member.email }"><br>
                pw:<input type="password" name="pw"><br>
                pw confirm:<input type="password"  name="pw"><br>
                name:<input type="text" name="name" disabled value="${member.name }"><br>
                sex:<input type="text" name="name" disabled value="${member.sex }"><br>
                type:<input type="text" name="name" disabled value="${member.mType }"><br>
                phone:<input type="text" name="phone" value="${member.phone }"><br>
                birth:<input type="text" name="birth" disabled value="${member.birth }"><br>
                height:<input type="text" name="height" disabled value="${member.height }cm"><br>
                weight:<input type="text" name="weight" disabled value="${member.weight }kg"><br>
                <input type="submit" value="회원정보 변경">
             </form>
        </div>
    </body>
</html>