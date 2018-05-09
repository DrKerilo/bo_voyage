package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.adaming.model.Vol;

@EnableTransactionManagement
@Repository
public class VolDaoImpl implements IVolDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Vol> getvolsByOffre(int id) {
		// requete sql
		String req="SELECT * FROM vols v, offre_vol ov, offres o "
				+ "WHERE o.id_off=ov.off_id "
				+ "AND ov.v_id=v.id_v "
				+ "AND o.id_off=?";
		
		// creation d'un query pour envoyer la requete
		Query query= em.createNativeQuery(req, Vol.class);
	
		//passage des parametres
		query.setParameter(1, id);
				
		// envoyer la requete et récupérer le résultat
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

	@Override
	public List<Vol> getAllVols() {
		// req JPQL
		String req = "SELECT v FROM Vol AS v";

		// récup du query
		Query q = em.createQuery(req);

		return q.getResultList();

	}

}
