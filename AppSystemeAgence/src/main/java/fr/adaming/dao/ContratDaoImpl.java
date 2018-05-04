package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	@Autowired
	SessionFactory sf;
	Session s;
	
	@Override
	public Contrat addContrat(Contrat cont) {
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		s.save(cont);
		
		return cont;
	}

	@Override
	public List<Contrat> getAllContrat() {
		
		// Création de la requête
		String req = "FROM Contrat";
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		Query query=s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Contrat updateContrat(Contrat cont) {
		
		s=sf.getCurrentSession();
		
		s.update(cont);
		
		return cont;
	}

	@Override
	public int deleteContrat(int id) {
		
		// Creation de la requete
		String req = "DELETE FROM Contrat as c WHERE c.id=:pId";
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		//Récup du query
		Query query = s.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);
		
		query.executeUpdate();
		
		return 0;
	}

	@Override
	public Contrat getContratById(int id) {
		
		return null;
	}

}
