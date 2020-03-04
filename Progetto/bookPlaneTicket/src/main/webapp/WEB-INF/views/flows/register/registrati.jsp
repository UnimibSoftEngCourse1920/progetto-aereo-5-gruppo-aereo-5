<%@include file="../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			

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
	<sf:form
				method="POST"
				modelAttribute="user"
				class="form-horizontal"
				id="registerForm"
						>
<div class="booking-form">
<form action="reg" method="post">
	<label>Nome</label>
	<sf:input type="text" class="form-control" path="nome" placeholder="inserisci nome"/>
	
	<label>Cognome</label>
	<sf:input type="text" class="form-control" path="cognome" placeholder="inserisci cognome"/>
	
	<label>E-Mail</label>
	<sf:input type="text" class="form-control" path="email" placeholder="inserisci email"/>
	
	<div class="birth-date"><label>Data di nascita</label>
	<sf:input type="date" class="form-control select-date" path="data" placeholder="inserisci data di nascita"/></div>
	
	<label>Indirizzo di casa</label>
	<sf:input type="text" class="form-control" path="indirizzo" placeholder="inserisci indirizzo"/>
	
	<label>Password</label>
	<sf:input type="password" class="form-control" path="pwd" placeholder="password"/>
	
	<label>Conferma Password</label>
	<sf:input type="password" class="form-control" path="pwdC" placeholder="password"/>


<button  type="submit" class="btn btn-primary flight"  
		name="_eventiId_billing" value="Registrati">
</button>
</form>
</div> 	
</sf:form>	
</div>

</body>
</html>
<%@include file="../shared/flows-footer.jsp" %>
