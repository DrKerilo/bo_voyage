package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IVolDao;
import fr.adaming.model.Vol;

@Service("volService")
@Transactional
public class VolServiceImpl implements IVolService{

	//tranfo uml en java
	@Autowired
	private IVolDao vol;
	
	@Override
	public List<Vol> getAllvols() {
		
		return vol.getAllvols();
	}

	@Override
	public Vol addVol(Vol v) {
		
		return vol.addVol(v);
	}

	@Override
	public Vol updateVol(Vol v) {
		
		return vol.updateVol(v);
	}

	@Override
	public int deleteVol(Vol v) {
		
		return vol.deleteVol(v);
	}

	@Override
	public Vol getVolbyId(Vol v) {
		
		return vol.addVol(v);
	}

}
