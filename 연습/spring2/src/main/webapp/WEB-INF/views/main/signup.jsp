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
	  <form action="<%=request.getContextPath()%>/signup" method="post">
	    <div class="form-group">
	      <label for="id">아이디:</label>
	      <input type="text" class="form-control" id="id" name="id">
	    </div>
	    <div class="form-group">
	      <label for="pw">비밀번호:</label>
	      <input type="password" class="form-control" id="pw" name="pw">
	    </div>
	    <div class="form-group">
	      <label for="pw2">비밀번호확인:</label>
	      <input type="password" class="form-control" id="pw2" name="pw2">
	    </div>
	    <div class="form-group">
	      <label for="age">나이:</label>
	      <input type="text" class="form-control" id="age" name="age">
	    </div>
	    <div class="form-group">
	      <label for="name">이름:</label>
	      <input type="text" class="form-control" id="name" name="name">
	    </div>
	    <div class="form-group">
	      <label for="email">이메일:</label>
	      <input type="text" class="form-control" id="email" name="email">
	    </div>
	    <div class="form-group">
	      <label for="home">홈페이지:</label>
	      <input type="text" class="form-control" id="home" name="home">
	    </div>
	    <button type="submit" class="btn btn-primary">회원가입</button>
	  </form>
	</div>
</body>
</html>