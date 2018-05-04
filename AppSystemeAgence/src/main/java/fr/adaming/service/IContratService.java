package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {
	
	public Contrat addContrat(Contrat cont);
	
	public List<Contrat> getAllContrat();
	
	public Contrat updateContrat(Contrat cont);
	
	public int deleteContrat(int id);
	
	public Contrat getContratById(int id);

}
