package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService {
	
	// Injection de d�pendance
	@Autowired
	private IClasseStandardDao csDao;
	
	// Setter pour l'injection de d�pendance
	public void setCsDao(IClasseStandardDao csDao) {
		this.csDao = csDao;
	}
	
	// M�thodes CRUD Service
	// ----- CREATE
	@Override
	public ClasseStandard addClasseStandard(ClasseStandard cs) {
		return csDao.addClasseStandard(cs);
	}

	// ----- UPDATE
	@Override
	public ClasseStandard updateClasseStandard(ClasseStandard cs) {
		return csDao.updateClasseStandard(cs);
	}

	// ----- DELETE
	@Override
	public int deleteClasseStandard(int id) {
		return csDao.deleteClasseStandard(id);
	}

	// ----- READ ALL
	@Override
	public List<ClasseStandard> getAllClasseStandard() {
		return csDao.getAllClasseStandard();
	}

	@Override
	public ClasseStandard getClasseStandardById(int id) {
		return csDao.getClasseStandardById(id);
	}

}
