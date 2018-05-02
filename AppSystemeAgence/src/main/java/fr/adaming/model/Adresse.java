package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable	// Classe embarquée
public class Adresse implements Serializable{

	// Attributs
	private String rue;
	private int numero;
	private int codePostal;
	private String localite;
	
	// Constructeurs
	public Adresse() {
		super();
	}
	public Adresse(String rue, int numero, int codePostal, String localite) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.localite = localite;
	}
	
	// Getters et setters
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	
	// toString
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", numero=" + numero + ", codePostal=" + codePostal + ", localite=" + localite
				+ "]";
	}
	
}
