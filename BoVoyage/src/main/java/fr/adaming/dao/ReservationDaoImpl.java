package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Reservation;

@Repository
public class ReservationDaoImpl implements IReservationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Reservation> getAllRes() {
		// req JPQL
		String req = "SELECT res FROM Reservation AS res";

		// récup du query
		Query q = em.createQuery(req);

		return q.getResultList();
	}

	@Override
	public Reservation addRes(Reservation res) {
		// méthode de JPA
		em.persist(res);
		return res;
	}

	@Override
	public Reservation updateRes(Reservation res) {
		// méthode de JPA
		return em.merge(res);
	}

	@Override
	public int deleteRes(Reservation res) {
		// req JPQL
		String req = "DELETE FROM Reservation AS res WHERE res.id=:pId";

		// récup du query
		Query q = em.createQuery(req);

		// passage des params
		q.setParameter("pId", res.getId());

		return q.executeUpdate();
	}

	@Override
	public Reservation getResById(Reservation res) {
		// req JPQL
		String req = "SELECT res FROM Reservation AS res WHERE res.id=:pId";

		// récup du query
		Query q = em.createQuery(req);

		// passage des params
		q.setParameter("pId", res.getId());

		return (Reservation) q.getSingleResult();
	}

}
