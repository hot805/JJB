/**
 * index?page=/board/detail&bno=${board.bno }&section=B4-01"
 * 
 */

$(document).ready(function(){
	$("#write").click(function(){
		location.href="index?page=/recipe/recipeWrite"
	})
})

function sendDetail(bno, userid){
	location.href="index?page=/board/detail&section=B2-01&bno="+bno+"&userid="+userid;
}