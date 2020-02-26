<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<input type="hidden" value="B3-01" id="section">

<script src="resources/js/talk/talkWrite.js"></script>

talkWrite
<input type="hidden" value="1" id="countImg">
<br>
<input type="hidden" name="imgname">
내용
<textarea name="content"></textarea>
<br>
이미지파일
<a
	href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">
	이미지업로드 </a>
<br>
<div contenteditable="false" id="contentTest" onclick="insertHtmlAtCursor()" style="padding:2%">
	<div class='temporaryTag'></div>
</div>
<br>
<input type="button" value="작성완료" id="btn_click">


