<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/member/modifyMember" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="memberName" value="${loginMember.memberName}">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="memberPw">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pwCheck">
					</td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
	</body>
</html>