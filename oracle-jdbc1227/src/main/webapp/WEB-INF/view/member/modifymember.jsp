<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/member/modifyMember" method="post" id="pageForm">
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="memberName" value="${loginMember.memberName}" id="name">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="memberPw" id="pw1">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pwCheck" id="pw2">
					</td>
				</tr>
			</table>
			<button type="button" id="updateBtn">수정</button>
		</form>
		<script>
			$(document).ready(function() {
				// 내용을 입력하지 않으면
				$('#updateBtn').click(function() {
					if($('#name').val() == '' 
						|| $('#pw1').val() == ''
						|| $('#pw2').val() == '') {
						alert('정보를 모두 입력해주세요');
						return;
					}
					
					// 비밀번호 확인 유호성 검사
					if($('#pw1').val() != $('#pw2').val()) {
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