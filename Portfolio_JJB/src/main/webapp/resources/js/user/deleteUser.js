/**
 * 
 */
$(document).ready(function(){
	$("#btn_delete").click(function(){
		var password = $("input[name=password").val();
		var rechPw = $("input[name=reckPw]").val();
		if(password == "" || rechPw == ""){
			alert("비밀번호를 모두 입력해주세요.")
			return false;
		}
		
		if(password != rechPw){
			alert("비밀번호 재확인해주십시오.")
			return false;
		}
		
		var result = confirm("계정을 정말 삭제하시겠습니까?");
		if(result){
		$.ajax({
			url : "user/deleteUser",
			type : "POST",
			data : {
					"password":password
					},
			success : function(result) {
				if(result==true){
					alert("삭제가 완료되었습니다.");
					location.href="index";
				}else{
					alert("비밀번호를 다시 확인해주세요.");
				}
				
			},
			error : function(request,error){
				alert("code:"+request.status+"message:"+request.responseText+"error:"+error);
			}
		})	
		}else{
			alert("취소하셨습니다. 메인페이지로 돌아갑니다.");
			location.href="index";
		}
	})
	
})