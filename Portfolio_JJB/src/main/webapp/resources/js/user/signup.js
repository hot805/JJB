/**
 * 
 */
var idBool = false;
var pwBool = false;
var nickBool = false;
var emailBool = false;

//타이머 관련 변수
var num = 60 * 3; // 몇분을 설정할지의 대한 변수 선언
var myVar;
var randomNum;
//타이머 관련 변수 끝

$(document).ready(function() {
	
	var idcheck=RegExp(/^[a-zA-Z0-9]{5,20}$/);
	var pwcheck=RegExp(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,16}$/);

	// 아이디 중복체크
	$("#btn_id").click(function() {
		if($("#answer_id").html() == "형식에 맞게 입력해주세요."){
			alert("아이디를 형식에 맞춰서 입력해주세요.")
			return false;
		}
		
		if(idBool == true){
			alert("이미 중복체크를 하셨습니다.")
			return false;
		}
		
		var userid = $("input[name=userid]").val();

		if (userid == "") {
			alert("아이디를 입력해주세요");
		} else {
			$.ajax({
				url : "user/checkID?userid=" + userid,
				type : "GET",
				success : function(data) {
					if (data == true) {// 사용가능한 아이디
						idBool = true;
						alert("사용가능한 아이디입니다.")
						$("#answer_id").html("아이디 중복체크가 완료되었습니다.");
					} else {// 중복된 닉네임
						alert("이미 존재하는 아이디입니다.")
						$("#answer_id").html("아이디를 수정해주세요.");
					}
				}
			})
		}
	})
	// 아이디 중복체크 끝

	// 닉네임 중복체크
	$("#btn_nick").click(function() {
		var nickname = $("input[name=nickname]").val();

		if (nickname == "") {
			alert("닉네임을 입력해주세요");
		} else {
			$.ajax({
				url : "user/checkNick?nickname=" + nickname,
				type : "GET",
				dataType : "text",
				success : function(data) {
					if (data == "") {// 사용가능한 닉네임					
						nickBool = true;
						alert("사용가능한 닉네임입니다.")
						$("#answer_nick").html("닉네임 중복체크가 완료되었습니다.");
					} else {// 중복된 닉네임
						alert("이미 존재하는 닉네임입니다.")
						$("#answer_nick").html("닉네임을 수정해주세요.");
					}
				},
				error : function(request,error){
					alert("code:"+request.status+"message:"+request.responseText+"error:"+error);
				}
			})
		}
	})
	// 닉네임 중복체크 끝

	// 패스워드 중복체크
	$("#recheckpw").keyup(function(){
		pwReCk();
	})
	// 패스워드 중복체크 끝
	
	//이메일 인증
	$("#btn_email").click(function(){
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
				url : "mail",
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
					alert("error:"+error);
				}
			})
		}
	})
	//이메일 인증 끝
	
	//키업 패턴 (아이디, 패스워드, 닉네임, 이메일)
	$("input[name=userid]").keyup(function(){
		idBool = false;
		if(!(idcheck.test($("input[name=userid]").val()))){
			$("#answer_id").html("형식에 맞게 입력해주세요.")
		}else{
			$("#answer_id").html("사용가능한 아이디입니다.")

		}
	});
	
	$("input[name=userpw]").keyup(function(){
		if(!(pwcheck.test($("input[name=userpw]").val()))){
			$("#answer_pw").html("형식에 맞게 입력해주세요.")
		}else{
			$("#answer_pw").html("사용가능한 비밀번호입니다.")
		}
		
		pwReCk();
	});
	
	//키업 끝
	
	//change 함수 (id 혹은 닉네임 값이 바뀔 경우 인증이 취소됨)
	$("input[name=userid]").change(function(){
		idBool = false;
	})
	
	$("input[name=nickname]").change(function(){
		nickBool = false;
	})
	//change 함수 끝
	
	$("#btn_cancel").click(function(){
		alert("메인페이지로 돌아갑니다.")
		location.href="index"
	})

	
})

//우편번호 함수
function execPostCode() {
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
    
    if(emailBool == true){
    	clearInterval(myVar)
    }
    num--;
}
//타이머 끝 

//이메일 인증 확인버튼
function btn_ckEmail(){
	var checkNum = $("#checkNum_email").val();
	if(randomNum == checkNum){
		alert("이메일 인증이 완료되었습니다.");
		emailBool = true;
		$("input[name=email]").attr('readonly', true);
		$("#createEmailck").empty();
    	$("#createEmailck").html("이메일 인증이 완료되었습니다.");
	}else{
		alert("인증번호가 다릅니다. 다시한번 입력해주세요.")
	}

}
//이메일 인증 확인버튼 끝

//비밀번호 재확인 함수
function pwReCk(){
	var userpw = $("#userpw").val();
	var recheckpw = $("#recheckpw").val();

	if (userpw == recheckpw && $("#answer_pw").html() == "사용가능한 비밀번호입니다.") {
		pwBool = true;
		$("#answer_repw").html("비밀번호가 일치합니다.");
	} else {
		pwBool = false;
		$("#answer_repw").html("비밀번호가 일치하지않습니다.");
	}
}
//비밀번호 재확수 확인 끝

//회원가입 버튼 이벤트
function btn_checkFinal(){

	var nameLen=$("input[name=username]").val().length;
	var add1Len=$("input[name=addr1]").val().length;
	var add2Len=$("input[name=addr2]").val().length;
	var add3Len=$("input[name=addr3]").val().length;
	
	if(idBool == false){
		alert("아이디 중복확인을 해주세요.");
		$("input[name=userid]").focus();
		$("#answer_id").empty();
		$("#answer_id").html("아이디 중복체크를 해주세요.");
		return false;
	}
	
	if(pwBool == false){
		alert("비밀번호 확인창을 다시 확인해주세요.");
		$("#recheckpw").focus();
		$("#answer_repw").empty();
		$("#answer_repw").html("비밀번호를 재확인해주세요.");
		return false;
	}
	
	if(nickBool == false){
		alert("닉네임 중복확인을 해주세요.");
		$("input[name=nickname]").focus();
		$("#answer_nick").empty();
		$("#answer_nick").html("닉네임 중복체크를 해주세요.");
		return false;
	}
	
	if(emailBool == false){
		alert("이메일 본인인증을 해주세요.");
		$("input[name=email]").focus();
		$("#createEmailck").empty();
		$("#createEmailck").html("이메일 본인인증을 해주세요.");
		return false;
	}
	
	if(nameLen == 0){
		alert("이름을 입력해주세요.");
		$("input[name=username]").focus();
		$("#answer_name").empty();
		$("#answer_name").html("이름을 입력해주세요.");
		return false;
	}
	
	if(add1Len == 0 || add2Len ==0 || add3Len == 0){
		alert("주소를 입력해주세요.");
		$("input[name=addr3]").focus();
		$("#answer_addr").empty();
		$("#answer_addr").html("주소를 입력해주세요.");
		return false;
	}

	
	alert("회원가입이 완료되었습니다.")
	formSign.action="user/signUp"
}
//회원가입 버튼 이벤트 끝