<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
	
	
  <title>Aereo5 Booking Project</title>

</head>
<link href="myapp.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">

<body>



  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">Login</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Cerca il tuo volo</h1>
        <p class="lead">Nonostante la minaccia del Covid-19 i voli non saranno annullati!</p>
        <ul class="list-unstyled">
        

        </ul>
      </div>
    </div>
  </div>

<div class="booking-form-box">



<div class="radio-btn">
	<input type="radio" class="btn" name="check"><span>Sola Andata</span>
	<input type="radio" class="btn" name="check" checked><span>Andata e Ritorno</span>
</div>
<div class="booking-form">
	<label>Da</label>
	<input type="text" class="form-control" placeholder="Città o Aeroporto">
	<label>A</label>
	<input type="text" class="form-control" placeholder="Città o Aeroporto">
	
<div class="input-grp">
<label>Partenza</label>
<input type="date" class="form-control select-date">
</div>

<div class="input-grp">
<label>Ritorno</label>
<input type="date" class="form-control select-date">
</div>

<div class="input-grp">
<label>Adulti</label>
<input type="number" class="form-control" value="1">
</div>

<div class="input-grp">
<label>Bambini</label>
<input type="number" class="form-control" value="0">
</div>

<button type button class="btn btn-primary flight">Mostra voli</button>
</div>

</div>






	<script src="${js}/jquery.js"></script>
	
  <!-- Bootstrap core JavaScript -->
  <script src="${js}vendor/jquery/jquery.slim.min.js"></script>
  <script src="${js}vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
