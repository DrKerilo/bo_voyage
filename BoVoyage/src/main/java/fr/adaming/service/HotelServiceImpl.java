package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IHotelDao;
import fr.adaming.model.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hDao;

	@Override
	public int deleteHotel(int id) {
		// TODO Auto-generated method stub
		return hDao.deleteHotel(id);
	}

	@Override
	public Hotel addHotel(Hotel h) {
		return hDao.addHotel(h);
	}

	@Override
	public Hotel updateHotel(Hotel h) {
		// TODO Auto-generated method stub
		return hDao.updateHotel(h);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hDao.getAllHotel();
	}

	@Override
	public Hotel getHotelById(int id) {
		
		return hDao.getHotelById(id);
	}

	@Override
	public List<Hotel> gethotelsByOffre(int id) {
		
		return hDao.gethotelsByOffre(id);
	}
}
