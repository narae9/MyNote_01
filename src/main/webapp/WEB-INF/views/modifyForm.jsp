<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/board.js"></script>
</head>
<body>
<div class="page-main">
	<h2>글수정</h2>
	<form id="register_form" action="modify.do" method="post">
		<input type="hidden" name="num" value="${boardVO.num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"
				   value="${boardVO.title}"
				   size="30" maxlength="50">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name"
				   value="${boardVO.name}"
				   size="10" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" 
				   id="passwd"
				   size="12" maxlength="12">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email"
				   value="${boardVO.email}"
				   size="20" maxlength="50">
			</li>
			<li>
				<label for="content">내용</label>
				<textarea rows="5" cols="40" name="content"
				 id="content">${boardVO.content}</textarea>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글수정">
			<input type="button" value="목록"
			            onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>
