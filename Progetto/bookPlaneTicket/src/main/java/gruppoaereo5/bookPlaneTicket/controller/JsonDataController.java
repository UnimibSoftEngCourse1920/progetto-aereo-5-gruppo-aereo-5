package gruppoaereo5.bookPlaneTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Filtro;
import gruppoaereo5.bookBackEnd.dto.Volo;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	Filtro filtroVolo = new Filtro();
	
	@Autowired
	private VoloDAO voloDAO;
	
	@RequestMapping("/voli")
	@ResponseBody
	public List<Volo> getVoli(){
	
		return voloDAO.listVoli(filtroVolo);
	}

	@RequestMapping(value = "/listaVoli")
	public ModelAndView listavoli(@ModelAttribute Filtro filtro,Model model){
		
		ModelAndView mv = new ModelAndView("page");
	 	mv.addObject("title","Lista Voli");
		
		if(filtro.getCittaPartenza()!=null && filtro.getCittaArrivo()!=null && filtro.getDataPartenza()!=null) {
			model.addAttribute("ricercaCittaPartenza", filtro.getCittaPartenza());
			model.addAttribute("ricercaCittaArrivo", filtro.getCittaArrivo());
			model.addAttribute("ricercaDataPartenza", filtro.getDataPartenza());
			
			filtroVolo.setCittaPartenza(filtro.getCittaPartenza());
			filtroVolo.setCittaArrivo(filtro.getCittaArrivo());
			filtroVolo.setDataPartenza(filtro.getDataPartenza());
		}else {
			model.addAttribute("ricercaCittaPartenza", filtroVolo.getCittaPartenza());
			model.addAttribute("ricercaCittaArrivo", filtroVolo.getCittaArrivo());
			model.addAttribute("ricercaDataPartenza", filtroVolo.getDataPartenza());
		}
		
	 	mv.addObject("userClickMostraVoli",true);	
	 	
		return mv;
	}
	
}
