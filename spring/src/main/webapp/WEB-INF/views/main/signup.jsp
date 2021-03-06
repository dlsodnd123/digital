<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<style>
		.title{
			text-align: center;
			margin-top: 50px;
		}
		label.error{
			color: red;
			display: none;
		}
	</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/signup" id="form" class="container" method="post">
		<h1 class="title">회원가입</h1>
		<div class="form-group">
			<input type="text" class="form-control" id="id" name="id" placeholder="아이디" value="${user.id}">
			<label for="id" class="error" id="id-error"></label>
		</div>
		<button type="button" class="btn btn-outline-success col-12" id="dup">아이디 중복 확인</button>
		<div class="form-group">
			<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호"value="${user.pw}">
			<label for="pw" class="error" id="pw-error"></label>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pw2" name="pw2" placeholder="비밀번호 확인"value="${user.pw2}">
			<label for="pw2" class="error" id="pw2-error"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="age" name="age" placeholder="나이"value="${user.age}">
			<label for="age" class="error" id="age-error"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="name" name="name" placeholder="이름"value="${user.name}">
			<label for="name" class="error" id="name-error"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="email" name="email" placeholder="이메일" value="${user.email}">
			<label for="email" class="error" id="email-error"></label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="home" name="home" placeholder="홈페이지" value="${user.home}">
			<label for="home" class="error" id="home-error"></label>
		</div>
		<button class="btn btn-outline-success col-12">회원가입</button>
	</form>
	<script>
		var dup = false;	// 중복검사여부
		$('#dup').click(function(){
			var id = $('input[name=id]').val();
			if(id == ''){
				alert('아이디를 입력하세요');
				return;
			}
			var data = { 'id' : id };
			$.ajax({
				url : '<%=request.getContextPath()%>/dup',
				type : 'post',
				data : data,
				success : function(data){
					console.log(data)
					if(data == 'user'){
						alert('이미 가입한 아이디 입니다.');
						
					}else{
						alert('가입 가능한 아이디 입니다.');
						dup = true;
					}
				},
				error : function(){
					console.log('실패');
				}
			})
		})
				
		$('input[name=id]').change(function(){
			dup = false;
		})
		$('form').submit(function(){
			if(!dup){
				alert('아이디 중복검사를 하세요.');
				return false;
			}
		})
	</script>
</body>
</html>



