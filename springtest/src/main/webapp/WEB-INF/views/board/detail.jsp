<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	  <h3>게시글 상세 내용</h3>
	  <c:if test="${board != null}">
	  <form action="">
	  	<div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성일</label>
	      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label>조회수</label>
	      <input type="text" class="form-control" name="views" value="${board.views}" readonly>
	    </div>
	    <div class="form-group">
	   	  <button type="button" class="btn btn-<c:if test="${likeVo == null || likeVo.up != 1 }">outline-</c:if>info up">추천</button>
	   	  <button type="button" class="btn btn-<c:if test="${likeVo == null || likeVo.up != -1 }">outline-</c:if>info down">비추천</button>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea class="form-control" rows="10" name="content" readonly>${board.content}</textarea>
	    </div>
	    <c:if test="${fList.size() != 0}">
	    <div class="form-group">
	      <label>첨부파일</label> <br>
	      <c:forEach items="${fList}" var="file">
	      	<div><a href="<%=request.getContextPath()%>/board/download?filename=${file.filename}">${file.oriFilename}</a></div>
	      </c:forEach>
	    </div>
	    </c:if>
	    <a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}"><button type="button" class="btn btn-outline-secondary">목록</button></a>
	    <a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-outline-secondary">글쓰기</button></a>
	    <c:if test="${user != null && user.id == board.writer}">
	    <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn btn-outline-secondary">수정</button></a>
	    <a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn btn-outline-secondary">삭제</button></a>
	    </c:if>	    
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
	  	<br> <h1>존재하지 않는 게시글 입니다.</h1> <br>
	  	<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-secondary">목록</button></a> <br>
	  </c:if>
	</div>
	<script type="text/javascript">
		var up = '${likeVo.up}';
		console.log(up);
		$('.btn.up, .btn.down').click(function(){	
			var id = '${user.id}';
			if(id == ''){
				alert('회원만 추천/비추천이 가능합니다.')
				return ;
			}
			// 추천 버튼을 클릭하면
			if($(this).hasClass('up')){
				// 추천 상태에서 추천버튼을 클릭하면 up을 0으로 추천 상태가 
				if(up == 1)
					up = 0;
				//아닌상황에서 추천버튼을 클릭하면 up을 1로
				else
					up = 1;
			// 비추천 버튼을 클릭하면
			}else{
				// 비추천 상태에서 비추천 버튼을 클릭하면 up을 0으로 비추천 상태가 
				if(up == -1)
					up = 0;
				// 아닌상황에서 비추천 버튼을 클릭하면 up을 -1로
				else
					up = -1;
			}
			// 추천/비추천인 경우
			if(up != 0){
				/*
					추천/비추천 버튼 모두에 btn-secondary클래스 제거, btn-outline-secondary클래스 추가
	 			 	클릭한 버튼에 btn-secondary 클래스 추가, btn-outline-secondary클래스 제거
				*/
				$('.btn.up, .btn.down').removeClass('btn-info').addClass('btn-outline-info')
				$(this).addClass('btn-info').removeClass('btn-outline-info');
			}
			// 추천/비추천을 취소한 경우
			else{
				/*
					클릭한 버튼에 btn-secondary 클래스 제거, btn-outline-secondary클래스 추가
				*/
				$(this).removeClass('btn-info').addClass('btn-outline-info');
			}
			
			var boardNum = $('input[name=num]').val();			
			var data = { 'boardNum' : boardNum, 'id' : id, 'up' : up }
			var obj = $(this)
			$.ajax({
		        type:'post',
		        data:data,
		        url:'<%=request.getContextPath()%>/board/like',
		        success : function(data){
		           		if(up == 1){
		           			alert('추천하였습니다.');
		        		}else if(up == -1){
		           			alert('비추천하였습니다.');
		           		}else{
		           			// 클릭된 버튼이 추천이면 추천이 취소되었습니다.
		           			if(obj.hasClass('up'))
		           				alert('추천이 취소하였습니다.')
		           			// 아니면 비추천이 취소되었습니다.
		           			else
		           				alert('비추천이 취소하였습니다.')
		           		}
		           			
		           			
		        }
		    })
		})
	</script>
</body>
</html>