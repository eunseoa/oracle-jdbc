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
		<script src="../assets/js/core/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/soft-ui-dashboard.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	</head>
	<body class="g-sidenav-show  bg-gray-100">
	<jsp:include page="../../../navbar.jsp"></jsp:include>
		<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
			<div class="container-fluid">
				<div class="page-header min-height-300 border-radius-xl mt-4" style="background-image: url('../assets/img/curved-images/curved0.jpg'); background-position-y: 50%;">
					<span class="mask bg-gradient-primary opacity-6"></span>
				</div>
				<div class="card card-body blur shadow-blur mx-4 mt-n6 overflow-hidden">
					<div class="row gx-4">
						<div class="col-auto">
							<div class="avatar avatar-xl position-relative">
								<img src="../assets/img/bruce-mars.jpg" alt="profile_image" class="w-100 border-radius-lg shadow-sm">
							</div>
						</div>
						<div class="col-auto my-auto">
							<div class="h-100">
								<h5 class="mb-1">${loginMember.memberId}</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid py-4">
      			<div class="row">
        			<div class="col-12">
          				<div class="card h-100">
            				<div class="card-header pb-0 p-3">
            					<h6 class="mb-0">내 정보</h6>
							</div>
							<div class="card-body p-3">
								<table class="table">
									<tr>
										<td class="align-middle text-center text-sm">아이디</td>
										<td class="align-middle text-center text-sm text-bold">${loginMember.memberId}</td>
									</tr>
									<tr>
										<td class="align-middle text-center text-sm">이름</td>
										<td class="align-middle text-center text-sm text-bold">${loginMember.memberName}</td>
									</tr>
									<tr>
										<td class="align-middle text-center text-sm">가입 일자</td>
										<td class="align-middle text-center text-sm text-bold">${loginMember.createdate}</td>
									</tr>
								</table>
								<div>
	            					<a href="${pageContext.request.contextPath}/member/modifyMember" class="btn bg-gradient-primary">정보 수정</a>
									<a href="${pageContext.request.contextPath}/member/modifyMemberPw" class="btn bg-gradient-primary">비밀번호 수정</a>
									<div class="col-md-4">
										<button type="button" class="btn btn-outline-secondary mb-3" data-bs-toggle="modal" data-bs-target="#exampleModalMessage">회원탈퇴</button>
										<form action="${pageContext.request.contextPath}/member/removeMember" method="post" id="pageForm">
											<div class="modal fade" id="exampleModalMessage" tabindex="-1" role="dialog" aria-labelledby="exampleModalMessageTitle" aria-hidden="true">
												<div class="modal-dialog modal-dialog-centered" role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">탈퇴하시겠습니까?</h5>
															<button type="button" class="btn-close text-dark" data-bs-dismiss="modal" aria-label="Close">
																<span aria-hidden="true">×</span>
															</button>
														</div>
														<div class="modal-body">
															<div class="form-group">
																<label for="recipient-name" class="col-form-label">비밀번호</label> 
																<input type="password" name="memberPw" id="memberPw" class="form-control">
																<label for="recipient-name" class="col-form-label">비밀번호 확인</label> 
																<input type="password" class="form-control" id="pw2">
															</div>
														</div>
														<div class="modal-footer">
															<button type="submit" class="btn bg-gradient-secondary" data-bs-dismiss="modal" aria-label="Close">탈퇴</button>
															<button type="submit" class="btn bg-gradient-primary">취소</button>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>