package gruppoaereo5.bookPlaneTicket.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.dao.PostoDAO;
import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Volo;

@Controller
public class PageController{

	
	@Autowired
	private VoloDAO voloDAO;
	
	@Autowired
	private PostoDAO postoDAO;
		
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(Model model){
		
		model.addAttribute("filtro", new Filtro());
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Home");
	 	mv.addObject("userClickHome",true);	
		return mv;
	}
	@RequestMapping(value = "/conferma")
	public ModelAndView conferma(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Conferma la Prenotazione");
	 	mv.addObject("userClickConfermaLaPrenotazione",true);	
		return mv;
	}
	
	@RequestMapping(value = "/registrati")
	public ModelAndView registrati(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Registrati al servizio");
	 	mv.addObject("userClickRegistrati",true);	
	 	
		return mv;
	}
	@RequestMapping(value = "/info")
	public ModelAndView info(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Informazioni sul sito");
	 	mv.addObject("userClickInfo",true);	
		return mv;
	}
	@RequestMapping(value = "/pagamento")
	public ModelAndView pagamento(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Pagamento");
	 	mv.addObject("userClickPaga",true);	
		return mv;
	}
	
	/*@RequestMapping(value = "/login_prova")
	public ModelAndView login_prova(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Logn prova");
	 	mv.addObject("userClickLoginProva",true);	
		return mv;
	}*/
	
	@RequestMapping(value = "/pagamentok")
	public ModelAndView pagamentok(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Pagamentok");
	 	mv.addObject("userClickPagamentok",true);	
		return mv;
	}
	@RequestMapping(value = "/accedi_o_prosegui")
	public ModelAndView accedi_o_prosegui(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","accedi_o_prosegui");
	 	mv.addObject("userClickAccedi_o_prosegui",true);	
		return mv;
	}
	@RequestMapping(value = "/registrazioneEffettuata")
	public ModelAndView registrazioneEffettuata(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Pagamento");
	 	mv.addObject("userClickRegistrazioneEffettuata",true);	
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error){
		ModelAndView mv = new ModelAndView("login");
	 	mv.addObject("title","Login");
	
	 	if(error!=null) {
			mv.addObject("message", "Username e Password non validi!");
		}
	 	
		return mv;
	}
	/*
	 * Pagina specifiche volo
	 * */
	@RequestMapping(value = "/show/{id}/volo")
	public ModelAndView showSingleVolo(@PathVariable String id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Volo volo = new Volo();
		volo = voloDAO.get(id);
		
		int postiDisponibili = postoDAO.listPostiLiberi(id).size();
		
		mv.addObject("title","Specifiche Volo");
		mv.addObject("volo", volo);
		mv.addObject("postiDisponibili", postiDisponibili);
		
	 	mv.addObject("userClickSpecificheVolo",true);	
		
		return mv;
	}

	@ModelAttribute("selectVoli")
	public List<Volo> getVoli(){
		return voloDAO.list();
	}

}