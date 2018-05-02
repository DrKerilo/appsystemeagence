package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@Autowired
	SessionFactory sf;
	
	Session s;

	@Override
	public Client addClient(Client cl) {
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		// Ajout du client
		s.save(cl);
			
		return cl;
	}

	@Override
	public List<Client> getAllClient() {
		
		// Création de la requête
		String req = "FROM Client";
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		Query query =s.createQuery(req);
		
		return query.list();
	}

	@Override
	public Client updateClient(Client cl) {
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		// Modification du client
		s.update(cl);
		
		return cl;
	}

	@Override
	public int deleteClient(int id) {
		
		// Création de la requête
		String req = "DELETE from Client cl WHERE cl.id=:pId";
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		//Récup du query
		Query query=s.createQuery(req);
		
		// Passage des params
		query.setParameter("pId",id);
		
		query.executeUpdate();
		
		return 0;
	}

	@Override
	public Client getClientById(int id) {
		
		// Création de la requête
		String req = "FROM Client cl WHERE cl.id=:pid";
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		// Récup du query
		Query query=s.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);
		
		return (Client) query.uniqueResult();
	}

}
