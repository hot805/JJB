/**
 *
 */
function sign(){
 	location.href="index?page=/user/signUp"
 }

function loginCheck(){
	if($("input[name=userid]").val()==""){
		alert("아이디를 입력해주세요,")
		return false;
	}
	if($("input[name=userpw]").val()==""){
		alert("비밀번호를 입력해주세요,")
		return false;
	}
}
