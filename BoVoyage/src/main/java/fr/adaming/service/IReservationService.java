package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Reservation;

public interface IReservationService {
	
	public List<Reservation> getAllRes();

	public Reservation addRes(Reservation res);

	public Reservation updateRes(Reservation res);

	public int deleteRes(Reservation res);

	public Reservation getResById(Reservation res);

}
