<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/board/modifyBoard">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="hidden" name="boardNo" value="${boardOne.boardNo}">
						<input type="text" name="boardTitle" value="${boardOne.boardTitle}">
					</td>
				</tr>
				<tr>
					<td>일자</td>
					<td>
						<input type="text" readonly="readonly" value="${boardOne.updatedate}">
						<input type="text" readonly="readonly" value="${boardOne.createdate}">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="memberId" readonly="readonly" value="${boardOne.memberId}">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="7" cols="50" name="boardContent">${boardOne.boardContent}</textarea>
					</td>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>
		<script>
			$(document).ready(function() {
				
			})
		</script>
	</body>
</html>