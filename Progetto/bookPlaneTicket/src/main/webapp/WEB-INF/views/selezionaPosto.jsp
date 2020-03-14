<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="booking-form-box form-check">

	<div class="row">

		<div>
			<sf:form id="form" action="${contextRoot}/prenota" modelAttribute="postoSelezionato" method="post">
				<div class="row">
					<div class="col">

						<h3>
							<strong>Scegli il tuo posto:</strong>
						</h3>
					</div>
					<div class="col">
						
						<c:forEach items="${posti}" var="posto">

							<div class="form-check">

								<sf:radiobutton path="idPosto" value="${posto.idPosto}" id="${posto.idPosto}" required="true"/>
								<label for="${posto.idPosto}">${posto.fila} - ${posto.lettera}</label>

							</div>

						</c:forEach>
					</div>
				</div>

				<div class="row">

					<label>Inserisci la tua e-mail: </label><input type="email"
						name="email" required="true"/>

				</div>
				<div class="row">
					<div class="col">
						<a href="${contextRoot}/show/${posti[1].volo}/volo"
							class="btn btn-warning">Torna indietro</a>
					</div>
					<div class="col">
						<input type="submit" value="Prenota"
							class="btn btn-primary flight">
					</div>
				</div>
				<sf:hidden path="fila"/>
				<sf:hidden path="lettera"/>
				<sf:hidden path="prenotazione"/>
				<sf:hidden path="volo"/>

			</sf:form>
		</div>

	</div>

</div>