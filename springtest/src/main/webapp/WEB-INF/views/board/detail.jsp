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
	  <h3>게시글 상세 내용</h3>
	  <form action="/action_page.php">
	    <c:if test="${board != null}">
	  	<div class="form-group">
	      <label for="usr">번호:</label>
	      <input type="text" class="form-control" id="usr" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="usr">제목:</label>
	      <input type="text" class="form-control" id="usr" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="usr">작성자:</label>
	      <input type="text" class="form-control" id="usr" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="usr">내용:</label>
	      <input type="text" class="form-control" id="usr" name="content" value="${board.content}" readonly>
	    </div>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	    </c:if>
	    <c:if test="${board == null}">
	    <br> <h2>존재하지 않는 게시글 입니다.</h2> <br>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	    </c:if>
	  </form>
	</div>
</body>
</html>