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

	// Injection de d�pendance
	@PersistenceContext
	private EntityManager em;

	// ===== M�thodes CRUD : Voiture =====
	// ----- READ ALL
	@Override
	public List<Accompagnant> getAllAccompagnant() {
		// Requ�te JPQL
		String req = "SELECT a FROM Accompagnant a";
		// Query
		Query q = em.createQuery(req);
		// Envoi requ�te et r�cup�ration du r�sultat
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
		// R�cup�ration de l'objet avec son id g�n�r�
		return a;
	}

	// ----- UPDATE
	@Override
	public Accompagnant updateAccompagnant(Accompagnant a) {
		// Merge
		em.merge(a);
		// R�cup�ration de l'objet mis � jour
		return a;
	}

	// ----- DELETE
	@Override
	public int deleteAccompagnant(int id) {
		// Requ�te JPQL
		String req="DELETE FROM Accompagnant a WHERE a.id=:pID";
		// Query
		Query q=em.createQuery(req);
		// Passage du param�tre
		q.setParameter("pID", id);
		// Envoi requ�te et r�cup�ration du nombre de lignes modifi�es
		return q.executeUpdate();
	}

	// ----- READ BY Reservation
	@Override
	public List<Accompagnant> getAccompagnantByReservation(int idRes) {
		// Requ�te SQL
		String req="SELECT a.* "
				 + "FROM accompagnants a, reservations r, accompagnants_reservations ar "
				 + "WHERE a.id_ac=ar.ac_id "
				 + "AND r.id_res=ar.res_id "
				 + "AND r.id_res=:pID";
		// Query
		Query q=em.createNativeQuery(req, Accompagnant.class);
		// Passage du param�tre
		q.setParameter("pID", idRes);
		// Envoi requ�te et r�cup�ration du r�sultat
		return q.getResultList();
	}

}
