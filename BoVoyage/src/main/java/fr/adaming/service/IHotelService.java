package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Hotel;

public interface IHotelService {


	public int deleteHotel(int id);
	public Hotel addHotel(Hotel h);
	public Hotel updateHotel(Hotel h);
	public List<Hotel> getAllHotel();
	public Hotel getHotelById(int id);
	public List<Hotel> gethotelsByOffre(int id);
	
}
