<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/member/modifyMemberPw" method="post" id="pageForm">
			<table border="1">
				<tr>
					<td>변결할 비밀번호</td>
					<td>
						<input type="text" name="changePw" id="changePw">
					</td>
				</tr>
				<tr>
					<td>현재 비밀번호</td>
					<td>
						<input type="text" name="defaultPw" id="defaultPw">
					</td>
				</tr>
				<tr>
					<td>현재 비밀번호 확인</td>
					<td>
						<input type="text" id="checkPw" id="checkPw">
						<span>${msg}</span>
						<!-- 자바스크립트 유효성 검사용 -->
					</td>
				</tr>
			</table>
			<button type="button" id="updateBtn">수정</button>
		</form>
		<script>
			$(document).ready(function() {
				// 정보를 입력하지 않으면
				$('#updateBtn').click(function() {
					if($('#changePw').val() == ''
						|| $('#defaultPw').val() == ''
						|| $('#checkPw').val() == '') {
						alert('내용을 모두 입력해주세요');
						return;
					}
					
					// 비밀번호 확인 유호성 검사
					if($('#defaultPw').val() != $('#checkPw').val()) {
						alert('비밀번호를 확인해주세요');
						return;
					}
					
					// 유효성 검사 통과하면
					$('#pageForm').submit();
				})
			});
		</script>
	</body>
</html>