<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<script src="resources/js/talk/talkWrite.js"></script>
<script src="resources/js/recipe/recipeWrite.js"></script>
<link rel="stylesheet" href="resources/css/board/recipe/recipeWrite.css">

<input type="hidden" value="1" id="countImg">
<input type="hidden" id="imgname">
<input type="hidden" value="B2-01" id="section">

<table class="table-bordered recipeWrite_table">
		<tr>
			<th>제목</th>
			<td><input type="text" id="recipe_title"></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td>
				<select name="category">
					<option value="">카테고리 선택</option>
					<option value="조림">조림</option>
					<option value="찌개">찌개</option>
					<option value="구이">구이</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>썸네일</th>
			<td>
				<form enctype="multipart/form-data" target="zeroFrame" name="uploadForm">
					<input type="file" value="이미지 올리기" name="file">
				</form>
				<br>
				<div class="selectedThumb"></div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<a class="recipe_contentAtag" href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">이미지 업로드<클릭> </a>
				<br>
				<div contenteditable="true" id="contentTest" onkeyup="insertHtmlAtCursor()" onclick="insertHtmlAtCursor()" style="padding:2%">
					<div class='temporaryTag'></div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="recipe_btn">
				<input type="button" value="작성완료" id="btn_click">
			</td>
		</tr>
</table>
