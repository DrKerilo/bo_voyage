package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.itextpdf.text.Image;
import com.itextpdf.text.xml.simpleparser.EntitiesToSymbol;

@Repository
public class ImageDaoImpl implements IImageDao{

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addImage(Image image) {
		em.persist(image);
		
	}

}
