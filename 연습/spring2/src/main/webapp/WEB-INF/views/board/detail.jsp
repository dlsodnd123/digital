<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 정보</title>
</head>
<body>
	<div class="container">
	  <h2>게시글 상세 내용</h2>
	  <form action="/action_page.php">
	    <div class="form-group">
	      <label for="num">번호:</label>
	      <input type="text" class="form-control" id="num" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label for="title">제목:</label>
	      <input type="text" class="form-control" id="title" name="title" value="${board.title}" readonly>
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
	      <label for="views">조회수:</label>
	      <input type="text" class="form-control" id="views" name="views" value="${board.views}" readonly>
	    </div>
	    <div class="form-group">
		  <label for="content">내용:</label>
		  <textarea class="form-control" rows="10" id="content" name="content" readonly>${board.content}</textarea>
		</div>
	  </form>
		<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-secondary">목록</button></a>
		<a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-secondary">글쓰기</button></a> <c:if test="${user.id != board.writer}"><br> <br></c:if>
		<c:if test="${user.id == board.writer}">
			<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn btn-secondary">수정</button></a>
			<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn btn-secondary">삭제</button></a> <br> <br>
		</c:if>
	</div>
</body>
</html>