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

import fr.adaming.model.Voiture;
import fr.adaming.service.IVoitureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class VoitureServiceImplTest {

	// Classe à tester
	@Autowired
	private IVoitureService vService;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllVoitureService() {
		double exp = 2;
		double real = vService.getAllVoiture().size();
		assertEquals(new Double(exp), new Double(real));
	}

	// Test 2 : liste non vide - essai sur loueur
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllVoitureService() {
		assertEquals("Hertz", vService.getAllVoiture().get(1).getLoueur());
	}

	// ----- Test READ BY ID
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetVoitureByIdService() {
		Voiture vIn = vService.getVoitureById(2);
		assertEquals("SOFGH", vIn.getReference());
	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddVoitureService() {
		// Instanciation objet
		Voiture vIn = new Voiture();
		double before = vService.getAllVoiture().size();
		vService.addVoiture(vIn);
		double after = vService.getAllVoiture().size();
		assertEquals(new Double(++before), new Double(after));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateVoitureService() {
		// Récupération d'un objet de la BD
		Voiture vModif = vService.getVoitureById(1);
		vModif.setCategorie("ZX");
		assertEquals("ZX", vService.updateVoiture(vModif).getCategorie());
	}

	// ----- Test DELETE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteVoitureService() {
		double before = vService.getAllVoiture().size();
		vService.deleteVoiture(1);
		double after = vService.getAllVoiture().size();
		assertEquals(new Double(--before), new Double(after));
	}
}
