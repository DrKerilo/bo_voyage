package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IReservationDao;
import fr.adaming.model.Client;
import fr.adaming.model.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao resDao;

	@Override
	public List<Reservation> getAllRes() {
		return resDao.getAllRes();
	}

	@Override
	public Reservation addRes(Reservation res) {
		return resDao.addRes(res);
	}

	@Override
	public Reservation updateRes(Reservation res) {
		return resDao.updateRes(res);
	}

	@Override
	public int deleteRes(Reservation res) {
		return resDao.deleteRes(res);
	}

	@Override
	public Reservation getResById(Reservation res) {
		return resDao.getResById(res);
	}

	@Override
	public List<Reservation> getResByClient(Client cl) {
		return resDao.getResByClient(cl);
	}

}
