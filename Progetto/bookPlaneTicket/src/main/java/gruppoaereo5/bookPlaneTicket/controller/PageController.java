package gruppoaereo5.bookPlaneTicket.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Volo;

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
	@RequestMapping(value = "/pagamento")
	public ModelAndView pagamento(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Pagamento");
	 	mv.addObject("userClickPaga",true);	
		return mv;
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("login");
	
		
	 	mv.addObject("title","Login");
	
		return mv;
	}
	@RequestMapping(value = "/listaVoli")
	public ModelAndView listavoli(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Lista Voli");
	 	
	 	mv.addObject("userClickMostraVoli",true);	
	 	
		return mv;
	}
	
	/*
	 * Pagina specifiche volo
	 * */
	@RequestMapping(value = "/show/{id}/volo")
	public ModelAndView showSingleVolo(@PathVariable String id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Volo volo = voloDAO.get(id);
		
		mv.addObject("title","Specifiche Volo");
		mv.addObject("volo", volo);
		
	 	mv.addObject("userClickSpecificheVolo",true);	
		
		return mv;
	}


}