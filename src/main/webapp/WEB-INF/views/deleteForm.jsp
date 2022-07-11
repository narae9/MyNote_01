<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/board_del.js"></script>
</head>
<body>
<div class="page-main">
	<h2>글쓰기</h2>
	<form id="delete_form" action="delete.do" method="post">
		<input type="hidden" name="num" value="${num}">
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" 
				   id="passwd"
				   size="12" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글삭제">
			<input type="button" value="목록"
			            onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>




