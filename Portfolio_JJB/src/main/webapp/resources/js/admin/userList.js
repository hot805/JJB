/**
 * 
 */

//쉐프 권한부여
function user_grant(userid, nickname, profileImg){
	$.ajax({
		url : "user/grantUser",
		type : "POST",
		data : {"userid":userid,
				"nickname":nickname,
				"profileImg":profileImg},
		success : function() {
			alert("쉐프 권한을 성공적으로 주었습니다.")
		},
		error : function(request,error){
			alert("error:"+error);
		}
	})
}

//쉐프 권한 해제
function user_revoke(userid){
	$.ajax({
		url : "user/revokeUser",
		type : "POST",
		data : {"userid":userid},
		success : function() {
			alert("쉐프 권한을 성공적으로 해제하였습니다.")
		},
		error : function(request,error){
			alert("error:"+error);
		}
	})
}

//회원 탈퇴
function user_delete(userid){
	$.ajax({
		url : "user/deleteUser_admin",
		type : "POST",
		data : {"userid":userid},
		success : function() {
			alert("회원을 탈퇴시켰습니다.")
		},
		error : function(request,error){
			alert("error:"+error);
		}
	})
}