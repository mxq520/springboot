<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<th>${user.userid}</th>
				<th>${user.username}</th>
				<th>${user.userage}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>