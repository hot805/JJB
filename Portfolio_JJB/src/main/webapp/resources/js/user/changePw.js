/**
 * 
 */
$(document).ready(function() {
	//패턴 변수
	var pwcheck=RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,16}$/);
	
	//패스워드 패턴형식 확인
	$("input[name=newPw]").keyup(function(){
		if(!(pwcheck.test($("input[name=newPw]").val()))){
			$("#answer_pw").html("형식에 맞게 입력해주세요.")
		}else{
			$("#answer_pw").html("사용가능한 비밀번호입니다.")
		}
	});
	
	//비밀번호 확인 Ajax포함
	$("#btn_pw").click(function() {
		var newPw = $("input[name=newPw]").val();
		var reckNewPw = $("input[name=reckNewPw]").val();
		
		if($("input[name=password]").val()==""){
			alert("비밀번호를 입력해주세요.")
			return false;
		}
		
		if($("#answer_pw").html() != "사용가능한 비밀번호입니다."){
			alert("비밀번호 패턴을 다시 확인해주세요.")
			return false;
		}
		
		if (newPw != reckNewPw) {
			alert("비밀번호 재확인이 일치하지 않습니다.")
			return false;
		}

		var password = $("input[name=password]").val();
		// 비밀번호 확인 ajax 실행
		$.ajax({
			url : "user/checkPw",
			type : "POST",
			data : {
					"password" : password
					},
			success : function(result) {
			if (result == true) {
				$.ajax({
					url : "user/changePw",
					type : "POST",
					data : {
							"newPw" : newPw
							},
					success : function() {
							alert("비밀번호가 수정되었습니다.");
							location.href="index?page=/user/manage";
							},
					error : function(request, error) {
							alert("code:" + request.status
							+ "message:"
							+ request.responseText
							+ "error:" + error);
							}
						})
			} else {
					alert("현재 비밀번호와 일치하지 않습니다.")
					}
			},
			error : function(request, error) {
					alert("code:" + request.status + "message:"
					+ request.responseText + "error:"
					+ error);
					}
		})
		// 비밀번호 확인 ajax 끝
	})
})
