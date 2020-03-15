<!DOCTYPE html>
<p class="lead">Lista voli</p>
<div class="list-group">
	<c:forEach items="${voli}" var="volo">
		<p>${volo.codice_volo} ${volo.citta_partenza}</p>
	</c:forEach>

</div>
