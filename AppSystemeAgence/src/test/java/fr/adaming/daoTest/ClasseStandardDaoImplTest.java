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

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClasseStandardDaoImplTest {

	// Classe à tester
	@Autowired
	private IClasseStandardDao csDao;

	// ----- Test READ ALL
	// Test 1 : taille de la liste
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetAllClasseStandardDao() {
		double tailleAtt = 2;
		double tailleReelle = csDao.getAllClasseStandard().size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));

	}

	// Test 2 : liste non vide - test sur type
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test2GetAllClasseStandardDao() {
		assertEquals("maison", csDao.getAllClasseStandard().get(0).getType());
	}

	// ----- Test READ ONE
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetClasseStandardByIdDao() {
		ClasseStandard csIn = csDao.getClasseStandardById(1); // Vérifier valeur
																// de l'id

		assertEquals("maison", csIn.getType()); // Vérifier type correspondant à
												// l'id donné

	}

	// ----- Test CREATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddClasseStandardDao() {
		// Instanciation objet vide
		ClasseStandard csIn = new ClasseStandard();

		int tailleAvant = csDao.getAllClasseStandard().size();

		csDao.addClasseStandard(csIn);

		assertEquals(new Double(++tailleAvant), new Double(csDao.getAllClasseStandard().size()));
	}

	// ----- Test UPDATE
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateClasseStandardDao() {
		// Récupération d'un objet de la BD
		ClasseStandard csModif = csDao.getClasseStandardById(1);

		csModif.setType("TEST");

		assertEquals("TEST", csDao.updateClasseStandard(csModif).getType());

	}

}
