<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="resources/css/admin/userList.css">
<script src="resources/js/admin/userList.js"></script>


<c:forEach items="${list}" var="user" varStatus="status">
	<c:if test="${user.qualify le 1}">
		<div class="user_list">
			<h5>${status.count}</h5> &nbsp 
			<img src="${user.profileImg}"> &nbsp 
			<div>${user.userid }</div> &nbsp 
			<div>${user.username }</div> &nbsp 
			<div>${user.nickname }</div> &nbsp 
			<div class="user_btnAll">
				<c:choose>
					<c:when	test="${user.qualify eq 0}">
						<input class="user_grant" type="button" value="쉐프 임명" onclick="user_grant('${user.userid}','${user.nickname }','${user.profileImg }')">&nbsp<input class="user_delete" type="button" value="탈퇴" onclick="user_delete('${user.userid}')">
					</c:when>
					<c:when	test="${user.qualify eq 1}">
						<input class="user_revoke" type="button" value="쉐프 삭제" onclick="user_revoke('${user.userid}')">&nbsp<input class="user_delete" type="button" value="탈퇴" onclick="user_delete('${user.userid}')">
					</c:when>				
				</c:choose>
			</div>
		</div>
		<hr>
	</c:if>
</c:forEach>