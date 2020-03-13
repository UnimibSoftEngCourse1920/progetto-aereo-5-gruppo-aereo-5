<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
	<body>
    
  	<head>
  		<title> Conferma</title>
 	 </head>
 	<div class="container">
  	  <div class="row">
   	   <div class="col-lg-12 text-center">
    	    <h1 class="mt-5">Effettua il login se sei nostro cliente</h1>
     	   <p class="lead">Inserisci la tua E-mail con il codice della prenotazione ricevuto</p>
      </div>
    </div>
  </div>

	<div class="booking-form-box">
		<div class="booking-form">
			<form action="pagamento" method="post">
				<label >ID Utente</label>
					<input type="text" name="id" class="form-control" placeholder="Inserisci ID"/>
	 
				<label >password</label>
					<input type="text" class="form-control" name="pwd" placeholder="Inserisci il codice della prenotazione"/>	
				
				<div class="form-group">
					<input  type="submit" class="btn btn-primary flight"  
							name="log" value="Vai al pagamento" >		
				</div>
			</form>	
		</div>
	</div>
</body>

</html>