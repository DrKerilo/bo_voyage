package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IOffreDao;
import fr.adaming.model.Offre;

@Service("offreservice")
@Transactional
public class OffreServiceImpl implements IOffreService{

	//transfo UML en java
	@Autowired
	private IOffreDao offre;
	
	
	@Override
	public List<Offre> getAlloffres() {
		
		return offre.getAlloffres();
	}

	@Override
	public Offre addOffre(Offre off) {
		
		return offre.addOffre(off);
	}

	@Override
	public Offre updateOffre(Offre off) {
		
		return offre.updateOffre(off);
	}

	@Override
	public int deleteOffre(Offre off) {
		
		return offre.deleteOffre(off);
	}

	@Override
	public Offre getOffrebyId(Offre off) {
		
		return offre.getOffrebyId(off);
	}

}
