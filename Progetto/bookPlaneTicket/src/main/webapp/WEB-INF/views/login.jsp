<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.io.*,java.util.*,java.text.*,java.sql.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="${css}vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${css}/myapp.css" rel="stylesheet">

<title>Aereo5 Booking Project - ${title}></title>

<script>
	window.menu = '${title}';
</script>
</head>


<body>
	<!-- Navigation -->



	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h1 class="mt-5">Accedi al tuo account</h1>
				<p class="lead">Inserisci le tue credenziali</p>
				<ul class="list-unstyled">


				</ul>
			</div>
		</div>
	</div>

	<div class="booking-form-box">
		<div class="booking-form">
			<form action="${contextRoot}/login" method="POST" id="loginForm">

				<label for="username">Email:</label>
				<input type="text"	name="username" id="username" class="form-control" />
				<label for="password">Password:</label> 
				<input type="password" name="password" id="password" class="form-control" />
				<input type="submit" value="Login" class="btn btn-primary flight" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

			</form>
			<div class="panel-footer">
				<div class="text-right">
					Nuovo Utente - <a href="${contextRoot}/registrati">Registrati</a>
				</div>
			</div>
		</div>

	</div>

	<!-- /Page Content -->

	<!--  jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}vendor/jquery/jquery.slim.min.js"></script>
	<script src="${js}vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!--  javascript -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
