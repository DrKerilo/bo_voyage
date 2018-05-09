package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Vol;

public interface IVolDao {
	
	public List<Vol> getAllvols();
	
	public Vol addVol(Vol v);
	
	public Vol updateVol(Vol v);
	
	public int deleteVol(Vol v);
	
	public Vol getVolbyId(Vol v);
	
	

}
