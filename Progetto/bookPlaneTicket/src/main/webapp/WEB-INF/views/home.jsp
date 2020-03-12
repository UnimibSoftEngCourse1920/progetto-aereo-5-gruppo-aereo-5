<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<body>

<head>
<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h1 class="mt-5">Cerca il tuo volo</h1>
			<p class="lead">Nonostante la minaccia del Covid-19 i voli non
				saranno annullati!</p>
			<ul class="list-unstyled">


			</ul>
		</div>
	</div>
</div>

<div class="booking-form-box">




	<div class="booking-form">

		<form action="listaVoli" method="post" accept-charset=utf-8>
			<p>
				Da: <select id="partenza" class="form-control">
  <option > </option>				
  <option value="milano">Milano</option>
  <option value="Roma">Roma</option>
  <option value="Brindisi">Brindisi</option>
  <option value="Napoli">Napoli</option>
</select>
 
			</p>

			<p>
				A: <select id="partenza" class="form-control">
 <option > </option>
  <option value="volvo">Milano</option>
  <option value="saab">Roma</option>
  <option value="opel">Brindisi</option>
  <option value="audi">Napoli</option>
</select> 
			</p>

			<div class="input-grp">
				<label>Data di Partenza</label> <input type="date" id="filtro_data_partenza"
					class="form-control select-date">

			</div>
			<button id="filtra_voli" class="btn btn-primary flight">
				Mostra voli</button>
		</form>
	</div>
</div>

</body>
</html>