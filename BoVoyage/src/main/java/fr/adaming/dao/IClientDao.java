package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	public List<Client> getAllCl();

	public Client addCl(Client cl);

	public Client updateCl(Client cl);

	public int deleteCl(Client cl);

	public Client getClById(Client cl);

}
