<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div class="container">
	  <h2>회원가입</h2>
	  <form action="">
	    <div class="form-group">
	      <label for="usr">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
	    <div class="form-group">
	      <label for="pwd">비밀번호확인:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
	    <button type="submit" class="btn btn-primary">회원가입</button>
	  </form>
	</div>
</body>
</html>