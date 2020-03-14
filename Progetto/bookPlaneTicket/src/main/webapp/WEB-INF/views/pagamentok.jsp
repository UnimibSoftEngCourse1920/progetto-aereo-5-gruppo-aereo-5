<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<body>  
<%	
	String nome = request.getParameter("nome");
	String codice = request.getParameter("codice");
	String cvc = request.getParameter("cvc");
	String data = request.getParameter("data");
	
  	String idfedele = session.getAttribute("pagafedele").toString();

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
     	   <h1 class="mt-5">Pagamento Avvenuto con successo<br> </h1>
      	   <p class="lead">A breve riceverai una mail con tutte le informazioni sul volo acquistato</p>
           </div>        
      	  </div>
		</div>
   </body>
</html>