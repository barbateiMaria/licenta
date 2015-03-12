<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value = "/resources/css/Script.css" />"
	rel="stylesheet">

<title>Event Management</title>
</head>
<body>
	<nav id="nav02"></nav>

	<div class="form-group">
		<p class="lead">Event generation</p>
	</div>
	<form class="form-inline" action="generatePage.htm" method="POST">
		<div class="form-group">
			<label for="eventName">Event name</label> <input type="text"
				class="form-control" id="eventName" name="name"
				placeholder="Enter name" style="length: 40px">
		</div>
		<select name="menuList">

			<c:forEach var="item" items="${list}">
				<option>${item}</option>
			</c:forEach>

		</select> <input type="submit" value="Generate Page" />
	</form>
	<script src="<c:url value = "/resources/js/script.js" />"></script>

</body>
</html>