package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;


public interface IContratDao {
	
	public Contrat addContrat(Contrat cont);
	
	public List<Contrat> getAllContrat();
	
	public Contrat updateClient(Contrat cont);
	
	public int deleteContrat(int id);
	
	public Contrat getContratById(int id);

}
