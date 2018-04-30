package fr.adaming.model;

import java.util.List;

public class Client extends Personne {
	
	// Attributs
	
	private int numCl;

	// Transformation des associations UML en JAVA
	List<ClasseStandard> listeClasseStd;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(int numCl) {
		super();
		this.numCl = numCl;
	}

	// Getters et setters
	public int getNumCl() {
		return numCl;
	}

	public void setNumCl(int numCl) {
		this.numCl = numCl;
	}

	public List<ClasseStandard> getListeClasseStd() {
		return listeClasseStd;
	}

	public void setListeClasseStd(List<ClasseStandard> listeClasseStd) {
		this.listeClasseStd = listeClasseStd;
	}

	@Override
	public String toString() {
		return "Client [numCl=" + numCl + "]";
	}
	

}
