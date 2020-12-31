<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${option eq '이름'}">
		<c:forEach items="${list}" var="name">
			<div>${name}</div>
		</c:forEach>
	</c:if>
</body>
</html>