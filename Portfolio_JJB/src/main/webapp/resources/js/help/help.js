/**
 * 
 */
//스위치를 위한 변수
var swnum=1;

//답변 보이게해주는 함수
function displayAnswer(bno){
	if($(".help_bno"+bno).css("display") == "none"){
		$(".help_bno"+bno).show();
	}else{
		$(".help_bno"+bno).hide();
	}
}

//게시판 삭제
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

//관리자일때 답변버튼 보이게 하는 함수
function help_ShowAnswer(bno){
	swnum=swnum*-1;
	$(".help_bno"+bno).show();
	if(swnum == -1){
		$(".help_answer").attr("readOnly",false);
		$(".help_answer").after("<center class='answer_btn"+bno+"'><input type='button' value='확인' onclick='help_answer("+bno+")'></center>")
	}else if(swnum == 1){
		$(".help_answer").attr("readOnly",true);
		$(".answer_btn"+bno).remove();
		$(".help_bno"+bno).hide();
	}
}

//관리자 답변
function help_answer(bno){
	var answer = $(".help_bno"+bno+" textarea").val();
	$.ajax({
				url : 'board/help_answer',
				type : 'post',
				data : {
					"bno" : bno,
					"answer" : answer
				},
				success : function() {
					alert("답변이 완료되었습니다.")
					location.reload();
				},
				error : function(){
					alert("답변이 실패하였습니다.")
				}

			})
}