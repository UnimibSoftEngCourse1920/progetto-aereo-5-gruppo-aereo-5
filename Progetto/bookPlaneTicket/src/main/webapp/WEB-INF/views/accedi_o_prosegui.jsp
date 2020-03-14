<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

	<body>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h1 class="mt-5">Accedi o Prosegui</h1>
					<p class="lead">Accedi se possiedi un account, oppure prosegui senza l'autenticazione. In questo modo però non potrai caricare i punti del viaggio</p>
				</div>
			</div>
		</div>
			<div class="booking-form"> 
				<div class="form-group">
      				<a class="btn btn-primary flight" href="${contextRoot}/login">Accedi</a>
				</div> 		
			</div> 	
			<div class="booking-form"> 
				<div class="form-group">
      				<a class="btn btn-primary flight" href="${contextRoot}/pagamento">Prosegui con il pagamento</a>	
			</div> 	
		</div> 	
	</body>
</html>