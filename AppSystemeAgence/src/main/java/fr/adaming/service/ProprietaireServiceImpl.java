package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService {

	// Injection de dépendance
	@Autowired
	private IProprietaireDao propDao;

	// Setter pour l'injection de dépendance
	public void setPropDao(IProprietaireDao propDao) {
		this.propDao = propDao;
	}
	
	// Méthodes CRUD Service
	
	// ----- CREATE
	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		return propDao.addProprietaire(p);
	}

	// ----- UPDATE
	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		return propDao.updateProprietaire(p);
	}

	// ----- DELETE
	@Override
	public int deleteProprietaire(int id) {
		return propDao.deleteProprietaire(id);
	}

	// ----- READ ALL
	@Override
	public List<Proprietaire> getAllProprietaire() {
		return propDao.getAllProprietaire();
	}

	// ----- READ BY ID
	@Override
	public Proprietaire getProprietaireById(int id) {
		return propDao.getProprietaireById(id);
	}

}
