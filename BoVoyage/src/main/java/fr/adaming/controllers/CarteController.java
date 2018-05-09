package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/carteCTRL")
public class CarteController {

	@RequestMapping(value = "/carteMonde", method = RequestMethod.GET)
	public String affichePageClientCarte() {
		return "carteMonde";
	}

}
