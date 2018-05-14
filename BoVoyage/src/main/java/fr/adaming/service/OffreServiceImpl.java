package fr.adaming.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Offre;

@Service("offreservice")
@Transactional
public class OffreServiceImpl implements IOffreService {

	// transfo UML en java
	@Autowired
	private IOffreDao offre;

	@Override
	public List<Offre> getAlloffres() {

		return offre.getAlloffres();
	}

	@Override
	public Offre addOffre(Offre off) {

		return offre.addOffre(off);
	}

	@Override
	public Offre updateOffre(Offre off) {

		return offre.updateOffre(off);
	}

	@Override
	public int deleteOffre(Offre off) {

		return offre.deleteOffre(off);
	}

	@Override
	public Offre getOffrebyId(Offre off) {

		return offre.getOffrebyId(off);
	}

	@Override
	public List<Offre> getAlloffresNorthAmerica() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeNA = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Amerique du Nord")) {
				listeNA.add(liste.get(i));
			}
		}
		return listeNA;
	}

	@Override
	public List<Offre> getAlloffresSouthAmerica() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeSA = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Amerique du Sud")) {
				listeSA.add(liste.get(i));
			}
		}
		return listeSA;
	}

	@Override
	public List<Offre> getAlloffresAfrica() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeAfr = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Afrique")) {
				listeAfr.add(liste.get(i));
			}
		}
		return listeAfr;
	}

	@Override
	public List<Offre> getAlloffresEurope() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeEur = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Europe")) {
				listeEur.add(liste.get(i));
			}
		}
		return listeEur;
	}

	@Override
	public List<Offre> getAlloffresNorthAfrica() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeNAfr = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Afrique du Nord")) {
				listeNAfr.add(liste.get(i));
			}
		}
		return listeNAfr;
	}

	@Override
	public List<Offre> getAlloffresAsia() {
		List<Offre> liste = getAlloffres();
		List<Offre> listeAs = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getContinent().equals("Asie")) {
				listeAs.add(liste.get(i));
			}
		}
		return listeAs;
	}

	@Override
	public List<Offre> getOffresByPays(String Pays) {
		List<Offre> liste = getAlloffres();
		List<Offre> listePays = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getPays().equals(Pays)) {
				listePays.add(liste.get(i));
			}
		}
		return listePays;
	}

	@Override
	public List<Offre> getOffresByVille(String Ville) {
		List<Offre> liste = getAlloffres();
		List<Offre> listeVille = new ArrayList<Offre>();
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getDestination().getPays().equals(Ville)) {
				listeVille.add(liste.get(i));
			}
		}
		return listeVille;

	}

}
