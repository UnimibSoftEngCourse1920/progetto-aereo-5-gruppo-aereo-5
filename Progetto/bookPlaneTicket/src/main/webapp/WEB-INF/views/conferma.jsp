<!DOCTYPE html SYSTEM "about:legacy-compat">
<html lang="it">
  	<head>
  		<title> Conferma</title>
 	 </head>
	<body>
 	<div class="container">
  	  <div class="row">
   	   <div class="col-lg-12 text-center">
    	    <h1 class="mt-5">Hai gi� una prenotazione confermata?</h1>
     	   <p class="lead">Inserisci la tua E-mail con il codice della prenotazione ricevuta</p>
      </div>
    </div>
  </div>

	<div class="booking-form-box">
		<div class="booking-form">
			<form action="<%=request.getContextPath()%>/cercaPrenotazione" method="post">
				<label >E-mail</label>
					<input type="text" name="email" class="form-control"placeholder="Inserisci E-mail"/>


				<label >Codice Prenotazione</label>
					<input type="text" class="form-control" name="codiceprenotazione" placeholder="Inserisci il codice della prenotazione"/>	
				
				<div class="form-group">
					<input  type="submit" class="btn btn-primary flight"  
							name="pagamento" value="Vai al pagamento" >		
				</div>
			</form>	
		</div>
	</div>
</body>

</html>