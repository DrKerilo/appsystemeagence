package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service("vstService")
@Transactional
public class VisiteServiceImpl implements IVisiteService {
	
	@Override
	public List<Visite> getAllVisite() {
		return vstDao.getAllVisite();
	}

	@Autowired
	private IVisiteDao vstDao;

	@Override
	public Visite addVisite(Visite vst) {
		return vstDao.addVisite(vst);
	}

	@Override
	public Visite updateVisite(Visite vst) {
		return vstDao.updateVisite(vst);
	}

	@Override
	public int deleteVisite(int id) {
		return vstDao.deleteVisite(id);
	}

	@Override
	public List<Visite> getVisiteByAgent(int idAgent) {
		return vstDao.getVisiteByAgent(idAgent);
	}

	@Override
	public List<Visite> getVisiteByClient(int idClient) {
		return vstDao.getVisiteByClient(idClient);
	}


}
