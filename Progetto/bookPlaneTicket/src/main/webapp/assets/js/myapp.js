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
})