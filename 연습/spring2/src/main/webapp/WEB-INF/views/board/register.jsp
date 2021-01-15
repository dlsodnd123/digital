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
	  <h2>게시글 등록(글쓰기)</h2>
	  <form action="<%=request.getContextPath()%>/board/register" method="post">
	    <div class="form-group">
	      <label for="title">제목:</label>
	      <input type="text" class="form-control" id="title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="writer">작성자:</label>
	      <input type="text" class="form-control" id="writer" name="writer" value="${user.id}" readonly>
	    </div>
	    <div class="form-group">
		  <label for="content">내용:</label>
		  <textarea class="form-control" rows="10" id="content" name="content"></textarea>
		</div>
	    <button type="submit" class="btn btn-primary">등록</button>
	  </form>
	</div>
</body>
</html>