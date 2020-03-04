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