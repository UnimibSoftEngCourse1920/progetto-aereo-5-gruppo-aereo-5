<%@include file="../shared/flows-header.jsp" %>

<!DOCTYPE html>
<html>
<body>

 <div class="container">
			

    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Conferma Dati<br>
        </h1>

      </div>
    </div>
  </div>

<div class="booking-form-box">
		<div class="text-center">
			<h3>Nome : <strong>${registerModel.user.nome}</strong></h3>
			<h4>Cognome : <strong>${registerModel.user.lastName}</strong></h4>					
			<h4>Email : <strong>${registerModel.user.email}</strong></h4>
			<h4>Data di nascita : <strong>${registerModel.user.contactNumber}</strong></h4>
			<h4>Indirizzo di casa : <strong>${registerModel.user.role}</strong></h4>
			<p>
				<a href="${flowExecutionUrl}&_eventId_registrati" class="btn btn-primary">Modifica dati inseriti</a>
			</p>
		</div>
	</div>
<div class="booking-form-box">	
	<div class="col-sm-4 col-sm-offset-4">			
		<div class="text-center">				
			<a href="${flowExecutionUrl}&_eventId_registrazioneEffettuata" class="btn btn-lg btn-primary">Conferma</a>				
		</div>			
	</div>		
</div>

</body>
</html>
<%@include file="../shared/flows-footer.jsp"%>
