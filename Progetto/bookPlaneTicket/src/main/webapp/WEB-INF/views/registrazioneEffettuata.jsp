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
     	   <h1 class="mt-5">Registrazione avvenuta con successo<br></h1>
      </div>
    </div>
  </div> 

	<div class="booking-form-box">
		<div class="booking-form"> 
			<h2 class="form-control" align="center">Ecco i dati che hai inserito:</h2>
			
				<a class="form-control">Nome: <% ;		
					out.println(request.getParameter("nome"));
 					%></a><br>
		 		<a class="form-control">Cognome: <% ;		
					out.println(request.getParameter("cognome"));
 					%></a><br>
				<a class="form-control">E-Mail: <% ;		
					out.println(request.getParameter("email"));
 					%></a><br>
				<a class="form-control">Data di nascita:<% ;		
					out.println(request.getParameter("datanascita"));
 					%></a><br> 
				<a class="form-control">Indirizzo di casa: <% ;		
					out.println(request.getParameter("indirizzo"));
 					%></a><br>
	
				<div class="form-group">
      				<a class="btn btn-primary flight" href="${contextRoot}/home">Torna alla HomePage</a>
				</div> 	
			</div> 	
		</div> 	
	</body>
</html>