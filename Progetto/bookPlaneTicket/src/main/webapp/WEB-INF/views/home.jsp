<!DOCTYPE html SYSTEM "about:legacy-compat">
<html xmlns:th="https://www.thymeleaf.org">

  <body>
    <head>
  <title>Home</title>
  </head>
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



<div class="radio-btn">
	<input type="radio" class="btn" name="check"><span>Sola Andata</span>
	<input type="radio" class="btn" name="check" checked><span>Andata e Ritorno</span>
</div>
<div class="booking-form">

    <form action="listaVoli" method="post">
    	<p>Da: <input type="text" name="città_partenza" class="form-control" placeholder="Città o Aeroporto" th:field="*{id}" /></p>
        <p>A: <input type="text" class="form-control" placeholder="Città o Aeroporto" th:field="*{content}" /></p>

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
<input type="date" class="form-control select-date">

</div>

<div class="input-grp">
<label>Ritorno</label>
<input type="date" class="form-control select-date">
</div>

<div class="input-grp">
<label>Adulti</label>
<input type="number" class="form-control" value="1">
</div>

<div class="input-grp">
<label>Bambini</label>
<input type="number" class="form-control" value="0">
</div>

<input type="submit" class="btn btn-primary flight" value="Mostra voli">
       </form> 
</div>

</div>
</body>
</html>