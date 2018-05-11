package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Reservation;
import fr.adaming.service.IClientService;
import fr.adaming.service.IReservationService;

@Controller
@RequestMapping("/clientCTRL")
@Scope("session")
public class ReservationCtrl {

	@Autowired
	private IReservationService resService;

	@Autowired
	private IClientService clService;

	Client client;
	RedirectAttributes rda;

	/*public void init() {
		// récup le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// récup l'identifiant du client connecté
		String mail = auth.getName();

		// récup toutes les infos du client à partir de la BD
		client = clService.getClByMail(mail);
	}*/

	// setter pour l'injection de dépendance
	public void setResService(IReservationService resService) {
		this.resService = resService;
	}

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	// =================================================================================

	// Méthode afficher la liste
	@RequestMapping(value = "/listeResa", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la méthode
		List<Reservation> listeResa = resService.getAllRes();

		return new ModelAndView("listeResa", "listeResas", listeResa);

	}

	// -------------------------------------------------------------------------------------------

	// Méthode ajouter
	@RequestMapping(value = "/afficheAjoutResa", method = RequestMethod.GET)
	public ModelAndView afficheForm() {
		return new ModelAndView("addResa", "resaAjout", new Reservation());
	}

	@RequestMapping(value = "/soumettreAjoutResa", method = RequestMethod.POST)
	public String soumettreForm(ModelMap model, @ModelAttribute("resaAjout") Reservation res) {
		// appel de la méthode
		Reservation resAdd = resService.addRes(res);

		if (resAdd.getId() != 0) {
			return "redirect:listeResa";

		} else {
			return "redirect:afficheAjoutResa";
		}

	}

	// -------------------------------------------------------------------------------------------

	// Fonctionnalité modifier avec un lien
	@RequestMapping(value = "/modifLink", method = RequestMethod.GET)
	public String modifAvecLien(Model model, @RequestParam("pId") int id) {

		Reservation resIn = new Reservation();
		resIn.setId(id);
		// appel de la méthode
		Reservation resOut = resService.getResById(resIn);

		// mettre à jour la liste dans la page d'accueil
		model.addAttribute("resaModif", resOut);
		return "modifResa";

	}

	// Méthode modifier
	@RequestMapping(value = "/afficheModifResa", method = RequestMethod.GET)
	public String afficheFormModif(Model model) {
		model.addAttribute("resaModif", new Reservation());
		String idMod = "modifResa";
		return idMod;
	}

	@RequestMapping(value = "/soumettreModifResa", method = RequestMethod.POST)
	public String soumettreFormModif(ModelMap model, @ModelAttribute("resaModif") Reservation res) {
		// appel de la méthode
		Reservation verif = resService.updateRes(res);

		if (verif != null) {

			// récup la liste en appelant la méthode afficheListe
			return "redirect:listeResa";

		} else {
			return "redirect:afficheModifResa";
		}

	}

	// -------------------------------------------------------------------------------------------

	// Méthode rechercher par id
	@RequestMapping(value = "/afficheRechResa", method = RequestMethod.GET)
	public ModelAndView afficheFormRech() {
		return new ModelAndView("rechResa", "resaRech", new Reservation());
	}

	@RequestMapping(value = "/soumettreRechResa", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("resaRech") Reservation res) {
		// appel de la méthode
		Reservation resaRech = resService.getResById(res);

		if (resaRech != null) {
			model.addAttribute("resaFind", resaRech);
			return "rechResa";
		} else {
			rda.addFlashAttribute("msg", "La reservation n'existe pas !");
			return "redirect:afficheRechResa";
		}

	}

	// -------------------------------------------------------------------------------------------

	// Fonctionnalité supprimer avec un lien du côté de l'agent
	@RequestMapping(value = "/supLink/{pId}", method = RequestMethod.GET)
	public String supAvecLien(Model model, @PathVariable("pId") int id) {

		Reservation resIn = new Reservation();
		resIn.setId(id);
		// appel de la méthode
		int verif = resService.deleteRes(resIn);

		// récup la nouvelle liste
		List<Reservation> liste = resService.getAllRes();
		// mettre à jour la liste dans la page d'accueil
		model.addAttribute("listeResas", liste);
		return "listeResa";
	}
	
	// Fonctionnalité supprimer avec un lien dans accueilClient
		@RequestMapping(value = "/supLink2/{pId}", method = RequestMethod.GET)
		public String supAvecLien2(Model model, @PathVariable("pId") int id) {

			Reservation resIn = new Reservation();
			resIn.setId(id);
			// appel de la méthode
			int verif = resService.deleteRes(resIn);

			// récup la nouvelle liste
			List<Reservation> liste = resService.getAllRes();
			// mettre à jour la liste dans la page d'accueil
			model.addAttribute("listeResasByCl", liste);
			return "listeResaClient";
		}

	// -------------------------------------------------------------------------------------------

	// Méthode afficher la liste recherche par client (id) du côté BackOffice
	@RequestMapping(value = "/rechResaByClient", method = RequestMethod.GET)
	public ModelAndView afficheFormRech1() {
		return new ModelAndView("rechResaByClient", "resaRechCl", new Reservation());
	}

	@RequestMapping(value = "/soumettreRechResaByCl", method = RequestMethod.POST)
	public String soumettreFormRech1(ModelMap model, @ModelAttribute("resaRechCl") Client cl) {
		// appel de la méthode
		List<Reservation> listeRechResa = resService.getResByClient(cl);

		if (listeRechResa != null) {
			model.addAttribute("listeRechResa", listeRechResa);
			return "rechResaByClient";
		} else {
			rda.addFlashAttribute("msg", "Fail !");
			return "redirect:rechResaByClient";
		}

	}

	// Méthode afficher directement la liste des résas quand le client se connecte
	@RequestMapping(value = "/listeResaClient", method = RequestMethod.GET)
	public ModelAndView afficheListe1() {
		// récup le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// récup l'identifiant du client connecté
		String mail = auth.getName();

		// récup toutes les infos du client à partir de la BD
		client = clService.getClByMail(mail);
		
		// appel de la méthode
		List<Reservation> liste = resService.getResByClient(client);

		return new ModelAndView("accueilClient", "listeResasByCl", liste);

	}

}
