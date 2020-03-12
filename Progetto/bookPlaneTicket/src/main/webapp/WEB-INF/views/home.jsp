<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<head>
<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<body>
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

	<div class="booking-form-box">




		<div class="booking-form">

			<sf:form id="formRicerca" action="json/data/listaVoli" method="post"
				modelAttribute="filtro" accept-charset="utf-8" onsubmit="return validateData()">
				<label> Da: </label>
				<sf:select id="filtro_partenza" path="cittaPartenza"
					name="citta_partenza" class="form-control"
					 
					items="${selectVoli}"
					itemLabel="citta_partenza"
					itemValue="citta_partenza"
					/>

				<label> A: </label>
				<sf:select id="filtro_arrivo" class="form-control"
					path="cittaArrivo" name="citta_arrivo"
					
					items="${selectVoli}"
					
					
					itemLabel="citta_arrivo"
					itemValue="citta_arrivo"
					/>


				<div class="input-grp">
					<label>Data di Partenza</label>
					<sf:input type="date" id="filtro_data_partenza" path="dataPartenza"
						name="data_partenza" class="form-control select-date" required="true"/>

				</div>
				<div class="form-group">
				<input type="submit" value="Mostra Voli" id="filtra_voli"
					class="btn btn-primary flight">
				</div>
			</sf:form>
		</div>
	</div>
</body>
<script type="text/javascript">

/*Validare data*/

var today = new Date();

function validateData() {
	
	var data = new Date(document.getElementById("filtro_data_partenza").value);
	
	if (data <= today){
	        alert ("Inserisci una data valida!");
	       return false;
		}
};


</script>
</body>
</html>

