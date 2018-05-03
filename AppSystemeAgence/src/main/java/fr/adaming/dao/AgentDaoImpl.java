package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao{

	// Injection de dépendance
	@Autowired
	private SessionFactory sf;

	// Objets utiles
	Session s;
	Query q;
	String r;
	
	@Override
	public List<Agent> getAllAgents() {
		// Requête HQL
		r = "FROM Agent";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(r);
		// Envoi requête et récupération du résultat
		return q.list();
	}

}
