<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

  <body>
  
<%--
	try{
		String utente = request.getParameter("utente");
		String codiceprenotazione = request.getParameter("codiceprenotazione");
		String dbUtente = null;
		String dbCodiceprenotazione = null;
				
		
		String sql = "select codiceprenotazione, utente from prenotazione where utente=? and codiceprenotazione=?";
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:./localhost/~/bookPlaneTicket;DB_CLOSE_DELAY=-1", "gruppo5", "progetto");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, utente);
		ps.setString(2, codiceprenotazione);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			dbUtente = rs.getString("utente");
			dbCodiceprenotazione=rs.getString("codiceprenotazione");
		}
		//out.println( dbUtente +" :utente,codice: "+dbCodiceprenotazione);

		if(utente.equals(dbUtente) && codiceprenotazione.equals(dbCodiceprenotazione)){
			out.println( "Prenotazione Trovata");

		}
		else {
			response.sendRedirect("conferma");
			return;
		}
	}

	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch (SQLException e) {
	e.printStackTrace();
}

--%>
  
  
  <head>
  <title> Pagamento</title>
  </head>
 <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Effettua pagamento con carta di credito<br> </h1>
        <form action="login" method="post">
        <p class="lead">Sei iscritto al nostro servizio Fedelta' ?
        <input type="submit"  value="Accedi"> </p>
        </form>
       

      </div>
    </div>
  </div>

<div class="booking-form-box">

<div class="booking-form">
<form action="pagamento_ok" method="post">

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