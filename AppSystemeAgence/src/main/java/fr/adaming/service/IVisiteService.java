package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {
	
	public List<Visite> getAllVisite();

	public List<Visite> getVisiteByAgent(int idAgent);

	public List<Visite> getVisiteByClient(int idClient);

	public Visite addVisite(Visite vst);

	public Visite updateVisite(Visite vst);

	public int deleteVisite(int id);

}
