package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Hotel;
import fr.adaming.model.ImageCLass;
import fr.adaming.model.Vol;

@Repository
public class HotelDaoImpl implements IHotelDao {

	@PersistenceContext(unitName = "PU_BoVoyage_JPA")
	private EntityManager em;

	@Override
	public int deleteHotel(int id) {
		String req = "DELETE FROM Hotel h WHERE h.id=:pIdH";
		Query query = em.createQuery(req);
		query.setParameter("pIdH", id);
		return query.executeUpdate();
	}

	@Override
	public Hotel addHotel(Hotel h) {
		for (ImageCLass image : h.getPhotos()) {
			em.persist(image);
		}

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
		String req = "SELECT h FROM Hotel as h";
		Query query = em.createQuery(req);
		List<Hotel> listehot = query.getResultList();

		return listehot;
	}

	@Override
	public Hotel getHotelById(int id) {
		Hotel h = em.find(Hotel.class, id);
		List<String> images = new ArrayList<String>();

		for (ImageCLass photo : h.getPhotos()) {
			String img = "data:image/png;base64," + Base64.encodeBase64String(photo.getPhoto());
			images.add(img);
		}
		h.setImages(images);

		return h;
	}

	@Override
	public List<Hotel> gethotelsByOffre(int id) {
		// requete sql
		String req = "SELECT * FROM hotels h, offre_hotel oh, offres o " + "WHERE o.id_off=oh.off_id "
				+ "AND oh.h_id=h.id_h " + "AND o.id_off=?";

		// creation d'un query pour envoyer la requete
		Query query = em.createNativeQuery(req, Vol.class);

		// passage des parametres
		query.setParameter(1, id);

		// envoyer la requete et récupérer le résultat
		return query.getResultList();

	}
}
