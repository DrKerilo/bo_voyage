package fr.adaming.controllers;

import java.nio.channels.FileChannel.MapMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hotel;
import fr.adaming.service.IHotelService;

@Controller
@RequestMapping("/agCTRL")
public class HotelController {

	@Autowired
	private IHotelService hotelService;
	
	// A chaque requ�te, il va appeler cette m�thode pour traduire (ici, date un peu compliqu� pour lui � traduire)
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// L'objet WebDataBinder sert � faire le lien entre les param�tres de la requ�te et les objets java 
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfh=new SimpleDateFormat("HH:mm");
		df.setLenient(false);
		// La m�thode registerEditor sert � configurer/sp�cifier la conversion du param�tre re�u au type de l'attribut 
		// L'objet CustomDateEditor : sert � Mapper/lier la date re�ue comme param�tre de la requ�te � l'attribut
		// de l'objet �tudiant 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		
	}
	
	//############################ LISTE DES HOTELS #####################
	
	@RequestMapping(value="/listeHotels", method=RequestMethod.GET)
	public ModelAndView afficheListe(){
		List<Hotel> listeHotels=hotelService.getAllHotel();
		return new ModelAndView ("accueilHot", "listeH", listeHotels);
	}
	
	
	//########################### AJOUTER HOTEL ############################
	
	// Afficher le formulaire d'ajout d'un hotel 
	@RequestMapping(value="/affFormAjoutHot", method=RequestMethod.GET)
	public ModelAndView affFormAjoutHot() {
		return new ModelAndView("ajoutHotel", "hotel", new Hotel());
	}
	
	
	// Soumettre le formulaire d'ajout d'un hotel 
	@RequestMapping(value="soumAjoutHot", method=RequestMethod.POST)
	public String soumFormAjoutHot(ModelMap modele, @ModelAttribute("hotel")Hotel hotel,@RequestParam("heure") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,@RequestParam("heure2") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time2){
		// Appel de la m�thode ajouter de service 
		hotel.getHoraire().setHeureDep(new Date(20, 01, 01, time.getHour(), time.getMinute()));
		hotel.getHoraire().setHeureRet(new Date(20, 01, 01, time2.getHour(), time2.getMinute()));
		Hotel hOut = hotelService.addHotel(hotel);
		if (hOut.getId()!=0){
			return "redirect:listeHotels";
		}else {
			return "redirect:affFormAjoutHot";
		}
	}
	
	//############################ SUPPRESSION HOTEL #####################
	@RequestMapping(value="/suppHotel", method=RequestMethod.GET)
	public ModelAndView suppHotel(){
		return new ModelAndView("supprHot", "hotSup", new Hotel());
	}
	
	@RequestMapping(value="soumSuppHotel", method=RequestMethod.POST)
	public String soumSuppHotel(@ModelAttribute("hotSup")Hotel h){
		int verif=hotelService.deleteHotel(h.getId());
		if (verif!=0){
			return "redirect:listeHotels";
		} else {
			return "redirect:suppHotel";
		}
	}
	
	//############################ RECUPERER UN HOTEL PAR L'ID #####################
	@RequestMapping(value="searchHotForm", method=RequestMethod.GET)
	public ModelAndView affFormRechHot(){
		return new ModelAndView("searchHot", "hSearch", new Hotel());
	}
	
	@RequestMapping(value="soumSearchHot", method=RequestMethod.POST)
	public String soumSearchHot(@ModelAttribute("hSearch")Hotel h, RedirectAttributes redirect, Model model){
		Hotel hOut=hotelService.getHotelById(h.getId());
		if (hOut!=null){
			model.addAttribute("hTrouve", hOut);
			return "searchHot";
		} else {
			redirect.addFlashAttribute("message", "L'h�tel recherch� n'existe pas...");
			return "redirect:searchHotForm";
		}
	}
	
	
	//############################ MODIFICATION DES INFORMATIONS D'UN HOTEL #####################
	
	@RequestMapping(value="modifFormHot", method=RequestMethod.GET)
	public ModelAndView modifHotelForm(){
		return new ModelAndView("modifHotel", "hModif", new Hotel());
	}
	
	@RequestMapping(value="soumModifHot", method=RequestMethod.POST)
	public String soumModifHotel(@ModelAttribute("hModif")Hotel hot,@RequestParam("heure") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,@RequestParam("heure2") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time2){
		hot.getHoraire().setHeureDep(new Date(20, 01, 01, time.getHour(), time.getMinute()));
		hot.getHoraire().setHeureRet(new Date(20, 01, 01, time2.getHour(), time2.getMinute()));
		Hotel hMod=hotelService.updateHotel(hot);
		if (hMod!=null){
			return "redirect:listeHotels";
		} else {
			return "redirect:modifFormHot";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
