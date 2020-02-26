/**
 * 
 */

function boardDelete(bno){
	
	$.ajax({
				url : 'board/delete',
				type : 'post',
				data : {
					"bno" : bno,
					"section" : "B3-01"
				},
				success : function() {
					alert("글삭제가 완료되었습니다.")
					location.href = "index?page=/board/&section=B3-01";
				},
				error : function(){
					alert("글삭제가 실패하였습니다. 관리자에게 문의해주세요.")
				}

			})
}