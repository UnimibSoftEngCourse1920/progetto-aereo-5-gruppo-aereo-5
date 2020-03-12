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

<!-- Bootstrap DataTable -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!--  Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<title>Aereo5 Booking Project - ${title}></title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>
</head>

<body>
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<!--  Home Page -->

	<c:if test="${userClickHome == true }">
		<%@include file="home.jsp"%>
	</c:if>
	<!-- / Home Page -->

	<!--  Booking Page -->

	<c:if test="${userClickConfermaLaPrenotazione == true }">
		<%@include file="conferma.jsp"%>
	</c:if>
	<!-- / Booking Page -->
	
	<!--  Registration Success Page -->

	<c:if test="${userClickRegistrazioneEffettuata == true }">
		<%@include file="registrazioneEffettuata.jsp"%>
	</c:if>
	<!-- / Registration Success Page Page -->

	<!--  Payment Page -->

	<c:if test="${userClickPaga == true }">
		<%@include file="pagamento.jsp"%>
	</c:if>
	<!-- / Payment Page -->
	
	<!--  Payment ok Page -->

	<c:if test="${userClickPagamentok == true }">
		<%@include file="pagamentok.jsp"%>
	</c:if>
	<!-- / Payment ok Page -->
	
	<!--  Register Page -->

	<c:if test="${userClickRegistrati == true }">
		<%@include file="registrati.jsp"%>
	</c:if>
	<!-- / Register Page -->

	<!--  Login Page -->

	<c:if test="${userClickAccedi == true }">
		<%@include file="login.jsp"%>
	</c:if>
	<!-- / Login Page -->

	<!--  Info Page -->

	<c:if test="${userClickInfo == true }">
		<%@include file="info.jsp"%>
	</c:if>
	<!-- / Info Page -->

	<!--  Flight List Page -->

	<c:if test="${userClickMostraVoli == true }">
		<%@include file="listaVoli.jsp"%>
	</c:if>
	<!-- / Flight List Page -->

	<!--  Specifiche Volo Page -->

	<c:if test="${userClickSpecificheVolo == true }">
		<%@include file="specificheVolo.jsp"%>
	</c:if>
	<!-- / Specifiche Volo Pagee -->

	<!-- / Page Content -->

	<!--  jQuery -->
	<script src="${js}/jquery.js"></script>

	<!--  jQuery Validator-->
	<script src="${js}/jquery.validate.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

	<!--  DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>

	<!--  DataTable Bootstrap -->
	<script src="${js}/dataTables.bootstrap.js"></script>

	<!--  javascript -->
	<script src="${js}/myapp.js"></script>

</body>

</html>
