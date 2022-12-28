<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<c:if test="${loginMember == null}">
			<form method="post" action="${pageContext.request.contextPath}/member/login">
				<table>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id" id="id">
							<span id="idMsg"></span>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<input type="password" name="pw" id="pw">
							<span id="pwMsg"></span>
						</td>
					</tr>
				</table>
				<button type="submit" id="loginBtn">로그인</button>
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
		<script>
			// body 태그를 다 읽고 
			$(document).ready(function() {
				
				// 아이디 유효성 검사
				$('#id').blur(function() {
					if($('#id').val() == '') {
						$('#idMsg').text('아이디를 입력해주세요');
						$('#id').focus();
					} else {
						$('#idMsg').text('');
						$('#pw').focus();
					}
				});

				$('#pw').blur(function() {
					if($('#pw').val() == '') {
						$('#pwMsg').text('비밀번호를 입력해주세요');
						$('#pw').focus();
					} else {
						$('#pwMsg').text('');
						$('#pw').focus();
					}
				});
				
				// 페이지 로딩되자마자 버튼을 누름 방지
				$('#loginBtn').click(function() {
					if($('#id').val() == '' || $('#pw').val() == '') {
						alert('내용을 입력해주세요');
						return;
					}
				})
			})
		</script>
	</body>
</html>