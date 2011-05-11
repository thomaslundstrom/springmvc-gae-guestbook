<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	Greetings;
	<br />
	<c:forEach var="greeting" items="${greetings}">
		<c:out value="${greeting.author.nickname}" /> wrote: <c:out value="${greeting.content}" />. <br />
	</c:forEach>
	<a href="/index.jsp">Back</a>
</body>
</html>
