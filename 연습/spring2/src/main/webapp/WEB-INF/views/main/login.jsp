<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<br>
	<div class="container">
	  <form action="<%=request.getContextPath()%>/login" method="post">
	    <div class="form-group">
	      <label for="usr">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
	    <button type="submit" class="btn btn-primary">로그인</button>
	  </form>
	</div>
</body>
</html>