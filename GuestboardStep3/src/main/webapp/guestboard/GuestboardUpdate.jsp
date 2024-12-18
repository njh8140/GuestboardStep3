<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<style>
	textarea{
		width:100%;
	    height:7em;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 정보 수정</h1>
	<hr>
	<form action="update" method="post">
		<table>
		<tr><th>id</th><td><input type="text" name="id" value="${requestScope.guestboard.getId()}" readonly></td></tr>
		<tr><th>name</th><td><input type="text" name="name" value="${requestScope.guestboard.getName()}"></td></tr>
		<tr><th>email</th><td><input type="text" name="email" value="${requestScope.guestboard.getEmail()}"></td></tr>
		<tr><th>inputdate</th><td><input type="text" name="inputdate" value="${requestScope.guestboard.getInputdate()}" readonly></td></tr>
		<tr><th>subject</th><td><input type="text" name="subject" value="${requestScope.guestboard.getSubject()}"></td></tr>
<%-- 		<tr><th>content</th><td><input type="text" name="content" value="${requestScope.guestboard.getContent()}"></td></tr>--%>		
		<tr><th>content</th><td><textarea name="content"></textarea></td></tr>
		<tr><th colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="삭제" onclick='location.href="delete?id=${requestScope.guestboard.getId()}"'>
			</th></tr>
		</table>
	</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>