<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h3>게시글 등록</h3>
	  <form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="">
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea class="form-control" rows="10" name="content"></textarea>
	    </div>
	     <div class="form-group">
	        <label>파일</label>
	        <input type="file" class="form-control" name="fileList"/> <br>
	        <input type="file" class="form-control" name="fileList"/> <br>
	        <input type="file" class="form-control" name="fileList"/> <br>
         </div>
	    <button type="submit" class="btn btn-outline-primary">등록</button>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a> <br>
	  </form>
</body>
</html>