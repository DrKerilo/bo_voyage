package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/clientCTRL")
@Scope("session")
public class ClientCtrl {

	@Autowired
	private IClientService clService;

	RedirectAttributes rda;

	// setter pour l'injection de d�pdce
	public void setClService(IClientService clService) {
		this.clService = clService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	// =================================================================================

	// M�thode afficher la liste
	@RequestMapping(value = "/listeClient", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// appel de la m�thode
		List<Client> listeCl = clService.getAllCl();

		return new ModelAndView("listeClient", "listeClients", listeCl);
	}

	// -------------------------------------------------------------------------------------------

	// M�thode ajouter
	@RequestMapping(value = "/afficheAjoutClient", method = RequestMethod.GET)
	public ModelAndView afficheForm() {
		return new ModelAndView("addClient", "clAjout", new Client());
	}

	@RequestMapping(value = "/soumettreAjoutClient", method = RequestMethod.POST)
	public String soumettreForm(ModelMap model, @ModelAttribute("clAjout") Client cl) {
		// appel de la m�thode
		Client clAdd = clService.addCl(cl);

		if (clAdd.getId() != 0) {
			return "redirect:listeClient";

		} else {
			return "redirect:afficheAjoutClient";
		}

	}

	// -------------------------------------------------------------------------------------------
			//C�t� Agent

	// Fonctionnalit� modifier avec un lien
	@RequestMapping(value = "/modifLink", method = RequestMethod.GET)
	public String modifAvecLien(Model model, @RequestParam("pId") int id) {

		Client clIn = new Client();
		clIn.setId(id);
		// appel de la m�thode
		Client clOut = clService.getClById(clIn);

		// mettre � jour la liste dans la page d'accueil
		model.addAttribute("clModif", clOut);
		return "modifClient";

	}

	// M�thode modifier
	@RequestMapping(value = "/afficheModifClient", method = RequestMethod.GET)
	public String afficheFormModif(Model model) {
		model.addAttribute("clModif", new Client());
		String idMod = "modifClient";
		return idMod;
	}

	@RequestMapping(value = "/soumettreModifClient", method = RequestMethod.POST)
	public String soumettreFormModif(ModelMap model, @ModelAttribute("clModif") Client cl) {
		// appel de la m�thode
		Client verif = clService.updateCl(cl);

		if (verif != null) {
			return "redirect:listeClient";

		} else {
			return "redirect:afficheModifClient";
		}

	}
	
	// -------------------------------------------------------------------------------------------
				//Quand le client est connect� et qu'il souhaite modifier son compte

		// Fonctionnalit� modifier avec un lien
		@RequestMapping(value = "/modifLink2", method = RequestMethod.GET)
		public String modifAvecLien2(Model model, @RequestParam("pId") int id) {

			Client clIn = new Client();
			clIn.setId(id);
			// appel de la m�thode
			Client clOut = clService.getClById(clIn);

			// mettre � jour la liste dans la page d'accueil
			model.addAttribute("clModif2", clOut);
			return "modifClient2";

		}
		
		// M�thode modifier
		@RequestMapping(value = "/afficheModifClient2", method = RequestMethod.GET)
		public String afficheFormModif2(Model model) {
			model.addAttribute("clModif2", new Client());
			String idMod = "modifClient2";
			return idMod;
		}

		@RequestMapping(value = "/soumettreModifClient2", method = RequestMethod.POST)
		public String soumettreFormModif2(ModelMap model, @ModelAttribute("clModif2") Client cl) {
			// appel de la m�thode
			Client verif = clService.updateCl(cl);

			if (verif != null) {
				rda.addFlashAttribute("msg", "Votre compte a �t� modifi� avec succes !");
				return "redirect:afficheModifClient2";

			} else {
				rda.addFlashAttribute("msg", "La modification de votre compte a �chou� !");
				return "redirect:afficheModifClient2";
			}

		}

	// -------------------------------------------------------------------------------------------

	// Fonctionnalit� supprimer avec un lien
	@RequestMapping(value = "/supLink/{pId}", method = RequestMethod.GET)
	public String supAvecLien(Model model, @PathVariable("pId") int id) {

		Client clIn = new Client();
		clIn.setId(id);
		// appel de la m�thode
		int verif = clService.deleteCl(clIn);

		// r�cup la nouvelle liste
		List<Client> liste = clService.getAllCl();
		// mettre � jour la liste dans la page d'accueil
		model.addAttribute("listeClients", liste);
		return "listeClient";

	}

	// -------------------------------------------------------------------------------------------

	// M�thode rechercher par id
	@RequestMapping(value = "/afficheRechClient", method = RequestMethod.GET)
	public ModelAndView afficheFormRech() {
		return new ModelAndView("accueilClient", "clRech", new Client());
	}

	@RequestMapping(value = "/soumettreRechClient", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("clRech") Client cl) {
		// appel de la m�thode
		Client clRech = clService.getClById(cl);

		if (clRech != null) {
			model.addAttribute("clFind", clRech);
			return "rechClient";
		} else {
			rda.addFlashAttribute("msg", "Le client n'existe pas !");
			return "redirect:afficheRechClient";
		}

	}

}
