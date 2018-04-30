package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class ClasseStandardDaoImpl implements IClasseStandardDao {

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
	public ClasseStandard addClasseStandard(ClasseStandard cs) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Faire persister l'objet
		s.save(cs);
		// Récupération du résultat
		return cs;
	}

	// ----- UPDATE
	@Override
	public ClasseStandard updateClasseStandard(ClasseStandard cs) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Synchroniser l'objet modifié
		s.update(cs);
		// Récupération du résultat
		return cs;
	}

	// ----- DELETE
	@Override
	public int deleteClasseStandard(int id) {
		// Requête HQL
		String req = "DELETE FROM ClasseStandard cs WHERE cs.code=:pID";
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
	public List<ClasseStandard> getAllClasseStandard() {
		// Requête HQL
		String req = "FROM ClasseStandard";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Envoi requête et récupération du résultat
		return q.list();
	}

	// ----- READ BY ID
	@Override
	public ClasseStandard getClasseStandardById(int id) {
		// Requête HQL
		String req = "FROM ClasseStandard WHERE cs.code=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Créer Query
		q = s.createQuery(req);
		// Passage des paramètres
		q.setParameter("pID", id);
		// Envoi requête et récupération du résultat
		return (ClasseStandard) q.uniqueResult();
	}

}
