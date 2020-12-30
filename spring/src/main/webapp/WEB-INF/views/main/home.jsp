<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<form method="post" action="">
	<input type="text" name="name">
	<select name="fruit">
		<option value="apple">사과</option>
		<option value="orange">오렌지</option>
	</select>
	<button type="submit">전송</button>
</form>
</body>
</html>
