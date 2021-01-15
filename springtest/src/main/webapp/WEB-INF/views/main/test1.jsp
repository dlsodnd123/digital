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
	이름 : ${name} <br>
	나이 : ${age } <br> <br>
	이름 : ${testVo.name} <br>
	나이 : ${testVo.age } <br> <br>
	<c:forEach begin="${start}" end="${end}" var="index">${index}<br></c:forEach> <br>
	<c:forEach items="${list}" var="list">
		이름 : ${list.name}<br>
		나이 : ${list.age }<br>
	</c:forEach>
</body>
</html>