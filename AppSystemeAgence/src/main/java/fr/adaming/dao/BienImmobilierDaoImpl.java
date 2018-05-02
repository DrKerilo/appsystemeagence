package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;

@Repository
public class BienImmobilierDaoImpl implements IBienImmobilierDao {
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public BienImmobilier addBienImmobilier(BienImmobilier bien) {
		Session s = sf.getCurrentSession();
		
		s.save(bien);
		
		return bien;
	}

	@Override
	public BienImmobilier editBienImmobilier(BienImmobilier bien) {
		Session s = sf.getCurrentSession();
		
		s.update(bien);
		
		return bien;
	}

	@Override
	public int deleteBienImmobilier(int id) {
		Session s = sf.getCurrentSession();
		
		// Créer le query avec requete SQL
		Query query = s.createQuery("DELETE FROM BienImmobilier b WHERE b.id = :pId");
		
		// Passage des parametres
		query.setParameter("pId", id);
		
		return query.executeUpdate();
	}

	@Override
	public BienImmobilier getBienById(int id) {
		Session s = sf.getCurrentSession();
		
		Query query = s.createQuery("FROM BienImmobilier b WHERE b.id = :pId");
		
		// Passage des parametres
		query.setParameter("pId", id);
		
		return (BienImmobilier) query.uniqueResult();
	}

	@Override
	public List<BienImmobilier> getAllBienImmobilier() {
		Session s = sf.getCurrentSession();
		
		String req = "FROM BienImmobilier bien";
		
		// Créer le query
		Query query = s.createQuery(req);

		List<BienImmobilier> liste = query.list();

		return liste;
	}

	@Override
	public List<BienImmobilier> getBiensByClasse(int id) {
		
		Session s = sf.getCurrentSession();
		
		String req = "FROM BienImmobilier b WHERE b.classeStandard.code = :pId";
		
		Query query = s.createQuery(req);
		
		// Passage des parametres
		query.setParameter("pId", id);

		return query.list();
	}

}
