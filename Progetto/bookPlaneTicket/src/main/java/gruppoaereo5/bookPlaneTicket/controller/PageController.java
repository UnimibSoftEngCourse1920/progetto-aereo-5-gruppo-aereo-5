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
	@RequestMapping(value = "/conferma")
	public ModelAndView conferma(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Conferma la Prenotazione");
	 	mv.addObject("userClickConfermaLaPrenotazione",true);	
		return mv;
	}
	@RequestMapping(value = "/register")
	public ModelAndView register(){
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Registrati al servizio");
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
	
	


}