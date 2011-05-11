<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>greetings</title>
</head>
<body>
	Greetings:
	<br />
	<c:forEach var="greeting" items="${greetings}">
		<c:out value="${greeting.author.nickname}" /> wrote: <c:out value="${greeting.content}" />, <a href="/greetings/get/<c:out value="${greeting.key.id}" />">(json)</a> <br />
	</c:forEach>
	<form action="post" method="post">
		your message: <br /> <input type="text" name="message" /> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>
