package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> getAllCl() {
		// req JPQL
		String req = "SELECT cl FROM Client AS cl";

		// récup du query
		Query q = em.createQuery(req);

		return q.getResultList();
	}

	@Override
	public Client addCl(Client cl) {
		// méthode de JPA
		em.persist(cl);
		return cl;
	}

	@Override
	public Client updateCl(Client cl) {
		return em.merge(cl);
	}

	@Override
	public int deleteCl(Client cl) {
		// req JPQL
		String req = "DELETE FROM Client AS cl WHERE cl.id=:pId";

		// récup du query
		Query q = em.createQuery(req);

		// passage des params
		q.setParameter("pId", cl.getId());

		return q.executeUpdate();
	}

	@Override
	public Client getClById(Client cl) {
		// req JPQL
		String req = "SELECT cl FROM Client AS cl WHERE cl.id=:pId";

		// récup du query
		Query q = em.createQuery(req);

		// passage des params
		q.setParameter("pId", cl.getId());

		return (Client) q.getSingleResult();
	}

}
