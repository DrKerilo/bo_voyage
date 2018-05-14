package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.model.Reservation;
import fr.adaming.service.IAccompagnantService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IReservationService;

@Controller
@RequestMapping("/newResaCTRL")
@Scope("request")
public class NewResaController {


		@Autowired
		private IReservationService resaService;

		@Autowired
		private IClientService clService;
		
		@Autowired
		private IAccompagnantService accService;

		Client client;
		List<Accompagnant> accompagnants;
		
		
		// AFFICHER LE FORMULAIRE DE RENSEIGNEMENTS CLIENT ET ACCOMPAGNANT (nouvelle reservation)
		@RequestMapping(value = "/newResaForm", method = RequestMethod.GET)
		public ModelAndView afficheFormulaireAjout() {

			Reservation resa = new Reservation();

			resa.setClient(new Client());
			resa.setListeAcc(new ArrayList<Accompagnant>());
			
			return new ModelAndView("nouvelleResaClient", "newResa", resa);
		}
		
		// méthode POST pour soumettre le formulaire
		@RequestMapping(value = "/soumettreNewResa", method = RequestMethod.POST)
		public String soumettreFormulaireAjout(@ModelAttribute("newResa") Reservation resa, 
				@RequestParam("pCiviliteClient") String civilite, 
				@RequestParam("pNomClient") String nom, 
				@RequestParam("pPrenomClient") String prenom, 
				@RequestParam("pDnClient") Date dn,
				@RequestParam("pMailClient") String mail,
				@RequestParam("pNumeroAdresse") int numero, 
				@RequestParam("pRueAdresse") String rue, 
				@RequestParam("pCpAdresse") String codePostal, 
				@RequestParam("pVilleAdresse") String ville,
				@RequestParam("pChoix") String assurance ) {
			
			Client clientResa = new Client();
			clientResa.setCivilite(civilite);
			clientResa.setNom(nom);
			clientResa.setPrenom(prenom);
			clientResa.setDn(dn);
			clientResa.setMail(mail);
			
			Adresse adresse = new Adresse();
			adresse.setNumero(numero);
			adresse.setRue(rue);
			adresse.setCodePostal(codePostal);
			adresse.setVille(ville);
			
			clientResa.setAdresse(adresse);
			
			if (assurance == "1") {
				resa.setAssurance("oui");
			} else {
				resa.setAssurance("non");
			}

			resa.setClient(clService.addCl(clientResa));
			resaService.addRes(resa);
			return "redirect:listeResa";
		}

}
