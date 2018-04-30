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
	public ClasseStandard addClasseStandard(ClasseStandard cs) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Faire persister l'objet
		s.save(cs);
		// R�cup�ration du r�sultat
		return cs;
	}

	// ----- UPDATE
	@Override
	public ClasseStandard updateClasseStandard(ClasseStandard cs) {
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Synchroniser l'objet modifi�
		s.update(cs);
		// R�cup�ration du r�sultat
		return cs;
	}

	// ----- DELETE
	@Override
	public int deleteClasseStandard(int id) {
		// Requ�te HQL
		String req = "DELETE FROM ClasseStandard cs WHERE cs.code=:pID";
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
	public List<ClasseStandard> getAllClasseStandard() {
		// Requ�te HQL
		String req = "FROM ClasseStandard";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Cr�er Query
		q = s.createQuery(req);
		// Envoi requ�te et r�cup�ration du r�sultat
		return q.list();
	}

	// ----- READ BY ID
	@Override
	public ClasseStandard getClasseStandardById(int id) {
		// Requ�te HQL
		String req = "FROM ClasseStandard WHERE cs.code=:pID";
		// Ouvrir une session
		s = sf.getCurrentSession();
		// Cr�er Query
		q = s.createQuery(req);
		// Passage des param�tres
		q.setParameter("pID", id);
		// Envoi requ�te et r�cup�ration du r�sultat
		return (ClasseStandard) q.uniqueResult();
	}

}
