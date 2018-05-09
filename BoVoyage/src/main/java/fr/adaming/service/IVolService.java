package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Vol;

public interface IVolService {

	public List<Vol> getAllvols();

	public Vol addVol(Vol v);

	public Vol updateVol(Vol v);

	public int deleteVol(Vol v);

	public Vol getVolbyId(Vol v);

}
