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

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ProprietaireDaoImplTest {

	// Classe à tester
	@Autowired
	private IProprietaireDao propDao;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllProprietaireDao() {
		double tailleAtt = 2;
		double tailleReelle = propDao.getAllProprietaire().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));

	}

	// Test 2 : liste non vide - test sur nom
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllProprietaireDao() {
		assertEquals("Michel", propDao.getAllProprietaire().get(0).getNom());
	}

	// ----- Test READ ONE
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetProprietaireByIdDao() {
		Proprietaire pIn = propDao.getProprietaireById(1); // Vérifier valeur
																// de l'id

		assertEquals("Michel", pIn.getNom()); // Vérifier nom correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddProprietaireDao() {
		// Instanciation objet vide
		Proprietaire pIn = new Proprietaire("Toto","Titi",666,new Adresse("Rue", 1, 44000, "Ville"),222);

		int tailleAvant = propDao.getAllProprietaire().size();

		propDao.addProprietaire(pIn);

		assertEquals(new Double(++tailleAvant), new Double(propDao.getAllProprietaire().size()));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateProprietaireDao() {
		// Récupération d'un objet de la BD
		Proprietaire pModif = propDao.getProprietaireById(1);

		pModif.setNom("WALOU");

		assertEquals("WALOU", propDao.updateProprietaire(pModif).getNom());

	}

	// ----- Test DELETE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteProprietaireDao() {
		int tailleAvant = propDao.getAllProprietaire().size();
		propDao.deleteProprietaire(1);
		int tailleApres = propDao.getAllProprietaire().size();
		assertEquals(new Double(--tailleAvant), new Double(tailleApres));
	}

}
