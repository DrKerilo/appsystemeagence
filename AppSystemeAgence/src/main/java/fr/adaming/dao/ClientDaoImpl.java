package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	SessionFactory sf;
	Query q;

	@Override
	public Client addClient(Client cl) {
		
		s=sf.getCurrentSession();
		
		return null;
	}

	@Override
	public List<Client> getAllClient(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client updateClient(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteClient() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Client getClientById(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}

}
