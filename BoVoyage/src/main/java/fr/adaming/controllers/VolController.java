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
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import fr.adaming.model.Horaire;
import fr.adaming.model.Offre;
import fr.adaming.model.Vol;
import fr.adaming.service.IVolService;

@Controller
@RequestMapping("/agCTRL")
@Scope("session")
public class VolController {

	// injection dépendance
	@Autowired
	private IVolService volServ;
	
	private int id;

	// le setter de l'injection dependance
	public void setVolServ(IVolService volServ) {
		this.volServ = volServ;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) { // sera lancé à chque fois
													// qu'une date sera reçu
													// pour la transformer en
													// date java util
		// l'objet webdatabinder sert à faire le lien entre les params de la
		// requete et les objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfh=new SimpleDateFormat("HH:mm");
		df.setLenient(false);
		//dfh.setLenient(false);

		// la methode register sert à convertir le parametre recu par au type de
		// l'attribut

		// l'objet customDateEditor sert à lier la date reçue comme param de la
		// requete à l'attribut de l'objet etudiant
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		// requete à l'attribut de l'objet etudiant
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(dfh, false));
	}

	// AFFICHE LISTE VOL
	@RequestMapping(value = "/listeV", method = RequestMethod.GET)
	public ModelAndView afficheListeVol() {
		// appel de la méthode service pour récupérer la liste
		List<Vol> listeVol = volServ.getAllVols();

		return new ModelAndView("accueilVol", "listeVols", listeVol);
	}


	// AFFICHE LISTE PAR OFFRE
	@RequestMapping(value = "/listeVOffre/{pIdO}", method = RequestMethod.GET)
	public ModelAndView afficheListe(@PathVariable("pIdO") int id) {
		// appel de la méthode service pour récupérer la liste
		List<Vol> listeVolOff = volServ.getvolsByOffre(id);

		return new ModelAndView("listeVolOffre", "listeVolsOff", listeVolOff);
	}

	// AJOUTER UN VOL
	// AFFICHER LE FORMULAIRE

	@RequestMapping(value = "/afficheAjoutV", method = RequestMethod.GET)
	public ModelAndView afficheFormAjoutV() {
		return new ModelAndView("ajoutV", "vAjout", new Vol());
	}

	// SOUMETTRE LE FORMULAIRE
	@RequestMapping(value = "/soumettreAjoutV", method = RequestMethod.POST)
	public String soumettreFormAjoutV(ModelMap modele, @ModelAttribute("vAjout")Vol v,@RequestParam("heure") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,@RequestParam("heure2") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time2) {

		
		v.getHoraire().setHeureDep(new Date(20, 01, 01, time.getHour(), time.getMinute()));
		v.getHoraire().setHeureRet(new Date(20, 01, 01, time2.getHour(), time2.getMinute()));
		// appel de la methode
		Vol vOut = volServ.addVol(v);

		
		if (vOut.getId() != 0) {
			return "redirect:listeV";
		} else {
			return "redirect:afficheAjoutV";
		}

	}
	
	// MODIFIER UN VOL
		// afficher un fomulaire de modification
		@RequestMapping(value = "/affichModifV", method = RequestMethod.GET)
		public String afficheFormModif(Model modele, @ModelAttribute("vModif")Vol v,@RequestParam("heure") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,@RequestParam("heure2") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time2) {

			v.getHoraire().setHeureDep(new Date(20, 01, 01, time.getHour(), time.getMinute()));
			v.getHoraire().setHeureRet(new Date(20, 01, 01, time2.getHour(), time2.getMinute()));
			
			modele.addAttribute("vModif", new Vol());
			String idPage = "modifV";

			return idPage;
		}

		// soumettre un formulaire
		@RequestMapping(value = "/soumettreModifV", method = RequestMethod.POST)
		public String soumettreFormModif(ModelMap modele, @ModelAttribute("vModif") Vol v) {
			// modifier le vol
			Vol vmod= volServ.updateVol(v);
			if (vmod.getId() != 0) {

				return "redirect:listeV";
			} else {
				return "redirect:affichModif";
			}

		}
	

	// SUPPRIMER UN VOL
		// afficher le formulaire de suppression
		@RequestMapping(value = "/afficheSupprV", method = RequestMethod.GET)
		public ModelAndView afficheFormSuppr() {
			return new ModelAndView("supprV", "vSuppr", new Vol());
		}

		// soumettre un formulaire de suppression
		@RequestMapping(value = "/soumettreSupprV", method = RequestMethod.POST)
		public String soumettreFormSuppr(ModelMap modele, @ModelAttribute("vSuppr") Vol v) {
			// supprimer la marchandise
			int verif = volServ.deleteVol(v);
			
				return "redirect:listeV";
		
		}
	
		// RECHERCHER UN Vol
		// afficher le formulaire de recherche
		@RequestMapping(value = "/affichRecV", method = RequestMethod.GET)
		public ModelAndView afficheFormRecherche() {
			return new ModelAndView("rechercherV", "vRec", new Vol());
		}

		// soumettre un formulaire de recherche
		@RequestMapping(value = "/soumettreRecV", method = RequestMethod.POST)
		public String soumettreFormRec(ModelMap modele, @ModelAttribute("vRec") Vol v, RedirectAttributes rda) {
			// rechercher 
			Vol vRec = volServ.getVolbyId(v);

			if (vRec != null) {
				// mettre  en lien avec la page
				modele.addAttribute("vFind", vRec);

				return "rechercherV";
			} else {
				// ajouter un message d'erreur dans le modele de MVC2 et le passer à
				// la methode afficheRec
				rda.addFlashAttribute("msg", "le vol recherché n'existe pas ! :( ");

				return "redirect:affichRec";
			}

		}
	
		
		
}
