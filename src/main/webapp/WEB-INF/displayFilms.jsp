<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Details</title>
</head>
<body>
	<h2>Related Films</h2>
	
	<p>
	<c:choose>
	<c:when test="${! empty films}">
		<c:forEach items="${films}" var="f">
	
			<ul>
			<li><a href="home.do?film=${f.id}">${f.title}</a></li>
			</ul>
		
		</c:forEach>
	</c:when>
	<c:otherwise>
		No films found.
		<a href="home.do">Back to main page</a>
	</c:otherwise>
	</c:choose>
	</p>
	
</body>
</html>