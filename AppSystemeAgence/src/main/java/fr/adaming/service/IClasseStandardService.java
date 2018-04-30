package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {
	
	public ClasseStandard addClasseStandard(ClasseStandard cs);
	
	public ClasseStandard updateClasseStandard(ClasseStandard cs);
	
	public int deleteClasseStandard(int id);
	
	public List<ClasseStandard> getAllClasseStandard();
	
	public ClasseStandard getClasseStandardById(int id);

}
