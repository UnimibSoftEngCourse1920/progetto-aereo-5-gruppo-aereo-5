<!DOCTYPE html SYSTEM "about:legacy-compat">

 <html>
  <body>
  <head>
  <title> Pagamento</title>
  </head>
 <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Effettua pagamento con carta di credito<br> </h1>
        <form action="login" method="post">
        <p class="lead">Sei iscritto al nostro servizio Fedelta' ?
        <input type="submit"  value="Accedi"> </p>
        </form>
       

      </div>
    </div>
  </div>

<div class="booking-form-box">

<div class="booking-form">
<form action="pagamento_ok" method="post">

	<label>Nome Intestatario</label>
	<input type="text" class="form-control" name="nome">
	
	<label>Codice</label>
	<input type="text" class="form-control" name="cognome">
	
	<label>cvc</label>
	<input type="text" class="form-control" name="email">
	
	<div class="birth-date"><label>Data di Scadenza</label>
	<input type="date" class="form-control select-date" name="data"></div>
	

<input  type="submit" class="btn btn-primary flight"  value="Paga">
</form>
</div>
</div>

</body>
</html>