<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
	
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="resources/css/user/changeInfo.css">
<script src="resources/js/user/changeInfo.js"></script>


	<section class="container">
		<hr>
		<div class="form-group row">
			<div class="col-sm-3">
				<Strong>아이디</Strong>
			</div>
			<div class="col-sm-9">
				<input class="form-control col-sm-3" type="text" name="userid" value="${user.userid}" readonly>
			</div>
		</div>
		<hr>
		<div class="form-group row">
			<div class="col-sm-3">
				<Strong>프로필 이미지</Strong>
			</div>
			<div class="col-sm-9">
				<form enctype="multipart/form-data" target="zeroFrame" name="uploadForm">
					<input type="file" value="이미지 올리기" name="file">
				</form>
				<div>
					<img class="rounded-circle info_profile" src="${sessionScope.profileImg }">
				</div>				
			</div>
		</div>
		<hr>
		<div class="form-group row">
			<div class="col-sm-3">
				<Strong>닉네임</Strong>
			</div>
			<div class="col-sm-9">
				<input class="form-control col-sm-3" type="text" name="nickname" value="${sessionScope.nickname}" style="display: inline-block" readonly>
				<input class="btn btn-outline-secondary btn-md" type="button" value="수정" id="btn_nick">
			</div>
		</div>
		<hr>
		<div class="form-group row">
			<div class="col-sm-3">
				<Strong>이메일</Strong>
			</div>
			<div class="col-sm-9">
				<input class="form-control col-sm-3" type="text" name="email" value="${user.email}" style="display: inline-block" readonly>
				<input class="btn btn-outline-secondary btn-md" type="button" value="수정" id="btn_email">
				<br><span id="createEmailck"> </span>
			</div>
		</div>
		<hr>
		<div class="form-group row">
			<div class="col-sm-3">
				<Strong>주소</Strong>
			</div>
			<div class="col-sm-9">
				<div class="form-group">
					<input class="form-control col-sm-4" placeholder="우편번호"
						name="addr1" id="addr1" type="text" readonly
						style="display: inline-block" value="${user.addr1}">
					<input type="button" class="btn btn-outline-secondary btn-md"
						onclick="execPostCode();" value="수정" id="addrck">
				</div>
				<div class="form-group">
					<input class="form-control col-sm-6" placeholder="도로명 주소"
						name="addr2" id="addr2" type="text" readonly value="${user.addr2}">
				</div>
				<div class="form-group">
					<input class="form-control col-sm-6" placeholder="상세주소"
						name="addr3" id="addr3" type="text" readonly value="${user.addr3}" style="display:inline">
						<span id="createAddrck"> </span>
				</div>			
			</div>
		</div>
		<hr>
		<div></div>
		<div></div>
		<div></div>
	</section>
