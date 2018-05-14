package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ImageCLass;
import fr.adaming.model.ImageCLass2;
import fr.adaming.model.Offre;

@Repository
public class OffreDaoImpl implements IOffreDao {

	@PersistenceContext(unitName = "PU_BoVoyage_JPA")
	private EntityManager em;

	@Override
	public List<Offre> getAlloffres() {
		// requete jpql
		String req = "SELECT off FROM Offre as off";

		// creation d'un query pour envoyer la requete
		Query query = em.createQuery(req);

		// envoyer la requete et récupérer le résultat
		return query.getResultList();
	}

	@Override
	public Offre addOffre(Offre off) {
		em.persist(off);
		return off;
	}

	@Override
	public Offre updateOffre(Offre off) {
		em.merge(off);
		return off;
	}

	@Override
	public int deleteOffre(Offre off) {
		Offre offOut = em.find(Offre.class, off.getId());
		em.remove(offOut);
		return 0;
	}

	@Override
	public Offre getOffrebyId(Offre off){
		Offre o= em.find(Offre.class, off.getId());
		
		List<String> images = new ArrayList<String>();

		for (ImageCLass2 photo : o.getPhotos()) {
			String img = "data:image/png;base64," + Base64.encodeBase64String(photo.getPhoto());
			images.add(img);
		}
		o.setImages(images);

		return o;
	}

}
