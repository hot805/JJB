<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->

<link rel="stylesheet" href="resources/css/board/chef/chef.css">

<ul class="nav nav-tabs">
	<li class="nav-item"><a class="nav-link <c:if test="${activeItem eq 'a1' || empty activeItem }">active</c:if> " data-toggle="tab"
		href="#a1">등록순</a></li>
	<li class="nav-item"><a class="nav-link <c:if test="${activeItem eq 'a2' }">active</c:if> " data-toggle="tab"
		href="#a2">팔로우순</a></li>
	<li class="nav-item"><a class="nav-link <c:if test="${activeItem eq 'a3' }">active</c:if> " data-toggle="tab"
		href="#a3">게시글순</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane fade <c:if test="${activeItem eq 'a1' || empty activeItem }">show active</c:if> " id="a1">
		<c:forEach items="${orderdate }" var="chef" varStatus="status">
			<div class="chef_board">
				<h2>${status.count }</h2><img src="${chef.profileImg }" />
				<div class="chef_all">
					<div class="chef_nickname">${chef.nickname }</div>&nbsp(<div class="chef_userid">${chef.userid }</div>)<br>
					팔로우 : <div class="chef_followno">${chef.followno }</div>&nbsp 게시글 : <div class="chef_tableno">${chef.tableno }</div>&nbsp 쉐프날짜 : <div class="chef_regdate">${chef.regdate }</div>
				</div>
			</div>
			<hr>
		</c:forEach>
	

	<center>
		<c:if test="${Page.prev}">
			<a href="index?pageNum=${Page.startPage-1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a1">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a href="index?pageNum=${num}&check=true&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a1">${num}</a></li>
		</c:forEach>

		<c:if test="${Page.next}">
			<a href="index?pageNum=${Page.endPage+1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a1">Next</a></li>
		</c:if>
	</center>
	</div>
	<div class="tab-pane fade <c:if test="${activeItem eq 'a2' }">show active</c:if>" id="a2">
		<c:forEach items="${orderfollow }" var="chef" varStatus="status">
			<div class="chef_board">
				<h2>${status.count }</h2><img src="${chef.profileImg }" />
				<div class="chef_all">
					<div class="chef_nickname">${chef.nickname }</div>&nbsp(<div class="chef_userid">${chef.userid }</div>)<br>
					팔로우 : <div class="chef_followno">${chef.followno }</div>&nbsp 게시글 : <div class="chef_tableno">${chef.tableno }</div>&nbsp 쉐프날짜 : <div class="chef_regdate">${chef.regdate }</div>
				</div>
			</div>
			<hr>
		</c:forEach>


	<center>
		<c:if test="${Page.prev}">
			<a href="index?pageNum=${Page.startPage-1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a2">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a href="index?pageNum=${num}&check=true&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a2">${num}</a></li>
		</c:forEach>

		<c:if test="${Page.next}">
			<a href="index?pageNum=${Page.endPage+1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a2">Next</a></li>
		</c:if>

	</center>
	</div>

	<div class="tab-pane fade <c:if test="${activeItem eq 'a3' }">show active</c:if>" id="a3">
		<c:forEach items="${orderboard }" var="chef" varStatus="status">
			<div class="chef_board">
				<h2>${status.count }</h2><img src="${chef.profileImg }" />
				<div class="chef_all">
					<div class="chef_nickname">${chef.nickname }</div>&nbsp(<div class="chef_userid">${chef.userid }</div>)<br>
					팔로우 : <div class="chef_followno">${chef.followno }</div>&nbsp 게시글 : <div class="chef_tableno">${chef.tableno }</div>&nbsp 쉐프날짜 : <div class="chef_regdate">${chef.regdate }</div>
				</div>
			</div>
			<hr>
		</c:forEach>


	<center>
		<c:if test="${Page.prev}">
			<a href="index?pageNum=${Page.startPage-1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a3">Previous</a></li>
		</c:if>

		<c:forEach var="num" begin="${Page.startPage}" end="${Page.endPage}">
			<a href="index?pageNum=${num}&check=true&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a3">${num}</a></li>
		</c:forEach>

		<c:if test="${Page.next}">
			<a href="index?pageNum=${Page.endPage+1}&page=/chef/chef&bno=${board.bno }&section=B5-01&category=a3">Next</a></li>
		</c:if>

	</center>
</div>
</div>