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
	<div class="container">
	  	<h2>게시글 상세</h2>
	  	<c:if test="${board != null}">
	    <div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
	    </div>
	    <div class="form-group">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">
	    </div>
	    <div class="form-group">
	      <label for="writer">작성자</label>
	      <input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">
	    </div>
	    <div class="form-group">
	      <label for="registerDate">작성일</label>
	      <input type="text" class="form-control" id="registerDate" name="registerDate" readonly value="${board.registerDate}">
	    </div>
	    <div class="form-group">
	      <label for="views">조회수</label>
	      <input type="text" class="form-control" id="views" name="views" readonly value="${board.views}">
	    </div>
	    <div class="form-group">
	      <label for="content">내용</label>
	      <textarea class="form-control" id="content" name="content" readonly>${board.content}</textarea>
	    </div>
	    </c:if>
	    <c:if test="${board == null}">
	    	<h1>존재하지 않는 게시물입니다.</h1>
	    </c:if>
	    <a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&search=${cri.search}&type=${cri.type}">
		    <button type="button" class="btn btn-outline-info">목록</button>
	    </a>
	    <a href="<%=request.getContextPath()%>/board/register">
		    <button type="button" class="btn btn-outline-info">글쓰기</button>
	    </a>
	    <c:if test="${user != null && user.id == board.writer}">
	    <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
		    <button type="button" class="btn btn-outline-info">수정</button>
	    </a>
	    <a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
		    <button type="button" class="btn btn-outline-info">삭제</button>
	    </a>
	    </c:if>
	</div>
</body>
</html>