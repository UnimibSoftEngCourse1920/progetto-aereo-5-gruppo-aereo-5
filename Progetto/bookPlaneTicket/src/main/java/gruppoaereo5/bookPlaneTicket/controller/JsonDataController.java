package gruppoaereo5.bookPlaneTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gruppoaereo5.bookBackEnd.dao.VoloDAO;
import gruppoaereo5.bookBackEnd.dto.Volo;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private VoloDAO voloDAO;
	
	@RequestMapping("/voli")
	@ResponseBody
	public List<Volo> getVoli(){
		
		return voloDAO.listVoli();
	}

}
