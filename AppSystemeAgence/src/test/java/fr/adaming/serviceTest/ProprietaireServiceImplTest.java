package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Adresse;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ProprietaireServiceImplTest {

	// Classe à tester
	@Autowired
	private IProprietaireService propService;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	// @Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllProprietaire() {
		double tailleAtt = 2;
		double tailleReelle = propService.getAllProprietaire().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));

	}

	// Test 2 : liste non vide - test sur nom
	// @Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllProprietaireService() {
		assertEquals("Michel", propService.getAllProprietaire().get(0).getNom());
	}

	// ----- Test READ ONE
	// @Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetProprietaireByIdService() {
		Proprietaire pIn = propService.getProprietaireById(1); // Vérifier valeur
															// de l'id

		assertEquals("Michel", pIn.getNom()); // Vérifier nom correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	// @Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddProprietaireService() {
		// Instanciation objet vide
		Proprietaire pIn = new Proprietaire("Toto","Titi",666,new Adresse("Rue", 1, 44000, "Ville"),222);

		int tailleAvant = propService.getAllProprietaire().size();

		propService.addProprietaire(pIn);

		assertEquals(new Double(++tailleAvant), new Double(propService.getAllProprietaire().size()));
	}

	// ----- Test UPDATE
	// @Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateProprietaireService() {
		// Récupération d'un objet de la BD
		Proprietaire pModif = propService.getProprietaireById(1);

		pModif.setNom("WALOU");

		assertEquals("WALOU", propService.updateProprietaire(pModif).getNom());

	}

	// ----- Test DELETE
	// @Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteProprietaireService() {
		int tailleAvant = propService.getAllProprietaire().size();
		propService.deleteProprietaire(1);
		int tailleApres = propService.getAllProprietaire().size();
		assertEquals(new Double(--tailleAvant), new Double(tailleApres));
	}

}
