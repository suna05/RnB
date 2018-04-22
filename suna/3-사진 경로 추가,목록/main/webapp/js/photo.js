var PTitle = $('#photoTitle');
		//PPath = $('#files');

/*
var upload = document.getElementsByTagName('input')[0],
holder = document.getElementById('holder'),
state = document.getElementById('status');


upload.onchange = function (e) {
e.preventDefault();

var file = upload.files[0],
    reader = new FileReader();

reader.onload = function (event) {
  var img = new Image();
  img.src = event.target.result;
  // note: no onload required since we've got the dataurl...I think! :)
  if (img.width > 560) { // holder width
    img.width = 560;
  }
  holder.innerHTML = '';
  holder.appendChild(img);
  console.log(img.src)
};
reader.readAsDataURL(file);
console.log("file", file)
console.log("filename", file.name)
console.log("path", file.webkitRelativePath)

return false;
};*/

$('#add-btn').unbind('click').on('click', function(e) {
	
	
	//var file = upload.files[0]
	
	console.log("추가버튼 눌렀네")
	//console.log(file.name)
		
		PTitle = $('#photoTitle').val()
		console.log(PTitle)
		
		 $.ajax({
       data : {
      	 	p_title : PTitle
          //p_path: PPath
          //p_path: PPath
       },
       url : "insertPhoto.do",
       success : function(data) {
          if (data == 1) {
          	history.go(-1);
          } else {
          	location.href="index.do";
          }
       } ,
       error: function(data) {
      	 
      	 alert("오류");
       }
    });
		
		
		
})
