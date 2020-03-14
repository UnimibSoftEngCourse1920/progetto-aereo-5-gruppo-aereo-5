<!DOCTYPE html SYSTEM "about:legacy-compat">
 <html>
  <body>
    
  <head>
  <title> Conferma</title>
  </head>
 <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Hai già una prenotazione confermata?</h1>
        <p class="lead">Inserisci la tua E-mail con il codice della prenotazione ricevuto</p>
        <ul class="list-unstyled">
        

        </ul>
      </div>
    </div>
  </div>

<div class="booking-form-box">
<div class="booking-form">
<form action="<%=request.getContextPath()%>/prenotazione" method="post">
		<label >ID Utente</label>
		<input type="text" name="utente" class="form-control"placeholder="Inserisci ID"/>
	 
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