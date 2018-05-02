package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao{

	// Injection de dépendance
	@Autowired
	private SessionFactory sf;

	// Objets utiles
	Session s;
	Query q;
	String r;
	
	
	@Override
	public List<Visite> getVisiteByAgent(int id_agent) {
		// Requête HQL
		r = "FROM Visite v WHERE v.agent.id=:pId";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(r);
		// Passage des paramètres
		q.setParameter("pId", id_agent);
		// Envoi requête et récupération du résultat
		return q.list();
	}

	@Override
	public List<Visite> getVisiteByClient(int id_client) {
		// Requête HQL
		r = "FROM Visite v WHERE v.client.id=:pId";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(r);
		// Passage des paramètres
		q.setParameter("pId", id_client);
		// Envoi requête et récupération du résultat
		return q.list();
	}

	@Override
	public Visite addVisite(Visite v) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Faire persister l'objet
		s.save(v);
		// Récupération du résultat
		return v;
	}

	@Override
	public int deleteVisite(int id_visite) {
		// Requête HQL
		String req = "DELETE FROM Visite v WHERE v.id=:pId";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Passage des paramètres
		q.setParameter("pId", id_visite);
		// Envoi requête et récupération du résultat
		return q.executeUpdate();
	}

	@Override
	public Visite updateVisite(Visite v) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Synchroniser l'objet modifié
		s.update(v);
		// Récupération du résultat
		return v;
	}

}
