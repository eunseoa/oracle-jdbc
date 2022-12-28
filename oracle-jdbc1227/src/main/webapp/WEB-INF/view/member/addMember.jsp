<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/member/addMember" id="pageForm">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="memberId" id="id">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="memberName" id="name">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="memberPw" id="pw">
					</td>
				</tr>
			</table>
			<button type="button" id="addBtn">회원가입</button>
		</form>
		<script>
		$(document).ready(function() {
			// 내용을 입력하지 않으면
			$('#addBtn').click(function() {
				if($('#id').val() == '' 
					|| $('#name').val() == ''
					|| $('#pw').val() == '') {
					alert('정보를 모두 입력해주세요');
					return;
				}
				
				// 유효성 검사 통과하면
				$('#pageForm').submit();
			})
		});
		</script>
	</body>
</html>