<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/LoginActionCotroller">
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
		<a href="${pageContext.request.contextPath}/InsertMemberFormController">회원가입</a>
	</body>
</html>