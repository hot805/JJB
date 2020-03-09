/**
 * index?page=/board/detail&bno=${board.bno }&section=B4-01"
 * 
 */

//레시피 작성페이지로 이동
$(document).ready(function(){
	$("#write").click(function(){
		location.href="index?page=/recipe/recipeWrite"
	})
})

//레시피 디테일로 이동
function sendDetail(bno, userid){
	location.href="index?page=/board/detail&section=B2-01&bno="+bno+"&userid="+userid;
}