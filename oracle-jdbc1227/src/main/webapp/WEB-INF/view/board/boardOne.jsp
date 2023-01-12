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
		<style>
			table {
				border-collapse: separate;
				border-spacing: 0 1rem;
			}
			
			td {
				width: 100px;
				white-space: pre;
				word-wrap: break-word;
				word-break: break-all;
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
								<h6 class="mb-0">게시글</h6>
							</div>
							<div class="card-body pt-4 p-3">
								<ul class="list-group">
									<li class="list-group-item border-0 p-4 mb-2 bg-gray-100 border-radius-lg">
										<table class="table">
											<tr>
												<td><span class="text-bold text-lg">${boardOne.boardTitle}</span></td>
											</tr>
											<tr>
												<td>
													${boardOne.memberId} | 
													<span class="text-sm">${boardOne.updatedate} . ${boardOne.createdate}</span>
												</td>
											</tr>
											<tr>
												<td style="height: 400px;"><span>${boardOne.boardContent}</span></td>
											</tr>
										</table>
										<div style="float: right;">
											<c:if test="${boardOne.memberId == loginMemberId}">
												<a href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${boardOne.boardNo}" class="btn btn-outline-primary">수정</a>
												<a href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${boardOne.boardNo}" class="btn btn-outline-dark">삭제</a>
											</c:if>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
	</body>
</html>