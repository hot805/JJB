/**
 * 
 */
//이미지 파일이 변경 시 폴더에 이미지 저장 및 이미지 표시
$(document).ready(function() {
	$("input[name=file]").change(function() {
		var form= $("form[name=uploadForm]")[0];
		var formData = new FormData(form);
		
		console.log(form)
		console.log(formData)
		
		
		$.ajax({
			url : 'talk/GetImgName',
			type:'post',
			data: formData,
			contentType:false,
			processData:false,
			success:function(data){
				
				if($("#imgname").val() != ""){
					$(".selectedThumb").children('img').attr("src","talk/displayFile?fileName="+data);
				}else{
					$(".selectedThumb").append("<img src='talk/displayFile?fileName="+data+"'>");
				}			
				$("#imgname").val("talk/displayFile?fileName="+data);
			},
			error:function(error){
				alert(error)
			}
		
		})		
	});
	
	
})
