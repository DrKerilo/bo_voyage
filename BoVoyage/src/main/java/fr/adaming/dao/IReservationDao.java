package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Reservation;

public interface IReservationDao {

	public List<Reservation> getAllRes();

	public Reservation addRes(Reservation res);

	public Reservation updateRes(Reservation res);

	public int deleteRes(Reservation res);

	public Reservation getResById(Reservation res);
	
	public List<Reservation> getResByClient (Client cl);

}
