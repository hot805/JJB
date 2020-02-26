/**
 * 
 */

function openLeft(){
	if($(".left_menu").css("display") == "none"){
		$(".left_menu").attr("style","display:block")
	}else{
		$(".left_menu").attr("style","display:none")
	}
}