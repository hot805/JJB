<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link rel="stylesheet" href="resources/css/board/recipe/recipe.css">
<script src="resources/js/recipe/recipe.js"></script>

<c:if test="${sessionScope.qualify >= 1 }">
	<div class="recipe_background">
		<h5>여러분들의 레시피를 공유해보세요.</h5>
		<input class="btn btn-info" type="button" value="글쓰기" id="write"><br>
	</div>
</c:if>

<div class="ListAtag">
	<span>분류별</span>&nbsp&nbsp
	<a class="iconTotal" href="index?page=/board/&section=B2-01">전체</a>&nbsp&nbsp
	<a class="iconList" href="index?page=/board/&section=B2-01&category=찌개">찌개</a>&nbsp
	<a class="iconList" href="index?page=/board/&section=B2-01&category=구이">구이</a>&nbsp
	<a class="iconList" href="index?page=/board/&section=B2-01&category=조림">조림</a>&nbsp
</div>
<hr>

<div class="recipe_order">
	<a href="index?page=/board/&section=B2-01&orderno=1">최신순</a>&nbsp
	<a href="index?page=/board/&section=B2-01&orderno=2">조회순</a>&nbsp
	<a href="index?page=/board/&section=B2-01&orderno=3">좋아요순</a>
</div>
<br>
<div class="recipe_content">
	<div class="recipe_orderby"></div>
	<div class="recipe_foreach">
		<c:forEach items="${list }" var="board">
			<div class="recipe_items"
				onclick="sendDetail(${board.bno}, '${board.userid}')">
				<img src="${board.imgname}"> <br>
				<div style="text-align: center">
					<c:choose>
						<c:when test="${fn:length(board.title) gt 15}">
							<c:out value="${fn:substring(board.title, 0, 14)}">
							</c:out>...
        				</c:when>
						<c:otherwise>
							<c:out value="${board.title}">
							</c:out>
						</c:otherwise>
					</c:choose>
					<br> <span>by ${board.nickname}</span><br>
				</div>
			</div>
		</c:forEach>
	</div>
	<center>

		<c:if test="${Page.prev}">
			<a
				href="index?pageNum=${Page.startPage-1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}&category=${board.category}&orderno=${board.orderno}">Previous</a>
			</li>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a
				href="index?pageNum=${num}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}&category=${board.category}&orderno=${board.orderno}">${num}</a>
			</li>
		</c:forEach>

		<c:if test="${Page.next}">
			<a
				href="index?pageNum=${Page.endPage+1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}&category=${board.category}&orderno=${board.orderno}">Next</a>
			</li>
		</c:if>


	</center>
</div>
