package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBienImmobilierService {
	public BienImmobilier addBienImmobilier(BienImmobilier bien);
	
	public BienImmobilier editBienImmobilier(BienImmobilier bien);
	
	public int deleteBienImmobilier(int id);
	
	public BienImmobilier getBienById(int id);
	
	public List<BienImmobilier> getAllBienImmobilier();
	
	public List<BienImmobilier> getBiensByClasse(int id);
	
	public List<BienImmobilier> getBiensByProprietaire(int id);
}
