<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="resources/css/board/talk/talkWrite.css">
<script src="resources/js/talk/talkWrite.js"></script>

<input type="hidden" value="B3-01" id="section">
<input type="hidden" value="1" id="countImg">
<input type="hidden" name="imgname">

<table class="table-bordered talkWrite_table">
			<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="talk_content"></textarea>
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<a class="recipe_contentAtag" 
				   href="javascript:void(window.open('talk/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">
					이미지 업로드<클릭>
				</a>
				<div contenteditable="false" id="contentTest" onclick="insertHtmlAtCursor()" style="padding:2%">
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
