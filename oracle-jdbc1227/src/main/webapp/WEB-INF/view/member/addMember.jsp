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
		<body class="g-sidenav-show bg-gray-100">
		<main class="main-content  mt-0">
			<section>
				<div class="page-header min-vh-75">
					<div class="container">
						<div class="row">
							<div class="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
								<div class="card card-plain mt-8">
									<div class="card-header pb-0 text-left bg-transparent">
										<h3 class="font-weight-bolder text-info text-gradient">Welcome!</h3>
									</div>
									<div class="card-body">
										<form method="post" action="${pageContext.request.contextPath}/member/addMember" id="pageForm">
											<label>ID</label>
											<div class="mb-3">
												<input type="text" name="memberId" id="id" class="form-control">
											</div>
											<label>Name</label>
											<div class="mb-3">
												<input type="text" name="memberName" id="name" class="form-control">
											</div>
											<label>Password</label>
											<div class="mb-3">
												<input type="password" name="memberPw" id="pw" class="form-control">
											</div>
											<div>
												<label id="msg"></label>
											</div>
											<div class="text-center">
												<button type="button" class="btn bg-gradient-info w-100 mt-4 mb-0" id="addBtn">Sign up</button>
											</div>
										</form>
									</div>
									<div class="card-footer text-center pt-0 px-lg-2 px-1">
										<p class="mb-4 text-sm mx-auto">
											<a href="${pageContext.request.contextPath}/home" class="text-info text-gradient font-weight-bold">Sign in</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</main>
		<footer class="footer py-5">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 mx-auto text-center mb-4 mt-2">
						<a href="javascript:;" target="_blank" class="text-secondary me-xl-4 me-4"> <span class="text-lg fab fa-dribbble"></span>
						</a> <a href="javascript:;" target="_blank" class="text-secondary me-xl-4 me-4"> <span class="text-lg fab fa-github"></span>
						</a>
					</div>
				</div>
				<div class="row">
					<div class="col-8 mx-auto text-center mt-1">
						<p class="mb-0 text-secondary">
							Copyright ©
							<script>
								document.write(new Date().getFullYear())
							</script>
							Soft by Creative Tim.
						</p>
					</div>
				</div>
			</div>
		</footer>
		<script>
		$(document).ready(function() {
			$('#id').blur(function() {
				if($('#id').val() < 6) {
					alert('아이디는 5글자이상 입력해야합니다')
					return;
				}
			});
			
			$('#name').blur(function() {
				if($('#name').val() < 3) {
					alert('이름은 2글자이상 입력해야합니다')
					return;
				}
			});
			
			$('#pw').blur(function() {
				if($('#pw').val() < 5) {
					alert('비밀번호는 4글자이상 입력해야합니다')
					return;
				}
			});
			
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