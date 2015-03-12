<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>


<nav id="nav02"></nav>


<%-- <form:form method="POST" commandname="navigationBar" action="manageevent.htm">
<table>
    <tbody><tr>
    <td>
<ul>
<form:checkboxes element="li" path="navBars" items="${navBars}">
</form:checkboxes></ul>
    </td>
    </tr>
    <tr>
        <td>
            <input value="Submit" type="submit">
        </td>
    </tr>
</tbody></table>
</form:form>
 --%>

<div class="container">
  <p>Choose the elements of the navigation Bar!</p>
  <form role="form" action = "results.htm" method = "POST">
    <div class="checkbox">
    <c:forEach var="item" items = "${navBars}">
      <label><input type="checkbox" value="">${item}</label>
      </c:forEach>
    </div>
    <input type = "submit" class = "btn btn default" value= "Next"/>
  </form>
</div>
	<script src="<c:url value = "/resources/js/script.js" />"></script>
 
</body>
</html>
