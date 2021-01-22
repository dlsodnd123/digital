<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/board/list" method="get">
	<div class="container">
	  <h2>게시판</h2>
	  <table class="table table-striped">
	  	<div class="input-group mb-3">
	  		<select>
	  			<option value="1" name="type">전체</option>
	  			<option value="2" name="type">제목</option>
	  			<option value="3" name="type">작성자</option>
	  			<option value="4" name="type">내용</option>
	  		</select>
		    <input type="text" class="form-control" placeholder="Search" name="search">
		    <div class="input-group-append">
		      <button class="btn btn-success" type="submit">검색</button>  
		     </div>
		</div>
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	  	  <c:forEach items="${list}" var="board" >
	      <tr>
	        <td>${board.num}</td>
	        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
	        <td>${board.writer}</td>
	        <td>${board.registerDate}</td>
	        <td>${board.views}</td>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  <a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-secondary">글쓰기</button></a>
	</div>
	<div class="container">
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    	<li class="page-item <c:if test="${pm.criteria.page == index}">active</c:if>"><a class="page-link"  href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">다음</a></li>
	    </c:if>
	  </ul>
	</div>
	</form>
</body>
</html>