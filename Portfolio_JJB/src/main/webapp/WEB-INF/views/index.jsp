<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>포트폴리오(미제)</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/main.css">
<script src="resources/plugin/jquery.min.js"></script>
<script src="resources/plugin/popper.js"></script>
<script src="resources/plugin/bootstrap.min.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${msg eq '1-1' }">
			<script type="text/javascript">
				alert("로그인에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/user/login";
			</script>
		</c:when>
		<c:when test="${msg eq '1-2' }">
			<script type="text/javascript">
				alert("로그인에 성공하셨습니다.")
				location.href = "index?page=/main";
			</script>
		</c:when>
		<c:when test="${msg eq '4-1' }">
			<script type="text/javascript">
				alert("글작성에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B4-01";
			</script>
		</c:when>
		<c:when test="${msg eq '4-2' }">
			<script type="text/javascript">
				alert("글작성에 성공하였습니다.")
				location.href = "index?page=/board/&section=B4-01";
			</script>
		</c:when>
		<c:when test="${msg eq '4-3' }">
			<script type="text/javascript">
				alert("글수정에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B4-01";
			</script>
		</c:when>
		<c:when test="${msg eq '4-4' }">
			<script type="text/javascript">
				alert("글수정에 성공하였습니다.")
				location.href = "index?page=/board/&section=B4-01";
			</script>
		</c:when>
		<c:when test="${msg eq '4-21' }">
			<script type="text/javascript">
				alert("글작성에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B4-02";
			</script>
		</c:when>
		<c:when test="${msg eq '4-22' }">
			<script type="text/javascript">
				alert("글작성에 성공하였습니다.")
				location.href = "index?page=/board/&section=B4-02";
			</script>
		</c:when>
		<c:when test="${msg eq '4-23' }">
			<script type="text/javascript">
				alert("글수정에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B4-02";
			</script>
		</c:when>
		<c:when test="${msg eq '4-24' }">
			<script type="text/javascript">
				alert("글수정에 성공하였습니다.")
				location.href = "index?page=/board/&section=B4-02";
			</script>
		</c:when>
		<c:when test="${msg eq '6-1' }">
			<script type="text/javascript">
				alert("글작성에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B6-01";
			</script>
		</c:when>
		<c:when test="${msg eq '6-2' }">
			<script type="text/javascript">
				alert("글작성에 성공하였습니다.")
				location.href = "index?page=/board/&section=B6-01";
			</script>
		</c:when>
		<c:when test="${msg eq '6-3' }">
			<script type="text/javascript">
				alert("글수정에 실패하였습니다. 다시한번 시도해주세요.")
				location.href = "index?page=/board/&section=B6-01";
			</script>
		</c:when>
		<c:when test="${msg eq '6-4' }">
			<script type="text/javascript">
				alert("글수정에 성공하였습니다.")
				location.href = "index?page=/board/&section=B6-01";
			</script>
		</c:when>
	</c:choose>
	<!-- 헤더 -->
	<div id="header">
		<div class="myHeader">
			<nav class="navbar navbar-expand-sm" style="float: right; padding-bottom:0">
				<ul class="navbar-nav mainNav">
					<c:choose>
						<c:when test="${sessionScope.userid == null }">
							<li class="nav-item"><a class="nav-link"
								href="index?page=/user/login">로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="index?page=/user/signUp">회원가입</a></li>
						</c:when>
						<c:when test="${sessionScope.userid != null }">
							<span style="line-height:2.3">${sessionScope.nickname}님 환영합니다.</span>
							<c:if test="${sessionScope.qualify ge 2}">
								<li class="nav-item">
								<a class="nav-link" href="index?page=/user/listUser">유저 관리</a></li>
							</c:if>
							<li class="nav-item"><a class="nav-link" href="user/logOut">로그아웃</a></li>
							<li class="nav-item"><a class="nav-link"
								href="index?page=/user/manage">정보</a></li>
						</c:when>
					</c:choose>
				</ul>
			</nav>
			<div id="myHeader_Mid">
				<a href="index"><img src="resources/image/pagelogo.png"
					class="imgLogo"></a>
				<form class="group_Header_search" method="get">
					<input type="hidden" name="page" value="/board/"> <input
						type="hidden" name="section" value="B2-01"> <input
						class="form-control header_search" type="search"
						placeholder="내용을 입력하세요." aria-label="Search" name="keyword">
					<input class="btn btn-outline-secondary" type="submit" value="검색">
				</form>
				<div class="header_searchAtag">
					<c:forEach items="${list}" var="list" begin="0" end="4">
						<a href="index?page=/board/&section=B2-01&keyword=${list}">
							${list} </a>&nbsp
					</c:forEach>
				</div>
			</div>


		</div>

	</div>
	<div id="header_menuBar">
		<ul>
			<li><a href="index?page=/main">메인</a></li>
			<li><a href="index?page=/board/&section=B2-01">레시피</a></li>
			<li><a href="index?page=/board/&section=B3-01">토크</a></li>
			<li><a href="index?page=/board/&section=B4-01">공지사항</a></li>
			<li><a href="index?page=/chef/chef">셰프</a></li>
			<li><a href="index?page=/board/&section=B6-01">고객센터</a></li>
		</ul>
	</div>


	<!-- 헤더 끝 -->
	<!-- c:import url을 controller에서 들고와서 바로 넣으면 테이블의 값을 못들고옴  -->
	<div id="body_bkground">
		<div id="body">
			<c:import
				url="${cri.getPage()}?cri=${cri }&board=${board }&msg=${msg}">
			</c:import>

		</div>
	</div>
	<!-- 바디 -->


	<!-- 바디 끝  -->

	<!-- 푸터 -->
	<footer id="footer">
		<div>CopyRight &copy; 2020 정종범 All Rights Reserved.</div>
	</footer>
</body>
</html>