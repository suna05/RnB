var PNo = $('#photoNo'),
		PTitle = $('#photoTitle'),
		PWriter = $('#photoWriter'),
		PDate = $('#photoDate'),
		pCount = 1,
		PPath = $('#files');


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
};
reader.readAsDataURL(file);
console.log(file)
console.log(file.name)

return false;
};

$('#add-btn').unbind('click').on('click', function(e) {
	
	event.preventDefault()
	
	var file = upload.files[0]
	
	console.log("추가버튼 눌렀네")
	console.log(file.name)
		
		PTitle = $('#photoTitle').val(),
		PWriter = $('#photoWriter').val(),
		PCount= '1'
		PPath= file.name
		
		console.log(PTitle)
		console.log("작성자", PWriter);
	console.log(PPath)
		//console.log(PPath)
		//console.log($('#files').val())
		//console.log($('#filename').val())
		
		
		 $.ajax({
       data : {
      	 file:file
      	 	/*p_title : PTitle,
          p_writer : PWriter,
          P_count: PCount,
          //p_path: PPath
          p_path: PPath*/
       },
       url : "insertPhoto.do",
       success : function(data) {
          if (data == 1) {
          } else {
          	console.log("ddd")
          }
       } ,
       error: function() {
      	 alert("오류")
       }
    });
		
		
		
})
