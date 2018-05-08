package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Accompagnant;
import fr.adaming.model.Adresse;
import fr.adaming.service.IAccompagnantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class AccompagnantServiceImplTest {

	// Classe à tester
	@Autowired
	private IAccompagnantService accService;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllAccompagnantService() {
		double exp = 2;
		double real = accService.getAllAccompagnant().size();
		assertEquals(new Double(exp), new Double(real));
	}

	// Test 2 : liste non vide - essai sur nom
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllAccompagnantService() {
		assertEquals("Toto", accService.getAllAccompagnant().get(0).getNom());
	}

	// ----- Test READ BY ID
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAccompagnantByIdService() {
		Accompagnant accIn = accService.getAccompagnantById(2);
		assertEquals("Lolo", accIn.getNom());
	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddAccompagnantService() {
		// Instanciation objet
		Accompagnant accIn = new Accompagnant(null, null, null, null, new Adresse());
		double before = accService.getAllAccompagnant().size();
		accService.addAccompagnant(accIn);
		double after = accService.getAllAccompagnant().size();
		assertEquals(new Double(++before), new Double(after));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAccompagnantService() {
		// Récupération d'un objet de la BD
		Accompagnant accModif = accService.getAccompagnantById(1);
		accModif.setPrenom("Eugene");
		assertEquals("Eugene", accService.updateAccompagnant(accModif).getPrenom());
	}

	// ----- Test DELETE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteAccompagnantService() {
		double before = accService.getAllAccompagnant().size();
		accService.deleteAccompagnant(1);
		double after = accService.getAllAccompagnant().size();
		assertEquals(new Double(--before), new Double(after));
	}

	// ----- Test READ BY Reservation

}
