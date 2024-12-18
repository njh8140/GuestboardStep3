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
	<h1>게시글 등록</h1>
	<hr>
	<form action="add" method="post">
		<table>
			<!-- <tr><th>no</th><td><input type="text" name="no"></td></tr> -->
			<tr><th>name</th><td><input type="text" name="name"></td></tr>
			<tr><th>email</th><td><input type="text" name="email"></td></tr>
			<tr><th>inputdate</th><td><input type="date" name="inputdate"></td></tr>
			<tr><th>subject</th><td><input type="text" name="subject"></td></tr>
<!-- 		<tr><th>content</th><td><input type="text" name="content"></td></tr>-->			
			<tr><th>content</th><td><textarea name="content"></textarea></td></tr>
			<tr><th colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</th></tr>
		</table>
	</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>