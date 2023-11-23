<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Details</title>
</head>
<body>
	<h2>Film Details</h2>
	<br>
	
	<p>
	<c:choose>
	<c:when test="${! empty film }">
	<table border=".5px">
		<thead>
			<tr>
				<th>Film: </th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><strong>ID</strong></td>
				<td>${film.id}</td>
			</tr>
			<tr>
				<td><strong>Title</strong></td>
				<td>${film.title}</td>
			</tr>
			<tr>
				<td><strong>Language</strong></td>
				<td>${film.languageName}</td>
			</tr>
			<tr>
				<td><strong>Release Year</strong></td>
				<td>${film.releaseYear}</td>
			</tr>
			<tr>
				<td><strong>Length</strong></td>
				<td>${film.length}</td>
			</tr>
			<tr>
				<td><strong>Rating</strong></td>
				<td>${film.rating}</td>
			</tr>
			<tr>
				<td><strong>Features</strong></td>
				<td>${film.features}</td>
			</tr>
			<tr>
				<td><strong>Category</strong></td>
				<td>${film.category}</td>
			</tr>
			<tr>
				<td><strong>Description</strong></td>
				<td>${film.desc}</td>
			</tr>
			<tr>
				<td colspan="2"><strong>Cast</strong></td>
			</tr>
				<c:forEach items="${film.actors}" var="a">
					<tr>
						<td colspan="2">${a.firstName} ${a.lastName} </td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		No film found.
		<a href="home.do">Back to main page</a>
	</c:otherwise>
	</c:choose>
	
	<p>
</body>
</html>