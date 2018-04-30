package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
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
	public List<Client> getAllClient(Client cl) {
		
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
	public int deleteClient() {
		
		// Ouverture de la session
		s=sf.getCurrentSession();
		
		// 
		
		return 0;
	}

	@Override
	public Client getClientById(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

}
