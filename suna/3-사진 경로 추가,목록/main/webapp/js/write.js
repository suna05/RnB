var WNo = $('#writeNo'),
		WTitle = $('#writeTitle'),
		WWriter = $('#writeWriter'),
		WContent = $('#writeContent')
		WDate = $('#writeDate'),
		WCount = 0;


$('#add-btn').unbind('click').on('click', function(e) {
	
	
	console.log("글 추가버튼 눌렀네")
		
		WTitle = $('#writeTitle').val(),
		WWriter = $('#writeWriter').val(),
		WContent= $('#writeContent').val(),
		
		console.log(WTitle)
		//console.log(WWriter)
		console.log(WContent)
		
		
		 $.ajax({
       data : {
      	 	w_title : WTitle,
          w_writer : 'dd',
          w_content: WContent,
          W_count: WCount
       },
       url : "index.do",
       success : function(data) {
          if (data == 1) {
          } else {
          	console.log("글 추가")
          }
       } ,
       error: function() {
      	 alert("오류")
       }
    });
		
		
		
})
