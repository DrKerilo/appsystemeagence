package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteDao {
	
	public List<Visite> getVisiteByAgent(int id);
	
	public List<Visite> getVisiteByClient(int id);
	
	public Visite addVisite(Visite v);
	
	public int deleteVisite(int id);
	
	public Visite updateVisite(Visite v);

}
