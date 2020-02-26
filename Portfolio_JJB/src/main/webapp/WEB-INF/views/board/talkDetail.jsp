<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->

<link rel="stylesheet"
	href="resources/css/board/notice/noticeDetail.css">
<script src="resources/js/notice/noticeDetail.js"></script>
<script src="resources/js/talk/talkDetail.js"></script>
<input type="hidden" value="${sessionScope.userid}" id="sessionid">
<input type="hidden" value="${sessionScope.nickname}" id="sessionname">
<input type="hidden" value="${board.bno }" id="boardnum">
<input type="hidden" value="${board.section }" id="section">
<input type="hidden" value='${board}' id="baordInfo">


<div class="ND_style1 ND_inline">${board.nickname }</div>
(
<div class="ND_style2 ND_inline">${board.userid }</div>
)
<div class="ND_style2 ND_udate">${board.udate }<c:if test="${sessionScope.userid eq board.userid}">&nbsp|&nbsp<a href="index?page=/talk/talkModify&bno=${board.bno}">수정</a>&nbsp|&nbsp<a style="cursor: pointer" onclick="boardDelete(${board.bno})">삭제</a></c:if></div>

<br>
<div class="ND_content"><textarea readonly>${board.content }</textarea><br>${board.contentImg }</div>
<div class="ND_content_det"></div>
<div class="ND_repSend">
	<input type="text" class="ND_repContent " placeholder="댓글을 입력해주세요." name="repText">
	<input type="button" class="ND_repSendBtn" value="등록" onclick="repWrite()" >
</div>
<div class="ND_repReceive">
	<c:forEach items="${list}" var="reboard">
		<p>${reboard.nickname }(${reboard.userid } ) &nbsp ${reboard.likeno }</p>
		<p>
			&nbsp ${reboard.content } ${reboard.udate }
			<c:if test="${reboard.userid eq sessionScope.userid }">
				<a style="cursor: pointer"
					onclick="repModi(${reboard.rno},'${reboard.userid }')">수정</a>
				<a style="cursor: pointer" onclick="repDel(${reboard.rno})">삭제</a>
				<br>
				<span class="forModify${reboard.rno }"></span>
			</c:if>
		</p>
		<hr>
	</c:forEach>


	<center>
		<c:if test="${Page.prev}">
			<a href="index?pageNum=${Page.startPage-1}&page=/board/detail&bno=${board.bno }&section=${board.section }">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a href="index?pageNum=${num}&check=true&page=/board/detail&bno=${board.bno }&section=${board.section }">${num}</a></li>
		</c:forEach>

		<c:if test="${Page.next}">
			<a href="index?pageNum=${Page.endPage+1}&page=/board/detail&bno=${board.bno }&section=${board.section }">Next</a></li>
		</c:if>

	</center>
	
</div>
