<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="${pageContext.request.contextPath}/favicon.png" rel="icon">
		<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<style>
			input, textarea {
				width: 1000px;
				border: none;
			}
			
			#textarea {
				height: 500px;
				resize: none;
			}
			
			input:focus, textarea:focus {
				outline: none;
			}
		</style>
	</head>
	<body class="g-sidenav-show bg-gray-100">
		<jsp:include page="../../../navbar.jsp"></jsp:include>
		<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
			<div class="container-fluid py-4">
				<div class="row">
					<div class="col-12">
						<div class="card mb-4">
							<div class="card-header pb-0 px-3">
								<h6 class="mb-0">게시글 수정</h6>
							</div>
							<div class="card-body pt-4 p-3">
								<table class="table">
									<tr>
										<td>
											<input type="hidden" name="boardNo" value="${boardOne.boardNo}">
											<input type="text" name="boardTitle" value="${boardOne.boardTitle}">
										</td>
									</tr>
									<tr>
										<td>
											${boardOne.memberId} | 
											<span class="text-sm">${boardOne.updatedate} . ${boardOne.createdate}</span>
										</td>
									</tr>
									<tr>
										<td><textarea rows="7" cols="50" name="boardContent" id="textarea">${boardOne.boardContent}</textarea></td>
									</tr>
								</table>
								<button type="button" class="btn bg-gradient-primary btn-lg w-100" id="addBtn">등록</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<script>
			$(document).ready(function() {
				
			})
		</script>
	</body>
</html>