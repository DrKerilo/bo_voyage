package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Reservation;

@Repository
public class AccompagnantDaoImpl implements IAccompagnantDao {

	// Injection de dépendance
	@PersistenceContext
	private EntityManager em;

	// ===== Méthodes CRUD : Voiture =====
	// ----- READ ALL
	@Override
	public List<Accompagnant> getAllAccompagnant() {
		// Requête JPQL
		String req = "SELECT a FROM Accompagnant a";
		// Query
		Query q = em.createQuery(req);
		// Envoi requête et récupération du résultat
		return q.getResultList();
	}

	// ----- READ BY ID
	@Override
	public Accompagnant getAccompagnantById(int id) {
		return em.find(Accompagnant.class, id);
	}

	// ----- CREATE
	@Override
	public Accompagnant addAccompagnant(Accompagnant a) {
		// Persist
		em.persist(a);
		// Récupération de l'objet avec son id généré
		return a;
	}

	// ----- UPDATE
	@Override
	public Accompagnant updateAccompagnant(Accompagnant a) {
		// Merge
		em.merge(a);
		// Récupération de l'objet mis à jour
		return a;
	}

	// ----- DELETE
	@Override
	public int deleteAccompagnant(int id) {
		// Requête JPQL
		String req="DELETE FROM Accompagnant a WHERE a.id=:pID";
		// Query
		Query q=em.createQuery(req);
		// Passage du paramètre
		q.setParameter("pID", id);
		// Envoi requête et récupération du nombre de lignes modifiées
		return q.executeUpdate();
	}

	// ----- READ BY Reservation
	@Override
	public List<Accompagnant> getAccompagnantByReservation(int idRes) {
		// Requête SQL
		String req="SELECT a.* "
				 + "FROM accompagnants a, reservations r, accompagnants_reservations ar "
				 + "WHERE a.id_ac=ar.ac_id "
				 + "AND r.id_res=ar.res_id "
				 + "AND r.id_res=:pID";
		// Query
		Query q=em.createNativeQuery(req, Accompagnant.class);
		// Passage du paramètre
		q.setParameter("pID", idRes);
		// Envoi requête et récupération du résultat
		return q.getResultList();
	}

}
