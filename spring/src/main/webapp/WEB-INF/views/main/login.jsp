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
	<c:if test="${user == null}">
	<!-- url이 localhost:8080/test/login -->
	<form action="<%=request.getContextPath()%>/login" method="post">
    <div class="form-group">
      <label for="usr">ID:</label>
      <input type="text" class="form-control" id="usr" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">PW:</label>
      <input type="password" class="form-control" id="pwd" name="pw">
    </div>
    <button type="submit" class="btn btn-primary col-12">로그인</button>
  </form>
  </c:if>
  <c:if test="${user != null}">
  	<button id="btnAjax1">ajax 버튼1</button>
  	
  	
  	<script>
  		$(function(){
  			$('#btnAjax1').click(function(){
  				var data = {name : 'Hong', age : 21};
  				$.ajax({
  					url : '<%=request.getContextPath()%>/ajax1',
  					type : 'post',
  					data : data,
  					success : function(data){
  						console.log(data);
  					},
  					error : function(){
  						console.log('실패');
  					}
  				})
  			})
  		})
  	</script>
  </c:if>
</body>
</html>