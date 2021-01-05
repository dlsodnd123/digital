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
	<div class="container">
	  <h2>Hoverable Dark Table</h2>
	  <p>The .table-hover class adds a hover effect (grey background color) on table rows:</p>            
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.num}</td>
	        <td><a href="#">${board.title}</a></td>
	        <td>${board.writer}</td>
	        <td>${board.registerDate}</td> 
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	</div>
</body>
</html>