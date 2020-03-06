<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/user/deleteUser.js"></script>
</head>
<body>
	<section class="container" style="margin-left:30%;">
			<div class="form-group">
				<h5>현재 비밀번호</h5>
				<input class="form-control col-sm-3" type="password" name="password">
			</div>

			<div class="form-group">
				<h5>비밀번호 재확인</h5>
				<input class="form-control col-sm-3" type="password" name="reckPw">
			</div>
			<div class="form-group">
				<input type="button" class="btn btn-outline-secondary btn-md" value="삭제" id="btn_delete">
			</div>
	</section>
</body>
</html>