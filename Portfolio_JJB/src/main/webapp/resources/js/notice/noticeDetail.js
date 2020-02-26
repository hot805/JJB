/**
 * 
 */
window.onload = function(){
	$("input[value=삭제]").attr("style","display:none");
}

function repWrite() {
	var repText = $("input[name=repText]").val();
	var userid = $("#sessionid").val();
	var nickname = $("#sessionname").val();
	var bno = $("#boardnum").val();
	var section = $("#section").val();
	alert(section)
	if (userid == "") {
		alert("로그인을 해주세요.")
		return false;
	}

	if (repText == "") {
		alert("댓글을 입력해주세요");
		$("input[name=repText]").focus();
	}

	$.ajax({
		url : "board/repWrite",
		type : "POST",
		data : {
			"content" : repText,
			"userid" : userid,
			"nickname" : nickname,
			"bno" : bno,
			"section" : section
		},
		success : function() {
			alert("댓글을 입력하셨습니다.")
			location.reload();
		},
		error : function(request, error) {
			alert("code:" + request.status + "message:" + request.responseText
					+ "error:" + error);
		}
	})

}

function repModi(no, userid) {
	var replyid = $("#sessionid").val();
	alert(no + " " + userid)

	$(".forModify" + no).html(
			"<input type='text' id='forUpdate"+no+"'>"
					+ "<input type='button' value='수정하기' onclick='repUpdate("
					+ no + ")'>");
}

function repUpdate(rno) {
	var section = $("#section").val();
	var repText = $("#forUpdate" + rno).val()
	var result = confirm("댓글을 수정하시겠습니까?");
	if (!result) {
		alert("수정작업을 취소하셨습니다.")
		return false;
	}

	$.ajax({
		url : "board/repModify",
		type : "POST",
		data : {
			"content" : repText,
			"rno" : rno,
			"section" : section
		},
		success : function() {
			alert("댓글이 수정되었습니다.")
			location.reload();
		},
		error : function(request, error) {
			alert("code:" + request.status + "message:" + request.responseText
					+ "error:" + error);
		}
	})
}

function boardDelete(bno,section){
	
	$.ajax({
				url : 'board/delete',
				type : 'post',
				data : {
					"bno" : bno,
					"section" : section
				},
				success : function() {
					alert("글삭제가 완료되었습니다.")
					location.href = "index?page=/board/&section=B2-01";
				},
				error : function(){
					alert("글삭제가 실패하였습니다. 관리자에게 문의해주세요.")
				}

			})
}


function repDel(rno) {
	var section = $("#section").val();
	var result = confirm("댓글을 삭제하시겠습니까?");
	if(!result){
		alert("삭제를 취소하셨습니다.")
		return false;
	}
	
	$.ajax({
		url : "board/repDelete",
		type : "POST",
		data : {
			"rno" : rno,
			"section" : section
		},
		success : function() {
			alert("댓글이 삭제되었습니다.")
			location.reload();
		},
		error : function(request, error) {
			alert("code:" + request.status + "message:" + request.responseText
					+ "error:" + error);
		}
	})
	
}

function clickLike(bno){
	if($("#sessionid").val()==""){
		alert("로그인을 해주세요.")
		return false;
	}
	
	var likeck = $(".forlike").attr("check");
	
	if(likeck == "unlike"){
		$.ajax({
			url : "board/unlike",
			type : "GET",
			data : {
				"bno" : bno,
				"section" : $("#section").val()
			},
			success : function() {
				alert("좋아요를 취소하셨습니다.")
				$(".forlike").attr("check", "like")
				$(".forlike").html("좋아요")
			},
			error : function(request, error) {
				alert("code:" + request.status + "message:" + request.responseText
						+ "error:" + error);
			}
		})
		
	}else if(likeck = "like"){
		$.ajax({
			url : "board/like",
			type : "GET",
			data : {
				"bno" : bno,
				"section" : $("#section").val()
			},
			success : function() {
				alert("좋아요를 하셨습니다.")
				$(".forlike").attr("check", "unlike")
				$(".forlike").html("좋아요 취소")
			},
			error : function(request, error) {
				alert("code:" + request.status + "message:" + request.responseText
						+ "error:" + error);
			}
		})
	}
}

function clickfollow(userid){
	if($("#sessionid").val()==""){
		alert("로그인을 해주세요.")
		return false;
	}
	
	var followck = $(".forfollow").attr("check");
	
	if(followck == "unfollow"){
		$.ajax({
			url : "chef/unfollow",
			type : "GET",
			data : {
				"chef_followed" : userid
			},
			success : function() {
				alert("팔로우를 취소하셨습니다.")
				$(".forfollow").attr("check", "follow")
				$(".forfollow").html("팔로우")
			},
			error : function(request, error) {
				alert("code:" + request.status + "message:" + request.responseText
						+ "error:" + error);
			}
		})
		
	}else if(followck = "follow"){
		$.ajax({
			url : "chef/follow",
			type : "GET",
			data : {
				"chef_followed" : userid
			},
			success : function() {
				alert("좋아요를 하셨습니다.")
				$(".forfollow").attr("check", "unfollow")
				$(".forfollow").html("팔로우 취소")
			},
			error : function(request, error) {
				alert("code:" + request.status + "message:" + request.responseText
						+ "error:" + error);
			}
		})
	}
}