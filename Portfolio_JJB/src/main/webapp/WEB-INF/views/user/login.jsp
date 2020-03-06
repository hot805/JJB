<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="resources/js/user/login.js"></script>
<style type="text/css">
</style>
</head>
<body>
		<form action="user/login" method="post" onsubmit="return loginCheck()">
			<div id="myLogin1">
				<h4>로그인</h4>
				<input type="text" placeholder="아이디" name="userid"><br>
				<input type="password" placeholder="비밀번호" name="userpw">
			</div>
			<div id="myLogin1">
			<input type="submit" value="로그인"><br>
			<input type="button" value="회원가입" onclick="sign()">
			</div>
		</form>
</body>
</html>