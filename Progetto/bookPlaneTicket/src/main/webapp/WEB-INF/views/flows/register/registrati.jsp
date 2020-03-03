<%@include file="../shared/flows-header.jsp" %>

<!DOCTYPE html>
<html>
<body>

 <div class="container">
 
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Crea Account<br>
        </h1>
    
        <p align="left" class="lead"><br>Se non possiedi un account sul nostro sito puoi comunque 
        effettuare la prenotazione e gestire il tuo volo.<br>Se deciderai di registrarti 
        al nostro sito avrai la 
        possibilità di ricevere offerte dedicate sulla mail indicata in fase di
        registrazione. <br> Avrai inoltre la possibilità di 
        accumulare punti sulla Member Card e quando ne avrai accumulati abbastanza
        potrai riscattare un viaggio gratis. </p>        
        <ul class="list-unstyled">
        

        </ul>
      </div>
    </div>
  </div>

<div class="booking-form-box">

<div class="booking-form">
<form action="reg" method="post">
	<label>Nome</label>
	<input type="text" class="form-control" id="nome">
	
	<label>Cognome</label>
	<input type="text" class="form-control" id="cognome">
	
	<label>E-Mail</label>
	<input type="text" class="form-control" id="email">
	
	<div class="birth-date"><label>Data di nascita</label>
	<input type="date" class="form-control select-date" id="data"></div>
	
	<label>Indirizzo di casa</label>
	<input type="text" class="form-control" id="indirizzo">
	
	<label>Password</label>
	<input type="password" class="form-control" id="pwd">
	
	<label>Conferma Password</label>
	<input type="password" class="form-control" id="pwdC">
<input  type="submit" class="btn btn-primary flight"  value="Registrati">
</form>
</div>
</div>

</body>
</html>
<%@include file="../shared/flows-footer.jsp" %>
