<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.sql.*"%>
<%@page
	import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<head>
<title>Home</title>
</head>

<body>
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

			<sf:form id="formRicerca" action="json/data/listaVoli" method="post"
				modelAttribute="filtro" accept-charset="utf-8">
				<label> Da: </label>
				<sf:input type="text" id="filtro_partenza" path="cittaPartenza"
					name="citta_partenza" class="form-control"
					placeholder="Città o Aeroporto" />

				<label> A: </label>
				<sf:input type="text" id="filtro_arrivo" class="form-control"
					path="cittaArrivo" name="citta_arrivo"
					placeholder="Città o Aeroporto" />


				<div class="input-grp">
					<label>Data di Partenza</label>
					<sf:input type="date" id="filtro_data_partenza" path="dataPartenza"
						name="data_partenza" class="form-control select-date" />

				</div>
				<div class="form-group">
				<input type="submit" value="Mostra Voli" id="filtra_voli"
					class="btn btn-primary flight">
				</div>
			</sf:form>
		</div>
	</div>
</body>