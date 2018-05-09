package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clDao;

	@Override
	public List<Client> getAllCl() {
		return clDao.getAllCl();
	}

	@Override
	public Client addCl(Client cl) {
		return clDao.addCl(cl);
	}

	@Override
	public Client updateCl(Client cl) {
		return clDao.updateCl(cl);
	}

	@Override
	public int deleteCl(Client cl) {
		return clDao.deleteCl(cl);
	}

	@Override
	public Client getClById(Client cl) {
		return clDao.getClById(cl);
	}

}
