/**
 * 
 */
$(document).ready(function() {
	$("input[name=file]").change(function() {
		alert("aa")
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
				alert(data)
				
				if($("#imgname").val() != ""){
					alert("a")
					$(".selectedThumb").children('img').attr("src","talk/displayFile?fileName="+data);
				}else{
					alert("b")
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
