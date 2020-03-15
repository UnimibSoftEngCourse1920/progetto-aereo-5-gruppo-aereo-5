package gruppoaereo5.bookPlaneTicket.controller;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.config.SendEmail;
import gruppoaereo5.bookBackEnd.dao.PostoDAO;
import gruppoaereo5.bookBackEnd.dao.PrenotazioneDAO;
import gruppoaereo5.bookBackEnd.dao.UserDAO;
import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Posto;
import gruppoaereo5.bookBackEnd.dto.Prenotazione;
import gruppoaereo5.bookBackEnd.dto.User;
import gruppoaereo5.bookBackEnd.dto.Volo;

@Controller
public class PageController {

	@Autowired
	private VoloDAO voloDAO;

	@Autowired
	private PostoDAO postoDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PrenotazioneDAO prenotazioneDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index(@RequestParam(name = "ok", required = false) String result,@RequestParam(name = "errore", required = false) String error, Model model) {

		model.addAttribute("filtro", new Filtro());

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		System.out.println(result);
		if (result != null) {
			mv.addObject("prenotato",
					"Prenotazione avvenuta con successo, il codice prenotazione ti è stato inviato via e-mail");
		}
		if (error != null) {
			mv.addObject("errore",
					"Prenotazione annullata, hai gia effettuato una prenotazione per questo volo");
		}

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/conferma")
	public ModelAndView conferma() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Conferma la Prenotazione");
		mv.addObject("userClickConfermaLaPrenotazione", true);
		return mv;
	}

	@RequestMapping(value = "/registrati")
	public ModelAndView registrati() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Registrati al servizio");
		mv.addObject("userClickRegistrati", true);

		return mv;
	}

	@RequestMapping(value = "/info")
	public ModelAndView info() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Informazioni sul sito");
		mv.addObject("userClickInfo", true);
		return mv;
	}

	@RequestMapping(value = "/pagamento")
	public ModelAndView pagamento() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Pagamento");
		mv.addObject("userClickPaga", true);
		return mv;
	}

	@RequestMapping(value = "/pagamentok")
	public ModelAndView pagamentok() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Pagamentok");
		mv.addObject("userClickPagamentok", true);
		return mv;
	}

	@RequestMapping(value = "/accedi_o_prosegui")
	public ModelAndView accedi_o_prosegui() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "accedi_o_prosegui");
		mv.addObject("userClickAccedi_o_prosegui", true);
		return mv;
	}

	@RequestMapping(value = "/registrazioneEffettuata")
	public ModelAndView registrazioneEffettuata() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Pagamento");
		mv.addObject("userClickRegistrazioneEffettuata", true);
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("userClickAccedi", true);
		mv.addObject("title", "Login");

		if (error != null) {
			mv.addObject("message", "Username e Password non validi!");
		}

		return mv;
	}

	/*
	 * Pagina specifiche volo
	 */
	@RequestMapping(value = "/show/{id}/volo")
	public ModelAndView showSingleVolo(@PathVariable String id) {

		ModelAndView mv = new ModelAndView("page");

		Volo volo = new Volo();
		volo = voloDAO.get(id);

		int postiDisponibili = postoDAO.listPostiLiberi(id).size();

		mv.addObject("title", "Specifiche Volo");
		mv.addObject("volo", volo);
		mv.addObject("postiDisponibili", postiDisponibili);

		mv.addObject("userClickSpecificheVolo", true);

		return mv;
	}

	@ModelAttribute("selectVoli")
	public List<Volo> getVoli() {
		
		return voloDAO.list();
	}
	
	@RequestMapping(value = "/{id}/selezionaPosto")
	public String selezionaPosto(@PathVariable String id) {

		return "redirect:/scegliIlTuoPosto/{id}";
	}

	@RequestMapping(value = "/scegliIlTuoPosto/{id}")
	public ModelAndView selezionaPosto(@PathVariable String id, Model model) {

		model.addAttribute("postoSelezionato", new Posto());

		ModelAndView mv = new ModelAndView("page");

		List<Posto> posti = new ArrayList<>();

		posti = postoDAO.listPostiLiberi(id);
		System.out.println("SELEZIONA POSTO");
		mv.addObject("title", "Seleziona posto");

		mv.addObject("posti", posti);

		mv.addObject("userClickSelezionaPosto", true);

		return mv;
	}

	@RequestMapping(value = "/prenota")
	public String prenota(@ModelAttribute Posto postoSelezionato, HttpServletRequest request, Model model) {

		String email = request.getParameter("email");
		Posto posto = postoDAO.get(postoSelezionato.getIdPosto());
		Prenotazione prenotazione = new Prenotazione();
		SendEmail sm = new SendEmail();

		// Setta utente e controlla se ha gia effettuato una prenotazione
		User user = userDAO.getUserByEmail(email);
		if (user == null) {
			user = new User(email);
			userDAO.saveUser(user);
			prenotazione.setUtente(userDAO.getUserByEmail(email).getId());
		} else if(prenotazioneDAO.controlloPrenotazioni(user.getId(),posto.getVolo()) == false)
					prenotazione.setUtente(user.getId());
		else {
			String response = "errore";
			return "redirect:/home?" + response;
		}
		
		// Setta codice prenotazione
		String random = generaStringaRandom();
		prenotazione.setCodicePrenotazione(random);

		// Setta data prenotazione
		Date dataOggi = new Date();
		DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		String data = formatoData.format(dataOggi);
		data = splitData(data, "/", "-");
		prenotazione.setDataPrenotazione(data);

		// Setta data scadenza
		Volo volo = new Volo();
		volo = voloDAO.get(posto.getVolo());
		String dataPartenza = volo.getData_partenza();
		dataPartenza = splitData(dataPartenza, "-", "/");
		prenotazione.setDataScadenza(calcolaDataScadenza(dataPartenza));

		// Setta penale
		prenotazione.setPenaleModifica(5.0);

		//registra prenotazione
		prenotazioneDAO.savePrenotazione(prenotazione);
		
		// Setta prenotazione in posto
		posto.setPrenotazione(random);
		postoDAO.update(posto);

		String response = "ok";

		sm.sendEmailPrenotazione(email, random);

		return "redirect:/home?" + response;
	}

	private String generaStringaRandom() {
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = lower.toUpperCase();
		String numeri = "0123456789";
		String perRandom = upper + lower + numeri;
		int lunghezzaRandom = 4;

		SecureRandom sr = new SecureRandom();
		StringBuilder sb = new StringBuilder(lunghezzaRandom);
		for (int i = 0; i < lunghezzaRandom; i++) {
			int randomInt = sr.nextInt(perRandom.length());
			char randomChar = perRandom.charAt(randomInt);
			sb.append(randomChar);
		}
		return sb.toString();
	}

	private String splitData(String stringa, String separatoreIniziale, String separatoreFinale) {

		String[] arrOfStr = stringa.split(separatoreIniziale);

		stringa = "";
		for (int i = 2; i >= 0; i--) {
			stringa += arrOfStr[i];
			if (i >= 1)
				stringa += separatoreFinale;
		}

		return stringa;
	}

	private String calcolaDataScadenza(String dataPartenza) {

		Date data = new Date();
		DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		try {
			formatoData.setLenient(false);
			data = formatoData.parse(dataPartenza);
		} catch (ParseException e) {
			System.out.println("Formato data non valido.");
		}

		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
		c.setTime(data);
		c.add(Calendar.DAY_OF_MONTH, -3);

		String dataScadenza = formatoData.format(c.getTime());
		dataScadenza = splitData(dataScadenza, "/", "-");

		return dataScadenza;
	}
}