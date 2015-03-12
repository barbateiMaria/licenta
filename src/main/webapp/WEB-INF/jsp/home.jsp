<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
<link href="<c:url value = "/resources/css/Script.css" />" rel="stylesheet">
</head>

<body>
<nav id="nav01">
</nav>

  <div id="main">
  <c:out value="${home}"></c:out>
  <footer id="foot01"></footer>
  </div>
<script src="<c:url value = "/resources/js/test.js" />"></script>

</body>
</html>