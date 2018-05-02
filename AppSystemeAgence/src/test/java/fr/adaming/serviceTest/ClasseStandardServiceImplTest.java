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

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClasseStandardServiceImplTest {

	// Classe à tester
	@Autowired
	private IClasseStandardService csService;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllClasseStandardService() {
		double tailleAtt = 2;
		double tailleReelle = csService.getAllClasseStandard().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));
	}

	// Test 2 : liste non vide - test sur type
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllClasseStandardService() {
		assertEquals("maison", csService.getAllClasseStandard().get(0).getType());
	}

	// ----- Test READ ONE
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetClasseStandardByIdService() {
		ClasseStandard csIn = csService.getClasseStandardById(1); // Vérifier
																	// valeur
																	// de l'id

		assertEquals("maison", csIn.getType()); // Vérifier type correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddClasseStandardService() {
		// Instanciation objet vide
		ClasseStandard csIn = new ClasseStandard();

		int tailleAvant = csService.getAllClasseStandard().size();

		csService.addClasseStandard(csIn);

		assertEquals(new Double(++tailleAvant), new Double(csService.getAllClasseStandard().size()));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateClasseStandardService() {
		// Récupération d'un objet de la BD
		ClasseStandard csModif = csService.getClasseStandardById(1);

		csModif.setType("TEST");

		assertEquals("TEST", csService.updateClasseStandard(csModif).getType());

	}
}
