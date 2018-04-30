package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBienImmobilierDao {
	public BienImmobilier addBienImmobilier(BienImmobilier bien);
	
	public BienImmobilier editBienImmobilier(BienImmobilier bien);
	
	public int deleteBienImmobilier(int id);
	
	public BienImmobilier getBienById(int id);
	
	public List<BienImmobilier> getAllBienImmobilier();
	
}
