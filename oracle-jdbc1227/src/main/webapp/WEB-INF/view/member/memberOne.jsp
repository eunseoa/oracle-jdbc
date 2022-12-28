<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<div>아이디 : ${loginMember.memberId}</div>
			<div>이름 : ${loginMember.memberName}</div>
			<div>가입일자 : ${loginMember.createdate}</div>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/member/modifyMember">정보 수정</a>
			<a href="${pageContext.request.contextPath}/member/removeMember">회원 탈퇴</a>
			<!-- 자바스립트로 동적처리 -->
		</div>
	</body>
</html>