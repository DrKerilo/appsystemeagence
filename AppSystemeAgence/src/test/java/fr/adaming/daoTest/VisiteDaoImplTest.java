package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class VisiteDaoImplTest {

	// Classe à tester
	@Autowired
	private IVisiteDao visiteDao;
	
	// test méthode 
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void test1GetVisiteByAgent() {
		double tailleAtt = 2;
		double tailleReelle = visiteDao.getVisiteByAgent(1).size();

		assertEquals(new Double(tailleAtt), new Double(tailleReelle));

	}
	
}
