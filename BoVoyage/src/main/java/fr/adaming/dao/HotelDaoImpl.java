package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;

@Repository
public class HotelDaoImpl implements IHotelDao {

	@PersistenceContext(unitName="PU_BoVoyage_JPA")
	private EntityManager em;
	
	@Override
	public int deleteHotel(int id) {
		String req="DELETE FROM Hotel h WHERE h.id=:pIdH";
		Query query=em.createQuery(req);
		query.setParameter("pIdH", id);
		return query.executeUpdate();
	}

	@Override
	public Hotel addHotel(Hotel h) {
		em.persist(h);
		return h;
	}

	@Override
	public Hotel updateHotel(Hotel h) {
		em.merge(h);
		return h;
	}

	@Override
	public List<Hotel> getAllHotel() {
		// Création de la requête
		String req="SELECT h FROM Hotel as h";
		Query query=em.createQuery(req);
		List<Hotel> listehot=query.getResultList();
		return listehot;
	}

	@Override
	public Hotel getHotelById(int id) {
		return em.find(Hotel.class, id);
	}

}
