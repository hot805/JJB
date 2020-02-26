<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- jstl -->
<link rel="stylesheet" href="resources/css/board/help/help.css">
<script src="resources/js/help/help.js"></script>

<c:if test="${empty sessionScope.userid}">
	<script type="text/javascript">
		alert("로그인을 해주세요.")
		location.href="index"
	</script>
</c:if>

<div class="row">
		<div class="left col-sm-12">
			<table class="table table-bordered" id="help_table">
				<thead>
					<tr>
						<th width="25.5%">제목</th>
						<th width="40.5%">내용</th>
						<th width="9.5%">닉네임</th>
						<th width="15%">작성(수정)일자</th>
						<th width="9.5%">답변</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board" varStatus="status">
						<tr>
							<td>${board.title }</td>
							<td>${board.content }</td>
							<td>${board.nickname}</td>
							<td>${board.regdate}</td>
							<td><a class="ckAnswer" style="cursor:pointer" onclick="displayAnswer(${board.bno})">
								<c:choose>
									<c:when test=" ${empty board.answer}">
										답변 없음
									</c:when>
									<c:otherwise>
										답변 보기
									</c:otherwise>
								</c:choose>
							</a></td>
						</tr>
						<tr class="help_answerRow help_bno${board.bno }">
							<td colspan="5">
								<h6>└ 답변 : </h6><div class="help_answer">${board.answer }</div>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" style="text-align: center">

							
								<center>
									<c:if test="${Page.prev}">
										<a href="index?pageNum=${Page.startPage-1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Previous</a></li>
									</c:if>

									<c:forEach var="num" begin="${Page.startPage}"
										end="${Page.endPage}">
										<a href="index?pageNum=${num}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">${num}</a></li>
									</c:forEach>

									<c:if test="${Page.next}">
										<a href="index?pageNum=${Page.endPage+1}&check=true&page=/board/&amount=${Page.cri.amount}&keyword=${Page.cri.keyword}&section=${board.section}">Next</a></li>
									</c:if>
								</center>
							

						</td>
					</tr>
				</tbody>
			</table>
		</div>
</div>