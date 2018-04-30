package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="clients")
public class Client extends Personne implements Serializable {
	
	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numCl;

	// Transformation des associations UML en JAVA
	@Autowired
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
