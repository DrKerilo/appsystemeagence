package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@Service("coService")
@Transactional
public class ContratServiceImpl implements IContratService {
	
	@Autowired
	private IContratDao contratDao;

	@Override
	public Contrat addContrat(Contrat cont) {
		
		return contratDao.addContrat(cont);
	}

	@Override
	public List<Contrat> getAllContrat() {
		
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat updateContrat(Contrat cont) {
		
		return contratDao.updateContrat(cont);
	}

	@Override
	public int deleteContrat(int id) {
		
		return contratDao.deleteContrat(id);
	}

	@Override
	public Contrat getContratById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
