<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="resources/js/user/signup.js"></script>

<style type="text/css">
h4 {
	font-size: 15pt
}


#in {
	margin-left: 37%
}

#in div {
	text-align: left;
}
</style>

</head>
<body>
<section class="container">
		<div id="in">
			<form method="post" name="formSign" onsubmit="return btn_checkFinal()">

				<div class="form-group">
					<h4>아이디</h4>
					<input class="form-control col-lg-6" type="text"
						placeholder="8~20자 사이의  아이디를 입력해주세요." name="userid"
						style="display: inline-block">&nbsp<input
						class="btn btn-outline-secondary btn-md" type="button"
						value="중복체크" id="btn_id"><br>
					<span id="answer_id"></span>

				</div>
				<div class="form-group">
					<h4>비밀번호</h4>
					<input class="form-control col-lg-6" type="password"
						placeholder="8~20사이의 비밀번호를 입력해주세요." name="userpw" id="userpw">
					<span id="answer_pw"></span>
				</div>
				<div class="form-group">
					<h4>비밀번호 확인</h4>
						<input class="form-control col-lg-6" type="password"
							placeholder="위의 비밀번호와 동일하게 입력해주세요." style="display: inline-block"
							id="recheckpw"> <br>
						<span id="answer_repw"></span>
				</div>
				<div class="form-group">
					<h4>이름</h4>
					<input class="form-control col-lg-3" type="text" name="username">
					<br>
					<span id="answer_name"></span>
				</div>
				<div class="form-group">
					<h4>닉네임</h4>
						<input class="form-control col-lg-3" type="text" name="nickname"
							style="display: inline-block">&nbsp<input
							class="btn btn-outline-secondary btn-md" type="button"
							value="중복 체크" id="btn_nick"><br>
						<span id="answer_nick"></span>
				</div>
				<div class="form-group">
					<h4>이메일</h4>
						<input class="form-control col-lg-6" type="text" name="email"
							placeholder="이메일을 입력해주세요." style="display: inline-block">
						<input class="btn btn-outline-secondary btn-md" type="button"
							value="이메일 인증" id="btn_email"><br>
						<span id="createEmailck"> </span>
				</div>

				<div class="form-group">
					<h4>주소</h4>
						<input class="form-control col-lg-4" placeholder="우편번호"
							name="addr1" id="addr1" type="text" readonly="readonly"
							style="display: inline-block">
						<input type="button" class="btn btn-outline-secondary btn-md"
							onclick="execPostCode();" value="우편번호 찾기">
				</div>
				<div class="form-group">
					<input class="form-control col-lg-6" placeholder="도로명 주소"
						name="addr2" id="addr2" type="text" readonly="readonly" />
				</div>
				<div class="form-group">
					<input class="form-control col-lg-6" placeholder="상세주소"
						name="addr3" id="addr3" type="text" /> <br>
					<span id="answer_addr"></span>
				</div>

				<div class="form-group">
					<input class="btn btn-primary" type="submit" value="회원가입">&nbsp<input type="button"
						class="btn btn-danger" value="취소" id="btn_cancel">
				</div>
			</form>
		</div>
</section>






</body>
</html>