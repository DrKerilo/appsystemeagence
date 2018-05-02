package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {

	public Visite getVisiteById(int id);

	public List<Visite> getAllVisite();

	public Visite addVisite(Visite vst);

	public Visite updateVisite(Visite vst);

	public int deleteVisite(int id);

}
