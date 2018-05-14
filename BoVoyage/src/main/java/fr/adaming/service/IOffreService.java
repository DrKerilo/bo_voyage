package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Offre;

public interface IOffreService {

	public List<Offre> getAlloffres();

	public Offre addOffre(Offre off);

	public Offre updateOffre(Offre off);

	public int deleteOffre(Offre off);

	public Offre getOffrebyId(Offre off);

	public List<Offre> getAlloffresNorthAmerica();

	public List<Offre> getAlloffresSouthAmerica();

	public List<Offre> getAlloffresEurope();

	List<Offre> getAlloffresAfrica();

	List<Offre> getAlloffresAsia();

	List<Offre> getAlloffresNorthAfrica();

	List<Offre> getOffresByPays(String pays);

	List<Offre> getOffresByVille(String ville);

}
