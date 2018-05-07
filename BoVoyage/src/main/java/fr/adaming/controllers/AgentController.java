package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/agCTRL")
public class AgentController {
	
	@RequestMapping(value="/pageAccueil", method=RequestMethod.GET)
	public String afficheAccueil() {
		return "accueil";
	}

}
