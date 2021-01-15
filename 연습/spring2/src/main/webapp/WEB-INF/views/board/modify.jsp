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
	  <h2>게시글 수정</h2>
	  <form action="<%=request.getContextPath()%>/board/modify" method="post">
	  <div class="form-group">
	      <label for="num">번호:</label>
	      <input type="text" class="form-control" id="num" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="title">제목:</label>
	      <input type="text" class="form-control" id="title" name="title" value="${board.title}">
	    </div>
	    <div class="form-group">
	      <label for="writer">작성자:</label>
	      <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="registerDate">작성일:</label>
	      <input type="text" class="form-control" id="registerDate" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
		  <label for="content">내용:</label>
		  <textarea class="form-control" rows="10" id="content" name="content">${board.content}</textarea>
		</div>
	    <button type="submit" class="btn btn-primary">수정</button>
	  </form>
	 </div> 
</body>
</html>