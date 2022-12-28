<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/board/addBoard">
			<table>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" id="title">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="7" cols="50" name="content" id="content"></textarea>
					</td>
				</tr>
			</table>
			<button type="submit" id="addBtn">등록</button>
		</form>
	</body>
	<script>
		$(document).ready(function() {
			// 내용을 입력하지 않으면
			$('#addBtn').click(function() {
				if($('#title').val() == '' || $('#content').val() == '') {
					alert('내용을 입력해주세요');
					$('#title').focus();
					return;
				}
			})
		});
	</script>
</html>