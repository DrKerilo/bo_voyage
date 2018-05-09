package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAccompagnantDao;
import fr.adaming.model.Accompagnant;
import fr.adaming.model.Adresse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class AccompagnantDaoImplTest {

	// Classe à tester
	@Autowired
	private IAccompagnantDao accDao;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllAccompagnantDao() {
		double exp = 2;
		double real = accDao.getAllAccompagnant().size();
		assertEquals(new Double(exp), new Double(real));
	}

	// Test 2 : liste non vide - essai sur nom
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllAccompagnantDao() {
		assertEquals("Toto", accDao.getAllAccompagnant().get(0).getNom());
	}

	// ----- Test READ BY ID
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAccompagnantByIdDao() {
		Accompagnant accIn = accDao.getAccompagnantById(2);
		assertEquals("Lolo", accIn.getNom());
	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddAccompagnantDao() {
		// Instanciation objet
		Accompagnant accIn = new Accompagnant(null, null, null, null, new Adresse());
		double before = accDao.getAllAccompagnant().size();
		accDao.addAccompagnant(accIn);
		double after = accDao.getAllAccompagnant().size();
		assertEquals(new Double(++before), new Double(after));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAccompagnantDao() {
		// Récupération d'un objet de la BD
		Accompagnant accModif = accDao.getAccompagnantById(1);
		accModif.setPrenom("Eugene");
		assertEquals("Eugene", accDao.updateAccompagnant(accModif).getPrenom());
	}

	// ----- Test DELETE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteAccompagnantDao() {
		double before = accDao.getAllAccompagnant().size();
		accDao.deleteAccompagnant(1);
		double after = accDao.getAllAccompagnant().size();
		assertEquals(new Double(--before), new Double(after));
	}
	
	// ----- Test READ BY Reservation
	@Ignore
	@Test
	@Transactional(readOnly=true)
	public void testGetAccompagnantByReservationDao(){
		Double exp=(double) 2;
		Double real = (double) accDao.getAccompagnantByReservation(1).size();
		assertEquals(exp, real);
	}
	

}
