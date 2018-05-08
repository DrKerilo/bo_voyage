package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voiture;

public interface IVoitureDao {
	
	public List<Voiture> getAllVoiture();
	
	public Voiture getVoitureById(int id);
	
	public Voiture addVoiture(Voiture v);
	
	public Voiture updateVoiture(Voiture v);
	
	public int deleteVoiture(int id);

}
