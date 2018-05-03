package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	// Injection de dépendance
	@Autowired
	private SessionFactory sf;

	// Setter pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// Objets utiles
	Session s;
	Query q;

	// Méthodes CRUD DAO

	// ----- CREATE
	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Faire persister l'objet
		s.save(p);
		// Récupération du résultat
		return p;
	}

	// ----- UPDATE
	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Synchroniser l'objet modifié
		s.update(p);
		// Récupération du résultat
		return p;
	}

	// ----- DELETE
	@Override
	public int deleteProprietaire(int id) {
		// Requête HQL
		String req = "DELETE FROM Proprietaire p WHERE p.id=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Passage des paramètres
		q.setParameter("pID", id);
		// Envoi requête et récupération du résultat
		return q.executeUpdate();
	}

	// ----- READ ALL
	@Override
	public List<Proprietaire> getAllProprietaire() {
		// Requête HQL
		String req = "FROM Proprietaire";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Envoi requête et récupération du résultat
		return q.list();
	}

	// ----- READ BY ID
	@Override
	public Proprietaire getProprietaireById(int id) {
		// Requête HQL
		String req = "FROM Proprietaire p WHERE p.id=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Passage des paramètres
		q.setParameter("pID", id);
		// Envoi requête et récupération du résultat
		return (Proprietaire) q.uniqueResult();
	}

}
