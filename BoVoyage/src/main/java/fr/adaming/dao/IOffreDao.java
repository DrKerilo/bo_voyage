package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Offre;

public interface IOffreDao {

	public List<Offre> getAlloffres();

	public Offre addOffre(Offre off);

	public Offre updateOffre(Offre off);

	public int deleteOffre(Offre off);

	public Offre getOffrebyId(Offre off);

}
