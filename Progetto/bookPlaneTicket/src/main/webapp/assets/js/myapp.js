$(function() {
		switch(menu) {
		case 'Registrati al servizio':
			$('#registrati').addClass('active');
			break
		case 'Conferma la Prenotazione':
			$('#conferma').addClass('active');
			break
		case 'Informazioni sul sito':
			$('#info').addClass('active');
			break
		default:
			$('#home').addClass('active');
			break
		}


		
/*jquery dataTable*/
		
	
		var $table = $('#voloListTable');
		
		if($table.length){
			//console.log('Inside the table!');
			
			var jsonUrl = window.contextRoot +  '/json/data/voli';
			
			$table.DataTable({
				lengthMenu : [[3,5,10,-1], ['3','5','10','Tutti']],
				pageLength : 5,
				ajax: {
					url: jsonUrl,
					dataSrc: ''
				},
				columns: [
					
					{
						data: 'aereo'
					},
					{
						data: 'citta_partenza',
						bSortable: false
					},
					{
						data: 'citta_arrivo',
						bSortable: false
					},
					{
						data: 'ora_partenza'
					},
					{
						data: 'ora_arrivo'
					},
					{
						data: 'prezzo',
						mRender: function(data, type, row){
							return '&euro; ' + data
						}
					},
					{
						data: 'codice_volo',
						bSortable: false,
						mRender: function(data, type, row){
								
							var str ='';
							str += '<a href="'+ window.contextRoot+ '/show/'+data+'volo" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
							
							return str;
						}
					}
				]
			});
		}
		
		
/*Vlidazione jquery*/
		
		function errorPlacement(error, element) {
			// Add the 'help-block' class to the error element
			error.addClass("help-block");
			
			// add the error label after the input element
			error.insertAfter(element);
			
			
			// add the has-feedback class to the
			// parent div.validate in order to add icons to inputs
			element.parents(".validate").addClass("has-feedback");	

		}	
		
/*----*/
		
		$alert = $('.alert');
		if($alert.length) {
			setTimeout(function() {
		    	$alert.fadeOut('slow');
			   }, 3000
			);		
		}
			
		
/*Validare loginform*/

	$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Inserisci la tua email!',
						email: 'Inserisci un indirizzo email valido!'
					},
					password: {
						required: 'Inserisci la tua password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
})