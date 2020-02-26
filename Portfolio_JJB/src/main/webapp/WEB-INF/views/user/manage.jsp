<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/user/manage.css">

</head>
<body>
	<section class="container">
		<div class="row section_margin1">
			<div class="col-sm-2"></div>
			<div class="jumbotron col-sm-3">
				<a href="index?page=/user/changeInfo" class="aTagManage">회원정보 수정</a>
			</div>
			<div class="col-sm-2"></div>
			<div class="jumbotron col-sm-3">
				<a href="index?page=/user/changePw" class="aTagManage">비밀번호 변경</a>
			</div>
		</div>
		<div class="row section_margin2">
			<div class="col-sm-2"></div>
			<div class="jumbotron col-sm-3">
				<a href="index?page=/user/deleteUser" class="aTagManage">회원 탈퇴</a>
			</div>
		</div>
	</section>
</body>
</html>