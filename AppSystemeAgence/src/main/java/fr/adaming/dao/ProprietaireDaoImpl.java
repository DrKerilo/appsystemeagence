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

	// Injection de d�pendance
	@Autowired
	private SessionFactory sf;

	// Setter pour l'injection de d�pendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	// Objets utiles
	Session s;
	Query q;

	// M�thodes CRUD DAO

	// ----- CREATE
	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Faire persister l'objet
		s.save(p);
		// R�cup�ration du r�sultat
		return p;
	}

	// ----- UPDATE
	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Synchroniser l'objet modifi�
		s.update(p);
		// R�cup�ration du r�sultat
		return p;
	}

	// ----- DELETE
	@Override
	public int deleteProprietaire(int id) {
		// Requ�te HQL
		String req = "DELETE FROM Proprietaire p WHERE p.id=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Cr�er Query
		q = s.createQuery(req);
		// Passage des param�tres
		q.setParameter("pID", id);
		// Envoi requ�te et r�cup�ration du r�sultat
		return q.executeUpdate();
	}

	// ----- READ ALL
	@Override
	public List<Proprietaire> getAllProprietaire() {
		// Requ�te HQL
		String req = "FROM Proprietaire";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Cr�er Query
		q = s.createQuery(req);
		// Envoi requ�te et r�cup�ration du r�sultat
		return q.list();
	}

	// ----- READ BY ID
	@Override
	public Proprietaire getProprietaireById(int id) {
		// Requ�te HQL
		String req = "FROM Proprietaire p WHERE p.id=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Cr�er Query
		q = s.createQuery(req);
		// Passage des param�tres
		q.setParameter("pID", id);
		// Envoi requ�te et r�cup�ration du r�sultat
		return (Proprietaire) q.uniqueResult();
	}

}
