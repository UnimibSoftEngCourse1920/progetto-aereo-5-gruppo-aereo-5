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
        <h1 class="mt-5">Registrazione avvenuta con successo<br>
        </h1>
    
      
 
      </div>
    </div>
  </div> 

<%
	try{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String datanascita = request.getParameter("dataNascita");	
		String indirizzo = request.getParameter("indirizzo");
		String password = request.getParameter("password");
		String ultimoAcquisto = "2020-09-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String infedele = "0";
		
		
		String sql = "INSERT INTO UTENTE(EMAIL, NOME, COGNOME, DATANASCITA, INDIRIZZOCASA, PASSWORD, INFEDELE) values(?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:./localhost/~/bookPlaneTicket;DB_CLOSE_DELAY=-1", "gruppo5", "progetto");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, nome);
		ps.setString(3, cognome);
		ps.setString(4, indirizzo);
		ps.setString(5, password);
		ps.setString(6, infedele);
		ps.executeUpdate();
		out.println("  "+ nome + ", Grazie per esserti registrato");
	}

	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch (SQLException e) {
	e.printStackTrace();
}

%>
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
		out.println(request.getParameter("indirizzo"));
 		%></a><br> 
		<a class="form-control">Indirizzo di casa: <% ;		
		out.println(request.getParameter("indirizzo"));
 		%></a><br>
	
	<div class="form-group">
      <a class="btn btn-primary flight" href="${contextRoot}/home">Torna alla HomePage</a>
		</div> 	</div> 	</div> 	
</body>
</html>