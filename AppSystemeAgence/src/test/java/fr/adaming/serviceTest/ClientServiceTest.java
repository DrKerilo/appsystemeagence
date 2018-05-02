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

import fr.adaming.model.Adresse;
import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

/**
 * @author Inti0320
 * 
 *         Methode getAll n'est pas testé mais utilisé pour tester la methode
 *         addClient Methode getClientById n'est pas testé mais utilisé pour
 *         tester la methode updateClient
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ClientServiceTest {

	@Autowired
	private IClientService clService;

	// Test add
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddClientService() {
		// Instanciation objet vide
		Adresse addressTest = new Adresse("testRue", 123, 31000, "testLocalite");
		Client cl = new Client("testAdd", "testAdd", 456, addressTest);

		clService.addClient(cl);

		int tailleAvant = clService.getAllClient().size();

		System.out.println("List size in clients : " + tailleAvant);

		Adresse addressTest2 = new Adresse("testRue2", 1234, 31000, "testLocalite2");
		Client cl2 = new Client("testAdd2", "testAdd2", 4567, addressTest2);

		clService.addClient(cl2);

		int tailleApres = clService.getAllClient().size();
		System.out.println("List size in clients : " + tailleApres);

		assertEquals(new Double(tailleAvant + 1), new Double(tailleApres));
	}

	// test update
	@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateClientService() {
		// Instanciation objet vide

		String updateTestRue = "testRue66";
		int updateTestNumero = 12366;
		int updateTestCode = 31055;
		String updateTestLocalite = "testLocalite55";

		Adresse addressTestUpdate = new Adresse(updateTestRue, updateTestNumero, updateTestCode, updateTestLocalite);
		Client clUpdate = new Client(1, "testUpdate", "testUpdate", 45655, addressTestUpdate);

		clService.updateClient(clUpdate);

		// Test String
		// assertEquals(updateTestRue,clService.getClientById(1).getAdresse().getRue());

		// test Double
		assertEquals(new Double(updateTestNumero), new Double(clService.getClientById(1).getAdresse().getNumero()));

	}

	// test delete
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteClientService() {
		int tailleAvant = clService.getAllClient().size();
		System.out.println("List size in clients : " + tailleAvant);

		clService.deleteClient(1);
		int tailleApres = clService.getAllClient().size();
		System.out.println("List size in clients : " + tailleApres);

		assertEquals(new Double(tailleAvant - 1), new Double(tailleApres));
	}

}
