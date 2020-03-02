<!DOCTYPE html SYSTEM "about:legacy-compat">
<html xmlns:th="https://www.thymeleaf.org">

  <body>
    <head>
  <title>Home</title>
  </head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 <div class="container">
    <div class="row">
      <div class="col-lg-12 text-center">
        <h1 class="mt-5">Cerca il tuo volo</h1>
        <p class="lead">Nonostante la minaccia del Covid-19 i voli non saranno annullati!</p>
        <ul class="list-unstyled">
        

        </ul>
      </div>
    </div>
  </div>

<div class="booking-form-box">




<div class="booking-form">

    <form action="listaVoli" method="post">
    	<p>Da: <input type="text" id="filtro_partenza" name="città_partenza" class="form-control" placeholder="Città o Aeroporto" th:field="*{id}" /></p>
       
        <p>A: <input type="text" id="filtro_arrivo" class="form-control" placeholder="Città o Aeroporto" th:field="*{content}" /></p>

<%-- 
	<label>Da</label>
	<form action="listaVoli.jsp" method="post">
	<input type="text" name="città_partenza" class="form-control" placeholder="Città o Aeroporto">
	</form>
	<label>A</label>
	<input type="text" class="form-control" placeholder="Città o Aeroporto">
	--%>
<div class="input-grp">
<label>Partenza</label>
<input type="date" id="filtro_data_partenza" class="form-control select-date">

</div>

<div class="input-grp">
<label>Ritorno</label>
<input type="date" id="filtro_data_ritorno" class="form-control select-date">
</div>

<div class="input-grp">
<label>Passeggeri</label>
<input type="number" id="nPasseggeri" class="form-control" value="1">
</div>



<button id="filtra_voli" class="btn btn-primary flight" value="Mostra voli"></button>
       </form> 
       </div>
       </div>
<script type="text/javascript">
	
 	$(document).ready(function() {
 		var base_url = window.location.host + "/bookPlaneTicket/";
 		var filtro = {};
 		var partenza = '';
 		
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
                data: JSON.stringify(partenza),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function() {
                    console.log("success");
                }
              });
 		});
 		
 	});
</script>
</body>
</html>