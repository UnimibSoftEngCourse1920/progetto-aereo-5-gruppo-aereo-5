<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">

<body>  
<%	
	String nome = request.getParameter("nome");
	String codice = request.getParameter("codice");
	String cvc = request.getParameter("cvc");
	String data = request.getParameter("data");
	
  		if(nome != null){
  			if(nome.length()==0 || codice.length()!=16 || cvc.length()!=3 || data.length()!=10){
  				response.sendRedirect("pagamento");
  				return;
  			}
  			else {
  				out.println( " Pagamento effettuato");		
  			}	
  		}  	 	
%>
	<head>
  		<title> Pagamentok</title>
	</head>
  	<div class="container">
   	 <div class="row">
    	  <div class="col-lg-12 text-center">
     	   <h1 class="alert alert-success" style="text-align:center">Pagamento Avvenuto con successo<br> </h1>
      	   <p class="lead">A breve riceverai una mail con tutte le informazioni sul volo acquistato</p>
           </div>        
      	  </div>
		</div>
   </body>
</html>