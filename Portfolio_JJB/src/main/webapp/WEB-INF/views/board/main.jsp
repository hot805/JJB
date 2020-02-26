<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="resources/css/mainmenu.css">


<div class="listMain">
	<h5>최신순</h5><br>
	<c:forEach items="${List1}" var="list1" begin="0" end="2">
		<div>
			<a href="index?page=/board/detail&section=B2-01&bno=${list1.bno}">
				<img src="${list1.imgname}"/><br>
				<c:choose>
       				<c:when test="${fn:length(list1.title) gt 15}">
       					<c:out value="${fn:substring(list1.title, 0, 14)}">
        				</c:out>...
        			</c:when>
       				<c:otherwise>
       					<c:out value="${list1.title}">
        				</c:out>
        			</c:otherwise>
				</c:choose>
			</a>
		</div>
	</c:forEach>
	<a href="index?page=/board/&section=B2-01&orderno=1">더보기</a>
</div>

<div class="listMain">
	<h5>조회순</h5><br>
	<c:forEach items="${List2}" var="list2" begin="0" end="2">
		<div>
			<a href="index?page=/board/detail&section=B2-01&bno=${list2.bno}">
				<img src="${list2.imgname}"/><br>
				<c:choose>
       				<c:when test="${fn:length(list2.title) gt 15}">
       					<c:out value="${fn:substring(list2.title, 0, 14)}">
        				</c:out>...
        			</c:when>
       				<c:otherwise>
       					<c:out value="${list2.title}">
        				</c:out>
        			</c:otherwise>
				</c:choose>
			</a>
		</div>
	</c:forEach>
	<a href="index?page=/board/&section=B2-01&orderno=2">더보기</a>
</div>
<div class="listMain">
	<h5>좋아요순</h5><br>
	<c:forEach items="${List3}" var="list3" begin="0" end="2">
		<div>
			<a href="index?page=/board/detail&section=B2-01&bno=${list3.bno}">
				<img src="${list3.imgname}"/><br>
				<c:choose>
       				<c:when test="${fn:length(list3.title) gt 15}">
       					<c:out value="${fn:substring(list3.title, 0, 14)}">
        				</c:out>...
        			</c:when>
       				<c:otherwise>
       					<c:out value="${list3.title}">
        				</c:out>
        			</c:otherwise>
				</c:choose>
			</a>
		</div>
	</c:forEach>
	<a href="index?page=/board/&section=B2-01&orderno=3">더보기</a>
</div>