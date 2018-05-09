package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// afficher la page de login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String affichePageLogin() {
		return "loginPage";
	}
	
	// afficher un message d'erreur sur la page de login
	@RequestMapping(value="/loginEchec", method=RequestMethod.GET)
	public String afficheErreurLogin(ModelMap modele){
		modele.addAttribute("erreur", true);
		return "loginPage";
	}
	
	// affiche une page lorsuqe l'acces est refusé
	@RequestMapping(value="/accesDenied", method=RequestMethod.GET)
	public String affichePageDenied() {
		return "deniedPage";
	}
	
	// affiche une page lorsuqe l'acces est refusé
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String affichePageDeconnexion() {
		return "loginPage";
	}
}
