<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/member/modifyMemberPw" method="post">
			<table>
				<tr>
					<td>변결할 비밀번호</td>
					<td>
						<input type="text" name="changePw">
					</td>
				</tr>
				<tr>
					<td>현재 비밀번호</td>
					<td>
						<input type="text" name="defaultPw">
					</td>
				</tr>
				<tr>
					<td>현재 비밀번호 확인</td>
					<td>
						<input type="text" id="checkPw">
						<!-- 자바스크립트 유효성 검사용 -->
					</td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
	</body>
</html>