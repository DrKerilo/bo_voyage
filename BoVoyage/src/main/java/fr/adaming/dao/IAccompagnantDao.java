package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

public interface IAccompagnantDao {
	
	public List<Accompagnant> getAllAccompagnant();
	
	public Accompagnant getAccompagnantById(int id);
	
	public Accompagnant addAccompagnant(Accompagnant a);
	
	public Accompagnant updateAccompagnant(Accompagnant a);
	
	public int deleteAccompagnant(int id);
	
	public List<Accompagnant> getAccompagnantByReservation(int idRes);

}
