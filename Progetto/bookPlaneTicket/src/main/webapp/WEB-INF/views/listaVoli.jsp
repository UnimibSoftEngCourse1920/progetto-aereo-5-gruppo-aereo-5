<%@page import="java.sql.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%-- 
<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Result</h1>
    <p th:text=" ${greeting.id}" />
    <p th:text="'content ' + ${greeting.content}" />
    <a href="/bookPlaneTicket/home">Modifica Dati</a>
</body>
</html>--%>


<!DOCTYPE html>

<p class="lead">Lista voli</p>
<div class="list-group">
	<c:forEach items="${voli}" var="volo">
		<p>${volo.codice_volo} ${volo.citta_partenza}</p>
	</c:forEach>
</div>


