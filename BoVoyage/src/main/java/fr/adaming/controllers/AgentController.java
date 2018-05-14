package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Reservation;
import fr.adaming.service.IReservationService;

@Controller
@RequestMapping("/agCTRL")
public class AgentController {
	
	@Autowired
	private IReservationService resService;
	
	
	@RequestMapping(value="/pageAccueil", method=RequestMethod.GET)
	public String afficheAccueil() {
		return "accueil";
	}

	// Méthode afficher la liste
	@RequestMapping(value = "/listeResa", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la méthode
		List<Reservation> listeResa = resService.getAllRes();

		return new ModelAndView("listeResa", "listeResas", listeResa);

	}
}
