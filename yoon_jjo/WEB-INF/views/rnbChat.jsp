<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>채팅</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<style>
			.col-xs-3{
				width: 440px;
			}
			.container {
			  width: 970px;
			  max-width: none !important;
			}
            .mytext{
                border:0;padding:10px;background:whitesmoke;
            }
            .text{
                width:75%;display:flex;flex-direction:column;
            }
            .text > p:first-of-type{
                width:100%;margin-top:0;margin-bottom:auto;line-height: 13px;font-size: 12px;
            }
            .text > p:last-of-type{ 
                width:100%;text-align:right;color:silver;margin-bottom:-7px;margin-top:auto;
            }
            .text-l{
                float:left;padding-right:10px;
            }        
            .text-r{
                float:right;padding-left:10px;
            }
            .avatar{
                display:flex;
                justify-content:center;
                align-items:center;
                width:25%;
                float:left;
                padding-right:10px;
            }
            .macro{
                margin-top:5px;width:85%;border-radius:5px;padding:5px;display:flex;
            }
            .msj-rta{
                float:right;background:whitesmoke;
            }
            .msj{
                float:left;background:white;
            }
            .frame{
                background:#e0e0de;
                height:550px;
                overflow:hidden;
                padding:0;
            }
            .frame > div:last-of-type{
                position:absolute;bottom:0;width:100%;display:flex;
            }
            /* body > div > div > div:nth-child(2) > span */
            #sendBtn{
                background: whitesmoke;padding: 10px;font-size: 21px;border-radius: 50%;
            }
            /* body > div > div > div */
            .msj-rta.macro{
                margin:auto;margin-left:1%;
            }
            ul {
                width:100%;
                list-style-type: none;
                padding:18px;
                position:absolute;
                bottom:47px;
                display:flex;
                flex-direction: column;
                top:0;
                overflow-y:scroll;
            }
            .msj:before{
                width: 0;
                height: 0;
                content:"";
                top:-5px;
                left:-14px;
                position:relative;
                border-style: solid;
                border-width: 0 13px 13px 0;
                border-color: transparent #ffffff transparent transparent;            
            }
            .msj-rta:after{
                width: 0;
                height: 0;
                content:"";
                top:-5px;
                left:14px;
                position:relative;
                border-style: solid;
                border-width: 13px 13px 0 0;
                border-color: whitesmoke transparent transparent transparent;           
            }  
            input:focus{
                outline: none;
            }        
            ::-webkit-input-placeholder { /* Chrome/Opera/Safari */
                color: #d4d4d4;
            }
            ::-moz-placeholder { /* Firefox 19+ */
                color: #d4d4d4;
            }
            :-ms-input-placeholder { /* IE 10+ */
                color: #d4d4d4;
            }
            :-moz-placeholder { /* Firefox 18- */
                color: #d4d4d4;
            }
            #respMessage{
            	margin-top: 6px;
            }
        </style>
</head>
<body>
	<center id="center">
    <div class="col-xs-3 col-xs-offset-4 frame">
            <ul id="messagesArea">
            	<c:forEach items="${chatList }" var="chat">
            		<c:choose>
            			<c:when test="${sessionScope.member.m_id ==chat.m_id }">
            				<li style="width:100%">
	            				<div class="msj macro">
	            					<div class="avatar">
	            						<img class="img-circle" style="width:60%;" src="${chat.pp_fullpath }" />
	            					</div>
	                				<div class="text text-l">
	                    				<p>${chat.m_id }님 : ${chat.message }</p>
	                    				<p><small>${chat.c_date }</small></p>
	                				</div>
	            				</div>
	        				</li>
            			</c:when>
            			<c:otherwise>
            				<li id="respMessage" style="width:100%;">
			                	<div class="msj-rta macro">
			                		<div class="text text-r">
			                    		<p>${chat.m_id }님 : ${chat.message }</p>
			                    		<p><small>${chat.c_date }</small></p>
			                		</div>
			            			<div class="avatar" style="padding:0px 0px 0px 10px !important">
			            				<img class="img-circle" style="width:60%;" src="${chat.pp_fullpath }" />
			            			</div>  
			            		</div>
			      			</li>
            			</c:otherwise>
            		</c:choose>
            	</c:forEach>
            </ul>
            <div>
                <div class="msj-rta macro">                        
                    <div class="text text-r" style="background:whitesmoke !important">
                 	    <input type="text" id="sender" value="${sessionScope.member.m_id }" style="display: none;">
                        <input type="text" id="pp_fullpath" value="${sessionScope.memberProfile.pp_fullpath }" style="display: none;">
                        <input id="inputText" class="mytext" placeholder="Type a message"/>
                    </div> 

                </div>
                <div style="padding:10px;">
                    <span id="sendBtn" class="glyphicon glyphicon-share-alt"></span>
                </div>                
            </div>
        </div>
    </center>
    <!-- websocket javascript -->
    <script type="text/javascript">
    	console.log("세션에 저장된 path:"+$("#pp_fullpath").val());
    	console.log("세션에 저장된 id:"+$("#sender").val());
    	var ws;
    	var me = $("#pp_fullpath").val();
    	var messages=$("#messagesArea");
    	$(document).ready(function(){
    		var no_avatar="resources/images/rnbmark.png";
    		$("#sendBtn").click(send);
    		if(ws!==undefined && ws.readyState!==WebSocket.CLOSED){
    			writeResponse("WebSocket is already opened.");
    			return;
    		}
    		//웹소켓 객체 만드는 코드
    		ws=new WebSocket("ws://localhost:9080/rnb/echo.do");//192.168.0.101
    		
    		ws.onopen=function(){
    			/* var liTag='<li style="width:100%;">' +
			                '<div class="msj-rta macro">' +
			                '<div class="text text-r">' +
			                    '<p>'+$("#sender").val()+"님 환영합니다."+'</p>' +
			                    '<p><small>'+date+'</small></p>' +
			                '</div>' +
			            '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="'+no_avatar+'" /></div>' +                                
			      		'</li>';
			    messages.append(liTag); */
			    $("#messagesArea").scrollTop($("#messagesArea").prop('scrollHeight'));
    		};
    		ws.onmessage=function(event){
    			writeResponse(event.data);
    		};
    		ws.onclose=function(){
    			var liTag='<li style="width:100%;">' +
			                '<div class="msj-rta macro">' +
			                '<div class="text text-r">' +
			                    '<p>'+$("#sender").val()+"님이 퇴장하셨습니다."+'</p>' +
			                    '<p><small>'+date+'</small></p>' +
			                '</div>' +
			            '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="'+no_avatar+'" /></div>' +                                
			      		'</li>';
			    messages.append(liTag);
			    
    		}
    	});

    	function formatAMPM(date) {
    			var year=date.getFullYear();
    			var month=date.getMonth()+1;
    			var day=date.getDate();
                var hours = date.getHours();
                var minutes = date.getMinutes();
                /* var milisnd=date.getMilliseconds(); */ 
                var ampm = hours >= 12 ? 'PM' : 'AM';
                hours = hours % 12;
                hours = hours ? hours : 12; // the hour '0' should be '12'
                minutes = minutes < 10 ? '0'+minutes : minutes;
                var strTime =year+"/"+month+"/"+day+" "+ hours + ':' + minutes + ' ' + ampm;
                return strTime;
        } 
    	/* function closeSocket(){
    		ws.close();
    	} */
    	var date = formatAMPM(new Date());
    	function send(){
    		var text=$("#inputText").val()+":"+$("#sender").val()+":"+me;
    		var messages=$("#inputText").val();
    		var senderId=$("#sender").val();
    		var imagePath=$("#pp_fullpath").val();
    		var time=formatAMPM(new Date());
    		console.log(time);
    		ws.send(text);
    		$("#inputText").val("");
    		$("#inputText").focus();
    		$.ajax({
    			data:{
    				m_id:senderId,
    				message:messages,
    				pp_fullpath:imagePath,
    				c_date:time
    			},
    			url:"chatWrite.do",
    			success:function(data){
    				if(date==1)
    				console.log('DB에 채팅내용 저장성공!');
    			}
    		});
    	}
    	function writeResponse(text){
    		var textArr=text.split(":");
    		var from=textArr[0];
    		var ms=textArr[1];
    		var imgPath=textArr[2];
    		var liTag;
    		if(from==$("#sender").val()){
	    		liTag='<li style="width:100%">' +
	            '<div class="msj macro">' +
	            '<div class="avatar"><img class="img-circle" style="width:60%;" src="'+ me +'" /></div>' +
	                '<div class="text text-l">' +
	                    '<p>'+ from+'님 : '+ms +'</p>' +
	                    '<p><small>'+date+'</small></p>' +
	                '</div>' +
	            '</div>' +
	        	'</li>';
    		}else{
    			liTag='<li id="respMessage" style="width:100%;">' +
			                '<div class="msj-rta macro">' +
			                '<div class="text text-r">' +
			                    '<p>'+from+'님 : '+ms+'</p>' +
			                    '<p><small>'+date+'</small></p>' +
			                '</div>' +
			            '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:60%;" src="'+imgPath+'" /></div>' +                                
			      		'</li>';
    		}
    		setTimeout(
                    function(){                        
                        $("ul").append(liTag).scrollTop($("ul").prop('scrollHeight'));
                    }, 0);
    	}
    	$(".mytext").on("keydown", function(e){
            if (e.which == 13){
                var text = $(this).val();
                if (text !== ""){
                    send();              
                    $(this).val('');
                }
            }
        });
    </script>
</body>
</html>