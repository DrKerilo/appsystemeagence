package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteDao {
	
	public List<Visite> getAllVisite();
	
	public List<Visite> getVisiteByAgent(int id_agent);
	
	public List<Visite> getVisiteByClient(int id_client);
	
	public Visite addVisite(Visite v);
	
	public int deleteVisite(int id_visite);
	
	public Visite updateVisite(Visite v);

}
