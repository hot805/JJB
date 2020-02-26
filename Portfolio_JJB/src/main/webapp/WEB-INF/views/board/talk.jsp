<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<link rel="stylesheet" href="resources/css/board/talk/talk.css">
<script src="resources/js/talk/talk.js"></script>

<input type="hidden" value="${ sessionScope.userid }" id="sessionID">
<div class="talk_background">
	<h5>여러분들의 이야기를 들려주세요.</h5>
	<input class="btn btn-info" type="button" value="글쓰기" id="write"><br>
</div>

<c:forEach items="${list}" var="board">
	<div class="fortalk">
		<img class="rounded-circle talk_profile" src="${board.profileImg }" />
		<div class="talk_all">
			<div class="talk_nickname">${board.nickname }</div>
			<div class="talk_udate">${board.udate }</div>
			<a href="index?page=/board/detail&bno=${board.bno }&section=B3-01">
				<div class="talk_content">${board.content}</div>
				<c:if test="${not empty board.imgname}">
					<img src="${board.imgname }">
				</c:if>
			</a>
		</div>
	</div>
</c:forEach>
<center>
	<c:if test="${Page.prev}">
		<a href="index?pageNum=${Page.startPage-1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Previous</a>		
	</c:if>
	<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
		<a href="index?pageNum=${num}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">${num}</a>	
	</c:forEach>

	<c:if test="${Page.next}">
		<a href="index?pageNum=${Page.endPage+1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Next</a>
	</c:if>
</center>


<div id="contest"></div>

