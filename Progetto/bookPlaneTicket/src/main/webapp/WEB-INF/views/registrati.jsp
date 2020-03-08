<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			

<!DOCTYPE html SYSTEM "about:legacy-compat">

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
 
      </div>
    </div>


<div class="booking-form-box">
	<div class="booking-form">
	<form action="registrazioneEffettuata" method="post" >
		<label >Nome</label>
		<input type="text" name="nome" class="form-control"placeholder="inserisci nome"/>
		<sf:errors path="nome" cssClass="help-block" element="em"/>
	 
		<label >Cognome</label>
		<input type="text" class="form-control" name="cognome" placeholder="inserisci cognome"/>
		<sf:errors path="cognome" cssClass="help-block" element="em"/>
	
		<label >E-Mail</label>
		<input type="text" class="form-control" name="email" placeholder="inserisci email"/>
		<sf:errors path="email" cssClass="help-block" element="em"/>
	
		<label >Data di nascita</label>
		<input type="date" class="form-control select-date" name="dataNascita" placeholder="Inserisci data di nascita"/>
		<sf:errors path="dataNascita" cssClass="help-block" element="em"/>
	
		<label >Indirizzo di casa</label>
		<input type="text" class="form-control" name="indirizzo" placeholder="Inserisci indirizzo"/>
		<sf:errors path="indirizzo" cssClass="help-block" element="em"/>
	
		<label >Password</label>
		<input type="password" class="form-control" name="password" />
		<sf:errors path="password" cssClass="help-block" element="em"/>
	
	<div class="form-group">
		<input  type="submit" class="btn btn-primary flight"  
		name="conferma" value="Conferma Credenziali" >		
		</div>
		</form>	
	</div> 
</div>
</div>

  </body>
  </html>
