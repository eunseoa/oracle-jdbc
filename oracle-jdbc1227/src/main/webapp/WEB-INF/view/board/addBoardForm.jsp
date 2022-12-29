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
		<style>
			input {
				height: 60px;
			}
		
			#content {
			 	height: 380px;
				resize: none;
			}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body class="g-sidenav-show bg-gray-100">
		<jsp:include page="../../../navbar.jsp"></jsp:include>
		<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
			<div class="container-fluid py-4">
				<div class="row">
					<div class="col-12">
						<div class="card mb-4">
							<div class="card-header pb-0 px-3">
								<h6 class="mb-0">Billing Information</h6>
							</div>
							<div class="card-body pt-4 p-3">
								<ul class="list-group">
									<li class="list-group-item border-0 p-4 mb-2 bg-gray-100 border-radius-lg">
										<form method="post" action="${pageContext.request.contextPath}/board/addBoard" id="pageForm">
											<div class="row mb-3">
												<label for="inputText" class="col-sm-2 col-form-label">제목</label>
												<input type="text" name="title" id="title" class="form-control">
											</div>
											<div class="row mb-3">
												<label for="inputPassword" class="col-sm-2 col-form-label">내용</label>
												<textarea name="content" id="content" class="form-control"></textarea>
											</div>
											<br>
											<div class="row mb-3">
												<button type="button" class="btn btn-primary btn-lg bg-gradient" id="addBtn">등록</button>
											</div>
										</form>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<script>
			$(document).ready(function() {
				let check = false;
				// 내용을 입력하지 않으면
				$('#addBtn').click(function() {
					if($('#title').val() == '') {
						alert('제목을 입력해주세요');
						return;
					} 
					if($('#content').val() == '') {
						alert('내용을 입력해주세요');
					} else {
						check = true;
					}
					
					if(check == true) {
						$('#pageForm').submit();
					}
				})
			});
		</script>
	</body>
</html>