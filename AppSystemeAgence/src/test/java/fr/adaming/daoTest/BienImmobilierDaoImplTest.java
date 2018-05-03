package fr.adaming.daoTest;

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

import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmobilier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class BienImmobilierDaoImplTest {

	// Classe à tester
	@Autowired
	private IBienImmobilierDao biDao;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllBienImmobilierDao() {
		double tailleAtt = 2;
		double tailleReelle = biDao.getAllBienImmobilier().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));

	}

	// Test 2 : liste non vide - test sur type
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllBienImmobilierDao() {
		assertEquals("Ville d'Avray", biDao.getAllBienImmobilier().get(0).getAdresse().getLocalite());
	}

	// ----- Test READ ONE
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetBienImmobilierByIdDao() {
		BienImmobilier csIn = biDao.getBienById(1); // Vérifier valeur
																// de l'id

		assertEquals(92410, csIn.getAdresse().getCodePostal()); // Vérifier CP correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddBienImmobilierDao() {
		// Instanciation objet vide
//		BienImmobilier biIn = new BienImmobilier(null, new Date(), new Adresse("toto", 20, 20000, "Toto"), new Date(), 5000);
//
//		int tailleAvant = biDao.getAllBienImmobilier().size();
//
//		biDao.addBienImmobilier(biIn);
//
//		assertEquals(new Double(++tailleAvant), new Double(biDao.getAllBienImmobilier().size()));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateBienImmobilierDao() {
		// Récupération d'un objet de la BD
		BienImmobilier biModif = biDao.getBienById(1);

		biModif.setRevenuCadastral(1500);

		assertEquals(new Double(1500), new Double(biDao.editBienImmobilier(biModif).getRevenuCadastral()));

	}

}
