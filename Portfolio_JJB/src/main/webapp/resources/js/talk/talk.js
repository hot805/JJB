/**
 * 
 */
//토크 글쓰기 페이지로 이동
	$(document).ready(function() {
		$("input[value=글쓰기]").click(function() {
			if($("#sessionID").val() == ""){
				alert("로그인을 해주세요.")
				return false;
			}
			location.href = "index?page=/talk/talkWrite";
		})
	})