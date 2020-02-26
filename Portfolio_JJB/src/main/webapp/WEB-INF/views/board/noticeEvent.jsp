<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<link rel="stylesheet" href="resources/css/board/notice/noticeEvent.css">
<script src="resources/js/notice/notice.js"></script>

<div class="row">
	<div class="left col-sm-9">
		<c:forEach items="${list}" var="board">
			<div class="row_event">
				<div class="img_event">
					<a><img src="${board.imgname }"></a>
				</div>
				<div class="content_event"><a href="index?page=/board/detail&bno=${board.bno }&section=${board.section}"> <h3>${board.title }</h3> </a><br>
				<div>${board.udate }</div></div><br>
			</div>

				<hr><br>
		</c:forEach>
				<ul class="pagination" style="display: inline-block">
					<div class="row">
						<c:if test="${Page.prev}">
							<li class="page-item"><a class="page-link"
								href="index?pageNum=${Page.startPage-1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${Page.startPage}"
							end="${Page.endPage}">
							<li class="page-item"><a class="page-link"
								href="index?pageNum=${num}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">${num}</a></li>
						</c:forEach>

						<c:if test="${Page.next}">
							<li class="page-item"><a class="page-link"
								href="index?pageNum=${Page.endPage+1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Next</a></li>
						</c:if>
					</div>
				</ul>
			</div>

	<div style="float: right; width: 24%">
			<ul class="list-group notice_right">
				<li class="list-group-item"><a href="index?page=/board/notice">공지사항</a></li>
				<li class="list-group-item"><a class="dropdown-toggle" style="cursor:pointer" onclick="openLeft()">이벤트</a></li>
				<li class="list-group-item left_menu"><a href="index?page=/board/&section=B4-02">진행중인 이벤트</a></li>
				<li class="list-group-item left_menu"><a href="index?page=/board/&section=B4-03">종료된 이벤트</a></li>
				<li class="list-group-item left_menu"><a href="index?page=/board/&section=B4-04">이벤트 발표</a></li>
			</ul>
		</div>
	</div>
