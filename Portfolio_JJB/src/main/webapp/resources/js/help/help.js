/**
 * 
 */
function displayAnswer(bno){
	if($(".help_bno"+bno).css("display") == "none"){
		$(".help_bno"+bno).show();
	}else{
		$(".help_bno"+bno).hide();
	}
}