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
		// r�cup le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// r�cup l'identifiant du client connect�
		String mail = auth.getName();

		// r�cup toutes les infos du client � partir de la BD
		client = clService.getClByMail(mail);
	}*/

	// setter pour l'injection de d�pendance
	public void setResService(IReservationService resService) {
		this.resService = resService;
	}

	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	// =================================================================================

	// M�thode afficher la liste
	@RequestMapping(value = "/listeResa", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la m�thode
		List<Reservation> listeResa = resService.getAllRes();

		return new ModelAndView("listeResa", "listeResas", listeResa);

	}

	// -------------------------------------------------------------------------------------------

	// M�thode ajouter
	@RequestMapping(value = "/afficheAjoutResa", method = RequestMethod.GET)
	public ModelAndView afficheForm() {
		return new ModelAndView("addResa", "resaAjout", new Reservation());
	}

	@RequestMapping(value = "/soumettreAjoutResa", method = RequestMethod.POST)
	public String soumettreForm(ModelMap model, @ModelAttribute("resaAjout") Reservation res) {
		// appel de la m�thode
		Reservation resAdd = resService.addRes(res);

		if (resAdd.getId() != 0) {
			return "redirect:listeResa";

		} else {
			return "redirect:afficheAjoutResa";
		}

	}

	// -------------------------------------------------------------------------------------------

	// Fonctionnalit� modifier avec un lien
	@RequestMapping(value = "/modifLink", method = RequestMethod.GET)
	public String modifAvecLien(Model model, @RequestParam("pId") int id) {

		Reservation resIn = new Reservation();
		resIn.setId(id);
		// appel de la m�thode
		Reservation resOut = resService.getResById(resIn);

		// mettre � jour la liste dans la page d'accueil
		model.addAttribute("resaModif", resOut);
		return "modifResa";

	}

	// M�thode modifier
	@RequestMapping(value = "/afficheModifResa", method = RequestMethod.GET)
	public String afficheFormModif(Model model) {
		model.addAttribute("resaModif", new Reservation());
		String idMod = "modifResa";
		return idMod;
	}

	@RequestMapping(value = "/soumettreModifResa", method = RequestMethod.POST)
	public String soumettreFormModif(ModelMap model, @ModelAttribute("resaModif") Reservation res) {
		// appel de la m�thode
		Reservation verif = resService.updateRes(res);

		if (verif != null) {

			// r�cup la liste en appelant la m�thode afficheListe
			return "redirect:listeResa";

		} else {
			return "redirect:afficheModifResa";
		}

	}

	// -------------------------------------------------------------------------------------------

	// M�thode rechercher par id
	@RequestMapping(value = "/afficheRechResa", method = RequestMethod.GET)
	public ModelAndView afficheFormRech() {
		return new ModelAndView("rechResa", "resaRech", new Reservation());
	}

	@RequestMapping(value = "/soumettreRechResa", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("resaRech") Reservation res) {
		// appel de la m�thode
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

	// Fonctionnalit� supprimer avec un lien du c�t� de l'agent
	@RequestMapping(value = "/supLink/{pId}", method = RequestMethod.GET)
	public String supAvecLien(Model model, @PathVariable("pId") int id) {

		Reservation resIn = new Reservation();
		resIn.setId(id);
		// appel de la m�thode
		int verif = resService.deleteRes(resIn);

		// r�cup la nouvelle liste
		List<Reservation> liste = resService.getAllRes();
		// mettre � jour la liste dans la page d'accueil
		model.addAttribute("listeResas", liste);
		return "listeResa";
	}
	
	// Fonctionnalit� supprimer avec un lien dans accueilClient
		@RequestMapping(value = "/supLink2/{pId}", method = RequestMethod.GET)
		public String supAvecLien2(Model model, @PathVariable("pId") int id) {

			Reservation resIn = new Reservation();
			resIn.setId(id);
			// appel de la m�thode
			int verif = resService.deleteRes(resIn);

			// r�cup la nouvelle liste
			List<Reservation> liste = resService.getAllRes();
			// mettre � jour la liste dans la page d'accueil
			model.addAttribute("listeResasByCl", liste);
			return "listeResaClient";
		}

	// -------------------------------------------------------------------------------------------

	// M�thode afficher la liste recherche par client (id) du c�t� BackOffice
	@RequestMapping(value = "/rechResaByClient", method = RequestMethod.GET)
	public ModelAndView afficheFormRech1() {
		return new ModelAndView("rechResaByClient", "resaRechCl", new Reservation());
	}

	@RequestMapping(value = "/soumettreRechResaByCl", method = RequestMethod.POST)
	public String soumettreFormRech1(ModelMap model, @ModelAttribute("resaRechCl") Client cl) {
		// appel de la m�thode
		List<Reservation> listeRechResa = resService.getResByClient(cl);

		if (listeRechResa != null) {
			model.addAttribute("listeRechResa", listeRechResa);
			return "rechResaByClient";
		} else {
			rda.addFlashAttribute("msg", "Fail !");
			return "redirect:rechResaByClient";
		}

	}

	// M�thode afficher directement la liste des r�sas quand le client se connecte
	@RequestMapping(value = "/listeResaClient", method = RequestMethod.GET)
	public ModelAndView afficheListe1() {
		// r�cup le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// r�cup l'identifiant du client connect�
		String mail = auth.getName();

		// r�cup toutes les infos du client � partir de la BD
		client = clService.getClByMail(mail);
		
		// appel de la m�thode
		List<Reservation> liste = resService.getResByClient(client);

		return new ModelAndView("accueilClient", "listeResasByCl", liste);

	}

}
