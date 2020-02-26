<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/user/changePw.js"></script>
</head>
<body>
	<section class="container">
			<div class="form-group">
				<h5>비밀번호</h5>
				<input class="form-control col-sm-3" type="password" name="password">
			</div>
			<div class="form-group">
				<h5>새비밀번호</h5>
				<input class="form-control col-sm-3" type="password" name="newPw"><br>
				<span id="answer_pw"></span>
			</div>
			<div class="form-group">
				<h5>비밀번호 재확인</h5>
				<input class="form-control col-sm-3" type="password" name="reckNewPw">
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-outline-secondary btn-md" value="비밀번호 변경" id="btn_pw">
			</div>
	</section>

</body>
</html>