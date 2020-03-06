/**
 * 
 */

//타이머 관련 변수
var num = 60 * 1; // 몇분을 설정할지의 대한 변수 선언
var myVar;
var randomNum;
//타이머 관련 변수 끝

var realemail;

$(document).ready(function(){
	//닉네임 체크
	//닉네임 저장용 변수(닉네임 변경을 취소할 시 돌아갈 변수)
	var realnick;

	$("#btn_nick").click(function(){		
		if($(this).val()=="수정"){
			realnick = $("input[name=nickname]").val();
			$(this).val("중복 확인");
			alert("닉네임을 수정 후 중복확인을 해주세요.");
			$("input[name=nickname]").attr("readOnly",false);
			return false;
		}
		if($(this).val()=="중복 확인"){
			var nickname = $("input[name=nickname]").val();
			//ajax 시작
			$.ajax({
				url : "user/checkNick?nickname=" + nickname,
				type : "GET",
				dataType : "text",
				success : function(data) {
					if (data == "") {// 사용가능한 닉네임
						var result = confirm("사용가능한 닉네임입니다. 이 닉네임을 사용하시겠습니까?");
							if(result){
								changeAjax();	
							}else{
								alert("수정을 취소하셨습니다.")
								$("input[name=nickname]").val(realnick);
								$("input[name=nickname]").attr("readOnly",true);						
								$("#changeNickname").val("수정");
							}
							
					} else {// 중복된 닉네임
						alert("이미 존재하는 닉네임입니다.")
					}
				}
			})
			//ajax 끝
			
		}
	})
	//닉네임 체크 끝
	
	//이메일 인증
	$("#btn_email").click(function(){
		if($(this).val()=="수정"){
			realemail = $("input[name=email]").val();
			alert("수정할 이메일을 입력해주세요.")
			$("input[name=email]").attr("readOnly",false);
			$(this).val("본인인증");
			return false;
		}
		
		randomNum = Math.floor(Math.random() * 1000000)+100000;
		if(randomNum>1000000){
			randomNum = randomNum - 100000;
		}

		var email = $("input[name=email]").val();
		
		if (email == "") {
			alert("이메일을 입력해주세요.");
		} else {
		
			$.ajax({
				//url : "../mail?email=" + email,
				url : "../mail",
				type : "POST",
				data : {"email":email,
						"randomNum":randomNum},
				success : function(result) {
					if(result==true){
						alert("인증을 위한 메일이 발송되었습니다.");
						$("#createEmailck").html("<input class='form-control col-lg-2' type='text' style='display:inline-block' id='checkNum_email'>" +
								"&nbsp<input type='button' value='인증 확인' class='btn btn-outline-secondary btn-md'  onclick='btn_ckEmail()'>" +
								"&nbsp&nbsp<input type='text' id='timer_email' style='border:none;'>");
						time();
					}else{
						alert("메일 발송을 실패하였습니다.");
					}
					
				},
				error : function(request,error){
					alert("code:"+request.status+"message:"+request.responseText+"error:"+error);
				}
			})
		}
	})
	//이메일 인증 끝
	
	//프로필 이미지
$("input[name=file]").change(function() {
	var form= $("form[name=uploadForm]")[0];
	var formData = new FormData(form);
	var originalImg = $(".info_profile").attr("src");
	
	console.log(form)
	console.log(formData)
	
	$.ajax({
		url : 'user/GetImgName',
		type:'post',
		data: formData,
		contentType:false,
		processData:false,
		success:function(data){	
			$(".info_profile").attr("src","talk/displayFile?fileName="+data);
			var result = confirm("해당 이미지로 프로필이미지를 변경하시겠습니까?");
			if(result){
				changeAjax();	
			}else{
				alert("수정을 취소하셨습니다.")									
				$(".info_profile").attr("src",originalImg);
			}
		},
		error:function(error){
			alert(error)
		}
	
	})		
});
//프로필 이미지 끝
	
})

//공통 Ajax 처리
function changeAjax(){	
	var userid=$("input[name=userid").val();
	var nickname =$("input[name=nickname]").val();
	var email = $("input[name=email").val();
	var addr1 = $("input[name=addr1").val();
	var addr2 = $("input[name=addr2").val();
	var addr3 = $("input[name=addr3").val();
	var profileImg = $(".info_profile").attr("src");
	
	$.ajax({
		url : "user/changeInfo",
		type : "POST",
		//dataType : "text",
		data:{"userid":userid,
			  "nickname": nickname,
			  "email":email,
			  "addr1":addr1,
			  "addr2":addr2,
			  "addr3":addr3,
			  "profileImg":profileImg},
		success : function() {
					alert('수정이 완료되었습니다')
					location.reload();
		},
		error : function(request,error){
			alert("code:"+request.status+"message:"+request.responseText+"error:"+error);
		}
	})
}
//공통 Ajax 처리 끝


//우편번호 함수
function execPostCode() {
		if($("#addrck").val()=="수정"){
			$("#addrck").val("우편번호 검색");
			$("input[name=addr3]").attr("readOnly",false);
			$("#createAddrck").html("<input type='button' class='btn btn-outline-secondary btn-md' value='확인' onclick='changeBtn()'>");
			return false;
		}
	
         new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=addr1]").val(data.zonecode);
                $("[name=addr2]").val(fullRoadAddr);
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open();
     }
//우편번호 함수 끝

//타이머

function time(){
    myVar = setInterval(alertFunc, 1000); 
}

function alertFunc() {
    var min = num / 60; 
    min = Math.floor(min);
    
    var sec = num - (60 * min);
    console.log(min)
    console.log(sec)

    var $input = $('#timer_email').val(min + '분' + sec + '초');

    if(num == 0){
    	alert("인증시간이 만료되었습니다.")
    	$("#createEmailck").empty();
    	$("#createEmailck").html("인증시간이 만료되었습니다.");
        clearInterval(myVar) // num 이 0초가 되었을대 clearInterval로 타이머 종료
        num = 5 * 1;
    }
    num--;
}
//타이머 끝 

//이메일 인증 확인 및 수정
function btn_ckEmail(){
	var checkNum = $("#checkNum_email").val();
	if(randomNum == checkNum){
		var result = confirm("이메일 인증이 완료되었습니다. 이 이메일로 수정하시겠습니까?");
		if(result){
			changeAjax();
		}else{
			alert("이메일 수정을 취소하셨습니다.");
			$("#btn_email").val("수정");			
			$("input[name=email]").val(realemail);
			$("input[name=email]").attr('readonly', true);
			$("#createEmailck").empty();
		}
	}else{
		alert("인증번호가 다릅니다. 다시한번 입력해주세요.")
	}

}
//이메일 인증 확인 및 수정 끝

//우편번호 수정
function changeBtn(){
	changeAjax();
}
//우편번호 수정 끝

