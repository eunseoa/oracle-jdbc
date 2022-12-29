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
			td {
				height: 60px;
			}
			
			th:nth-child(1) {
				width: 40px;
			}
			
			th:nth-child(2) {
				width: 150px;
			}
			
			th:nth-child(3) {
				width: 70px;
			}
			
			th:nth-child(4) {
				width: 70px;
			}
		</style>
		<script>
			$(document).ready(function() {
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
				})
			});
		</script>
	</head>
	<body class="g-sidenav-show  bg-gray-100">
		<jsp:include page="../../../navbar.jsp"></jsp:include>
		<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
			<div class="container-fluid py-4">
				<div class="row">
					<div class="col-12">
						<div class="card mb-4">
							<div class="card-header pb-0">
								<div>
									<form method="get" action="${pageContext.request.contextPath}/board/boardList" id="pageForm">
										<table style="width: 100%">
											<tr>
												<td>
													<select name="rowPerPage" id="rowPerPage" class="form-select" style="width: 300px;">
														<c:if test="${rowPerPage == 10 }">
															<option value="10" selected="selected">10</option>
															<option value="20">20</option>
															<option value="30">30</option>
														</c:if>
														<c:if test="${rowPerPage == 20 }">
															<option value="10">10</option>
															<option value="20" selected="selected">20</option>
															<option value="30">30</option>
														</c:if>
														<c:if test="${rowPerPage == 30 }">
															<option value="10">10</option>
															<option value="20">20</option>
															<option value="30" selected="selected">30</option>
														</c:if>
													</select>
												</td>
												<td>
													<div class="bg-white border-radius-lg d-flex me-2">
														<input type="text" name="searchTitle" value="${searchTitle}" class="form-control border-0 ps-3" placeholder="Search">
														<button type="submit" class="btn bg-gradient-primary my-1 me-1">Search</button>
													</div>
												</td>
												<td>
													<a href="${pageContext.request.contextPath}/board/addBoard" class="btn btn-outline-primary my-1 me-1">글 추가</a>
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
							<div class="card-body px-0 pt-0 pb-2">
								<div class="table-responsive p-0">
									<table class="table align-items-center mb-0 text-center">
										<thead>
											<tr>
												<th class="text-uppercase text-secondary text-xs font-weight-bolder text-center">no</th>
												<th class="text-uppercase text-secondary text-xs font-weight-bolder text-center">Title</th>
												<th class="text-uppercase text-secondary text-xs font-weight-bolder text-center">Id</th>
												<th class="text-uppercase text-secondary text-xs font-weight-bolder text-center">date</th>
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
																<h6 class="mb-0 text-sms">
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
									<div>
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=1&searchTitle=${searchTitle}">처음</a>
										<c:if test="${currentPage > 1}">
											<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage-1}&searchTitle=${searchTitle}">이전</a>
										</c:if>
										<c:if test="${currentPage < lastPage}">
											<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${currentPage+1}&searchTitle=${searchTitle}">다음</a>
										</c:if>
										<a href="${pageContext.request.contextPath}/board/boardList?rowPerPage=${rowPerPage}&currentPage=${lastPage}&searchTitle=${searchTitle}">마지막</a>
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