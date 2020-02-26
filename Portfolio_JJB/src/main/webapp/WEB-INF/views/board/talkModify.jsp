<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script src="resources/js/talk/talkWrite.js"></script>

<input type="hidden" value='${BoardVO.bno }' id="bno">
<input type="hidden" value='${BoardVO.section }' id="section">
<input type="hidden" value='${BoardVO.countImg}' id="countImg">
<br>
<input type="hidden" name="imgname" value='${BoardVO.imgname}'>
내용
<textarea name="content">${BoardVO.content}</textarea>
<br>
이미지파일
<a
	href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">
	이미지업로드 </a>
<br>
<div contenteditable="false" id="contentTest" onclick="insertHtmlAtCursor()" style="padding:1%">
	${BoardVO.contentImg}
</div>
<br>
<input type="button" value="수정완료" id="btn_click">
