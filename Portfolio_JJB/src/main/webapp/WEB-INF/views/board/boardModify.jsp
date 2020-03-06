<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="resources/css/board/boardModify.css">    
    
<form action="board/modifyBasic" method="post">
	<input type="hidden" value="${board.section }" name="section">
	<input type="hidden" value="${board.bno }" name="bno">
	<table class="table-bordered boardModify_table">
		<tr>
			<th>제목</th>
			<td><input type="text" id="boardModify_title" name="title" value="${board.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="20%" cols="77%" name="content">${board.content }</textarea>		
			</td>
		</tr>
		<tr>
			<td colspan="2" id="board_btn">
				<input type="submit" value="작성완료" id="btn_click">
			</td>
		</tr>
	</table>
</form>