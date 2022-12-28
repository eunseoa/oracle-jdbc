<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/board/addBoard">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="7" cols="50"></textarea>
					</td>
				</tr>
			</table>
			<button type="submit">등록</button>
		</form>
	</body>
</html>