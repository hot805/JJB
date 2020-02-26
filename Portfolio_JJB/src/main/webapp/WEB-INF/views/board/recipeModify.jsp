<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<script src="resources/js/talk/talkWrite.js"></script>
<script src="resources/js/recipe/recipeWrite.js"></script>
<input type="hidden" value="1" id="countImg">
<input type="hidden" value="B2-01" id="section">
<input type="hidden" id="imgname" value="${BoardVO.imgname}">
<input type="hidden" value="${BoardVO.bno }" id="bno">

제목 :
<input type="text" id="recipe_title" value='${BoardVO.title}'>
<br>
<select name="category">
	<option value="">카테고리 선택</option>
	<option value="조림" <c:if test="${BoardVO.category eq '조림'}">selected</c:if>>조림</option>
	<option value="찌개" <c:if test="${BoardVO.category eq '찌개'}">selected</c:if>>찌개</option>
	<option value="구이" <c:if test="${BoardVO.category eq '구이'}">selected</c:if>>구이</option>
</select>
<br>
썸네일 :
<form enctype="multipart/form-data" target="zeroFrame" name="uploadForm">
	<input type="file" value="이미지 올리기" name="file">
</form>
<br>
<span class="selectedThumb">
	<img src="${BoardVO.imgname }">
</span>
<br>

<a
	href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">
	이미지업로드 </a>
<br>
내용 :
<div contenteditable="true" id="contentTest" onkeyup="insertHtmlAtCursor()" onclick="insertHtmlAtCursor()" style="padding:2%">
	${BoardVO.content}
</div>
<br>
<input type="button" value="수정완료" id="btn_click">