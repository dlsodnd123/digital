<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<td><b>아이디</b></td>
				<td><b>이름</b></td>
				<td><b>이메일</b></td>
				<td><b>나이</b></td>
				<td><b>홈페이지</b></td>
				<td><b>권한</b></td>
				<td><b>수정</b></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.age}</td>
				<td>${user.home}</td>
				<td>
					<select>
						<c:forEach begin="1" end="10" var="i">
							<option <c:if test="${i == user.author}">selected</c:if> >${i}</option>
						</c:forEach>
					</select>
				</td>
				<td><button class="btn btn-outline-success">수정</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>