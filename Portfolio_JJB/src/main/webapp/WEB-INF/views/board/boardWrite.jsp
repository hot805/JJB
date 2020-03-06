<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<link rel="stylesheet" href="resources/css/board/boardWrite.css">

<form action="board/writeBasic" method="post">
	<input type="hidden" value="${section }" name="section">
	<table class="table-bordered boardWrite_table">
		<tr>
			<th>제목</th>
			<td><input type="text" id="boardWrite_title" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="20%" cols="77%" name="content"></textarea>		
			</td>
		</tr>
		<tr>
			<td colspan="2" id="board_btn">
				<input type="submit" value="작성완료" id="btn_click">
			</td>
		</tr>
	</table>
</form>