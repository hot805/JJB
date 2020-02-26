<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<link rel="stylesheet" href="resources/css/board/notice/notice.css">
<script src="resources/js/notice/notice.js"></script>


	<div class="row">
		<div class="left col-sm-9">
			<table class="table table-bordered" id="dataTable">
				<thead>
					<tr>
						<th width="9.5%">글번호</th>
						<th width="40.5%">제목</th>
						<th width="13.5%">글쓴이</th>
						<th width="27%">작성일자</th>
						<th width="9.5%">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.bno}</td>
							<td><a href="index?page=/board/detail&bno=${board.bno }&section=B4-01">${board.title}</a></td>
							<td>${board.nickname}</td>
							<td>${board.regdate}</td>
							<td>${board.cnt}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: center">

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

						</td>
					</tr>
				</tbody>
			</table>
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

