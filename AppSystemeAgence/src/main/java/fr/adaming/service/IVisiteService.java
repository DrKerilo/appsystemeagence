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
	
	public String getFile(int id);
	
	public void genererPDF(Visite visite);
	
	public void sendMail(Visite visite);
	
	public void sendMail2(Visite visite);
	

}
