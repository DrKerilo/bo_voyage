package fr.adaming.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping("/agCTRL")
@Scope("session")
public class OffreController {
	
	@Autowired
	private IOffreService offreService;

	//le setter pour l'injection d�pendance
	
	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) { // sera lanc� � chque fois
													// qu'une date sera re�u
													// pour la transformer en
													// date java util
		// l'objet webdatabinder sert � faire le lien entre les params de la
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		// la methode register sert � convertir le parametre recu par au type de
		// l'attribut

		// l'objet customDateEditor sert � lier la date re�ue comme param de la
		// requete � l'attribut de l'objet etudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}
	
	// AFFICHE LISTE
	@RequestMapping(value = "/listeO", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la m�thode service pour r�cup�rer la liste
		List<Offre> listeOffre = offreService.getAlloffres();

		return new ModelAndView("accueilOffre", "listeOffres", listeOffre);
	}
	
}
