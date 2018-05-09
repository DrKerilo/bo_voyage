package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Vol;

@Repository
public class VolDaoImpl implements IVolDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Vol> getAllvols() {
		// requete jpql
		String req="SELECT v FROM Vol as v";
		
		//creation d'un query pour envoyer la requete
		Query query=em.createQuery(req);
		
		//envoyer la requete et récupérer le résultat
		return query.getResultList();
	}

	@Override
	public Vol addVol(Vol v) {
		em.persist(v);
		return v;
	}

	@Override
	public Vol updateVol(Vol v) {
		em.merge(v);
		return v;
	}

	@Override
	public int deleteVol(Vol v) {
		Vol volOut = em.find(Vol.class, v.getId());
		em.remove(volOut);
		return 0;
	}

	@Override
	public Vol getVolbyId(Vol v) {
		
		return em.find(Vol.class, v.getId());
	}

}
