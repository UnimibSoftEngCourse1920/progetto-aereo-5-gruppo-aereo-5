package gruppoaereo5.bookPlaneTicket.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.FiltroDTO;
import gruppoaereo5.bookBackEnd.dto.VoloDTO;

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
		
	 	ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Accedi");
	 	mv.addObject("userClickAccedi",true);	
		return mv;
	}
	
	@PostMapping(value = "/listaVoli", consumes = MediaType.APPLICATION_JSON)
	public ModelAndView listaVoli(@RequestBody FiltroDTO filtro){
		
		List<VoloDTO> list = new ArrayList<>();
		VoloDTO volo = new VoloDTO();

		 volo.setCodice_volo("e1");
		 volo.setAereo("fisa");
		 volo.setCitta_partenza("Milano");
		 volo.setCitta_arrivo("Roma");

		 volo.setKmTratta(122.22);
		 volo.setPrezzo(33.3);
		 volo.setPuntiOttenuti(44);
		 
		 list.add(volo);
		
	 	ModelAndView mv = new ModelAndView("page");
	 	
	 	mv.addObject("title","Lista Voli");
	 	
	 	//passo lista voli
	 	mv.addObject("voli", list);
	 	
	 	mv.addObject("userClickMostraVoli",true);	
		return mv;
}

}