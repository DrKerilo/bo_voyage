package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Offre;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping("/OffreCTRL")
public class ClientOffreController {

	@Autowired
	private IOffreService offreService;

	@RequestMapping(value = "/{pId}")
	public ModelAndView afficheOffre(@PathVariable("pId") int id) {
		Offre offre = new Offre();
		offre.setId(id);
		offre = offreService.getOffrebyId(offre);

		return new ModelAndView("offreParticulier", "offre", offre);
	}

}
