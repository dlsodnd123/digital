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
	  <c:if test="${board != null}">
	  <form action="">
	  	<div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성일</label>
	      <input type="text" class="form-control" name="writer" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea class="form-control" rows="10" name="content" readonly>${board.content}</textarea>
	    </div>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	    <a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-outline-secondary">글쓰기</button></a>
	    <c:if test="${user != null && user.id == board.writer}">
	    <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn btn-outline-secondary">수정</button></a>
	    <a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn btn-outline-secondary">삭제</button></a>
	    </c:if>	    
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
	  	<br> <h1>존재하지 않는 게시글 입니다.</h1> <br>
	  	<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a> <br>
	  </c:if>
	</div>
</body>
</html>