<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="resources/css/board/boardModify.css">    

<form action="board/modifyBasic" method="post">
	<input type="hidden" value="${board.section }" name="section">
	<input type="hidden" value="${board.bno }" name="bno">
	<input type="hidden" value="${board.imgname }" name="imgname">
	<table class="table-bordered boardModify_table">
		<tr>
			<th>제목</th>
			<td><input type="text" id="boardModify_title" name="title" value="${board.title }"></td>
		</tr>
		<tr>
			<th>이벤트 기간</th>
			<td><input type="text" id="boardWrite_duration" name="duration" value="${board.duration }" placeholder="ex)YYYY-MM-DD~YYYY-MM-DD"></td>
		</tr>
		<tr>
			<th>썸네일</th>
			<td>
				<a class="event_contentAtag" href="javascript:void(window.open('board/insertImg', '파일첨부','width=500px, height=300px, top=200, left=500'))">이미지 업로드<클릭> </a>
				<div class="event_thumb"><img id="event_img" src="${board.imgname }"/></div>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10%" cols="80%" name="content">${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="board_btn">
				<input type="submit" value="작성완료" id="btn_click">
			</td>
		</tr>
	</table>
</form>