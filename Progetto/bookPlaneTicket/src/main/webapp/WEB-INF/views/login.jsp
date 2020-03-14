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
  <link href="${css}/bootstrap.min.css" rel="stylesheet">
  
  <!--  Custom CSS -->
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

	   	<c:if test="${not empty message}">
			<div class="row">
				<div class="col-xs-12 col-md-offset-2 col-md-8">
					<div class="alert alert-danger fade in">${message}</div>
				</div>
			</div>
		</c:if>

		<div class="row">
			<div class="col-lg-12 text-center">
				<h1 class="mt-5">Accedi al tuo account</h1>
				<p class="lead">Inserisci le tue credenziali</p>
				<ul class="list-unstyled">


				</ul>
			</div>
		</div>
	

		<div class="booking-form-box ">
			<div class="booking-form">
				<form id="loginForm" action="${contextRoot}/loginConferma" method="POST" accept-charset=utf-8>
					<div class="form-group">
						<label for="username">Email:</label>
						<input type="text"	name="username" id="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password:</label> 
						<input type="password" name="password" id="password" class="form-control" />
					</div>
					<div class="form-group">
					<input type="submit" value="Login" class="btn btn-primary flight" />
					</div>
				</form>
				<div>
					<div class="text-right">
						Nuovo Utente - <a href="${contextRoot}/registrati">Registrati</a>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- /Page Content -->

	<!--  jQuery -->
	<script src="${js}/jquery.js"></script>
	
	  <!--  jQuery Validator-->	
	<script src="${js}/jquery.validate.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	
	<!-- Bootbox -->
	<script src="${js}/bootbox.min.js"></script>
	
	<!--  javascript -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
