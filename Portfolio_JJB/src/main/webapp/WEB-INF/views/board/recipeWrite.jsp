<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<script src="resources/js/talk/talkWrite.js"></script>
<script src="resources/js/recipe/recipeWrite.js"></script>
<input type="hidden" value="1" id="countImg">
<input type="hidden" id="imgname">
<input type="hidden" value="B2-01" id="section">

<table class="table-bordered" style="width:100%; padding:2%">
		<tr>
			<th style="width:20%">제목</th>
			<td ></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td ></td>
		</tr>
		<tr>
			<th>썸네일</th>
			<td ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td ></td>
		</tr>
</table>

제목 :
<input type="text" id="recipe_title">
<br>
<select name="category">
	<option value="">카테고리 선택</option>
	<option value="조림">조림</option>
	<option value="찌개">찌개</option>
	<option value="구이">구이</option>
</select>
<br>
썸네일 :
<form enctype="multipart/form-data" target="zeroFrame" name="uploadForm">
	<input type="file" value="이미지 올리기" name="file">
</form>
<br>
<span class="selectedThumb">
	
</span>
<br>
<div>
</div>
<br>
<a
	href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">
	이미지업로드 </a>
<br>
내용 :
<div contenteditable="true" id="contentTest" onkeyup="insertHtmlAtCursor()" onclick="insertHtmlAtCursor()" style="padding:2%">
	<div class='temporaryTag'></div>
</div>
<br>
<input type="button" value="작성완료" id="btn_click">