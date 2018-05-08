package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@Service
@Transactional
public class VoitureServiceImpl implements IVoitureService  {
	
	// Injection de dépendance
	@Autowired
	private IVoitureDao vDao;
	

	@Override
	public List<Voiture> getAllVoiture() {
		return vDao.getAllVoiture();
	}

	@Override
	public Voiture getVoitureById(int id) {
		return vDao.getVoitureById(id);
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		return vDao.addVoiture(v);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return vDao.updateVoiture(v);
	}

	@Override
	public int deleteVoiture(int id) {
		return vDao.deleteVoiture(id);
	}

}
