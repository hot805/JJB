/**
 * 
 */

	function deleteImg(data, imgnum) {
		alert("이미지" + imgnum)
		$.ajax({
			url : "talk/deleteFile",
			type : "post",
			//attr("1",2) 2라는 값을 1에 설정(세터), attr("1") 1이라는 값을 들고옴(게터)
			data : {
				fileName : data
			},//속성중에서 데이터 소스를 찾음(폴더안에서 데이터의 이름을 찾음)
			dataType : "text",
			success : function(result) {
				if (result == "deleted") {
					$(".deleteDiv" + imgnum).remove();
					$("#brfront" + imgnum).remove();
					$("#brback" + imgnum).remove();
					//$(".deleteDiv"+(imgnum-1)).focus();

				}
			}

		})
	}

	$(document).ready(function() {

		$("#btn_click").click(function() {
			
			if($("#countImg").val() > 1){	
				$(".temporaryTag").remove();
				
				if($("#section").val() == "B3-01"){
					var firstdiv = document.getElementById("contentTest").childNodes[2];
					var imgname = firstdiv.firstChild.getAttribute("src");
				}
			}
			
			if($("#section").val() == "B3-01"){
				var content = $("textarea[name=content]").val();
				var contentImg = $("#contentTest").html();
			
			}else if($("#section").val() == "B2-01"){
				var content = $("#contentTest").html();
				var title = $("#recipe_title").val();
				var imgname = $("#imgname").val();
				var category= $("select[name=category]").val();

			}
			
			var section = $("#section").val();
			var bno = $("#bno").val();
			var countImg = $("#countImg").val();
			var msg ="";
			var url ="";
			
			if($("#btn_click").val()=="작성완료"){
				msg="글작성이 완료되었습니다.";
				url = "board/write";
			}else{
				msg="글수정이 완료되었습니다.";
				url = "board/modify";
				if($("#section").val() == "B2-01"){
					var imgname1 = $("#imgname").val();
					var imgname = imgname1;
				}
			}

			$.ajax({
				url : url,
				type : 'post',
				data : {
					"contentImg" : contentImg,
					"imgname" : imgname,
					"content" : content,
					"section" : section,
					"countImg":countImg,
					"title": title,
					"bno" : bno,
					"category" : category
					
				},
				success : function() {
					alert(msg)
					location.href = "index?page=/board/&section="+section;
				}

			})

		})

	})

	function insertHtmlAtCursor() {
		 var sel = window.getSelection && window.getSelection();
		    if (sel && sel.rangeCount < 1) {
		    	return false;
		    }		
		$(".temporaryTag").remove();
		var html = "<div class='temporaryTag'></div>";
		var range, node;
		if (window.getSelection && window.getSelection().getRangeAt) {
			range = window.getSelection().getRangeAt(0);
			node = range.createContextualFragment(html);
			range.insertNode(node);
		} else if (document.selection && document.selection.createRange) {
			document.selection.createRange().pasteHTML(html);
		}
	}
	
	function checkImg(){
		window.getSelection().removeAllRanges();
	}
