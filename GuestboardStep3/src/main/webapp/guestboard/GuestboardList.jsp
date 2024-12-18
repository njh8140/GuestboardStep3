<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:include page="/Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<a href="add">신규등록</a>
	<hr>
	<c:forEach var="g" items="${requestScope.guestboards}">
		${g.id}, 
		<a href="update?id=${g.id}">${g.name}</a>, 
		${g.email}, 
		${g.inputdate}, 
		${g.subject} <br>
	</c:forEach>
	
<jsp:include page="/Tail.jsp"/>
</body>
</html>