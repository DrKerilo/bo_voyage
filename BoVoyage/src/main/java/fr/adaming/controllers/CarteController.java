package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Offre;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping("/carteCTRL")
public class CarteController {

	@Autowired
	private IOffreService offreService;

	// Controller carte
	@RequestMapping(value = "/carteMonde", method = RequestMethod.GET)
	public String affichePageClientCarte() {
		return "carteMonde";
	}

	@RequestMapping(value = "/listeNorthAmerica", method = RequestMethod.GET)
	public ModelAndView affichelisteNorthAmerica() {
		List<Offre> liste = offreService.getAlloffresNorthAmerica();
		return new ModelAndView("OffreNorthAmerica", "listeNA", liste);
	}

	@RequestMapping(value = "/listeSouthAmerica", method = RequestMethod.GET)
	public ModelAndView affichelisteSouthAmerica() {
		List<Offre> liste = offreService.getAlloffresSouthAmerica();
		return new ModelAndView("OffreSouthAmerica", "listeSA", liste);
	}

	@RequestMapping(value = "/listeEurope", method = RequestMethod.GET)
	public ModelAndView affichelisteEurope() {
		List<Offre> liste = offreService.getAlloffresEurope();
		return new ModelAndView("OffreEurope", "listeEur", liste);
	}

	@RequestMapping(value = "/listeAfrica", method = RequestMethod.GET)
	public ModelAndView affichelisteAfrica() {
		List<Offre> liste = offreService.getAlloffresAfrica();
		return new ModelAndView("OffreAfrica", "listeAfr", liste);
	}

	@RequestMapping(value = "/listeNorthAfrica", method = RequestMethod.GET)
	public ModelAndView affichelisteNorthAfrica() {
		List<Offre> liste = offreService.getAlloffresNorthAfrica();
		return new ModelAndView("OffreNorthAfrica", "listeNAfr", liste);
	}

	@RequestMapping(value = "/listeAsia", method = RequestMethod.GET)
	public ModelAndView affichelisteAsia() {
		List<Offre> liste = offreService.getAlloffresAsia();
		return new ModelAndView("OffreAsia", "listeAs", liste);
	}

	@RequestMapping(value = "/listeOffres", method = RequestMethod.GET)
	public ModelAndView affichelisteOffres() {
		List<Offre> liste = offreService.getAlloffres();
		return new ModelAndView("OffreToutes", "listeToutes", liste);
	}

}
