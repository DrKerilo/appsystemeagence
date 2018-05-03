package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.enumerations.ImmoStatut;
import fr.adaming.service.IBienImmobilierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class BienImmobilierServiceImplTest {

	// Classe à tester
	@Autowired
	private IBienImmobilierService biService;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllBienImmobilierService() {
		double tailleAtt = 2;
		double tailleReelle = biService.getAllBienImmobilier().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));
	}

	// Test 2 : liste non vide - test sur type
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllBienImmobilierService() {
		assertEquals("Ville d'Avray", biService.getAllBienImmobilier().get(0).getAdresse().getLocalite());
	}

	// ----- Test READ ONE
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetBienImmobilierByIdService() {
		BienImmobilier biIn = biService.getBienById(1); // Vérifier
																	// valeur
																	// de l'id

		assertEquals(92410, biIn.getAdresse().getCodePostal()); // Vérifier type correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddBienImmobilierService() {
//		// Instanciation objet vide
//		BienImmobilier biIn = new BienImmobilier(ImmoStatut.DISPONIBLE, new Date(), new Adresse("toto", 20, 20000, "Toto"), new Date(), 5000);
//
//		int tailleAvant = biService.getAllBienImmobilier().size();
//
//		biService.addBienImmobilier(biIn);
//
//		assertEquals(new Double(++tailleAvant), new Double(biService.getAllBienImmobilier().size()));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateBienImmobilierService() {
		// Récupération d'un objet de la BD
		BienImmobilier csModif = biService.getBienById(1);

		csModif.setRevenuCadastral(2500);

		assertEquals(new Double(2500), new Double(biService.editBienImmobilier(csModif).getRevenuCadastral()));

	}
	
	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteBienImmobilierService() {
		double tailleAtt = biService.getAllBienImmobilier().size() - 1;
		
		biService.deleteBienImmobilier(1);
		
		double tailleReelle = biService.getAllBienImmobilier().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));
	}

	
}
