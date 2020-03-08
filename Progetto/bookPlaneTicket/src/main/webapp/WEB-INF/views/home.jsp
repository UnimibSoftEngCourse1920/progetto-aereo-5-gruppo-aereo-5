<!DOCTYPE html SYSTEM "about:legacy-compat">
<%@ page import="java.sql.*" %>
<%@page import="java.io.*, java.util.Date,  java.text.SimpleDateFormat, java.util.Enumeration" %> <html xmlns:th="https://www.thymeleaf.org">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<body>

<%
	try{
		if(request.getParameter("nome")!= "null"){
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String datanascita = request.getParameter("dataNascita");	
		String indirizzo = request.getParameter("indirizzo");
		String password = request.getParameter("password");
		String ultimoAcquisto = "2020-09-09";
		
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
		out.println("Registrazione avvenuta con successo");

	}
}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch (SQLException e) {
	e.printStackTrace();
}


%>
<%--
		try {
		String sql = "INSERT INTO UTENTE(EMAIL, NOME, COGNOME, DATANASCITA, INDIRIZZOCASA, PASSWORD, INFEDELE) values(?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection("jdbc:h2:./localhost/~/bookPlaneTicket;DB_CLOSE_DELAY=-1", "gruppo5", "progetto");
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "34");
		ps.setString(2, "st2e");
		ps.setString(3, "st3e");
		
		
		
		ps.setString(4, "st4e");
		ps.setString(5, "s5te");
		ps.setString(6, "0");
		ps.executeUpdate();
		System.out.println("Registrazione avvenuta con successo");
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
--%>
<head>
<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h1 class="mt-5">Cerca il tuo volo</h1>
			<p class="lead">Nonostante la minaccia del Covid-19 i voli non
				saranno annullati!</p>
			<ul class="list-unstyled">


			</ul>
		</div>
	</div>
</div>

<div class="booking-form-box">




	<div class="booking-form">

		<form action="listaVoli" method="post" accept-charset=utf-8>
			<p>
				Da: <input type="text" id="filtro_partenza" name="città_partenza"
					class="form-control" placeholder="Città o Aeroporto"
					th:field="*{id}" />
			</p>

			<p>
				A: <input type="text" id="filtro_arrivo" class="form-control"
					placeholder="Città o Aeroporto" th:field="*{content}" />
			</p>

			<div class="input-grp">
				<label>Data di Partenza</label> <input type="date" id="filtro_data_partenza"
					class="form-control select-date">

			</div>
			<button id="filtra_voli" class="btn btn-primary flight">
				Mostra voli</button>
		</form>
	</div>
</div>
<!--<script type="text/javascript">
	
 	$(document).ready(function() {
 		var base_url = window.location.host + "/bookPlaneTicket/";
 		var filtro = {};
 		var partenza = '';
 		var token = $("meta[name='_csrf']").attr("content");
 		
 		$('#filtra_voli').on('click', function() {
 			partenza = $('#filtro_partenza').val();
 			arrivo = $('#filtro_arrivo').val();
 			data_partenza = $('#filtro_data_partenza').val();
 			data_ritorno = $('#filtro_data_ritorno').val();
 			nPasseggeri = $('#nPasseggeri').val();
 			
 			filtro.partenza=partenza;
 			filtro.arrivo=arrivo;
 			filtro.dataPartenza=data_partenza;
 			filtro.dataRitorno=data_ritorno;
 			filtro.nPasseggeri=nPasseggeri;
 			
 			console.log(filtro);
 			
 			$.ajax({
                type: "POST",
                url: base_url + "listaVoli",
                data: JSON.stringify(filtro),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                
                beforeSend: function(xhr) {
                    xhr.setRequestHeader('X-CSRF-TOKEN', token)
                success: function() {
                    console.log("success");
                }
              });
 		});
 		
 	});
</script>  -->
</body>
</html>