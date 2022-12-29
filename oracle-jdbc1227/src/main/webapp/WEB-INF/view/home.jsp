<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<c:if test="${loginMember == null}">
		<main class="main-content  mt-0">
			<section>
				<div class="page-header min-vh-75">
					<div class="container">
						<div class="row">
							<div class="col-xl-4 col-lg-5 col-md-6 d-flex flex-column mx-auto">
								<div class="card card-plain mt-8">
									<div class="card-header pb-0 text-left bg-transparent">
										<h3 class="font-weight-bolder text-info text-gradient">Welcome back</h3>
										<p class="mb-0">Enter your email and password to sign in</p>
									</div>
									<div class="card-body">
										<form method="post" action="${pageContext.request.contextPath}/member/login">
											<label>ID</label>
											<div class="mb-3">
												<input type="text" name="id" id="id" class="form-control" placeholder="ID">
											</div>
											<label>Password</label>
											<div class="mb-3">
												<input type="password"  name="pw" id="pw" class="form-control" placeholder="Password">
											</div>
											<div>
												<label id="msg"></label>
											</div>
											<div class="text-center">
												<button type="submit" class="btn bg-gradient-info w-100 mt-4 mb-0" id="loginBtn">Sign in</button>
											</div>
										</form>
									</div>
									<div class="card-footer text-center pt-0 px-lg-2 px-1">
										<p class="mb-4 text-sm mx-auto">
											Don't have an account? <a href="${pageContext.request.contextPath}/member/addMember" class="text-info text-gradient font-weight-bold">Sign up</a>
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
		</c:if>
		<c:if test="${loginMember != null}">
			<jsp:include page="../../navbar.jsp"></jsp:include>
			<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
				<div class="container-fluid py-4">
					<div class="row">
						<div class="col-lg-8 col-md-6 mb-md-0 mb-4">
							<div class="card">
								<div class="card-header pb-0">
									<div class="row">
										<div class="col-lg-6 col-7">
											<p class="mb-0">
												<i class="fa fa-check text-info" aria-hidden="true"></i> <span class="font-weight-bold ms-1">최근 게시판</span>
											</p>
										</div>
									</div>
								</div>
								<div class="card-body px-0 pb-2">
									<div class="table-responsive">
										<table class="table align-items-center mb-0">
											<thead>
												<tr>
													<th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Author</th>
													<th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Function</th>
													<th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="b" items="${boardList}">
													<tr>
														<td>
															<p class="text-xs font-weight-bold mb-0">${b.boardNo}</p>
														</td>
														<td>
															<div class="d-flex px-2 py-1">
																<div class="d-flex flex-column justify-content-center">
																	<h6 class="mb-0 text-sm">
																		<a href="${pageContext.request.contextPath}/board/boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a>
																	</h6>
																</div>
															</div>
														</td>
														<td class="align-middle text-center text-sm"><span>${b.memberId}</span></td>
														<td class="align-middle text-center"><span class="text-secondary text-xs font-weight-bold">${b.createdate}</span></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="card h-100">
								<div class="card-header pb-0">
									<h6>Orders overview</h6>
									<p class="text-sm">
										<i class="fa fa-arrow-up text-success" aria-hidden="true"></i> <span class="font-weight-bold">24%</span> this month
									</p>
									<div>아이디 : ${loginMember.memberId}</div>
										<div>이름 : ${loginMember.memberName}</div>
										<div>
											<a href="${pageContext.request.contextPath}/member/memberOne">내정보</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<footer class="footer pt-3">
					<div class="container-fluid">
						<div class="row align-items-center justify-content-lg-between">
							<div class="col-lg-6 mb-lg-0 mb-4">
								<div class="copyright text-center text-sm text-muted text-lg-start">
									©
									<script>
										document.write(new Date().getFullYear())
									</script>
									, made with <i class="fa fa-heart"></i> by <a href="https://www.creative-tim.com" class="font-weight-bold" target="_blank">Creative Tim</a> for a better web.
								</div>
							</div>
							<div class="col-lg-6">
								<ul class="nav nav-footer justify-content-center justify-content-lg-end">
									<li class="nav-item"><a href="https://www.creative-tim.com" class="nav-link text-muted" target="_blank">Creative Tim</a></li>
									<li class="nav-item"><a href="https://www.creative-tim.com/presentation" class="nav-link text-muted" target="_blank">About Us</a></li>
								</ul>
							</div>
						</div>
					</div>
				</footer>
			</main>
		</c:if>
		<script>
			// body 태그를 다 읽고 
			$(document).ready(function() {
				
				// 아이디 유효성 검사
				$('#id').blur(function() {
					if($('#id').val() == '') {
						$('#msg').text('아이디를 입력해주세요');
						$('#id').focus();
					} else {
						$('#msg').text('');
						$('#pw').focus();
					}
				});

				$('#pw').blur(function() {
					if($('#pw').val() == '') {
						$('#msg').text('비밀번호를 입력해주세요');
						$('#pw').focus();
					} else {
						$('#msg').text('');
						$('#pw').focus();
					}
				});
				
				// 페이지 로딩되자마자 버튼을 누름 방지
				$('#loginBtn').click(function() {
					if($('#id').val() == '' || $('#pw').val() == '') {
						alert('내용을 입력해주세요');
						return;
					}
				})
			})
		</script>
	</body>
</html>