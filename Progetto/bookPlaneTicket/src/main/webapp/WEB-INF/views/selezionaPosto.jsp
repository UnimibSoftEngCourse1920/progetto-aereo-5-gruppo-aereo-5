<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="booking-form-box">
	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/show/${posti[1].volo}/volo">Torna indietro</a></li>
				<li class="active">${posti[1].volo}</li>

			</ol>

		</div>
	</div>
	<div class="row">

			<sf:form id="form" action="${contextRoot}/prenota"
				modelAttribute="postoSelezionato" style="width:100%" method="post">
				<div class="row" style="margin-left:30px">
					<div class="col">

						<h3>
							<strong>Scegli il tuo posto:</strong>
						</h3>
					</div>
					<div class="col">

						<c:forEach items="${posti}" var="posto">

							<div class="form-check">

								<sf:radiobutton path="idPosto" value="${posto.idPosto}"
									id="${posto.idPosto}" required="true" />
								<label for="${posto.idPosto}">${posto.fila} -
									${posto.lettera}</label>

							</div>

						</c:forEach>
					</div>
				</div>

				<div class="row" style="margin-left:30px">

					<label>Inserisci la tua e-mail:	</label><input type="email"
						name="email" style="margin-left:10px" required="true"/>

				</div>
				<div class="row" style="margin-left:30px;margin-right:30px;margin-top:15px;margin-bottom:15px">
					
						<input type="submit" value="Prenota" class="btn btn-primary flight">
					
				</div>
				<sf:hidden path="fila" />
				<sf:hidden path="lettera" />
				<sf:hidden path="prenotazione" />
				<sf:hidden path="volo" />

			</sf:form>

	</div>

</div>