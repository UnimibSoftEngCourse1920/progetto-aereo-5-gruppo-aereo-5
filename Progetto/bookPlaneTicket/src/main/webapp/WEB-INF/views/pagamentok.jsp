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
	
	String devoRimuoverePunti = request.getParameter("devoRimuoverePunti");

  	String idfedele = session.getAttribute("pagafedele").toString();
  	String devoAggiungerePunti = session.getAttribute("devoAggiungerePunti").toString();

  	String kmvolo= "20";
  	out.println( " idfedele: " +idfedele + " devoAggiungerePunti " + devoAggiungerePunti+ " devoRimuoverePunti " + devoRimuoverePunti);
  	
  	if(!(idfedele.equals("null"))) {
  		if(devoRimuoverePunti!=null){
  			%>

  			<form action="<%=request.getContextPath()%>/aggiornaCartaFedele" method="post">				
					<input type="hidden"  name="idfedele" placeholder="idfedele" value=idfedele>	 
					<input type="hidden"  name="kmvolo" placeholder="idfedele" value=kmvolo>	 					
			</form>	
			<% 
  		  	out.println( "sono in rimuovi punti");

  		}
  		else{
  			if(nome != null){
  	  			if(nome.length()==0 || codice.length()!=16 || cvc.length()!=3 || data.length()!=10){
  	  				response.sendRedirect("pagamento");
  	  				return;
  	  			}
  	  			else {
  	  				out.println( "sono in aggiungi punti");
  	  				out.println( " Pagamento effettuato");		
  	  			}	
  	  		}
  			
  		}
  	}
  	else{
  		if(nome != null){
  			if(nome.length()==0 || codice.length()!=16 || cvc.length()!=3 || data.length()!=10){
  				response.sendRedirect("pagamento");
  				return;
  			}
  			else {
  				out.println( " Pagamento effettuato");		
  			}	
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