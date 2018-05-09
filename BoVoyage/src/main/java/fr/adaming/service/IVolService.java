package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Vol;

public interface IVolService {

	public List<Vol> getvolsByOffre(int id);
	
	public List<Vol> getAllVols();

	public Vol addVol(Vol v);

	public Vol updateVol(Vol v);

	public int deleteVol(Vol v);

	public Vol getVolbyId(Vol v);

}
