<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->

<link rel="stylesheet" href="resources/css/board/notice/noticeDetail.css">
<script src="resources/js/notice/noticeDetail.js"></script>
<input type="hidden" value="${sessionScope.userid}" id="sessionid">
<input type="hidden" value="${sessionScope.nickname}" id="sessionname">
<input type="hidden" value="${board.bno }" id="boardnum">
<input type="hidden" value="${board.section }" id="section">

<c:choose>
	<c:when test="${board.section == 'B2-01'}">
		<link rel="stylesheet" href="resources/css/board/recipe/recipeDetail.css">
		<c:set var="location" value="/recipe/recipeModify" />
	</c:when>
	<c:when test="${board.section == 'B4-01'}">
		<c:set var="location" value="/board/modifyBasic&bno=${board.bno}&content=${board.content }&section=${board.section }&title=${board.title }" />
	</c:when>
	<c:when test="${board.section == 'B4-02' || board.section == 'B4-03' || board.section == 'B4-04'}">
		<c:set var="location" value="/board/modifyBasic&bno=${board.bno}&content=${board.content }&section=${board.section }&title=${board.title }&imgname=${board.imgname }&duration=${board.duration }" />
	</c:when>
	
</c:choose>

<div class="ND_style1 ND_title">${board.title }</div>
<div class="ND_style2 ND_udate">${board.udate }<c:if test="${sessionScope.userid eq board.userid}">&nbsp|&nbsp<a href="index?page=<c:out value="${location}" />&bno=${board.bno}" style="color:#c9c9c9">수정</a>&nbsp|&nbsp<a style="cursor: pointer" onclick="boardDelete(${board.bno},'${board.section }')">삭제</a></c:if></div>
<hr>
<img class="rounded-circle detail_profile" src="${board.profileImg }"><div class="ND_style1 ND_inline">${board.nickname }</div>
(
<div class="ND_style2 ND_inline" id="forModifyID">${board.userid }</div>
)
<br>
<br>
<div class="ND_content">${board.content }</div>

<div class="ND_content_det">
	<c:if test="${board.section == 'B2-01'}">
		<c:choose>
			<c:when test="${likeck == '1'}">	
				<a class="forlike" check="unlike" style="cursor:pointer" onclick="clickLike(${board.bno})">좋아요 취소</a>
				</c:when>
			<c:when test="${likeck == '0'}">	
				<a class="forlike" check="like" style="cursor:pointer" onclick="clickLike(${board.bno})">좋아요</a>
			</c:when>
		</c:choose>
		&nbsp
		<c:choose>
			<c:when test="${followck == '1'}">	
				<a class="forfollow" check="unfollow" style="cursor:pointer" onclick="clickfollow('${board.userid}')">팔로우 취소</a>
				</c:when>
			<c:when test="${followck == '0'}">	
				<a class="forfollow" check="follow" style="cursor:pointer" onclick="clickfollow('${board.userid}')">팔로우</a>
			</c:when>
		</c:choose>
	</c:if>
</div>
<div class="ND_repSend">
	<input type="text" class="ND_repContent " placeholder="댓글을 입력해주세요."
		name="repText"> <input type="button" class="ND_repSendBtn"
		value="등록" onclick="repWrite()">
</div>
<div class="ND_repReceive">
	<c:forEach items="${list}" var="reboard">
		<p>${reboard.nickname }(${reboard.userid })</p>
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
			<a href="index?pageNum=${Page.startPage-1}&page=/board/detail&bno=${board.bno }&section=${board.section }">Previous</a>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a href="index?pageNum=${num}&check=true&page=/board/detail&bno=${board.bno }&section=${board.section }">${num}</a>
		</c:forEach>

		<c:if test="${Page.next}">
			<a href="index?pageNum=${Page.endPage+1}&page=/board/detail&bno=${board.bno }&section=${board.section }">Next</a>
		</c:if>
</center>

</div>
