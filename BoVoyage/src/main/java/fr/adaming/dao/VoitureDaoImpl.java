package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voiture;

@Repository
public class VoitureDaoImpl implements IVoitureDao {
	
	// Injection de dépendance
	@PersistenceContext
	private EntityManager em;

	// ===== Méthodes CRUD : Voiture =====
	// ----- READ ALL
	@Override
	public List<Voiture> getAllVoiture() {
		// Requête JPQL
		String req="SELECT v FROM Voiture v";
		// Query
		Query q = em.createQuery(req);
		// Envoi requête et récupération du résultat
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
		// Récupération de l'objet avec son id généré
		return v;
	}

	// ----- UPDATE
	@Override
	public Voiture updateVoiture(Voiture v) {
		// Merge
		em.merge(v);
		// Récupération de l'objet mis à jour
		return v;
	}

	// ----- DELETE
	@Override
	public int deleteVoiture(int id) {
		// Requête JPQL
		String req="DELETE FROM Voiture v WHERE v.id=:pID";
		// Query
		Query q=em.createQuery(req);
		// Passage du paramètre
		q.setParameter("pID", id);
		// Envoi requête et récupération du nombre de lignes modifiées
		return q.executeUpdate();
	}

}
