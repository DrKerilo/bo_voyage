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

import fr.adaming.dao.IVoitureDao;
import fr.adaming.model.Voiture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class VoitureDaoImplTest {

	// Classe à tester
	@Autowired
	private IVoitureDao vDao;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllVoitureDao() {
		double exp = 2;
		double real = vDao.getAllVoiture().size();
		assertEquals(new Double(exp), new Double(real));
	}

	// Test 2 : liste non vide - essai sur loueur
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllVoitureDao() {
		assertEquals("Hertz", vDao.getAllVoiture().get(1).getLoueur());
	}

	// ----- Test READ BY ID
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetVoitureByIdDao() {
		Voiture vIn = vDao.getVoitureById(2);
		assertEquals("SOFGH", vIn.getReference());
	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddVoitureDao() {
		// Instanciation objet
		Voiture vIn = new Voiture();
		double before = vDao.getAllVoiture().size();
		vDao.addVoiture(vIn);
		double after = vDao.getAllVoiture().size();
		assertEquals(new Double(++before), new Double(after));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVoitureDao() {
		// Récupération d'un objet de la BD
		Voiture vModif = vDao.getVoitureById(1);
		vModif.setCategorie("ZX");
		assertEquals("ZX", vDao.updateVoiture(vModif).getCategorie());
	}

	// ----- Test DELETE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVoitureDao() {
		double before = vDao.getAllVoiture().size();
		vDao.deleteVoiture(1);
		double after = vDao.getAllVoiture().size();
		assertEquals(new Double(--before), new Double(after));
	}
}
