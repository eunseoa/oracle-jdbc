<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
				})
			});
		</script>
	</head>
	<body>
		<span>${loginMember.memberId}(${loginMember.memberName})님, 반값습니다</span>
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		<h1>BOARD LIST</h1>
		<a href="${pageContext.request.contextPath}/home">홈</a>
		<form id="pageForm" method="get" action="${pageContext.request.contextPath}/board/boardList">
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="text" name="searchTitle" value="${searchTitle}">
			<button type="submit">검색</button>
			<select name="rowPerPage" id="rowPerPage">
				<c:if test="${rowPerPage == 10 }">
					<option value="10" selected="selected">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage == 20 }">
					<option value="10">10</option>
					<option value="20" selected="selected">20</option>
					<option value="30">30</option>
				</c:if>
				<c:if test="${rowPerPage == 30 }">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30" selected="selected">30</option>
				</c:if>
			</select>
		</form>
		<a href="${pageContext.request.contextPath}/board/addBoard">추가</a>
		<table border="1">
			<tr>
				<th>boardNo</th>
				<th>boardTitle</th>
				<th>memberId</th>
				<th>createdate</th>
			</tr>
			<c:forEach var="b" items="${boardList}">
				<tr>
					<td>${b.boardNo}</td>
					<td><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
					<td>${b.memberId}</td>
					<td>${b.createdate}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1&searchTitle=${searchTitle}">처음</a>
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}&searchTitle=${searchTitle}">이전</a>
			</c:if>
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}&searchTitle=${searchTitle}">다음</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}&searchTitle=${searchTitle}">마지막</a>
		</div>
	</body>
</html>