package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voiture;

@Repository
public class VoitureDaoImpl implements IVoitureDao {
	
	// Injection de d�pendance
	@PersistenceContext
	private EntityManager em;

	// ===== M�thodes CRUD : Voiture =====
	// ----- READ ALL
	@Override
	public List<Voiture> getAllVoiture() {
		// Requ�te JPQL
		String req="SELECT v FROM Voiture v";
		// Query
		Query q = em.createQuery(req);
		// Envoi requ�te et r�cup�ration du r�sultat
		return q.getResultList();
	}

	// ----- READ BY ID
	@Override
	public Voiture getVoitureById(int id) {
		return em.find(Voiture.class, id);
	}

	// ----- CREATE
	@Override
	public Voiture addVoiture(Voiture v) {
		// Persist
		em.persist(v);
		// R�cup�ration de l'objet avec son id g�n�r�
		return v;
	}

	// ----- UPDATE
	@Override
	public Voiture updateVoiture(Voiture v) {
		// Merge
		em.merge(v);
		// R�cup�ration de l'objet mis � jour
		return v;
	}

	// ----- DELETE
	@Override
	public int deleteVoiture(int id) {
		// Requ�te JPQL
		String req="DELETE FROM Voiture v WHERE v.id=:pID";
		// Query
		Query q=em.createQuery(req);
		// Passage du param�tre
		q.setParameter("pID", id);
		// Envoi requ�te et r�cup�ration du nombre de lignes modifi�es
		return q.executeUpdate();
	}

}
