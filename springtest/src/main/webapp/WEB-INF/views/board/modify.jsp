<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h3>게시글 수정</h3>
	  <form action="<%=request.getContextPath()%>/board/modify" method="post">
	  	<div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title }">
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${board.writer }" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성일</label>
	      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea class="form-control" rows="10" name="content">${board.content}</textarea>
	    </div>
	    <button type="submit" class="btn btn-outline-primary">수정</button> <br> <br>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	    <a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-outline-secondary">글쓰기</button></a> <br>
	  </form>
	</div>
</body>
</html>