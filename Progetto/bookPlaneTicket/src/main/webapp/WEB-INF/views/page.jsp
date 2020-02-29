<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.io.*,java.util.*,java.text.*,java.sql.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Bootstrap core CSS -->
  <link href="${css}vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${css}/myapp.css" rel="stylesheet">

  <title>Aereo5 Booking Project - ${title}> </title>

</head>
	<link href="myapp.css" rel="stylesheet">
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">

<body>
  <!-- Navigation -->
	<%@include file="./shared/navbar.jsp" %>

  <!-- Page Content -->
 	<!--  Home Page -->
 	
 	<c:if test="${userClickHome == true }">
 	<%@include file="home.jsp" %>
 	</c:if>
 	
	<!-- / Home Page -->
 	<!--  Booking Page -->
 	
 	<c:if test="${userClickConfermaLaPrenotazione == true }">
 	<%@include file="conferma.jsp" %>
 	</c:if>
 	
	<!-- / Booking Page -->
 	<!--  Register Page -->
 	
 	<c:if test="${userClickRegistrati == true }">
 	<%@include file="registrati.jsp" %>
 	</c:if>
 	
	<!-- / Register Page -->
 	<!--  Info Page -->
 	
 	<c:if test="${userClickInfo == true }">
 	<%@include file="info.jsp" %>
 	</c:if>
 	
	<!-- / Info Page -->
 	<!--  Flight List Page -->
 	
 	<c:if test="${userClickMostraVoli == true }">
 	<%@include file="listaVoli.jsp" %>
 	</c:if>
 	
	<!-- / Flight List Page -->
	
  <!-- / Page Content -->		
	<script src="${js}/jquery.js"></script>
	
  <!-- Bootstrap core JavaScript -->
  <script src="${js}vendor/jquery/jquery.slim.min.js"></script>
  <script src="${js}vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
