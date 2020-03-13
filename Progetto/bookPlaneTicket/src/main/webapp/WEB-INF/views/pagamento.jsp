<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

  <body>
  <%
  	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	String devoRimuoverePunti= "";
	String devoAggiungerePunti = "";
	
	
	
	
	int kmvolo= 0;// kmInDatabase - kmVolo solo se kmInDatabase > 10000;
	
	if(id!= null){ 
	devoAggiungerePunti="si";
	devoRimuoverePunti= "no";
	%>		
			<div class="booking-form">
				<form action="<%=request.getContextPath()%>/aggiornaCartaFedele"  method="post">
				
					<input type="hidden"  name="id" placeholder="idfedele" value="<%=request.getParameter("id")%>">									
					<input type="hidden"  name="kmvolo" placeholder="idfedele" value=<%=kmvolo%>   >
					<input  type="submit" class="btn btn-primary flight"  value="Paga con carta Fedeltà">
					<h4 class="mt-5" align="center">Altrimenti... </h4>
				</form>
			</div>	
						
		<form method="post" action="pagamentok"> 
			<%session.setAttribute("pagafedele", id); 
			  session.setAttribute("devoAggiungerePunti", devoAggiungerePunti);%>    
		</form>
	<% 
	}
	else{ 
	id="null" ;
	devoAggiungerePunti = "no";
	devoRimuoverePunti= "no";
	%>	
		<form method="post" action="pagamentok"> 
			<%session.setAttribute("pagafedele", id); 
		      session.setAttribute("devoAggiungerePunti", devoAggiungerePunti);
			  session.setAttribute("devoRimuoverePunti", devoRimuoverePunti);%>    
		</form>		
      	<div class="booking-form">
      		<h3 class="mt-5" align="center">Accedi al servizio fedeltà<br> </h3>
      		<a class="btn btn-primary flight" href="${contextRoot}/login_prova">Accedi</a>
		</div>		
<% 		
	}
  
 %> 
  
  <head>
  <title> Pagamento</title>
  </head>
 <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Effettua pagamento con carta di credito </h1>
      </div>
    </div>
  </div>

	<div class="booking-form-box">
		<div class="booking-form">
			<form action="pagamentok" method="post">

				<label>Nome Intestatario</label>
					<input type="text" class="form-control" name="nome">
	
				<label>Codice</label>
					<input type="text" class="form-control" maxlength="16" name="codice" placeholder="0000 0000 0000 0000">
	
				<label>cvc</label>
					<input type="text" class="form-control" maxlength="3" name="cvc" placeholder="000">
	
				<div class="birth-date"><label>Data di Scadenza</label>
					<input type="date" class="form-control select-date" name="data"></div>
				<input  type="submit" class="btn btn-primary flight"  value="Paga">

				</form>
			</div>
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	</body>
</html>



