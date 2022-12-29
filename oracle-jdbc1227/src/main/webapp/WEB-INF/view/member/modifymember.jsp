<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/favicon.png">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
		<script src="https://kit.fontawesome.com/42d5adcbca.js"></script>
		<link id="pagestyle" href="${pageContext.request.contextPath}/assets/css/soft-ui-dashboard.css?v=1.0.7" rel="stylesheet" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body class="g-sidenav-show  bg-gray-100">
	<jsp:include page="../../../navbar.jsp"></jsp:include>
		<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg">
			<div class="container-fluid py-4">
      			<div class="row justify-content-md-center">
        			<div class="col-8">
          				<div class="card h-100">
            				<div class="card-header pb-0 p-3">
            					<h6 class="mb-0">정보 수정하기</h6>
							</div>
							<div class="card-body p-3">
								<form action="${pageContext.request.contextPath}/member/modifyMember" method="post" id="pageForm">
									<table >
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
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
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