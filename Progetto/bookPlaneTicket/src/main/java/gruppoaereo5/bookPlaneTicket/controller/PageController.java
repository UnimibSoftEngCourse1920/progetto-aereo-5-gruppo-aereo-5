package gruppoaereo5.bookPlaneTicket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;

@Controller
public class PageController{

	@Autowired
	private VoloDAO voloDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
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
	@RequestMapping(value = "/listaVoli")
	public ModelAndView listaVoli(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Lista Voli");
	 	
	 	//passo lista voli
	 	mv.addObject("voli",voloDAO.list());
	 	
	 	mv.addObject("userClickMostraVoli",true);	
		return mv;
}
}