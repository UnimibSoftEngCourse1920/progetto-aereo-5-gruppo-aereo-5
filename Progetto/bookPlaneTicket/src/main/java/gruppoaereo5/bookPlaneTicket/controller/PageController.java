package gruppoaereo5.bookPlaneTicket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController{

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Home");
	 	mv.addObject("userClickHome",true);	
		return mv;
	}
	@RequestMapping(value = "/accedi")
	public ModelAndView accedi(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Accedi al servizio");
	 	mv.addObject("userClickAccedi",true);	
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
}