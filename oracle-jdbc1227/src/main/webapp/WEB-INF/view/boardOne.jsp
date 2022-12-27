<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" readonly="readonly" value="${boardOne.boardTitle}">
				</td>
			</tr>
			<tr>
				<td>일자</td>
				<td>
					<input type="text" readonly="readonly" value="${boardOne.updatedate}">
					<input type="text" readonly="readonly" value="${boardOne.createdate}">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" readonly="readonly" value="${boardOne.memberId}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="7" cols="50">${boardOne.boardContent}</textarea>
				</td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/ModifyBoardFormController?boardNo=${boardOne.boardNo}">수정</a>
		<a href="${pageContext.request.contextPath}/RemoveBoardController?boardNo=${boardOne.boardNo}">삭제</a>
	</body>
</html>