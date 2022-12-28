<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${loginMember == null}">
			<form method="post" action="${pageContext.request.contextPath}/member/login">
				<table>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id">
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="pw">
						</td>
					</tr>
				</table>
				<button type="submit">로그인</button>
			</form>
			<a href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
		</c:if>
		<c:if test="${loginMember != null}">
			<span>${loginMember.memberName}님, 반값습니다</span>
			<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
			<br>
			<div>
				<div>아이디 : ${loginMember.memberId}</div>
				<div>이름 : ${loginMember.memberName}</div>
				<div>
					<a href="${pageContext.request.contextPath}/member/memberOne">내정보</a>
				</div>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/board/boardList">리스트</a>
				<table border="1">
					<tr>
						<th>boardNo</th>
						<th>boardTitle</th>
						<th>createdate</th>
					</tr>
					<c:forEach var="b" items="${boardList}">
						<tr>
							<td>${b.boardNo}</td>
							<td><a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
							<td>${b.createdate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</body>
</html>