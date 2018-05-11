package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Hotel;
import fr.adaming.model.Vol;

public interface IHotelDao {

	public int deleteHotel(int id);
	public Hotel addHotel(Hotel h);
	public Hotel updateHotel(Hotel h);
	public List<Hotel> getAllHotel();
	public Hotel getHotelById(int id);
	public List<Hotel> gethotelsByOffre(int id);
	
}
