package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IBienImmobilierDao;
import fr.adaming.model.BienImmobilier;

@Service("biService")
@Transactional
public class BienImmobilierServiceImpl implements IBienImmobilierService {
	@Autowired
	public IBienImmobilierDao biDao;
	
	@Override
	public BienImmobilier addBienImmobilier(BienImmobilier bien) {
		return biDao.addBienImmobilier(bien);
	}

	@Override
	public BienImmobilier editBienImmobilier(BienImmobilier bien) {
		return biDao.editBienImmobilier(bien);
	}

	@Override
	public int deleteBienImmobilier(int id) {
		return biDao.deleteBienImmobilier(id);
	}

	@Override
	public BienImmobilier getBienById(int id) {
		return biDao.getBienById(id);
	}

	@Override
	public List<BienImmobilier> getAllBienImmobilier() {
		return biDao.getAllBienImmobilier();
	}

}
