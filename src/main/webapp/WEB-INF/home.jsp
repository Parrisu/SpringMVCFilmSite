<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Film Site</title>
</head>
<body>

<h1>Welcome to Parris' Film Site</h1>
<br>
<br>
	
	<h3>Film Search:</h3>
	<br>
	<form action="home.do" method="GET">
		Film ID:
		<input type="text" name="film"/> 
		<input type="submit" value="Submit" />
	</form>
	<br>
	<form action="home.do" method="GET">
		By Keyword:
		<input type="text" name="keyword"/> 
		<input type="submit" value="Submit" />
	</form>
	<br>
	

</body>
</html>