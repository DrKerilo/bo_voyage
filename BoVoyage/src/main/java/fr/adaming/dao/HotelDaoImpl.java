package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

@Repository
public class HotelDaoImpl implements IHotelDao {

	@Autowired
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU_BoVoyage_JPA");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	
	
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
