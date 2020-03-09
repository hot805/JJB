/**
 * 
 */

//이미지 업로드
$(document).ready(function(){
	$("input[value=업로드]").click(function(){
		var form= $("form[name=uploadForm]")[0];
		var formData = new FormData(form);
		
		console.log(form)
		console.log(formData)
		
		if(form==""){
			alert("파일을 넣어주세요.")
			return false;
		}
		
		$.ajax({
			url : '../user/GetImgName',
			type:'post',
			data: formData,
			contentType:false,
			processData:false,
			success:function(data){
				$(opener.document).find('#event_img').attr("src","talk/displayFile?fileName="+data);
				$(opener.document).find('input[name=imgname]').val("talk/displayFile?fileName="+data);
				window.close();
			}
		
		})
	})
})