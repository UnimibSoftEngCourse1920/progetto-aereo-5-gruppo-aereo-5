<%@include file="../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			


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
	<sf:form
				method="POST"
				modelAttribute="user"
				class="form-horizontal"
				id="registerForm"
						>
<div class="booking-form">
	<label >Nome</label>
	<sf:input type="text" class="form-control" path="nome" placeholder="inserisci nome"/>
	<sf:errors path="nome" cssClass="help-block" element="em"/>
	 
	<label >Cognome</label>
	<sf:input type="text" class="form-control" path="cognome" placeholder="inserisci cognome"/>
	<sf:errors path="cognome" cssClass="help-block" element="em"/>
	
	<label >E-Mail</label>
	<sf:input type="text" class="form-control" path="email" placeholder="inserisci email"/>
	<sf:errors path="email" cssClass="help-block" element="em"/>
	
	<div class="birth-date">
		<label >Data di nascita</label>
		<sf:input type="date" class="form-control select-date" path="dataNascita" placeholder="Inserisci data di nascita"/>
		<sf:errors path="dataNascita" cssClass="help-block" element="em"/>
	</div>
	
	<label >Indirizzo di casa</label>
	<sf:input type="text" class="form-control" path="indirizzo" placeholder="Inserisci indirizzo"/>
	<sf:errors path="indirizzo" cssClass="help-block" element="em"/>
	
	<label >Password</label>
	<sf:input type="password" class="form-control" path="password" />
	<sf:errors path="password" cssClass="help-block" element="em"/>
	
	<label >Conferma Password</label>
	<sf:input type="password" class="form-control" path="confermaPassword" placeholder="Conferma password"/>
	<sf:errors path="confermaPassword" cssClass="help-block" element="em"/>

<div class="form-group">
<button  type="submit" class="btn btn-primary flight"  
		name="_eventId_conferma" >
	Conferma <span class="glyphicon glyphicon-chevron-right"></span>
</button>
</div>
</div> 

</sf:form>	
</div>
  </div>
<%@include file="../shared/flows-footer.jsp" %>
