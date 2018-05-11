package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IOffreService;

@Controller
@RequestMapping("/agCTRL")
@Scope("session")

public class OffreController {

	@Autowired
	private IOffreService offreService;

	// le setter pour l'injection dépendance

	public void setOffreService(IOffreService offreService) {
		this.offreService = offreService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) { // sera lancé à chque fois
													// qu'une date sera reçu
													// pour la transformer en
													// date java util
		// l'objet webdatabinder sert à faire le lien entre les params de la
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		// la methode register sert à convertir le parametre recu par au type de
		// l'attribut

		// l'objet customDateEditor sert à lier la date reçue comme param de la
		// requete à l'attribut de l'objet etudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// AFFICHE LISTE
	@RequestMapping(value = "/listeO", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la méthode service pour récupérer la liste
		List<Offre> listeOffre = offreService.getAlloffres();

		return new ModelAndView("accueilOffre", "listeOffres", listeOffre);
	}

	// AJOUTER UN OFFRE
	// AFFICHER LE FORMULAIRE

	@RequestMapping(value = "/afficheAjoutO", method = RequestMethod.GET)
	public ModelAndView afficheFormAjoutO() {
		return new ModelAndView("ajoutOffre", "oAjout", new Offre());
	}

	// SOUMETTRE LE FORMULAIRE
	@RequestMapping(value = "/soumettreAjoutO", method = RequestMethod.POST)
	public String soumettreFormAjoutO(ModelMap model, @ModelAttribute("oAjout") Offre o) {

		// appel de la methode
		Offre oOut = offreService.addOffre(o);

		if (oOut.getId() != 0) {
			return "redirect:listeO";
		} else {
			return "redirect:afficheAjoutO";
		}

	}

	// MODIFIER UNE OFFRE
	// afficher un fomulaire de modification
	@RequestMapping(value = "/affichModifO", method = RequestMethod.GET)
	public String afficheFormModif(Model modele, @ModelAttribute("oModif") Offre o) {

		modele.addAttribute("oModif", new Offre());
		String idPage = "modifO";

		return idPage;
	}

	// soumettre un formulaire
	@RequestMapping(value = "/soumettreModifO", method = RequestMethod.POST)
	public String soumettreFormModif(ModelMap modele, @ModelAttribute("oModif") Offre o) {
		// modifier le vol
		Offre omod = offreService.updateOffre(o);
		if (omod.getId() != 0) {

			return "redirect:listeO";
		} else {
			return "redirect:affichModifO";
		}

	}

	// SUPPRIMER UNE OFFRE
	// afficher le formulaire de suppression
	@RequestMapping(value = "/afficheSupprO", method = RequestMethod.GET)
	public ModelAndView afficheFormSuppr() {
		return new ModelAndView("supprO", "oSuppr", new Offre());
	}

	// soumettre un formulaire de suppression
	@RequestMapping(value = "/soumettreSupprO", method = RequestMethod.POST)
	public String soumettreFormSuppr(ModelMap modele, @ModelAttribute("oSuppr") Offre o) {
		// supprimer la marchandise
		int verif = offreService.deleteOffre(o);

		return "redirect:listeO";

	}

	
	// RECHERCHER UNE OFFRE
			// afficher le formulaire de recherche
			@RequestMapping(value = "/affichRecO", method = RequestMethod.GET)
			public ModelAndView afficheFormRecherche() {
				return new ModelAndView("rechercherO", "oRec", new Offre());
			}

			// soumettre un formulaire de recherche
			@RequestMapping(value = "/soumettreRecO", method = RequestMethod.POST)
			public String soumettreFormRec(ModelMap modele, @ModelAttribute("oRec") Offre o, RedirectAttributes rda) {
				// rechercher 
				Offre oRec =offreService.getOffrebyId(o);

				if (oRec != null) {
					// mettre  en lien avec la page
					modele.addAttribute("oFind", oRec);

					return "rechercherO";
				} else {
					// ajouter un message d'erreur dans le modele de MVC2 et le passer à
					// la methode afficheRec
					rda.addFlashAttribute("msg", "l'offre recherché n'existe pas ! :( ");

					return "redirect:affichRecO";
				}

			}
		
	
	
}
