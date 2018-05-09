package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAccompagnantDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

@Service
@Transactional
public class AccompagnantServiceImpl implements IAccompagnantService {
	
	// Injection de dépendance
	@Autowired
	private IAccompagnantDao accDao;

	@Override
	public List<Accompagnant> getAllAccompagnant() {
		return accDao.getAllAccompagnant();
	}

	@Override
	public Accompagnant getAccompagnantById(int id) {
		return accDao.getAccompagnantById(id);
	}

	@Override
	public Accompagnant addAccompagnant(Accompagnant a) {
		return accDao.addAccompagnant(a);
	}

	@Override
	public Accompagnant updateAccompagnant(Accompagnant a) {
		return accDao.updateAccompagnant(a);
	}

	@Override
	public int deleteAccompagnant(int id) {
		return accDao.deleteAccompagnant(id);
	}

	@Override
	public List<Accompagnant> getAccompagnantByReservation(int idRes) {
		return accDao.getAccompagnantByReservation(idRes);
	}

}
