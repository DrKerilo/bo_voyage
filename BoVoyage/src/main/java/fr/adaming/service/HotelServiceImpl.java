package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IHotelDao;
import fr.adaming.model.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao eDao;

	@Override
	public int deleteHotel(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Hotel addHotel(Hotel h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(Hotel h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return null;
	}
}
