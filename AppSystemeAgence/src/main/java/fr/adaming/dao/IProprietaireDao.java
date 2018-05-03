package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {
	
	public Proprietaire addProprietaire(Proprietaire p);
	
	public Proprietaire updateProprietaire(Proprietaire p);
	
	public int deleteProprietaire(int id);
	
	public List<Proprietaire> getAllProprietaire();
	
	public Proprietaire getProprietaireById(int id);

}
