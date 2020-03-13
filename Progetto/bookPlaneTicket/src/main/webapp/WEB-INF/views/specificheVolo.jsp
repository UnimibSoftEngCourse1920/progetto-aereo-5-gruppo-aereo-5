<div class="container">

	<div class="booking-form-box">
	
		<!-- Breadcrumb -->
		<div class="row">

				<div class="col-xs-12">
		
					<ol class="breadcrumb">
		
						<li><a href="${contextRoot}/json/data/listaVoli">Cerca
								Ancora</a></li>
						<li class="active">${volo.aereo}</li>
		
					</ol>
		
				</div>
			</div>
		<div class="booking-form">
			
			<h1><strong>Specifiche Volo</strong></h1>

			<div class="row">
				<h3>
				<label>Codice volo:	</label>
				${volo.codice_volo}
				</h3>
			</div>
			
			<div class="row">
				<div class="col">
					<div class="row">
						<h3><label>Da:	</label>
						${volo.citta_partenza}</h3>
					</div>	
				</div>
				<div class="col">
					<div class="row">
						<h3><label>A:	</label>
						${volo.citta_arrivo}</h3>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col">
				
					<div class="row">
						<h3>
							<label>Partenza:	</label>
							${volo.data_partenza}
							<label>	Alle:	</label>
							${volo.ora_partenza}
						</h3>
					</div>
					
				</div>
				<div class="col">
				
					<div class="row">
						<h3>
							<label>Arrivo:	</label>
							${volo.data_arrivo}
							<label>	Alle:	</label>
							${volo.ora_arrivo}
						</h3>
					</div>
					
				</div>
			</div>
			
			<div class="row">
			
				<c:choose>
				
				<c:when test="${postiDisponibili < 1}">
				
					<h4><label>Posti disponibili: </label><span style="color:red">Volo completo!</span></h4>
					
				</c:when>
				<c:otherwise>				
					
					<h4><label>Posti disponibili:</label> ${postiDisponibili}</h4>
						
				</c:otherwise>
			
				</c:choose>
				
			</div>
			<div class="row">
				<h4>
				<label>Prezzo:	</label>
				&euro; ${volo.prezzo}
				</h4>
			</div>
			
			<div class="row">
			
				<c:choose>
				
				<c:when test="${postiDisponibili < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled">
					<span class="glyphicon glyphicon-shopping-cart"></span> Prenota</a>
					
				</c:when>
				<c:otherwise>				
				
				<a href="${contextRoot}/prenota" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span> Prenota</a>
	
				</c:otherwise>
			
				</c:choose>
			
			</div>
		</div>
	</div>
</div>